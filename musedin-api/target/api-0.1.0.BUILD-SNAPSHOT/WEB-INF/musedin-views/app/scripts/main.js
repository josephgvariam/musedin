/*global $:true, _:true, Backbone:true, Modernizr:true, player:true, playlistSongs:true, activities:true, appLayout:true, username:true, jQuery:true, google:true */

'use strict';

_.templateSettings = {
  interpolate: /{{(.+?)}}/g,
  evaluate: /@@(.+?)@@/g,
};

var isUpdating = false;

var app = new Backbone.Marionette.Application();

Backbone.Marionette.Region.prototype.open = function(view){
  this.$el.hide();
  this.$el.html(view.el);
  this.$el.fadeIn('slow');
};

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

var addActivity = function(code, msg, showUserName){
  isUpdating = true;
  //console.log('addActivity: '+msg);
  showUserName = typeof showUserName !== 'undefined' ? showUserName : true;
  if(showUserName){
    msg = msg+' by '+username;
  }
  var activity = new Activity({code: code, msg: msg});
  activities.add(activity);
  activity.save(null, {success: function(){isUpdating=false;}});
};

var poll = function(){
  $.getJSON('/players/'+player.get('id')+'/poll', function(json) {
    //console.log(json);
    if(!isUpdating){
      activities.update(json.activities, {remove: false, merge: false});
      playlistSongs.update(json.playlistSongs, {add: false, remove: false} );
      player.set(json.player);

      //$('.activity').stop().animate({ scrollTop: $('.activity')[0].scrollHeight }, 800);
    }
  });
};

