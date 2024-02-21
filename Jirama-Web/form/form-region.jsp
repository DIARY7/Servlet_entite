<%@page language = "java" pageEncoding="utf-8" %>
<%@page import="model.*" %>

<%  
    Region r = (Region) request.getAttribute("region");
    
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
        <div class="titre"> Region </div>
            <form action="RegionServlet" method="POST">
                <div class="liste-item">
                    <label for="nom"> Nom du Region : </label>
                    <input type="text" name="nom" id="nom" <% if(r!=null) { %>
                        value="<% out.print(r.getNom());  %>"
                    <% } %> >
                </div>
                
                <% 
                    if(r!=null){ %>
                        <input type="hidden" name="id" value="<% out.print(r.getId()); %>" >
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