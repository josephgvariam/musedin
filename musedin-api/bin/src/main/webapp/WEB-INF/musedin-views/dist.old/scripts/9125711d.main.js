/*global $:true, _:true, Backbone:true */
'use strict';

_.templateSettings = {
  interpolate: /{{(.+?)}}/g
};

var app = new Backbone.Marionette.Application();

app.addRegions({
  playerRegion: '#player',
  playlistRegion: '#playlist',
  libraryRegion: '#library'
});



var Player = Backbone.Model.extend({
  urlRoot: '/players',
  initialize: function() {
    //this.playlistSongs = new PlaylistSongs();
    //this.playlistSongs.url = '/players/' + this.id + '/playlistsongs';
    //this.messages.on("reset", this.updateCounts);
  },
  parse: function(response) {
    //console.log(response);
    //response.playlistSongs = new PlaylistSongs(response.playlistSongs);
    //response.playlistSongs && this.playlistSongs.reset(response.playlistSongs);
    return response;
  }
});

var PlaylistSong = Backbone.Model.extend({});

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
  template: '#template-player'
});

var PlaylistItemView = Backbone.Marionette.ItemView.extend({
  template: '#template-playlist-song',

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
    'change': 'sortCollection'
  },

  sortCollection: function(playlistSong) {
    playlistSongs.sort();
    this.renderCollection();
    
    playlistSong.save();
  }
});


var LibraryView = Backbone.Marionette.ItemView.extend({
  template: '#template-library'
});

app.addInitializer(function(options) {

  var playerView = new PlayerView();
  var playlistCompositeView = new PlaylistCompositeView({
    collection: playlistSongs
  });
  var libraryView = new LibraryView();

  app.playerRegion.show(playerView);
  app.playlistRegion.show(playlistCompositeView);
  app.libraryRegion.show(libraryView);
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



$(function() {
  app.start();
  new Router();
  Backbone.history.start();
});