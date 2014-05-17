<%@ page session="true" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>MusedIn - Sign In</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

        
        <link href="styles/bootstrap.css" rel="stylesheet">
        <link href="styles/bootstrap-responsive.css" rel="stylesheet">
        <link href="styles/main.css" rel="stylesheet">
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
            <ul class="nav">
              <li><a href="/">Home</a></li>
              <li><a href="about">About</a></li>
              <li><a href="contact">Contact</a></li>
              <li><a href="player">Player </a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>      

  <article class="container">
      
    
<div id="signup" class="accounts-form">
  <h2>Create your free account</h2>
  <hr class="small" />
  
  <div class="connect-buttons">

      <form class="connect-button" name="login" method="post" action="/social/twitter/redirect/" id="twitter-connect-form">
      <div style='display:none'><input type='hidden' name='csrfmiddlewaretoken' value='CCkKDIUYrmw69RJfHrAPD523GlGxRoFl' /></div>
      
          <input type="hidden" name="next" value="/welcome/" />
      
      <a href="#" onclick="$('#twitter-connect-form').submit(); return false;" class="btn" id="twitter_button"><span>Sign up with <strong>Twitter</strong></span></a>
      </form>

      <form class="connect-button" name="login" method="post" action="/social/facebook/redirect/" id="facebook-connect-form">
      <div style='display:none'><input type='hidden' name='csrfmiddlewaretoken' value='CCkKDIUYrmw69RJfHrAPD523GlGxRoFl' /></div>
      
          <input type="hidden" name="next" value="/welcome/" />
      
      <a href="#" onclick="$('#facebook-connect-form').submit(); return false;" class="btn" id="facebook_button"><span>Sign up with <strong>Facebook</strong></span></a>
      </form>
  </div>

  <form action="/signup" method="POST" autocomplete="off" class="clearfix" id="auth-form"><div style='display:none'><input type='hidden' name='csrfmiddlewaretoken' value='CCkKDIUYrmw69RJfHrAPD523GlGxRoFl' /></div>
    <h3>or with email</h3>
    <div class="all-errors">
        
    </div>

      <div class="input">
        <input id="id_email" type="text" placeholder="Email" name="email" maxlength="75" />
        
        <div class="email_suggestion"></div>
      </div>
      <div class="input">
        <input type="password" placeholder="Password" name="password" id="id_password" />
      
    </div>

    <div class="actions clearfix">
        
            <input type="hidden" name="next" value="/welcome/" />
        
        <input type="submit" value="Create account" class="btn btn-green"/>
    </div>
</form>
</div>

<p class="note">Already have an account? <a href="login.html">Log in</a></p>



      
    
    

<hr class="featurette-divider">    

      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2012 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </article> <!-- /container -->



        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->

        <!-- Add your site or application content here -->
        
        <!-- build:js scripts/scripts.js -->
        <script src="scripts/vendor/jquery.min.js"></script>
        <!-- endbuild -->
        

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            s.parentNode.insertBefore(g,s)}(document,'script'));
        </script>
    
    <!-- build:js scripts/plugins.js -->
    <script src="scripts/vendor/bootstrap/bootstrap-affix.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-alert.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-dropdown.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-tooltip.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-modal.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-transition.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-button.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-popover.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-typeahead.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-carousel.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-scrollspy.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-collapse.js"></script>
    <script src="scripts/vendor/bootstrap/bootstrap-tab.js"></script>
    <!-- endbuild -->

    <script>
      !function ($) {
        $(function(){
          // carousel demo
          $('#myCarousel').carousel()
        })
      }(window.jQuery)
    </script>
</body>
</html>
