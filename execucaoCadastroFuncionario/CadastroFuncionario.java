package execucaoCadastroFuncionario;
import persistencia.FuncionarioDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cadastroFuncionario.DadosEntradaFuncionario;
import cadastroFuncionario.Funcionario;
import manipulacaoArquivo.ManipularArquivo;


public class CadastroFuncionario {
	public static void main(String[] args) {	
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe a opcao desejada: I - Inserir, A - Alterar, E - Excluir, C - Consultar ");
		
		String opcao = scan.nextLine(); 
        
		while((!opcao.equalsIgnoreCase("I"))
			&&!(opcao.equalsIgnoreCase("A"))
			&&!(opcao.equalsIgnoreCase("E"))
			&&!(opcao.equalsIgnoreCase("C"))){
			System.out.println("Selecione uma opcao valida.");
			System.out.println("Informe a opcao desejada: I - Inserir, A - Alterar, E - Excluir, C - Consultar ");

			if((!opcao.equalsIgnoreCase("I"))&&!(opcao.equalsIgnoreCase("A"))&&!(opcao.equalsIgnoreCase("E"))&&!(opcao.equalsIgnoreCase("C")))
			{
			    opcao = scan.nextLine(); 
			}
		}
		
		Funcionario              f1 = new Funcionario();
		FuncionarioDAO        daof1 = new FuncionarioDAO();
		DadosEntradaFuncionario dea = new DadosEntradaFuncionario();	
		
		if(opcao.equalsIgnoreCase("I")){	
			    Date data= new Date();
			    f1.setDatacad(data);
				f1.setNome(dea.lerNome());
				f1.setCargo(dea.lerCargo());
				f1.setCpf(dea.lerCpf());
				f1.setGenero(dea.lerGenero());
				f1.setSalario(dea.lerSalario());
				try{
					daof1.inserir(f1);
					System.out.println("Funcionario Inserido na tabela mysql.");			
				}catch(Exception e){
					System.out.println("Erro: "+e.getMessage());
					e.printStackTrace();
				}

				String dados;
				String caminho = "C:/workspace/DiretorioArquivos/";
				String arquivo = "ArquivoFuncinario.txt";
				
				ManipularArquivo ma = new ManipularArquivo();

				ma.criarDiretorio(caminho);
				ma.crirarArquivo(caminho, arquivo);
							
				String newLine = System.getProperty("line.separator");

				dados = f1.getNome()               +";"+
						f1.getCargo()			   +";"+
						f1.getCpf()  			   +";"+
						f1.getGenero().toString()  +";"+
						f1.getSalario()            +";"+
						f1.getDatacad()			   +";"+newLine;
				
				System.out.println(ma.armazenaDados(caminho, arquivo, dados));
				System.out.println(ma.obterDados(caminho, arquivo));
		
		}else if(opcao.equalsIgnoreCase("A")){	
			System.out.println("Digite o cpf do funcionario que deseja alterar: ");
			f1.setCpf(dea.lerCpf());
			
			try{
				for(Funcionario f : daof1.pesquisar(f1.getCpf())){
					System.out.println(f.toString());
				}
				System.out.println("Informe novos valores");
				f1.setCargo(dea.lerCargo());
				f1.setSalario(dea.lerSalario());
				daof1.Alterar(f1);
			}catch(Exception e){
				System.out.println("Erro: "+e.getMessage());
				e.printStackTrace();
			}

		}else if(opcao.equalsIgnoreCase("E")){
			f1.setCpf(dea.lerCpf());
			
			try{
				for(Funcionario f : daof1.pesquisar(f1.getCpf())){
					System.out.println(f.toString());
				}
				daof1.Deletar(f1.getCpf());
				System.out.println("Funcionario deletado.");
				System.out.println();
			}catch(Exception e){
				System.out.println("Erro: "+e.getMessage());
				e.printStackTrace();
			}

		}else if(opcao.equalsIgnoreCase("C")){
			
			f1.setCpf(dea.lerCpf());
			
			try{
				System.out.println("Consultando Funcionario");
				System.out.println();
					
				for(Funcionario f : daof1.pesquisar(f1.getCpf())){
					System.out.println(f.toString());
				}
				
			}catch(Exception e){
				System.out.println("Erro: "+e.getMessage());
				e.printStackTrace();
			}
	
		}
		
	}
}
