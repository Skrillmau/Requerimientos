<%-- 
    Document   : OP
    Created on : 10/10/2018, 12:55:30 AM
    Author     : luill
--%>

<%@page import="clases.Metodo"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/AppRequerimientos/ServletAleta" method="POST">
            <center>
                <%
                    Metodo objReq = new Metodo();
                    String vpara = request.getParameter("txtpara");
                    String vId = request.getParameter("txtid");
                    String vNombre = "";
                    String vModificado = "";
                    String vEliminado = "";
                    Date vFecha = new Date(0000, 00, 00);
                    if (vpara.equals("N") == false) {
                        int id = Integer.parseInt(vId);
                        objReq.buscar(id);
                        vNombre = objReq.getNombre();
                        vModificado = objReq.getModificado();
                        vEliminado = objReq.getEliminado();
                        vFecha = objReq.getFecha();

                    }
                %>


                <h1>AHORA SI</h1>
                <table border="1">

                    <tr>
                        <th>Operacion:</th>
                        <th>
                            <%
                                if (vpara.equals("N")) {
                                    out.println("Nuevo");
                                }
                                if (vpara.equals("M")) {
                                    out.println("Modificar");
                                }
                                if (vpara.equals("E")) {
                                    out.println("Eliminar");
                                }
                            %>
                        </th>
                    </tr>

                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="ID" value="<%=vId%>" <%out.print("disabled");%> /></td>
                    </tr>

                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="Nombre" value="<%=vNombre%>"  /></td>
                    </tr>
                    <tr>
                        <td>Modificado</td>
                        <td><input type="text" name="Modificado" value="<%=vModificado%>" /></td>
                    </tr>
                    <tr>
                        <td>Eliminado</td>
                        <td><input type="text" name="Eliminado" value="<%=vEliminado%>" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Fecha</td>
                        <td><input type="text" name="Fecha" value="<%=vFecha%>" /></td>
                    </tr>
                    <tr align="center">
                        <td colspan="2"><input type="submit" value="<%
                            if (vpara.equals("N")) {
                                out.println("Ingresar");
                            }
                            if (vpara.equals("M")) {
                                out.println("Modificar");
                            }
                            if (vpara.equals("E")) {
                                out.println("Eliminar");
                            }
                                               %>"      
                                               />
                        </td>
                        <td></td>
                    </tr>
                </table>
                <input type="hidden" name="txtpara" value="<%=vpara%>" />
                <input type="hidden" name="txtid" value="<%=vId%>" />
            </center>
        </form>

    </body>
</html>
