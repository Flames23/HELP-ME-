function validar() {
	let nome = frmContrato.nome.value
	let fone = frmContrato.fone.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmContrato.nome.focus()
		return false
	} else if (fone === "") {
		alert('Preencha o campo Telefone')
		frmContrato.fone.focus()
		return false
	} else {
		document.forms["frmContrato"].submit()
	}
}

