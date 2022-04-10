<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-pt">
    <head>
        <meta charset="UTF-8">
        <title>Editar contratos</title>
        <link rel="icon" href="imagens/puzzle.png">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="box">
            <h1>Editar contrato</h1>
            <form name="frmContrato" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="Box3" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Box1"
                                           value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
                        <tr>
				<td><input type="text" name="email" class="Box1"
					value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="Box2"
					value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
                        <tr>
				<td><input type="text" name="horario" class="Box2"
					value="<%out.print(request.getAttribute("horario"));%>"></td>
			</tr>
                        <tr>
				<td><input type="text" name="datas" class="Box2"
					value="<%out.print(request.getAttribute("data"));%>"></td>
			</tr>
                        <tr>
				<td><input type="text" name="vaga" class="Box2"
					value="<%out.print(request.getAttribute("vaga"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Button1" onclick="validar()">
            </form>
        </div>               
	<script src="scripts/validador.js"></script>
    </body>
</html>