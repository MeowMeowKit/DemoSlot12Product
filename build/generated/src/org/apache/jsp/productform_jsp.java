package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import fu.ex.entities.Product;
import java.util.ArrayList;

public final class productform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Product p = (Product) request.getAttribute("pObject");
            String headerMsg = (String) request.getAttribute("msg");
            String action = (String) request.getAttribute("action");
            String errMsg = (String) request.getAttribute("errMsg");
        
      out.write("\n");
      out.write("        <h2> ");
      out.print( headerMsg);
      out.write("</h2>\n");
      out.write("        <font color=\"red\">");
 if (errMsg != null) {
      out.write(' ');
      out.print( errMsg);
      out.write(' ');
 }
      out.write(" </font>\n");
      out.write("        <table width=\"600px\" border=\"0px solid\">\n");
      out.write("            <form action=\"ProductManagementServlet\" method=\"post\" name=\"f1\">\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"");
      out.print( action);
      out.write("\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Product ID</td>\n");
      out.write("                    <td>: <input type=\"text\" name=\"id\" value=\"");
      out.print( p.getId());
      out.write("\"\n");
      out.write("                                 ");
 if (!action.equals("Create")) {
      out.write(" readonly ");
 }
      out.write("/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Name</td>\n");
      out.write("                    <td>: <input type=\"text\" name=\"name\" value=\"");
      out.print( p.getName());
      out.write("\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Description</td>\n");
      out.write("                    <td>: <textarea name=\"description\">");
      out.print( p.getDescription());
      out.write("</textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Quantity</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"quantity\" size=\"10\" value=\"");
      out.print( p.getQuantity());
      out.write("\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Price</td>\n");
      out.write("                    <td><input type=\"text\" name=\"price\" size=\"15\" value=\"");
      out.print( p.getPrice());
      out.write("\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Image URL</td>\n");
      out.write("                    <td><input type=\"text\" name=\"url\" value=\"");
      out.print( p.getImgURL());
      out.write("\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"center\">\n");
      out.write("                        <input type=\"submit\" value=\"");
      out.print( action);
      out.write("\" />\n");
      out.write("                        <input type=\"reset\" value=\"Reset\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"\">\n");
      out.write("            </form>\n");
      out.write("        </table>\n");
      out.write("        <br> <br>\n");
      out.write("        <a href=\"ProductManagementServlet\"> List of Products </a>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
