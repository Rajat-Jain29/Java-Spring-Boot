/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.43
 * Generated at: 2021-03-21 10:07:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700\" rel=\"stylesheet\">\r\n");
      out.write("<title>SIGN UP FORM</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script> \r\n");
      out.write("<style>\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\tcolor: #fff;\r\n");
      out.write("\t\tbackground: #3598dc;\r\n");
      out.write("\t\tfont-family: 'Roboto', sans-serif;\r\n");
      out.write("\t}\r\n");
      out.write("    .form-control{\r\n");
      out.write("\t\theight: 41px;\r\n");
      out.write("\t\tbackground: #f2f2f2;\r\n");
      out.write("\t\tbox-shadow: none !important;\r\n");
      out.write("\t\tborder: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t.form-control:focus{\r\n");
      out.write("\t\tbackground: #e2e2e2;\r\n");
      out.write("\t}\r\n");
      out.write("    .form-control, .btn{        \r\n");
      out.write("        border-radius: 3px;\r\n");
      out.write("    }\r\n");
      out.write("\t.signup-form{\r\n");
      out.write("\t\twidth: 390px;\r\n");
      out.write("\t\tmargin: 30px auto;\r\n");
      out.write("\t}\r\n");
      out.write("\t.signup-form form{\r\n");
      out.write("\t\tcolor: #999;\r\n");
      out.write("\t\tborder-radius: 3px;\r\n");
      out.write("    \tmargin-bottom: 15px;\r\n");
      out.write("        background: #fff;\r\n");
      out.write("        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\r\n");
      out.write("        padding: 30px;\r\n");
      out.write("    }\r\n");
      out.write("\t.signup-form h2 {\r\n");
      out.write("\t\tcolor: #333;\r\n");
      out.write("\t\tfont-weight: bold;\r\n");
      out.write("        margin-top: 0;\r\n");
      out.write("    }\r\n");
      out.write("    .signup-form hr {\r\n");
      out.write("        margin: 0 -30px 20px;\r\n");
      out.write("    }    \r\n");
      out.write("\t.signup-form .form-group{\r\n");
      out.write("\t\tmargin-bottom: 20px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.signup-form input[type=\"checkbox\"]{\r\n");
      out.write("\t\tmargin-top: 3px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.signup-form .row div:first-child{\r\n");
      out.write("\t\tpadding-right: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.signup-form .row div:last-child{\r\n");
      out.write("\t\tpadding-left: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("    .signup-form .btn{        \r\n");
      out.write("        font-size: 16px;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("\t\tbackground: #3598dc;\r\n");
      out.write("\t\tborder: none;\r\n");
      out.write("\t\tmin-width: 140px;\r\n");
      out.write("    }\r\n");
      out.write("\t.signup-form .btn:hover, .signup-form .btn:focus{\r\n");
      out.write("\t\tbackground: #2389cd !important;\r\n");
      out.write("        outline: none;\r\n");
      out.write("\t}\r\n");
      out.write("    .signup-form a{\r\n");
      out.write("\t\tcolor: #fff;\r\n");
      out.write("\t\ttext-decoration: underline;\r\n");
      out.write("\t}\r\n");
      out.write("\t.signup-form a:hover{\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t.signup-form form a{\r\n");
      out.write("\t\tcolor: #3598dc;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\t\r\n");
      out.write("\t.signup-form form a:hover{\r\n");
      out.write("\t\ttext-decoration: underline;\r\n");
      out.write("\t}\r\n");
      out.write("    .signup-form .hint-text {\r\n");
      out.write("\t\tpadding-bottom: 15px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"signup-form\">\r\n");
      out.write("    <form action=\"Register\" method=\"post\">\r\n");
      out.write("\t\t<h2>Sign Up</h2>\r\n");
      out.write("\t\t<p>Please fill in this form to create an account!</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"Name\" placeholder=\"Name\" required=\"required\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t      \t\r\n");
      out.write("        </div>\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"username\" placeholder=\"User Name\" required=\"required\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t      \t\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("        \t<input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"Email\" required=\"required\">\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("            <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\" required=\"required\">\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t\r\n");
      out.write("   \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"address\" placeholder=\"Address\" required=\"required\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t      \t\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"phone\" placeholder=\"Contact No.\" required=\"required\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t      \t\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"Pincode\" placeholder=\"Pincode\" required=\"required\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t      \t\r\n");
      out.write("        </div>\r\n");
      out.write("                 \r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("\t\t\t<label class=\"checkbox-inline\"><input type=\"checkbox\" required=\"required\"> I accept the <a href=\"#\">Terms of Use</a> &amp; <a href=\"#\">Privacy Policy</a></label>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary btn-lg\">Sign Up</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    <div class=\"hint-text\">Already have an account? <a href=\"#\">Login here</a></div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}