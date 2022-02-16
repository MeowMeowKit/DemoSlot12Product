<%-- 
    Document   : index
    Created on : Feb 16, 2022, 11:23:28 AM
    Author     : LCCuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fu.ex.entities.Product" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of products</title>
    </head>
    <body>
        <h2>List of products</h2>
        <a href="ProductManagementServlet?action=addform">Add new Product</a> <br> <br>
        <table width="700px" border="1px solid">
            <tr>
                <th>PRODUCT ID</th> <th>NAME</th>  <th>DESCRIPTION</th> <th>QUANTITY</th> <th>PRICE</th>
                <th>IMAGE URL</th>
                <th> </th> <th> </th>
            </tr>
            <%
                ArrayList<Product> ldt = new ArrayList<Product>();
                ldt = (ArrayList<Product>) request.getAttribute("data");
                for (Product dt : ldt) {%>
            <tr>
                <td><%=dt.getId()%></td>
                <td><%=dt.getName()%></td>
                <td><%=dt.getDescription()%></td>
                <td><%=dt.getQuantity()%></td>
                <td><%=dt.getPrice()%></td>
                <td><%=dt.getImgURL()%></td>
                <td><a href="ProductManagementServlet?action=updateform&pid=<%=dt.getId()%>">EDIT</a></td>
                <td><a href="ProductManagementServlet?action=delete&pid=<%=dt.getId()%>"
                       onclick="return confirm('DELETE ENTRY?')">DELETE</a></td>
            </tr>
            <% }%>
        </table>

    </body>
</html>
