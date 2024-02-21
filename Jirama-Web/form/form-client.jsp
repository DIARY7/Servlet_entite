<%@page language = "java" pageEncoding="utf-8" %>
<%@page import="model.*" %>
<%@page import="java.util.Vector" %>
<%  
    Client cl = (Client) request.getAttribute("client");
    Vector reg = (Vector) request.getAttribute("region"); 
    
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
            <form action="ClientServlet" method="POST">
                <div class="liste-item">
                    <label for="nom"> Nom du Client : </label>
                    <input type="text" name="nom" id="nom" <% if(cl!=null) { %>
                        value="<% out.print(cl.getNom());  %>"
                    <% } %> >
                </div>
                <div class="liste-item">
                    <label for="idRegion"> Regions :  </label>
                    
                    <select name="idRegion" id="idRegion">
                        <% for(int i=0;i < reg.size();i++){ %>
                            <option value="<% out.print( ((Region) reg.get(i)).getId() ); %>" <% if( cl!=null && ((Region) reg.get(i)).getId()==cl.getIdRegion()) out.print("selected"); %> ><% out.print( ((Region) reg.get(i)).getNom()); %> </option>
                        <% } %>
                    </select>
                    
                </div>
                <% 
                    if(cl!=null){ %>
                        <input type="hidden" name="id" value="<% out.print(cl.getId()); %>" >
                        <input type="hidden" name="action" value="update">
                <%    } else { %>
                    <input type="hidden" name="action" value="create" >
                <% }
            
                %>
                
                <button type="submit">Valider</button>
            </form>
    </div>
</body>
</html>