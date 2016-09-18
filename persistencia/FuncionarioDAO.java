package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cadastroFuncionario.Funcionario;


public class FuncionarioDAO extends DAO{

	PreparedStatement stmt;
	ResultSet rs;
	
	public void inserir(Funcionario f) throws Exception{
		abrirConexao();
		stmt = conn.prepareStatement("INSERT INTO funcionario VALUES(?, ?, ?, ?, ?, ?)");
	
	    stmt.setString(1,f.getNome());
	    stmt.setString(2, f.getGenero());
	    stmt.setString(3, f.getCpf());
	    stmt.setString(4, f.getCargo());
	    stmt.setDouble(5, f.getSalario());
	    stmt.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
	
	    stmt.execute();
	    fecharConexao();
	}
	
	public void Deletar(String cpf) throws Exception{
		abrirConexao();
		stmt = conn.prepareStatement("DELETE FROM cadastrofuncionarioscoti.funcionario WHERE cpf = "+cpf);
	    stmt.execute();
	    fecharConexao();
	}
	
	public List<Funcionario> pesquisar(String cpf) throws Exception{
		abrirConexao();
		stmt = conn.prepareStatement("SELECT nome, genero, cpf, cargo, salario, data_admissao FROM funcionario where cpf = "+cpf);
		rs = stmt.executeQuery();
			
		List<Funcionario> ListaFuncionario = new ArrayList<Funcionario>();
		
		while(rs.next()){
			Funcionario f = new Funcionario(
					rs.getString("nome"),
					rs.getString("genero"),
					rs.getString("cpf"),
					rs.getString("cargo"),
					rs.getDouble("salario"),
		        	rs.getDate("data_admissao"));
			
			ListaFuncionario.add(f);
		}
		
		rs.close();
		stmt.close();
		fecharConexao();
		return ListaFuncionario;
	}
			
	public void Alterar(Funcionario f) throws Exception{
		abrirConexao();
		stmt = conn.prepareStatement("UPDATE cadastrofuncionarioscoti.funcionario "
				+ "  SET cargo = '"+ f.getCargo()+"'"
				+ ", salario   =  "+ f.getSalario()
				+ "  WHERE cpf =  "+ f.getCpf());
		System.out.println("Alteracao realizada com sucesso!");
	    stmt.execute();
	    fecharConexao();
	}
	
		
}
