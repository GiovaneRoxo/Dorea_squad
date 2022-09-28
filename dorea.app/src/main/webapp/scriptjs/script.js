const cpf = document.getElementById('cpf');

cpf.addEventListener('keypress', () => {
	let cpflength = cpf.value.length
	
   	if ( cpflength === 3 ||  cpflength === 7) {
		cpf.value += '.'
	} else if (cpflength === 11) {
		cpf.value += '-'
	}
})

const cnpj = document.getElementById('cnpjTeste');

cnpj.addEventListener('keypress', () => {
	let cnpjlength = cnpj.value.length
	
   	if ( cnpjlength === 2 ||  cnpjlength === 6) {
		cnpj.value += '.'
	} else if (cnpjlength === 10) {
		cnpj.value += '/'
	} else if (cnpjlength === 15) {
		cnpj.value += '-'
	}
})

function somenteNumeros(num) {
        var er = /[^0-9.-]/;
        er.lastIndex = 0;
        var campo = num;
        if (er.test(campo.value)) {
          campo.value = "";
        }
}

function ValidateEmail(mail) 
{
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.emailAddr.value))
  {
    return (true)
  }
    alert("You have entered an invalid email address!")
    return (false)
}