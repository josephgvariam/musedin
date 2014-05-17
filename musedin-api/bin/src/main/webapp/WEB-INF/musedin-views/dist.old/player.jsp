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

        
        <script src="scripts/vendor/cf69c6f2.modernizr.min.js"></script>
    
        <link href="styles/101205d0.bootstrap.css" rel="stylesheet">
        <style type="text/css">
          body {
            padding-top: 60px;
            padding-bottom: 40px;
          }
          .sidebar-nav {
            padding: 9px 0;
          }
        </style>
        <link href="styles/b626be49.bootstrap-responsive.css" rel="stylesheet">


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

    <div class="container-fluid">
      <div class="row-fluid">
        <div id="player" class="span12"></div>
      </div>
      
      <div class="row-fluid">
        <div id="playlist" class="span6"></div>
        <div id="library" class="span6"></div>
      </div>
      
      <hr>

      <footer>
        <p>&copy; MusedIn 2013</p>
      </footer>

    </div>



        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->

        <!-- Add your site or application content here -->
        
        <script src="scripts/dd32c062.scripts.js"></script>
        
        <!-- xbuildx:js scripts/musedin.js -->
        <script src="scripts/vendor/6b329d10.underscore.js"></script>
        <script src="scripts/vendor/70263c60.backbone.js"></script>
        <script src="scripts/vendor/da5be929.backbone.marionette.js"></script>
        <script src="scripts/9125711d.main.js"></script>        
        <!-- xendbuildx -->
        

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            s.parentNode.insertBefore(g,s)}(document,'script'));
        </script>
    
    <script src="scripts/b498763f.plugins.js"></script>

     <script type="text/html" id="template-player">
		<h1>Player</h1>		
		<audio src="" preload controls></audio>
     </script>
     
     <script type="text/html" id="template-playlist">
		<h1>Playlist</h1>
		<ul></ul>
     </script>
     
     <script type="text/html" id="template-playlist-song">
		<li>{{title}} <button class="upvote">{{upVotes}}</button> <button class="downvote">{{downVotes}}</button></li>
     </script>     
     
     <script type="text/html" id="template-library">
		<h1>Library</h1>
     </script>
     
     <script>
     	var player = new Player(${playerJson});
     	var playlistSongs = new PlaylistSongs(${playlistSongsJson});
     </script>

</body>
</html>