var loadMap = function(position){
  //console.log('Got location: '+position);
  var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
  var myOptions = {
    zoom: 15,
    center: latlng,
    mapTypeControl: false,
    navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  var map = new google.maps.Map(document.getElementById('map_canvas'), myOptions);
  
  app.marker = new google.maps.Marker({
      position: latlng,
      map: map,
      draggable: true,
      animation: google.maps.Animation.DROP,
      title:'You are here! (at least within a '+position.coords.accuracy+' meter radius)'
  });
};

var loadMapError = function(msg){
  console.log('loadMapError: '+msg);
};



var Activity = Backbone.Model.extend({
  defaults: {
    msg: '',
    code: '100',
    tstamp: '9999999999999'
  },

  urlRoot: function() {
    return '/players/' + player.get('id') + '/activities';
  }
});

var Player = Backbone.Model.extend({
  urlRoot: '/players',

  defaults: {
    nowPlayingSong: {},
    playing: false
  }
});


var PlaylistSong = Backbone.Model.extend({
  defaults: {
    'fileName': '',
    'title': 'Unknown',
    'artist': 'Unknown',
    'album': 'Unknown',
    'year': '',
    'genre': '',
    'comment': '',
    'iconUrl': 'images/song.png',
    'upVotes': 0,
    'downVotes': 0,
    'songUrl': ''
  },

  urlRoot: function() {
    return '/players/' + player.get('id') + '/playlistsongs';
  }
});

var Activities = Backbone.Collection.extend({
  model: Activity,

  comparator: function(activity) {
    return -parseInt(activity.get('tstamp'),10);
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
    var x = d < 0 ? 1 : d > 0 ? -1 : 0;
    if(x===0){
      if(s1.get('upVotes')<s2.get('upVotes')) {return 1;}
      if(s1.get('upVotes')>s2.get('upVotes')) {return -1;}

      if(s1.get('fileName')<s2.get('fileName')) {return -1;}
      if(s1.get('fileName')>s2.get('fileName')) {return 1;}
      return 0;
    }
    return x;
  }
});

var ActivityItemView = Backbone.Marionette.ItemView.extend({
  template: '#template-activity-item',
  tagName: 'li'
});

var ActivityCompositeView = Backbone.Marionette.CompositeView.extend({
  itemView: ActivityItemView,
  itemViewContainer: 'ul',
  template: '#template-activity',

  appendHtml: function(cv, iv){
    // var childrenContainer = collectionView.$(collectionView.childrenContainer || collectionView.el);
    // var children = childrenContainer.children();
    // console.log(childrenContainer);
    // childrenContainer.children().eq(index).before(itemView.el);
    // // if (children.size() <= index) {
    // //   childrenContainer.append(itemView.el);
    // // } else {
    // //   childrenContainer.children().eq(index).before(itemView.el);
    // // }    
    var $container = this.getItemViewContainer(cv);
    $container.closest('ul').prepend(iv.el);
  }

});

var ToolBarView = Backbone.Marionette.ItemView.extend({
  template: '#template-toolbar',

  events: {
    'click #fileSelect': 'handleFileSelectClick',
    'change input': 'handleFiles',
    'click #startplayerbutton': 'startPlay'
  },

  handleFileSelectClick: function(e){
    var fileElem = this.$('#fileElem');
    if (fileElem) {
      fileElem.click();
    }
    e.preventDefault();
  },

  handleFiles: function(e){
    var files = e.srcElement.files;
    
    var filesLength = files.length;
    if(filesLength>50) {filesLength=50;} //limit number of files

    for (var i = 0; i < filesLength; i++) {
      var song = new PlaylistSong();
      song.set({
        fileName: files[i].name,
        title: files[i].name,
        songUrl: window.URL.createObjectURL(files[i])
      }); //Garbage Collect later window.URL.revokeObjectURL()

      playlistSongs.add(song);

    }
    addActivity('101',filesLength+' Songs added to Playlist');
  },

  startPlay: function(){
    if(playlistSongs.length===0){
      alertMsg('info','No songs to play.','The Playlist is empty. Add songs first!');
    }else{
      //console.log('startPlay');
      var song = playlistSongs.shift();
      if(song){
        player.set('nowPlayingSong', song.toJSON());
        var playerView = new PlayerView({model: player});
        var nowPlayingView = new NowPlayingView({model: player});

        appLayout.nowPlayingRegion.show(nowPlayingView);
        appLayout.playerRegion.show(playerView);

        
        addActivity('102','Player Started');

        player.set('playing', true);
        //console.log(song);

        addActivity('105', 'Playing "'+song.get('title')+'"', false);

        song.destroy();

        $('#startplayerbutton').hide();

      }
    }
  }

});

var NowPlayingView = Backbone.Marionette.ItemView.extend({
  template: '#template-nowplaying',


  modelEvents: {
    'change:nowPlayingSong': 'updateNowPlayingView'
  },

  updateNowPlayingView: function(e){
    if(player.get('playing')){
      //console.log('updateNowPlayingView');
      //console.log(e);
      //console.log(this.model.changedAttributes());

      this.render();
    }
  },

  onRender: function(){
    this.$('img').hide();
    this.$('img').fadeIn("slow");
  }

});

var PlayerView = Backbone.Marionette.ItemView.extend({
  template: '#template-player',

  initialize: function() {
    //_.bindAll(this, 'startPlay', 'handleEnded');
  },

  ui: {
    audioplayercontainer: '#audioplayercontainer',
  },

  modelEvents: {
    'change:playing change:nowPlayingSong': 'updatePlayerView',
  },

  onRender: function(){
    //this.ui.audioplayer.bind('play', this.handlePlay);
    
    //this.ui.startPlayingButton.toggle(true);
    //this.ui.player.toggle(false);
    //this.ui.audioplayer.bind('ended', this.handleEnded);
    //this.ui.audioplayer.bind('error', this.handleAudioPlayerError);
    //console.log('rendered');
    // this.ui.audioplayercontainer.append('<audio id="audioplayer" controls></audio>');
    this.$('#audioplayer').bind('ended', this.handleEnded);
    this.$('#audioplayer').bind('error', this.handleAudioPlayerError);
    // this.playNextSong();
  },

  handleAudioPlayerError: function(e){
    console.log(e);
  },

  handleEnded: function(){
    if(playlistSongs.length===0){
      isUpdating = true;
      player.set({
        playing: false,
        nowPlayingSong: player.defaults.nowPlayingSong
      });

      player.save(null, {success: function(){isUpdating=false;}});

      appLayout.playerRegion.close();
      appLayout.nowPlayingRegion.close();

      addActivity('106','Playlist done', false);

      $('#startplayerbutton').show();

    }else{
      var song = playlistSongs.shift();
      if(song){
        player.set('nowPlayingSong', song.toJSON());
        addActivity('105', 'Playing "'+song.get('title')+'"', false);
        song.destroy();
      }
    }
  },

  updatePlayerView: function(e){
    isUpdating = true;

    var song = player.get('nowPlayingSong');
    if(song  && player .get('playing') && !this.$('#audioplayer')[0].src!==song.songUrl){
      console.log('updatePlayerView');
      //console.log(e);
      //console.log(this.model.changedAttributes());

      this.$('#audioplayer')[0].src=song.songUrl;
      this.$('#audioplayer')[0].play();
      player.save(null, {success: function(){isUpdating=false;}});
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
    addActivity('103','Up Voted "'+this.model.get('title')+'"');
    this.model.set('upVotes', this.model.get('upVotes') + 1);
  },

  downVote: function() {
    addActivity('104','Down Voted "'+this.model.get('title')+'"');
    this.model.set('downVotes', this.model.get('downVotes') - 1);
  },

});

var PlaylistCompositeView = Backbone.Marionette.CompositeView.extend({
  itemView: PlaylistItemView,
  itemViewContainer: 'ul',
  template: '#template-playlist',

  updateCount: function(){
    //console.log('updateCount');
    // if(this.collection.length){
    //   this.$('h1').text('Playlist ('+this.collection.length+')');
    // }else{
    //   this.$('h1').text('Playlist');
    // }
  },

  collectionEvents: {
    //'change:upVotes change:downVotes': 'handlePlaylistSongChanged',
    'change': 'handlePlaylistSongChanged',
    'add': 'handleAddToPlaylistSongs',
    'remove': 'updateCount'
  },

  handlePlaylistSongChanged: function(playlistSong, options) {
    if(!playlistSong.changedAttributes().id){
      isUpdating = true;

      //console.log('handlePlaylistSongChanged');
      //console.log(playlistSong);
      //console.log(playlistSong.changedAttributes());
      
      playlistSongs.sort();
      this.renderCollection();
      playlistSong.save(null, {success: function(){isUpdating=false;}});

      
    }
  },

  handleAddToPlaylistSongs: function(playlistSong) {
    isUpdating = true;

    //console.log('handleAddToPlaylistSongs');
    //console.log(playlistSong);
    //console.log(playlistSong.changedAttributes());

    //this.updateCount();
    playlistSong.save(null, {success: function(){isUpdating=false;}});
  }
});


// var LibraryView = Backbone.Marionette.ItemView.extend({
//   template: '#template-library',

//   events: {
//     'click #fileSelect': 'handleFileSelectClick',
//     'change input': 'handleFiles'
//   },

//   handleFileSelectClick: function(e){
//     var fileElem = $('#fileElem');
//     if (fileElem) {
//       fileElem.click();
//     }
//     e.preventDefault();
//   },

//   handleFiles: function(e){
//     var files = e.srcElement.files;
    
//     for (var i = 0; i < files.length; i++) {
//       var song = new PlaylistSong();
//       song.set({
//         fileName: files[i].name,
//         title: files[i].name,
//         songUrl: window.URL.createObjectURL(files[i])
//       }); //Garbage Collect later window.URL.revokeObjectURL()

//       playlistSongs.add(song);

//     }
//     addActivity('100','Songs added to Playlist');
//   }

  // handleFilesOld: function(e){
  //   var files = e.srcElement.files;
  //   var audio = jQuery('#audioplayer')[0];

  //   audio.src = window.URL.createObjectURL(files[0]);
  //   audio.play();

  //   this.getMp3Id3Tag(files[0]);

  //   // if (audio != null && audio.canPlayType && audio.canPlayType("audio/mp3")) {
  //   // }else{
  //   //   alertMsg('error','Aww Crap!','The Audio APIs are not fully supported in this browser. Go get a real browser!');
  //   // }

  // },

  // getMp3Id3Tag: function(file){
  //   var reader = new FileReader();
  //   reader.onload = function(e) {
  //     var dv = new jDataView(this.result);

  //     // "TAG" starts at byte -128 from EOF.
  //     // See http://en.wikipedia.org/wiki/ID3
  //     if (dv.getString(3, dv.byteLength - 128) == 'TAG') {
  //       var title = dv.getString(30, dv.tell());
  //       var artist = dv.getString(30, dv.tell());
  //       var album = dv.getString(30, dv.tell());
  //       var year = dv.getString(4, dv.tell());

  //       console.log('title: '+title+' artist: '+artist+' album: '+album+' year: '+year);
  //     } else {
  //       console.log('no ID3v1 data found.');
  //     }
  //   };

  // reader.readAsArrayBuffer(file);
  // }

//});


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
    nowPlayingRegion: '#nowplaying',
    playerRegion: '#player',
    playlistRegion: '#playlist',
    //libraryRegion: '#library',
    toolBarRegion: '#toolbar',
    activityRegion: '#activity'
  }
});

