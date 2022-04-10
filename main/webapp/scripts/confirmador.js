function confirmar(id) {
	let resposta = confirm("Confirma a exclusão deste contrato?");
	if (resposta === true) {
            window.location.href = "delete?id=" + id;
	}
}

