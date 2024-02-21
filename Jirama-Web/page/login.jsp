
<!DOCTYPE html>
<html>
<head>
	<title>LOGIN</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="../assets/styl.css">
    <link rel="stylesheet" href="../assets/node_modules/sweetalert2/dist/sweetalert2.all.min.js">
	<style>
	
		body{
			display:flex;
			justify-content:center;
			align-items:center;
			height:100vh;
			flex-direction:column;
			background-color:white;
		}
		table td {
    	height: 33px;
    	text-align: center;
		}
	</style>
</head>
<body>
	
	<section class="section">
	<h1 class="bienvenue">Bienvenue</h1>
		<form action="../traite-login" method="get">
			<table>
				<tr>
					<td><label for="login">Entrez votre identifiant :</label> </td>
					<td><input type="text" placeholder="Adresse e-mail ou numero de telephone" name="login" id="login" ></td>
				</tr>
			<tr>
				<td><label for="mdp">Mot de passe:</label></td>
				<td><input type="password" placeholder="Votre mot de passe" name="mdp" id="mdp"></td>
			</tr>
			</table>
			<? if ( request.getParameter("erreur")!=null) { ?>
                <script>
                    Swal.fire({
                        icon:"error",
                        title: 'Error!',
                        text: `Identification incorrecte`,
                        icon: 'error',
                        confirmButtonText: 'Ressayer'
                    
                    })
                </script>
			<? }?>
				
				<input type="submit" value= "Valider"/>
				</section>
				

</body>
</html>