package cadastroFuncionario;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoFuncionario {

	
	Pattern patt;
	Matcher matc;

	public boolean verificarNome(String nome){
		patt = Pattern.compile("[a-zA-Zá-ù ' ']{2,40}");
		matc = patt.matcher(nome);
//		return matc.matches();		
		if (matc.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verificarGenero(String genero){
		boolean verif = false;
		if (genero.equalsIgnoreCase("masculino")||genero.equalsIgnoreCase("feminino")){
			return true;
		}else{
			return false;
		}
	}

	public boolean verificarCpf(String cpf){
		if (ValidaCPF.isCPF(cpf) == true){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean verificarCargo(String cargo){
		patt = Pattern.compile("[a-zA-Zá-ù' ']{2,40}");
		matc = patt.matcher(cargo);
		
		if (matc.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verificarSalario(Double salario){
		
		if (salario > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
