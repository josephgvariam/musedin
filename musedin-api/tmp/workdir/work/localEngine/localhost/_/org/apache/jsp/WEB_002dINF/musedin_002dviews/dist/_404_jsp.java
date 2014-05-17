package org.apache.jsp.WEB_002dINF.musedin_002dviews.dist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Page Not Found :(</title>\n");
      out.write("        <style>\n");
      out.write("            ::-moz-selection {\n");
      out.write("                background: #b3d4fc;\n");
      out.write("                text-shadow: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            ::selection {\n");
      out.write("                background: #b3d4fc;\n");
      out.write("                text-shadow: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            html {\n");
      out.write("                padding: 30px 10px;\n");
      out.write("                font-size: 20px;\n");
      out.write("                line-height: 1.4;\n");
      out.write("                color: #737373;\n");
      out.write("                background: #f0f0f0;\n");
      out.write("                -webkit-text-size-adjust: 100%;\n");
      out.write("                -ms-text-size-adjust: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            html,\n");
      out.write("            input {\n");
      out.write("                font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                max-width: 500px;\n");
      out.write("                _width: 500px;\n");
      out.write("                padding: 30px 20px 50px;\n");
      out.write("                border: 1px solid #b3b3b3;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("                box-shadow: 0 1px 10px #a7a7a7, inset 0 1px 0 #fff;\n");
      out.write("                background: #fcfcfc;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                margin: 0 10px;\n");
      out.write("                font-size: 50px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 span {\n");
      out.write("                color: #bbb;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h3 {\n");
      out.write("                margin: 1.5em 0 0.5em;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            p {\n");
      out.write("                margin: 1em 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            ul {\n");
      out.write("                padding: 0 0 0 40px;\n");
      out.write("                margin: 1em 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                max-width: 380px;\n");
      out.write("                _width: 380px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* google search */\n");
      out.write("\n");
      out.write("            #goog-fixurl ul {\n");
      out.write("                list-style: none;\n");
      out.write("                padding: 0;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #goog-fixurl form {\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #goog-wm-qt,\n");
      out.write("            #goog-wm-sb {\n");
      out.write("                border: 1px solid #bbb;\n");
      out.write("                font-size: 16px;\n");
      out.write("                line-height: normal;\n");
      out.write("                vertical-align: top;\n");
      out.write("                color: #444;\n");
      out.write("                border-radius: 2px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #goog-wm-qt {\n");
      out.write("                width: 220px;\n");
      out.write("                height: 20px;\n");
      out.write("                padding: 5px;\n");
      out.write("                margin: 5px 10px 0 0;\n");
      out.write("                box-shadow: inset 0 1px 1px #ccc;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #goog-wm-sb {\n");
      out.write("                display: inline-block;\n");
      out.write("                height: 32px;\n");
      out.write("                padding: 0 10px;\n");
      out.write("                margin: 5px 0 0;\n");
      out.write("                white-space: nowrap;\n");
      out.write("                cursor: pointer;\n");
      out.write("                background-color: #f5f5f5;\n");
      out.write("                background-image: -webkit-linear-gradient(rgba(255,255,255,0), #f1f1f1);\n");
      out.write("                background-image: -moz-linear-gradient(rgba(255,255,255,0), #f1f1f1);\n");
      out.write("                background-image: -ms-linear-gradient(rgba(255,255,255,0), #f1f1f1);\n");
      out.write("                background-image: -o-linear-gradient(rgba(255,255,255,0), #f1f1f1);\n");
      out.write("                -webkit-appearance: none;\n");
      out.write("                -moz-appearance: none;\n");
      out.write("                appearance: none;\n");
      out.write("                *overflow: visible;\n");
      out.write("                *display: inline;\n");
      out.write("                *zoom: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #goog-wm-sb:hover,\n");
      out.write("            #goog-wm-sb:focus {\n");
      out.write("                border-color: #aaa;\n");
      out.write("                box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);\n");
      out.write("                background-color: #f8f8f8;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #goog-wm-qt:hover,\n");
      out.write("            #goog-wm-qt:focus {\n");
      out.write("                border-color: #105cb6;\n");
      out.write("                outline: 0;\n");
      out.write("                color: #222;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input::-moz-focus-inner {\n");
      out.write("                padding: 0;\n");
      out.write("                border: 0;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Not found <span>:(</span></h1>\n");
      out.write("            <p>Sorry, but the page you were trying to view does not exist.</p>\n");
      out.write("            <p>It looks like this was the result of either:</p>\n");
      out.write("            <ul>\n");
      out.write("                <li>a mistyped address</li>\n");
      out.write("                <li>an out-of-date link</li>\n");
      out.write("            </ul>\n");
      out.write("            <script>\n");
      out.write("                var GOOG_FIXURL_LANG = (navigator.language || '').slice(0,2),GOOG_FIXURL_SITE = location.host;\n");
      out.write("            </script>\n");
      out.write("            <script src=\"http://linkhelp.clients.google.com/tbproxy/lh/wm/fixurl.js\"></script>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("       \n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/musedin-views/dist/404.jsp(159,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty exception}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("      <p>\n");
        out.write("        <h4>\n");
        out.write("          Exception Details\n");
        out.write("        </h4>\n");
        out.write("        Message:\n");
        out.write("\t\t");
        if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t<br/><br/>\n");
        out.write("\t\tTrace:\n");
        out.write("        ");
        if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("      </p>\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/musedin-views/dist/404.jsp(165,2) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${exception.message}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/musedin-views/dist/404.jsp(168,8) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/musedin-views/dist/404.jsp(168,8) '${exception.stackTrace}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${exception.stackTrace}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/musedin-views/dist/404.jsp(168,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("trace");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            ");
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\n");
          out.write("            <br />\n");
          out.write("          ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/musedin-views/dist/404.jsp(169,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${trace}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }
}
