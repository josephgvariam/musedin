package org.apache.jsp.WEB_002dINF.musedin_002dviews.dist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class player_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("  <title>MusedIn - Player</title>\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("\n");
      out.write("  <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/bdc9c4f6.bootstrap.css\"/>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/263254ea.player.css\"/>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <div class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("    <div class=\"navbar-inner\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("        <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n");
      out.write("          <span class=\"icon-bar\"></span>\n");
      out.write("          <span class=\"icon-bar\"></span>\n");
      out.write("          <span class=\"icon-bar\"></span>\n");
      out.write("        </a>\n");
      out.write("        <a class=\"brand\" href=\"/\">MusedIn</a>\n");
      out.write("        <div class=\"nav-collapse collapse\">\n");
      out.write("          <p class=\"navbar-text pull-right\">                \n");
      out.write("            Logged in as <a href=\"#\" class=\"navbar-link\">");
      if (_jspx_meth_sec_005fauthentication_005f0(_jspx_page_context))
        return;
      out.write("</a>\n");
      out.write("          </p>\n");
      out.write("          <ul class=\"nav\">\n");
      out.write("            <li><a href=\"/\">Home</a></li>\n");
      out.write("            <!--<li><a href=\"about\">About</a></li>-->            \n");
      out.write("            <li class=\"active\"><a href=\"#\">Player </a></li>\n");
      out.write("            <li><a href=\"contact\">Contact</a></li>\n");
      out.write("          </ul>\n");
      out.write("          <ul class=\"nav pull-right\">\n");
      out.write("            <li class=\"divider-vertical\"></li> \n");
      out.write("          </ul>\n");
      out.write("        </div><!--/.nav-collapse -->\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div id=\"container\"></div>\n");
      out.write("\n");
      out.write("  <footer class=\"footer\">   \n");
      out.write("    <p>&copy; MusedIn 2013</p>\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("    <div class=\"appinfo pull-left\">\n");
      out.write("        Version ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buildVersion}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write('#');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buildName  }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("        Build #");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buildNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write('@');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buildTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("        <div class=\"appinfofine\"\n");
      out.write("        Build ENV : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${buildEnv}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br>\n");
      out.write("        App Endpoint Url : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${appEndpoint}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("        App Path : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("    </div>    \n");
      out.write("\n");
      out.write("  <!-- Add your site or application content here -->\n");
      out.write("\n");
      out.write("  <script src=\"scripts/f03fce4d.scripts.js\"></script>\n");
      out.write("\n");
      out.write("  <script src=\"scripts/b48f3760.musedin.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-app-layout\" >\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div id=\"alert\"></div>\n");
      out.write("    <div class=\"row-fluid\">\n");
      out.write("\n");
      out.write("      <div class=\"span7\"> \n");
      out.write("        <div class=\"row-fluid\">\n");
      out.write("          <div class=\"span12\">\n");
      out.write("            <div id=\"toolbar\"></div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"row-fluid\">\n");
      out.write("          <div class=\"span12\" style=\"min-height:0px;\">\n");
      out.write("            <div id=\"nowplaying\"></div>\n");
      out.write("          </div>\n");
      out.write("        </div>     \n");
      out.write("\n");
      out.write("        <div class=\"row-fluid\">\n");
      out.write("          <div class=\"span12\" style=\"min-height:0px;\">\n");
      out.write("            <div id=\"player\"></div>\n");
      out.write("          </div>\n");
      out.write("        </div>         \n");
      out.write("\n");
      out.write("        <div class=\"row-fluid\">\n");
      out.write("          <div class=\"span12\">\n");
      out.write("            <div id=\"playlist\"></div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      <div class=\"span5\">\n");
      out.write("        <div class=\"row-fluid\">\n");
      out.write("          <div class=\"span12\">\n");
      out.write("            <div id=\"activity\"></div>\n");
      out.write("          </div>      \n");
      out.write("        </div>        \n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-init-layout\" >\n");
      out.write("    <div class=\"jumbotron masthead\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <h1>MusedIn</h1>\n");
      out.write("        <p>Music Democracy - Freedom to your playlist</p>\n");
      out.write("        <p>\n");
      out.write("          <a href=\"#\" id=\"startplayerbutton\" class=\"btn btn-primary btn-large\">Create New Player</a>\n");
      out.write("        </p>\n");
      out.write("        <!--\n");
      out.write("        <ul class=\"masthead-links\">          \n");
      out.write("          <li>\n");
      out.write("            <a href=\"#\">Link1</a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"#\">Link2</a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"#\">Link3</a>\n");
      out.write("          </li>          \n");
      out.write("        </ul>\n");
      out.write("        -->           \n");
      out.write("      </div>      \n");
      out.write("    </div>    \n");
      out.write("  </script>  \n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-toolbar\"> \n");
      out.write("  <input type=\"file\" id=\"fileElem\" multiple accept=\"audio/*\" style=\"display:none\" >\n");
      out.write("  <a href=\"#\" id=\"startplayerbutton\" class=\"btn btn-primary btn-large toolbar\">Start Player</a> \n");
      out.write("  <a class=\"btn btn-large btn-warning toolbar pull-right\">Player Code: {{code}}</a>\n");
      out.write("  <a id=\"fileSelect\" class=\"btn btn-large btn-success toolbar\">Load Files</a>  \n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-nowplaying\"> \n");
      out.write("  <div class=\"sex-bomb clearfix\" id=\"nowplayingsong\">\n");
      out.write("      <span class=\"downvote badge badge-important\"><i class=\"icon-arrow-down\"></i><span>{{nowPlayingSong.downVotes}}</span></span>\n");
      out.write("      <span class=\"upvote badge badge-success\"><i class=\"icon-arrow-up\"></i><span>{{nowPlayingSong.upVotes}}</span></span>\n");
      out.write("      <img src=\"{{nowPlayingSong.iconUrl}}\" class=\"pull-left nowplay img-polaroid\"/>\n");
      out.write("      <div class=\"nowplayingsongdetail\">\n");
      out.write("        <h4>{{nowPlayingSong.title}}</h4>\n");
      out.write("        <h5>{{nowPlayingSong.artist}}</h5>\n");
      out.write("        <h5>{{nowPlayingSong.album}}</h5>\n");
      out.write("        <h6>{{nowPlayingSong.fileName}}</h6>\n");
      out.write("      </div>\n");
      out.write("  </div>\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-player\">\n");
      out.write("  <div id=\"audioplayercontainer\" class=\"sex-bomb\">\n");
      out.write("    <audio id=\"audioplayer\" controls></audio>         \n");
      out.write("  </div>\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-activity\">\n");
      out.write("  <h1>Activity</h1>\n");
      out.write("  <ul class=\"activity\"></ul>\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-activity-item\">\n");
      out.write("  <div class=\"clearfix\">\n");
      out.write("    <div class=\"pull-left activity-code-{{code}}\"></div>\n");
      out.write("    <div class=\"activitydetail\">\n");
      out.write("      {{msg}}\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  </script> \n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-playlist\">\n");
      out.write("  <ul class=\"playlist\"></ul>\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <script type=\"text/template\" id=\"template-playlist-song\">\n");
      out.write("  <div class=\"clearfix\">\n");
      out.write("    <img src=\"{{iconUrl}}\" class=\"pull-left img-polaroid\" /> \n");
      out.write("    <span class=\"downvote badge badge-important\"><i class=\"icon-arrow-down\"></i>{{downVotes}}</span>\n");
      out.write("    <span class=\"upvote badge badge-success\"><i class=\"icon-arrow-up\"></i>{{upVotes}}</span>\n");
      out.write("    <div class=\"songdetail\">\n");
      out.write("      <h4>{{title}}</h4>\n");
      out.write("      <h5>{{artist}}</h5>\n");
      out.write("      <h5>{{album}}</h5>\n");
      out.write("      <h6>{{fileName}}</h6>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  </script>     \n");
      out.write("\n");
      out.write("  <script>\n");
      out.write("  var username = '");
      if (_jspx_meth_sec_005fauthentication_005f1(_jspx_page_context))
        return;
      out.write("';\n");
      out.write("  var player = new Player(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${playerJson}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(");\n");
      out.write("  var playlistSongs = new PlaylistSongs(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${playlistSongsJson}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(");\n");
      out.write("  var activities = new Activities(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${activitiesJson}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(");\n");
      out.write("  player.set('activities', activities);\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    var _gaq = _gaq || [];\n");
      out.write("    _gaq.push(['_setAccount', 'UA-38186336-1']);\n");
      out.write("    _gaq.push(['_trackPageview']);\n");
      out.write("\n");
      out.write("    (function() {\n");
      out.write("      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\n");
      out.write("      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n");
      out.write("      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\n");
      out.write("    })();\n");
      out.write("  </script>  \n");
      out.write("\n");
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

  private boolean _jspx_meth_sec_005fauthentication_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sec:authentication
    org.springframework.security.taglibs.authz.AuthenticationTag _jspx_th_sec_005fauthentication_005f0 = (org.springframework.security.taglibs.authz.AuthenticationTag) _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.get(org.springframework.security.taglibs.authz.AuthenticationTag.class);
    _jspx_th_sec_005fauthentication_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sec_005fauthentication_005f0.setParent(null);
    // /WEB-INF/musedin-views/dist/player.jsp(33,57) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sec_005fauthentication_005f0.setProperty("principal.username");
    int _jspx_eval_sec_005fauthentication_005f0 = _jspx_th_sec_005fauthentication_005f0.doStartTag();
    if (_jspx_th_sec_005fauthentication_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_sec_005fauthentication_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_sec_005fauthentication_005f0);
    return false;
  }

  private boolean _jspx_meth_sec_005fauthentication_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sec:authentication
    org.springframework.security.taglibs.authz.AuthenticationTag _jspx_th_sec_005fauthentication_005f1 = (org.springframework.security.taglibs.authz.AuthenticationTag) _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.get(org.springframework.security.taglibs.authz.AuthenticationTag.class);
    _jspx_th_sec_005fauthentication_005f1.setPageContext(_jspx_page_context);
    _jspx_th_sec_005fauthentication_005f1.setParent(null);
    // /WEB-INF/musedin-views/dist/player.jsp(199,18) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sec_005fauthentication_005f1.setProperty("principal.username");
    int _jspx_eval_sec_005fauthentication_005f1 = _jspx_th_sec_005fauthentication_005f1.doStartTag();
    if (_jspx_th_sec_005fauthentication_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_sec_005fauthentication_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_sec_005fauthentication_005f1);
    return false;
  }
}
