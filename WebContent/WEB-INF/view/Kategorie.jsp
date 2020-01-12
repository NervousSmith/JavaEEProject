<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
 
<html>
   <head>
   	  <meta charset="utf-8">
      <title>Kategorie prduktów</title>
   </head>

   <body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://remotemysql.com:3306/Dg3jCj0JRD"
         user = "Dg3jCj0JRD"  password = "bHPu8tQZqy"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT nazwa from kategoria;
      </sql:query>
      
      
      <table border="1" align="center" width = "50%" >
         <tr>
            <th>Nazwa</th>
         </tr>

         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.nazwa}"/></td>
             	</tr>
         </c:forEach>
      </table>

 
   </body>
</html>