<%@page language = "java" pageEncoding="utf-8" %>
<%@page import="model.*" %>

<%  
    Service s = (Service) request.getAttribute("service");
    
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/style.css">
    <link rel="stylesheet" href="assets/css1/home.css">
    <link rel="stylesheet" href="assets/css1/insertion.css">
    <link rel="stylesheet" href="assets/css1/reset.css">
    <title> Mr Naina </title>
</head>
<body>
    <div class="liste-container">
        <div class="titre"> Service </div>
            <form action="ServiceServlet" method="POST">
                <div class="liste-item">
                    <label for="nom"> Nom du Service : </label>
                    <input type="text" name="nom" id="nom" <% if(s!=null) { %>
                        value="<% out.print(s.getNom());  %>"
                    <% } %> >
                </div>
                
                <% 
                    if(s!=null){ %>
                        <input type="hidden" name="id" value="<% out.print(s.getId()); %>" >
                        <input type="hidden" name="action" value="update" >
                <%    } else { %>
                        <input type="hidden" name="action" value="create" >
                <% }
                %>
                
                <button type="submit">Valider</button>
            </form>
    </div>
</body>
</html>