package cadastroFuncionario;
import cadastroFuncionario.ValidacaoFuncionario;
import java.util.Scanner;

public class DadosEntradaFuncionario {
	
	ValidacaoFuncionario     va = new ValidacaoFuncionario();
	
	public String lerNome() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o nome: ");
		String nome = scan.nextLine(); 

		if (va.verificarNome(nome)) {
			return nome;
		} else {
			System.out.println("Erro! Nome informado está fora da especificação.");
			return lerNome(); 
		}
	}

	public String lerCargo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o cargo: ");
		String cargo = scan.nextLine(); 

		if (va.verificarCargo(cargo)) {
			return cargo;
		} else {
			System.out.println("Erro! Cargo informado está fora da especificação.");
			return lerCargo(); 
		}
	}
	
	public String lerCpf() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o cpf: ");
		String cpf = scan.nextLine(); 

		if (va.verificarCpf(cpf)) {
			return cpf;
		} else {
			System.out.println("Erro! Cpf informado não é verdadeiro.");
			return lerCpf(); 
		}
	}
	
	public String lerGenero() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o genero: ");
		String genero = scan.nextLine(); 

		if (va.verificarGenero(genero)) {
			return genero;
		} else {
			System.out.println("Erro! Genero informado está fora da especificação.");
			return lerGenero(); 
		}
	}
	
	public Double lerSalario() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o salario: ");
		
		try {
			double salario = scan.nextDouble();
			if (!va.verificarSalario(salario)) {
				System.out.println("Erro! Informe um salario maior que zero");
				return lerSalario();
			} else {
				return salario;
			}
		} catch (Exception e) {
			System.out.println("Erro! Informe valor numerico.");
			return lerSalario();
		}
		
	}




}
