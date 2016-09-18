package manipulacaoArquivo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ManipularArquivo {

	public File file;
	public String msg;
	
	public void criarDiretorio(String caminho){
		
		file = new File(caminho);
		if (file.mkdirs()){
			System.out.println("Diretorio Criado.");
		}else{
			System.out.println("Erro ao criar o diretorio.");
		}
	}
	
	public void crirarArquivo(String caminho, String arquivo){
		file = new File(caminho, arquivo);
		try{
			if (!file.exists()){
				file.createNewFile();
				System.out.println("Arquivo criado com sucesso");
			}else{
				System.out.println("Erro! Arquivo já existente.");	
			}
		}catch(Exception e){
		   System.out.println("Erro ao criar arquivo:"+e.getMessage());
		}
	}
	
	public String armazenaDados(String caminho, String arquivo, String dados){
		
		String msg;
		try{
			OutputStream          out = new FileOutputStream(caminho+"/"+arquivo, true);
			OutputStreamWriter writer = new OutputStreamWriter(out);
			BufferedWriter         bw = new BufferedWriter(writer);
			
			bw.write(dados+"\n");
			bw.flush();
			bw.close();
			out.close(); 
			
			msg = "Dados armazenos com sucesso.";
			
		}catch(Exception e){
			msg = "Erro: "+e.getMessage();
		}
		return msg;			
	}

	public String obterDados(String caminho, String arquivo){
		try{
			InputStream           in = new FileInputStream(caminho+"/"+arquivo);
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader        br = new BufferedReader(reader);
			StringBuilder         sb = new StringBuilder();
			String txt = "";
			
			while ((txt = br.readLine()) != null){
				sb.append(txt +"\n");
			}
			return sb.toString();
			
		}catch(Exception e){
			return "Erro: "+e.getMessage();
		}	
		
	}
	
}
