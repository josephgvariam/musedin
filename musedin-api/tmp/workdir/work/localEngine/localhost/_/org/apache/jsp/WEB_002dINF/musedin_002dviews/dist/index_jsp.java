package org.apache.jsp.WEB_002dINF.musedin_002dviews.dist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.release();
    _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <title>MusedIn - Music Democracy</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"description\" content=\"MusedIn - Music Democracy\">\n");
      out.write("        <meta name=\"author\" content=\"nRoots.com\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/bdc9c4f6.bootstrap.css\"/>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/2bcb6dd0.app.css\"/>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("          .navbar-text {\n");
      out.write("            padding: 5px;\n");
      out.write("          }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    <!-- Fav and touch icons -->\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("      <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("                    <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("                                   <link rel=\"shortcut icon\" href=\"images/ico/favicon.png\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <!-- NAVBAR\n");
      out.write("    ================================================== -->\n");
      out.write("    <div class=\"navbar-wrapper\">\n");
      out.write("      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->\n");
      out.write("      <div class=\"container\">\n");
      out.write("\n");
      out.write("        <div class=\"navbar navbar-inverse\">\n");
      out.write("          <div class=\"navbar-inner\">\n");
      out.write("            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->\n");
      out.write("            <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n");
      out.write("              <span class=\"icon-bar\"></span>\n");
      out.write("              <span class=\"icon-bar\"></span>\n");
      out.write("              <span class=\"icon-bar\"></span>\n");
      out.write("            </a>\n");
      out.write("            <a class=\"brand\" href=\"/\">MusedIn</a>\n");
      out.write("            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->\n");
      out.write("            <div class=\"nav-collapse collapse\">\n");
      out.write("              ");
      if (_jspx_meth_sec_005fauthorize_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("              <ul class=\"nav\">\n");
      out.write("                <li class=\"active\"><a href=\"/\">Home</a></li>\n");
      out.write("                <!--<li><a href=\"about\">About</a></li>-->                \n");
      out.write("                <li><a href=\"player\">Player</a></li>\n");
      out.write("                <li><a href=\"contact\">Contact</a></li>\n");
      out.write("                <!-- Read about Bootstrap dropdowns at http://twitter.github.com/bootstrap/javascript.html#dropdowns -->\n");
      out.write("                <!--\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                  <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Dropdown <b class=\"caret\"></b></a>\n");
      out.write("                  <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"#\">Action</a></li>\n");
      out.write("                    <li><a href=\"#\">Another action</a></li>\n");
      out.write("                    <li><a href=\"#\">Something else here</a></li>\n");
      out.write("                    <li class=\"divider\"></li>\n");
      out.write("                    <li class=\"nav-header\">Nav header</li>\n");
      out.write("                    <li><a href=\"#\">Separated link</a></li>\n");
      out.write("                    <li><a href=\"#\">One more separated link</a></li>\n");
      out.write("                  </ul>                  \n");
      out.write("                </li>\n");
      out.write("              -->\n");
      out.write("              </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("              <ul class=\"nav pull-right\">\n");
      out.write("                <li class=\"divider-vertical\"></li>\n");
      out.write("                ");
      if (_jspx_meth_sec_005fauthorize_005f1(_jspx_page_context))
        return;
      out.write("                \n");
      out.write("              </ul>\n");
      out.write("\n");
      out.write("            </div><!--/.nav-collapse -->\n");
      out.write("          </div><!-- /.navbar-inner -->\n");
      out.write("        </div><!-- /.navbar -->\n");
      out.write("\n");
      out.write("      </div> <!-- /.container -->\n");
      out.write("    </div><!-- /.navbar-wrapper -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Carousel\n");
      out.write("    ================================================== -->\n");
      out.write("    <div id=\"myCarousel\" class=\"carousel slide\">\n");
      out.write("      <div class=\"carousel-inner\">\n");
      out.write("        <div class=\"item active\">\n");
      out.write("          <img src=\"images/089e58d5.slide-01.jpg\" alt=\"\">\n");
      out.write("          <div class=\"container\">\n");
      out.write("            <div class=\"carousel-caption\">\n");
      out.write("              <h1>MusedIn for Music Democracy</h1>\n");
      out.write("              <p class=\"lead\">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\n");
      out.write("              ");
      if (_jspx_meth_sec_005fauthorize_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"item\">\n");
      out.write("          <img src=\"images/d137c9c0.slide-02.jpg\" alt=\"\">\n");
      out.write("          <div class=\"container\">\n");
      out.write("            <div class=\"carousel-caption\">\n");
      out.write("              <h1>Another example headline.</h1>\n");
      out.write("              <p class=\"lead\">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\n");
      out.write("              <a class=\"btn btn-large btn-primary\" href=\"#\">Learn more</a>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"item\">\n");
      out.write("          <img src=\"images/1f8271cb.slide-03.jpg\" alt=\"\">\n");
      out.write("          <div class=\"container\">\n");
      out.write("            <div class=\"carousel-caption\">\n");
      out.write("              <h1>One more for good measure.</h1>\n");
      out.write("              <p class=\"lead\">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\n");
      out.write("              <a class=\"btn btn-large btn-primary\" href=\"#\">Browse gallery</a>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <a class=\"left carousel-control\" href=\"#myCarousel\" data-slide=\"prev\">&lsaquo;</a>\n");
      out.write("      <a class=\"right carousel-control\" href=\"#myCarousel\" data-slide=\"next\">&rsaquo;</a>\n");
      out.write("    </div><!-- /.carousel -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Marketing messaging and featurettes\n");
      out.write("    ================================================== -->\n");
      out.write("    <!-- Wrap the rest of the page in another container to center all the content. -->\n");
      out.write("\n");
      out.write("    <div class=\"container marketing\">\n");
      out.write("\n");
      out.write("      <!-- Three columns of text below the carousel -->\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"span4\">\n");
      out.write("          <img class=\"img-circle\" data-src=\"holder.js/140x140\">\n");
      out.write("          <h2>Heading</h2>\n");
      out.write("          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>\n");
      out.write("          <p><a class=\"btn\" href=\"#\">View details &raquo;</a></p>\n");
      out.write("        </div><!-- /.span4 -->\n");
      out.write("        <div class=\"span4\">\n");
      out.write("          <img class=\"img-circle\" data-src=\"holder.js/140x140\">\n");
      out.write("          <h2>Heading</h2>\n");
      out.write("          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>\n");
      out.write("          <p><a class=\"btn\" href=\"#\">View details &raquo;</a></p>\n");
      out.write("        </div><!-- /.span4 -->\n");
      out.write("        <div class=\"span4\">\n");
      out.write("          <img class=\"img-circle\" data-src=\"holder.js/140x140\">\n");
      out.write("          <h2>Heading</h2>\n");
      out.write("          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>\n");
      out.write("          <p><a class=\"btn\" href=\"#\">View details &raquo;</a></p>\n");
      out.write("        </div><!-- /.span4 -->\n");
      out.write("      </div><!-- /.row -->\n");
      out.write("\n");
      out.write("\n");
      out.write("      <!-- START THE FEATURETTES -->\n");
      out.write("\n");
      out.write("      <hr class=\"featurette-divider\">\n");
      out.write("\n");
      out.write("      <div class=\"featurette\">\n");
      out.write("        <img class=\"featurette-image pull-right\" src=\"images/74b25008.browser-icon-chrome.png\">\n");
      out.write("        <h2 class=\"featurette-heading\">First featurette headling. <span class=\"muted\">It'll blow your mind.</span></h2>\n");
      out.write("        <p class=\"lead\">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <hr class=\"featurette-divider\">\n");
      out.write("\n");
      out.write("      <div class=\"featurette\">\n");
      out.write("        <img class=\"featurette-image pull-left\" src=\"images/5952e42c.browser-icon-firefox.png\">\n");
      out.write("        <h2 class=\"featurette-heading\">Oh yeah, it's that good. <span class=\"muted\">See for yourself.</span></h2>\n");
      out.write("        <p class=\"lead\">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <hr class=\"featurette-divider\">\n");
      out.write("\n");
      out.write("      <div class=\"featurette\">\n");
      out.write("        <img class=\"featurette-image pull-right\" src=\"images/96731689.browser-icon-safari.png\">\n");
      out.write("        <h2 class=\"featurette-heading\">And lastly, this one. <span class=\"muted\">Checkmate.</span></h2>\n");
      out.write("        <p class=\"lead\">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <hr class=\"featurette-divider\">\n");
      out.write("\n");
      out.write("      <!-- /END THE FEATURETTES -->\n");
      out.write("\n");
      out.write("\n");
      out.write("      <!-- FOOTER -->\n");
      out.write("      <footer>\n");
      out.write("        <p class=\"pull-right\"><a href=\"#\">Back to top</a></p>\n");
      out.write("        <p>&copy; 2012 Company, Inc. &middot; <a href=\"#\">Privacy</a> &middot; <a href=\"#\">Terms</a></p>\n");
      out.write("      </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"login-modal\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"Login\" aria-hidden=\"true\">\n");
      out.write("    <a class=\"close\" data-dismiss=\"modal\">&times;</a>\n");
      out.write("    <h1>Log in to MusedIn</h1>\n");
      out.write("    \n");
      out.write("    <form class=\"connect-button\" name=\"login\" method=\"post\" action=\"/signin/twitter\" id=\"twitter-connect-form\">\n");
      out.write("    \n");
      out.write("    <a href=\"#\" onclick=\"$('#twitter-connect-form').submit(); return false;\" class=\"signup-twitter signup-btn\" id=\"twitter_button\" class=\"signup-twitter signup-btn\"><i></i>Log in with Twitter</a>\n");
      out.write("    </form>\n");
      out.write("    <form class=\"connect-button\" name=\"login\" method=\"post\" action=\"/signin/facebook\" id=\"facebook-connect-form\">\n");
      out.write("      <div style='display:none'><input type='hidden' name='csrfmiddlewaretoken' value='CCkKDIUYrmw69RJfHrAPD523GlGxRoFl' /></div>\n");
      out.write("      \n");
      out.write("      <a href=\"#\" onclick=\"$('#facebook-connect-form').submit(); return false;\" class=\"signup-facebook signup-btn\" id=\"facebook_button\"><i></i>Log in  with Facebook</a>\n");
      out.write("      </form>\n");
      out.write("\n");
      out.write("      <form action=\"/resources/j_spring_security_check\" method=\"POST\" autocomplete=\"off\">  \n");
      out.write("        <fieldset>\n");
      out.write("            <h5>or with MusedIn account</h5>\n");
      out.write("            <input type=\"email\" placeholder=\"Email\" name=\"j_username\" maxlength=\"75\" id=\"id_username_login\" value=\"joppu@variam.com\"/>\n");
      out.write("            <input type=\"password\" placeholder=\"Password\" name=\"j_password\" id=\"id_password_login\" value=\"admin\"/>\n");
      out.write("            <input type=\"submit\" value=\"Log in\" class=\"btn\" id=\"loginbutton\">\n");
      out.write("        </fieldset>\n");
      out.write("         <a href=\"/accounts/password/reset/\"><span>Forgot password?</span></a> &middot; <a href=\"signup\"><span>Sign up for MusedIn</span></a>\n");
      out.write("     </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        <div class=\"modal hide fade\" tabindex=\"-1\" id=\"signup-modal\">\n");
      out.write("    <a class=\"close\" data-dismiss=\"modal\">&times;</a>\n");
      out.write("    <h1>Sign up for MusedIn</h1>\n");
      out.write("    \n");
      out.write("    <form class=\"connect-button\" name=\"login\" method=\"post\" action=\"/signin/twitter\" id=\"twitter-connect-form\">\n");
      out.write("    \n");
      out.write("    <a href=\"#\" onclick=\"$('#twitter-connect-form').submit(); return false;\" class=\"signup-twitter signup-btn\" id=\"twitter_button\" class=\"signup-twitter signup-btn\"><i></i>Sign up with Twitter</a>\n");
      out.write("    </form>\n");
      out.write("    <form class=\"connect-button\" name=\"login\" method=\"post\" action=\"/sigin/facebook\" id=\"facebook-connect-form\">\n");
      out.write("      \n");
      out.write("      <a href=\"#\" onclick=\"$('#facebook-connect-form').submit(); return false;\" class=\"signup-facebook signup-btn\" id=\"facebook_button\"><i></i>Sign up with Facebook</a>\n");
      out.write("      </form>\n");
      out.write("\n");
      out.write("      <form action=\"/signup\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("          \n");
      out.write("        <fieldset>\n");
      out.write("            <h5>or with email</h5>\n");
      out.write("            <input type=\"email\" placeholder=\"Email\" name=\"username\" maxlength=\"75\" id=\"id_username_signup\" /><div class=\"email_suggestion\"></div>\n");
      out.write("            <input type=\"password\" placeholder=\"Password\" name=\"password\" id=\"id_password\" />\n");
      out.write("            <input type=\"submit\" value=\"Sign Up\" class=\"btn\">\n");
      out.write("        </fieldset>\n");
      out.write("         <a href=\"login\"><span>Already have an account?</span> Log in</a>\n");
      out.write("     </form>\n");
      out.write("     \n");
      out.write("     \n");
      out.write("\n");
      out.write("</div> \n");
      out.write("\n");
      out.write("    </div><!-- /.container -->\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Add your site or application content here -->\n");
      out.write("        \n");
      out.write("        <script src=\"scripts/f03fce4d.scripts.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("          var _gaq = _gaq || [];\n");
      out.write("          _gaq.push(['_setAccount', 'UA-38186336-1']);\n");
      out.write("          _gaq.push(['_trackPageview']);\n");
      out.write("\n");
      out.write("          (function() {\n");
      out.write("            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\n");
      out.write("            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n");
      out.write("            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\n");
      out.write("          })();\n");
      out.write("        </script>\n");
      out.write("  \n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("      !function ($) {\n");
      out.write("        $(function(){\n");
      out.write("          // carousel demo\n");
      out.write("          $('#myCarousel').carousel()\n");
      out.write("        })\n");
      out.write("      }(window.jQuery)\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_sec_005fauthorize_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f0 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_sec_005fauthorize_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sec_005fauthorize_005f0.setParent(null);
    // /WEB-INF/musedin-views/dist/index.jsp(52,14) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sec_005fauthorize_005f0.setAccess("isAuthenticated()");
    int _jspx_eval_sec_005fauthorize_005f0 = _jspx_th_sec_005fauthorize_005f0.doStartTag();
    if (_jspx_eval_sec_005fauthorize_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n");
      out.write("            <p class=\"navbar-text pull-right\">                \n");
      out.write("              Logged in as <a href=\"#\" class=\"navbar-link\">");
      if (_jspx_meth_sec_005fauthentication_005f0(_jspx_th_sec_005fauthorize_005f0, _jspx_page_context))
        return true;
      out.write("</a>\n");
      out.write("            </p>\n");
      out.write("              ");
    }
    if (_jspx_th_sec_005fauthorize_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f0);
    return false;
  }

  private boolean _jspx_meth_sec_005fauthentication_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_sec_005fauthorize_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sec:authentication
    org.springframework.security.taglibs.authz.AuthenticationTag _jspx_th_sec_005fauthentication_005f0 = (org.springframework.security.taglibs.authz.AuthenticationTag) _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.get(org.springframework.security.taglibs.authz.AuthenticationTag.class);
    _jspx_th_sec_005fauthentication_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sec_005fauthentication_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sec_005fauthorize_005f0);
    // /WEB-INF/musedin-views/dist/index.jsp(54,59) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sec_005fauthentication_005f0.setProperty("principal.username");
    int _jspx_eval_sec_005fauthentication_005f0 = _jspx_th_sec_005fauthentication_005f0.doStartTag();
    if (_jspx_th_sec_005fauthentication_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_sec_005fauthentication_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_sec_005fauthentication_005f0);
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f1 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_sec_005fauthorize_005f1.setPageContext(_jspx_page_context);
    _jspx_th_sec_005fauthorize_005f1.setParent(null);
    // /WEB-INF/musedin-views/dist/index.jsp(82,16) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sec_005fauthorize_005f1.setAccess("isAnonymous()");
    int _jspx_eval_sec_005fauthorize_005f1 = _jspx_th_sec_005fauthorize_005f1.doStartTag();
    if (_jspx_eval_sec_005fauthorize_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n");
      out.write("                \t<li><div><a style=\"margin-left: 5px; margin-top: 10px\" class=\"btn btn-primary\" href=\"#signup-modal\" data-toggle=\"modal\">Sign Up</a></div></li>\n");
      out.write("                \t<li><div><a style=\"margin-left: 5px; margin-top: 10px\" class=\"btn btn-success\" href=\"#login-modal\" data-toggle=\"modal\">Log In</a></div></li>\n");
      out.write("                ");
    }
    if (_jspx_th_sec_005fauthorize_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f1);
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f2 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_sec_005fauthorize_005f2.setPageContext(_jspx_page_context);
    _jspx_th_sec_005fauthorize_005f2.setParent(null);
    // /WEB-INF/musedin-views/dist/index.jsp(107,14) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sec_005fauthorize_005f2.setAccess("isAnonymous()");
    int _jspx_eval_sec_005fauthorize_005f2 = _jspx_th_sec_005fauthorize_005f2.doStartTag();
    if (_jspx_eval_sec_005fauthorize_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n");
      out.write("              <a class=\"btn btn-large btn-primary\" href=\"signup\">Sign up today</a>\n");
      out.write("              ");
    }
    if (_jspx_th_sec_005fauthorize_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f2);
    return false;
  }
}
