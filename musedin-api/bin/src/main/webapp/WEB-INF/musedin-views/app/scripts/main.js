/*global $:true, _:true, Backbone:true, Modernizr:true, player:true, playlistSongs:true, jQuery:true */

'use strict';

_.templateSettings = {
  interpolate: /{{(.+?)}}/g
};

var app = new Backbone.Marionette.Application();

app.addRegions({
  containerRegion: '#container',
  alertRegion: '#alert'
});

var AlertModel = Backbone.Model.extend({
  defaults: {
    'alertClass': 'info', //info,warning,error,success
    'alertHeader': 'Alert Header',
    'alertBody': 'Alert Body'
  },

  getClassName: function(){
    if(this.get('alertClass')==='warning'){
      return 'alert alert-block';
    }
    else{
      return 'alert alert-block alert-'+this.get('alertClass');
    }
  }
});

var AlertView = Backbone.View.extend({
  className: function(){return this.model.getClassName();},

  events: {
    'closed': 'handleClosed'
  },

  initialize: function() {
    
  },

  handleClosed: function(){
    app.alertRegion.close();
  },

  render: function(){
    this.$el.html('<button type="button" class="close" data-dismiss="alert">&times;</button><h4>'+this.model.get('alertHeader')+'</h4>'+this.model.get('alertBody'));
    return this;
  }
});

var alertMsg = function(alertClass, alertHeader, alertBody){
  app.alertRegion.show(new AlertView({model: new AlertModel({alertClass: alertClass, alertHeader: alertHeader, alertBody: alertBody})}));
};

var Player = Backbone.Model.extend({
  urlRoot: '/players'
});

var PlaylistSong = Backbone.Model.extend({
  defaults: {
    'title': 'Unknown',
    'artist': '',
    'album': '',
    'year': '',
    'genre': '',
    'comment': '',
    'iconUrl': '',
    'upVotes': 0,
    'downVotes': 0,
    'songUrl': ''
  }
});

var PlaylistSongs = Backbone.Collection.extend({
  model: PlaylistSong,
  url: function() {
    return '/players/' + player.get('id') + '/playlistsongs';
  },

  comparator: function(s1, s2) {
    var d1 = s1.get('upVotes') + s1.get('downVotes');
    var d2 = s2.get('upVotes') + s2.get('downVotes');
    var d = d1 - d2;
    return d < 0 ? 1 : d > 0 ? -1 : 0;
  }
});

var PlayerView = Backbone.Marionette.ItemView.extend({
  template: '#template-player',

  initialize: function() {
    _.bindAll(this, 'startPlay', 'handleEnded');
  },

  ui: {
    player: '.player',
    audioplayer: '#audioplayer',
    startPlayingButton: '#startplayingbutton',
    nowPlayDownvote: '#nowplay_downvote',
    nowPlayUpvote: '#nowplay_upvote',
    nowPlaySongImg: '#nowplay_songimg',
    nowPlaySongTitle: '#nowplay_songtitle',
    nowPlaySongArtist: '#nowplay_songartist',
    nowPlaySongAlbum: '#nowplay_songalbum'


  },

  events: {
    'click #startplayingbutton': 'startPlay'
  },

  onRender: function(){
    //this.ui.audioplayer.bind('play', this.handlePlay);
    
    this.ui.startPlayingButton.toggle(true);
    this.ui.player.toggle(false);
    this.ui.audioplayer.bind('ended', this.handleEnded);
    this.ui.audioplayer.bind('error', this.handleAudioPlayerError);

  },

  handleAudioPlayerError: function(e){
    console.log(e);
  },

  startPlay: function(){
    if(playlistSongs.length===0){
      alertMsg('info','No songs to play.','The Playlist is empty. Add songs first!');
    }else{
      this.ui.startPlayingButton.toggle(false);
      this.ui.player.toggle(true);
      this.playNextSong();
    }
  },

  handleEnded: function(){
    if(playlistSongs.length===0){
      this.ui.startPlayingButton.toggle(true);
      this.ui.player.toggle(false);
    }else{
      this.playNextSong();
    }
  },

  playNextSong: function(){
    var song = playlistSongs.shift();
    if(song){
      this.ui.nowPlayUpvote.text(song.get('upVotes'));
      this.ui.nowPlayDownvote.text(song.get('downVotes'));
      this.ui.nowPlaySongImg.attr('src',song.get('iconUrl'));
      this.ui.nowPlaySongTitle.text(song.get('title'));
      this.ui.nowPlaySongArtist.text(song.get('artist'));
      this.ui.nowPlaySongAlbum.text(song.get('album'));

      this.ui.audioplayer[0].src=song.get('songUrl');
      this.ui.audioplayer[0].play();
    }
  }
});

