<%@ page session="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>MusedIn - Player</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">

  <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

  
  
  
  <link href="styles/bootstrap.css" rel="stylesheet">
  <link href="styles/bootstrap-responsive.css" rel="stylesheet">
  <link href="styles/player.css" rel="stylesheet">

  <script src="scripts/vendor/modernizr.min.js"></script>

</head>
<body>

  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container-fluid">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </a>
        <a class="brand" href="/">MusedIn</a>
        <div class="nav-collapse collapse">
          <p class="navbar-text pull-right">                
            Logged in as <a href="#" class="navbar-link"><sec:authentication property="principal.username" /></a>
          </p>
          <ul class="nav">
            <li><a href="/">Home</a></li>
            <li><a href="about">About</a></li>
            <li><a href="contact">Contact</a></li>
            <li class="active"><a href="#">Player </a></li>
          </ul>
          <ul class="nav pull-right">
            <li class="divider-vertical"></li> 
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
  </div>

  <div id="container"></div>

  <footer class="footer">
    <p>&copy; MusedIn 2013</p>
  </footer>

  <!--[if lt IE 7]>
  <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
  <![endif]-->

  <!-- Add your site or application content here -->

  <!-- build:js scripts/scripts.js -->
  <script src="scripts/vendor/jquery.min.js"></script>
  <!-- endbuild -->         

  <!-- xbuildx:js scripts/musedin.js -->
  <script src="scripts/vendor/underscore.js"></script>
  <script src="scripts/vendor/backbone.js"></script>
  <script src="scripts/vendor/backbone.marionette.js"></script>
  <script src="scripts/vendor/jdataview.js"></script>
  <script src="scripts/main.js"></script>        
  <!-- xendbuildx -->


  <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
  <script>
  var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
  (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
    g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
    s.parentNode.insertBefore(g,s)}(document,'script'));
  </script>

  <!-- build:js scripts/plugins.js -->
  <script src="scripts/vendor/bootstrap/bootstrap-transition.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-alert.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-modal.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-dropdown.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-scrollspy.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-tab.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-tooltip.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-popover.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-button.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-collapse.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-carousel.js"></script>
  <script src="scripts/vendor/bootstrap/bootstrap-typeahead.js"></script>
  <!-- endbuild -->

  <script type="text/template" id="template-app-layout" >
    <div class="container-fluid">
      <div id="alert"></div>

      <div class="row-fluid">
        <div id="player" class="span12"></div>
      </div>
      
      <div class="row-fluid">
        <div id="playlist" class="span6"></div>
        <div id="library" class="span6"></div>
      </div>  

      <div class="row-fluid">
        <div id="log" class="span12"></div>
      </div>    
    </div>
  </script>

  <script type="text/template" id="template-init-layout" >
    <div class="jumbotron masthead">
      <div class="container">
        <h1>MusedIn</h1>
        <p>Music Democracy - Freedom to your playlist</p>
        <p>
          <a href="#" id="startplayerbutton" class="btn btn-primary btn-large">Start Player</a>
        </p>
        <ul class="masthead-links">
          <li>
            <a href="#">Link1</a>
          </li>
          <li>
            <a href="#">Link2</a>
          </li>
          <li>
            <a href="#">Link3</a>
          </li>
          <li>
            Version 1.0.0 BETA
          </li>
        </ul>
        <div id="test"></div>
      </div>
    </div>
  </script>  

  <script type="text/template" id="template-player">
  <h1>Player</h1>   
  <button id="startplayingbutton" class="btn btn-large btn-primary" type="button">Start Playing</button>
  <div class="player">
    <div class="row-fluid">
      <div class="span6">
        <span id="nowplay_downvote" class="downvote badge badge-important"><i class="icon-arrow-down"></i>-5</span>
        <span id="nowplay_upvote" class="upvote badge badge-success"><i class="icon-arrow-up"></i>+5</span>
        <img id="nowplay_songimg" src="images/song.png" class="pull-left nowplay"/>
        
        <h4 id="nowplay_songtitle">Song Title</h4>
        <h5 id="nowplay_songartist">Artist</h5>
        <h5 id="nowplay_songalbum">Album</h5>
      </div>
      <div class="row-fluid">
        <div class="span12">
          <audio id="audioplayer" src="http://localhost:8080/player" controls></audio>
        </div>
      </div>
    </div>    
  </div>
  </script>

  <script type="text/template" id="template-playlist">
  <h1>Playlist</h1>
  <ul class="playlist"></ul>
  </script>

  <script type="text/template" id="template-playlist-song">
  {{title}} <span class="downvote badge badge-important"><i class="icon-arrow-down"></i>{{downVotes}}</span>
  <span class="upvote badge badge-success"><i class="icon-arrow-up"></i>{{upVotes}}</span>
  </script>     

  <script type="text/template" id="template-library">
  <h1>Library</h1>
  <input type="file" id="fileElem" multiple accept="audio/*" style="display:none" >
  <a href="#" id="fileSelect">Select some files</a> 
  </script>

  <script>
  var player = new Player(${playerJson});
  var playlistSongs = new PlaylistSongs(${playlistSongsJson});
  </script>

</body>
</html>
