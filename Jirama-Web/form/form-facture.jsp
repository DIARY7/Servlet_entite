<%@page language = "java" pageEncoding="utf-8" %>
<%@page import="model.*" %>
<%@page import="java.util.Vector" %>
<%  
    Facture fact = (Facture) request.getAttribute("facture");
    Vector clients = (Vector) request.getAttribute("client"); 
    Vector services = (Vector) request.getAttribute("service");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css1/home.css">
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
            <form action="FactureServlet" method="POST">
                <div class="liste-item">
                    <label for="dateFacture"> Date facture : </label>
                    <input type="text" name="dateFacture" id="dateFacture" <% if(fact!=null) { %>
                        value="<% out.print(fact.getDateFacture());  %>"
                    <% } %> >
                </div>
                <div class="liste-item">
                    <label for="idClient"> Clients :  </label>
                    <select name="idClient" id="idClient">
                        <% for(int i=0;i < clients.size();i++){ %>
                            <option value="<% out.print( ((Client) clients.get(i)).getId() ); %>" <% if( fact!=null && ((Client) clients.get(i)).getId()==fact.getIdClient()) out.print("selected"); %> ><% out.print( ((Client) clients.get(i)).getNom()); %> </option>
                        <% } %>
                    </select>
                    
                </div>

                <div class="liste-item">
                    <label for="idService"> Services :  </label>
                    <select name="idService" id="idService">
                        <% for(int i=0;i < services.size();i++){ %>
                            <option value="<% out.print( ((Service) services.get(i)).getId() ); %>" <% if( fact!=null && ((Service) services.get(i)).getId()==fact.getIdService()) out.print("selected"); %> ><% out.print( ((Service) services.get(i)).getNom()); %> </option>
                        <% } %>
                    </select>
                    
                </div>
                <div class="liste-item">
                    <label for="montant"> montant : </label>
                    <input type="text" name="montant" id="montant" <% if(fact!=null) { %>
                        value="<% out.print(fact.getMontant());  %>"
                    <% } %> >
                </div>

                <% 
                    if(fact!=null){ %>
                        <input type="hidden" name="id" value="<% out.print(fact.getId()); %>" >
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