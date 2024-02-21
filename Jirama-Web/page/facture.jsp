<%@page language = "java" pageEncoding="utf-8" %>
<%@page import="model.*" %>
<%@page import="java.util.Vector" %>
<% 
    Vector factures = (Vector) request.getAttribute("facture");
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
        <link rel="stylesheet" href="assets/css1/table.css">
        <script src="assets/node_modules/sweetalert2/dist/sweetalert2.all.min.js"></script>
    <title>Document</title>
</head>
<body>
    <jsp:include page="../include/nav.jsp" />
    <div class="container div-lp"  >
        <h3 class="titre"> Liste Facture </h3>
        <form action="FactureServlet" method="get">
            Date Min :
            <input type="date" name="dateMin" id="">
            Date Max :
            <input type="date" name="dateMax">
            <input type="submit" class="btn btn-danger" value="Rechercher" style="background-color: #fb7847;" >
            <input type="hidden" name="action" value="filtre" >
        </form>
        <div style="position: relative;" > <a href="form-facture" style="color: white; text-decoration: none; " > <button class="btn btn-danger"  style="right: 0%;position: absolute;" > Inserer <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> </a></button> </div>
        
        <table class="table table-container " >
            <tr>
                <th>Id</th>
                <th>IdClient</th> 
                <th>Montant</th>
                <th>IdService</th>
                <th>DateFacture</th>
            </tr>
            <% 
                for(int i=0;i< factures.size();i++){ %>
                    <tr>
                        <td><% out.print(((Facture) factures.get(i)).getId()); %></td>
                        <td><% out.print(((Facture) factures.get(i)).getIdClient()); %></td>
                        <td> <% out.print(((Facture) factures.get(i)).getMontant()); %> </td>
                        <td><% out.print(((Facture) factures.get(i)).getIdService()); %></td>
                        <td><% out.print(((Facture) factures.get(i)).getDateFacture()); %></td>
                        <td> <a href="FactureServlet?action=delete&id=<% out.print(((Facture) factures.get(i)).getId()); %>"> <span class="glyphicon glyphicon-remove-circle" aria-hidden="true" style="font-size: 25px;" ></span> </a>
                            <a href="form-facture?action=update&id=<% out.print(((Facture) factures.get(i)).getId()); %>">  <span class="glyphicon glyphicon-pencil" aria-hidden="true" style="margin-left: 15%;font-size: 25px;" ></span> </a> </td>
                    </tr>
            <%    }
            %>
            
            
        </table>
        <% if(request.getAttribute("erreur") != null ){ %>
            <script>
                Swal.fire({
                    icon:"error",
                    title: 'Error!',
                    text: `
                    <% out.print(request.getAttribute("erreur").toString()); %>
                    `,
                    icon: 'error',
                    confirmButtonText: 'Ressayer'
                
                })
            </script>
        <% } %>
    </div>
    
</body>
</html>