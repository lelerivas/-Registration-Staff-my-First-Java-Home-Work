package cadastroFuncionario;

import java.util.Date;

public class Funcionario {

	String nome;
	String genero;
	String cpf;
	String cargo;
	Double salario;
	Date datacad;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

   	public Funcionario(String nome, String genero, String cpf, String cargo, Double salario, Date datacad) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
		this.datacad = datacad;
	}


	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", genero=" + genero + ", cpf=" + cpf + ", cargo=" + cargo + ", salario="
				+ salario + ", datacad=" + datacad + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getDatacad() {
		return datacad;
	}

	public void setDatacad(Date datacad) {
		this.datacad = datacad;
	}
	
	
}