var PlaylistItemView = Backbone.Marionette.ItemView.extend({
  template: '#template-playlist-song',
  tagName: 'li',

  events: {
    'click .upvote': 'upVote',
    'click .downvote': 'downVote'
  },

  initialize: function() {
    //this.model.on('change', this.render, this);
  },

  upVote: function() {
    this.model.set('upVotes', this.model.get('upVotes') + 1);
  },

  downVote: function() {
    this.model.set('downVotes', this.model.get('downVotes') - 1);
  }

});

var PlaylistCompositeView = Backbone.Marionette.CompositeView.extend({
  itemView: PlaylistItemView,
  itemViewContainer: 'ul',
  template: '#template-playlist',


  collectionEvents: {
    'change:upVotes change:downVotes': 'handlePlaylistSongChanged',
    'add': 'handleAddToPlaylistSongs'
  },

  handlePlaylistSongChanged: function(playlistSong, options) {
    //console.log('handlePlaylistSongChanged');
    //console.log(options);
    playlistSongs.sort();
    this.renderCollection();
    
    playlistSong.save();
  },

  handleAddToPlaylistSongs: function(playlistSong) {
    //console.log('handleAddToPlaylistSongs');
    playlistSong.save();
  }
});


var LibraryView = Backbone.Marionette.ItemView.extend({
  template: '#template-library',

  events: {
    'click #fileSelect': 'handleFileSelectClick',
    'change input': 'handleFiles'
  },

  handleFileSelectClick: function(e){
    var fileElem = $('#fileElem');
    if (fileElem) {
      fileElem.click();
    }
    e.preventDefault();
  },

  handleFiles: function(e){
    var files = e.srcElement.files;
    
    for (var i = 0; i < files.length; i++) {
      var song = new PlaylistSong();
      song.set('title',files[i].name);
      song.set('songUrl',window.URL.createObjectURL(files[i]));

      playlistSongs.add(song);
    }
  },

  handleFilesOld: function(e){
    var files = e.srcElement.files;
    var audio = jQuery('#audioplayer')[0];

    audio.src = window.URL.createObjectURL(files[0]);
    audio.play();

    this.getMp3Id3Tag(files[0]);

    // if (audio != null && audio.canPlayType && audio.canPlayType("audio/mp3")) {
    // }else{
    //   alertMsg('error','Aww Crap!','The Audio APIs are not fully supported in this browser. Go get a real browser!');
    // }

  },

  getMp3Id3Tag: function(file){
    var reader = new FileReader();
    reader.onload = function(e) {
      var dv = new jDataView(this.result);

      // "TAG" starts at byte -128 from EOF.
      // See http://en.wikipedia.org/wiki/ID3
      if (dv.getString(3, dv.byteLength - 128) == 'TAG') {
        var title = dv.getString(30, dv.tell());
        var artist = dv.getString(30, dv.tell());
        var album = dv.getString(30, dv.tell());
        var year = dv.getString(4, dv.tell());

        console.log('title: '+title+' artist: '+artist+' album: '+album+' year: '+year);
      } else {
        console.log('no ID3v1 data found.');
      }
    };

  reader.readAsArrayBuffer(file);
  }

});


var Router = Backbone.Marionette.AppRouter.extend({
  appRoutes: {
    '*filter': 'setFilter'
  },
  controller: {
    setFilter: function(param) {
      app.vent.trigger('todoList:filter', param.trim() || '');
    }
  }
});



var AppLayout = Backbone.Marionette.Layout.extend({
  template: '#template-app-layout',

  regions: {
    alertRegion: '#alert',
    playerRegion: '#player',
    playlistRegion: '#playlist',
    libraryRegion: '#library',
    logRegion: '#log'
  }
});

var showApp = function(){
    var appLayout = new AppLayout();
    app.containerRegion.show(appLayout);
    var playerView = new PlayerView({model: player});
    var playlistCompositeView = new PlaylistCompositeView({collection: playlistSongs});
    var libraryView = new LibraryView();
    appLayout.playerRegion.show(playerView);
    appLayout.playlistRegion.show(playlistCompositeView);
    appLayout.libraryRegion.show(libraryView);
};

var InitLayout = Backbone.Marionette.Layout.extend({
  template: '#template-init-layout',

  events: {
    'click #startplayerbutton': 'startPlayer'
  },

  startPlayer: function(){
    player.save({active: true}, {success: function(){showApp();} });
    
  }
});

app.addInitializer(function(options) {
  if(Modernizr.audio && Modernizr.filereader && Modernizr.geolocation){
    if(player.isNew()){
      var initLayout = new InitLayout();
      app.containerRegion.show(initLayout);
    }else{
      showApp();
    }
  }else{
   console.log('The MusedIn Player is not fully supported in this browser. Go get a real browser!');
  }
});

$(function() {
  app.start();
  new Router();
  Backbone.history.start();
});