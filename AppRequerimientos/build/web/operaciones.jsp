<%--  
    Document   : operaciones
    Created on : 10/10/2018, 12:14:07 AM
    Author     : luill
--%>

<%@page import="java.util.Vector"%>
<%@page import="clases.Metodo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function nuevo(f1){
                f1.txtpara.value="N";
                f1.action="OP.jsp";
                f1.submit();
                return true;
            }
        </script>
    </head>
    <body>
        <form name="f1" method="POST">
            <center>

                <h1>Hola</h1>

                <table border="1">
                    <thead>
                        <tr align="center">
                            <th colspan="8">Requerimientos</th>
                        </tr>

                        <tr align="center">
                            <td>ID</td>
                            <td>nombre</td>
                            <td>modificado</td>
                            <td>eliminado</td>
                            <td>fecha</td>
                            <td colspan="2">operacion</td>
                        </tr>
                        <%
                            Metodo objReq=new Metodo();
                            Vector requerimiento=new Vector();
                            requerimiento=objReq.MostrarDatos();
                            for (int i = 0; i < requerimiento.size(); i++) {
                                    objReq=(Metodo)requerimiento.get(i);
                                
                        %>
                        <tr align="center">
                            <td><%=objReq.getIdReq() %></td>
                            <td><%=objReq.getNombre() %></td>
                            <td><%=objReq.getModificado() %></td>
                            <td><%=objReq.getEliminado() %></td>
                            <td><%=objReq.getFecha() %></td>
                            <td>
                                <a href="OP.jsp?txtpara=M&txtid=<%=objReq.getIdReq() %>">Modificacion</a>
                            </td>
                            <td>
                                <a href="OP.jsp?txtpara=E&txtid=<%=objReq.getIdReq() %>">Eliminacion</a>
                            </td>

                        </tr>
                        <%
                            }
                        %>
                        <tr align="center">
                            <td colspan="8">
                                <input type="submit" value="Nuevo" onclick="return nuevo(f1)" />
                            </td>
                        </tr>

                </table>
                <input type="hidden" name="txtpara" value="" />
            </center>
        </form>
    </body>
</html>
