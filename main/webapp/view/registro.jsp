<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Receptor"%>
<%@ page import="java.util.ArrayList"%>
<%
    @ SuppressWarnings ("unchecked")
    ArrayList<Receptor> lista = (ArrayList<Receptor>) request.getAttribute("contratos");
%>
<!DOCTYPE html>
<html lang="pt-pt">
    <head>
        <meta charset="UTF-8">
        <title>Agenda de Contratos</title>
        <link rel="icon" href="imagens/puzzle.png">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
	<h1>Contrato</h1>
        <div class="box">
            <a href="imagem" rel="normalForm.png"></a>
            <a href="novo.html" class="Button1">Novo contrato</a>
            <a href="report" class="Button2">Relatório</a>
            <table id="table">
		<thead>
			<tr>
                            <th>Id</th>
                            <th>Nome</th>
                            <th>E-mail</th>
                            <th>Fone</th>
                            <th>Horário</th>
                            <th>Data</th>
                            <th>Vagas</th>
                            <th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
                            for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
                            <td><%=lista.get(i).getId()%></td>
                            <td><%=lista.get(i).getNome()%></td>
                            <td><%=lista.get(i).getEmail()%></td>
                            <td><%=lista.get(i).getFone()%></td>
                            <td><%=lista.get(i).getHorario()%></td>
                            <td><%=lista.get(i).getDatas()%></td>
                            <td><%=lista.get(i).getVaga()%></td>
                            <td>
                                <a href="select?id=<%=lista.get(i).getId()%>"
					class="Button1">Editar</a>
				<a href="javascript:confirmar(<%=lista.get(i).getId()%>)"
					class="Button2">Excluir</a>
                            </td>
			</tr>
			<%
                            }
			%>
		</tbody>
            </table>
        </div>
	<script src="scripts/confirmador.js"></script>
    </body>
</html>
