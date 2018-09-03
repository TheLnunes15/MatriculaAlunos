<%-- 
    Document   : index
    Created on : 14/06/2015, 03:36:41
    Author     : Lucas Nunes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta MySql</title>
    </head>
    <body>
        <h1>Solicitação de matrícula dos alunos</h1>
        <form action="ListarTurmas" method="get">  
        <fieldset style="width: 300px">  
            <table>  
                <tr>  
                    <td>Digite sua matricula:</td>  
                    <td><input type="text" name="matricula" required="required" /></td>  
                </tr>  
                <tr>  
                    <td><input type="submit" value="Enviar" /></td>  
                </tr>  
            </table>  
        </fieldset>  
    </body>
</html>
