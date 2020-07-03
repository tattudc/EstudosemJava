<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: TatuEdi
  Date: 17/06/2020
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%!
  String name = "Tarcisio";
  int count = 0;
  String[] pessoas = {"Paulo", "Claudia", "Vanessa", "Edivania", "Magda"};
%>
  <head>
    <title>Página em JSP do <%= name %></title>
  </head>
  <body>
    <%-- Código em Java --%>


    <!-- Código em HTML -->
        <h1>Página do <%= name %></h1>
        <p>Quantidade de F5 dados na pagina: <%=count%><% count++; %></p>
        <h3>Lista de Convidados: </h3>
        <ul>
          <% for(int i = 0; i < pessoas.length; i++){ %>
          <li><%=pessoas[i] + " & "%><%@include file="convidado.jsp"%></li>
          <% } %>
          <li><%= request.getParameter("convidado") %></li>
        </ul>

        <br>
        <%
            session.setAttribute("nome", name);
            String aluno = (String) session.getAttribute("nome");
        %>
        <p>Sua Sessão é: <%=session.getId()%> e seu nome é: <%=aluno %></p><br>
        <%@include file="footer.jsp" %>
  </body>
</html>
