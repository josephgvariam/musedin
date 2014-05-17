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

        
        <link href="styles/101205d0.bootstrap.css" rel="stylesheet">
        <link href="styles/b626be49.bootstrap-responsive.css" rel="stylesheet">
        <link href="styles/fd317d86.main.css" rel="stylesheet">
        <script src="scripts/vendor/cf69c6f2.modernizr.min.js"></script>   


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
      
    
<div id="login" class="accounts-form">
  <h2>Log in to your account</h2>
  <hr class="small" />
  
  <div class="connect-buttons">
       <form class="connect-button" name="login" method="post" action="/signin/twitter" id="twitter-connect-form">
       <a href="#" onclick="$('#twitter-connect-form').submit(); return false;" class="btn" id="twitter_button"><span>Log in with <strong>Twitter</strong></span></a>
       </form>

       <form class="connect-button" name="login" method="post" action="/signin/facebook" id="facebook-connect-form">
       <a href="#" onclick="$('#facebook-connect-form').submit(); return false;" class="btn" id="facebook_button"><span>Log in with <strong>Facebook</strong></span></a>
       </form>
   </div>
   
   <form action="/resources/j_spring_security_check"  id="auth-form">
    
    
    <div class="all-errors">
    </div>
      <div class="input">
        <input id="id_username_login" type="text" name="j_username" maxlength="75" placeholder="Email"  />
        
      </div>
      <div class="input">
        <input type="password" name="j_password" id="id_password_login" placeholder="Password" />
        
    </div>
    <div class="actions clearfix">
    <input type="submit" value="Log In" class="btn btn-green" id="loginbutton" />

    </div>
    </form>
 
</div>
<p class="note"><a href="/accounts/password/reset">Forgot your password?</a> &middot; Need an account? <a href="signup">Sign up</a> </p>

      
  
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
        
        <script src="scripts/dd32c062.scripts.js"></script>
        

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            s.parentNode.insertBefore(g,s)}(document,'script'));
        </script>
             
    
    <script src="scripts/b498763f.plugins.js"></script>

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
