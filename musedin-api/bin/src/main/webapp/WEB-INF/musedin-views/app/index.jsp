<%@ page session="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>MusedIn - Music Democracy</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="MusedIn - Music Democracy">
        <meta name="author" content="nRoots.com">

        <link href="styles/bootstrap.css" rel="stylesheet">
        <link href="styles/bootstrap-responsive.css" rel="stylesheet">
        <link href="styles/main.css" rel="stylesheet">
        <script src="scripts/vendor/modernizr.min.js"></script>
        <style type="text/css">
          .navbar-text {
            padding: 5px;
          }
        </style>

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="images/ico/favicon.png">

    </head>
    <body>

    <!-- NAVBAR
    ================================================== -->
    <div class="navbar-wrapper">
      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
      <div class="container">

        <div class="navbar navbar-inverse">
          <div class="navbar-inner">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </a>
            <a class="brand" href="/">MusedIn</a>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
              <sec:authorize access="isAuthenticated()">
            <p class="navbar-text pull-right">                
              Logged in as <a href="#" class="navbar-link"><sec:authentication property="principal.username" /></a>
            </p>
              </sec:authorize>
              <ul class="nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="about">About</a></li>
                <li><a href="contact">Contact</a></li>
                <li><a href="player">Player</a></li>
                <!-- Read about Bootstrap dropdowns at http://twitter.github.com/bootstrap/javascript.html#dropdowns -->
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li class="nav-header">Nav header</li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>                  
                </li>
              </ul>


              <ul class="nav pull-right">
                <li class="divider-vertical"></li>
                <sec:authorize access="isAnonymous()">
                	<li><div><a style="margin-left: 5px; margin-top: 10px" class="btn btn-primary" href="signup" data-toggle="modal" data-target="#signup-modal">Sign Up</a></div></li>
                	<li><div><a style="margin-left: 5px; margin-top: 10px" class="btn btn-success" href="login" data-toggle="modal" data-target="#login-modal">Log In</a></div></li>
                </sec:authorize>                
              </ul>

            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->

      </div> <!-- /.container -->
    </div><!-- /.navbar-wrapper -->



    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src="images/slide-01.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>MusedIn for Music Democracy</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <sec:authorize access="isAnonymous()">
              <a class="btn btn-large btn-primary" href="signup">Sign up today</a>
              </sec:authorize>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="images/slide-02.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>Another example headline.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="#">Learn more</a>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="images/slide-03.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>One more for good measure.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="#">Browse gallery</a>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->



    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="span4">
          <img class="img-circle" data-src="holder.js/140x140">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
        </div><!-- /.span4 -->
        <div class="span4">
          <img class="img-circle" data-src="holder.js/140x140">
          <h2>Heading</h2>
          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
        </div><!-- /.span4 -->
        <div class="span4">
          <img class="img-circle" data-src="holder.js/140x140">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
        </div><!-- /.span4 -->
      </div><!-- /.row -->


      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="featurette">
        <img class="featurette-image pull-right" src="images/browser-icon-chrome.png">
        <h2 class="featurette-heading">First featurette headling. <span class="muted">It'll blow your mind.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>

      <hr class="featurette-divider">

      <div class="featurette">
        <img class="featurette-image pull-left" src="images/browser-icon-firefox.png">
        <h2 class="featurette-heading">Oh yeah, it's that good. <span class="muted">See for yourself.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>

      <hr class="featurette-divider">

      <div class="featurette">
        <img class="featurette-image pull-right" src="images/browser-icon-safari.png">
        <h2 class="featurette-heading">And lastly, this one. <span class="muted">Checkmate.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>

      <hr class="featurette-divider">

      <!-- /END THE FEATURETTES -->


      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2012 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->

        <div class="modal hide fade" tabindex="-1" id="login-modal">
    <a class="close" data-dismiss="modal">&times;</a>
    <h1>Log in to MusedIn</h1>
    
    <form class="connect-button" name="login" method="post" action="/signin/twitter" id="twitter-connect-form">
    
    <a href="#" onclick="$('#twitter-connect-form').submit(); return false;" class="signup-twitter signup-btn" id="twitter_button" class="signup-twitter signup-btn"><i></i>Log in with Twitter</a>
    </form>
    <form class="connect-button" name="login" method="post" action="/signin/facebook" id="facebook-connect-form">
      <div style='display:none'><input type='hidden' name='csrfmiddlewaretoken' value='CCkKDIUYrmw69RJfHrAPD523GlGxRoFl' /></div>
      
      <a href="#" onclick="$('#facebook-connect-form').submit(); return false;" class="signup-facebook signup-btn" id="facebook_button"><i></i>Log in  with Facebook</a>
      </form>

      <form action="/resources/j_spring_security_check" method="POST" autocomplete="off">  
        <fieldset>
            <h5>or with MusedIn account</h5>
            <input type="email" placeholder="Email" name="j_username" maxlength="75" id="id_username_login" value="joppu@variam.com"/>
            <input type="password" placeholder="Password" name="j_password" id="id_password_login" value="admin"/>
            <input type="submit" value="Log in" class="btn" id="loginbutton">
        </fieldset>
         <a href="/accounts/password/reset/"><span>Forgot password?</span></a> &middot; <a href="signup"><span>Sign up for MusedIn</span></a>
     </form>
</div>

        <div class="modal hide fade" tabindex="-1" id="signup-modal">
    <a class="close" data-dismiss="modal">&times;</a>
    <h1>Sign up for MusedIn</h1>
    
    <form class="connect-button" name="login" method="post" action="/signin/twitter" id="twitter-connect-form">
    
    <a href="#" onclick="$('#twitter-connect-form').submit(); return false;" class="signup-twitter signup-btn" id="twitter_button" class="signup-twitter signup-btn"><i></i>Sign up with Twitter</a>
    </form>
    <form class="connect-button" name="login" method="post" action="/sigin/facebook" id="facebook-connect-form">
      
      <a href="#" onclick="$('#facebook-connect-form').submit(); return false;" class="signup-facebook signup-btn" id="facebook_button"><i></i>Sign up with Facebook</a>
      </form>

      <form action="/signup" method="POST" autocomplete="off">
          
        <fieldset>
            <h5>or with email</h5>
            <input type="email" placeholder="Email" name="username" maxlength="75" id="id_username_signup" /><div class="email_suggestion"></div>
            <input type="password" placeholder="Password" name="password" id="id_password" />
            <input type="submit" value="Sign Up" class="btn">
        </fieldset>
         <a href="login"><span>Already have an account?</span> Log in</a>
     </form>
     
     

</div>  





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