var showApp = function(){
  window.appLayout = new AppLayout();
  app.containerRegion.show(appLayout);
  var playlistCompositeView = new PlaylistCompositeView({collection: playlistSongs});
  var toolBarView = new ToolBarView({model: player});
  var activityView = new ActivityCompositeView({collection: activities});

  appLayout.playlistRegion.show(playlistCompositeView);
  appLayout.toolBarRegion.show(toolBarView);
  appLayout.activityRegion.show(activityView);

  poll();
  if(window.pollId){
    clearInterval(window.pollId);
  }
  window.pollId = setInterval(poll, 3000);

};

var InitLayout = Backbone.Marionette.Layout.extend({
  template: '#template-init-layout',

  events: {
    'click #startplayerbutton': 'startPlayer'
  },

  startPlayer: function(){
    if($('#playerName').val()){
      var playerLocation = [];
      if(app.marker){
        playerLocation.push(app.marker.getPosition().lat(), app.marker.getPosition().lng());
      }

      player.save({
        active: true,
        location: playerLocation,
        name: $('#playerName').val(),
        description: $('#playerDescription').val()
      }, {
        success: function(){showApp();},
        error: function(e){console.log(e);}
      });
    }
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

  navigator.geolocation.getCurrentPosition(loadMap, loadMapError);
});