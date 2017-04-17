import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Processo {

	private int id;
	private String NomeReclamante = null;
	private String Telefone = null;
	private String Email = null;
	private String Content = null;
	
	public Processo(){}
	
	public Processo(File file){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			id = Integer.parseInt(br.readLine());
			NomeReclamante = br.readLine();
			Telefone = br.readLine();
			Email = br.readLine();
			Content = "";
			String line = null;
			while((line = br.readLine())!=null)
				Content+=line;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNomeReclamante(String nomeReclamante) {
		NomeReclamante = nomeReclamante;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getNomeReclamante() {
		return NomeReclamante;
	}
	public String getTelefone() {
		return Telefone;
	}
	public String getEmail() {
		return Email;
	}
	public String getContent() {
		return Content;
	}
	
	Processo copyProcesso(){
		Processo copy = new Processo();
		copy.setContent(this.Content);
		copy.setEmail(this.Email);
		copy.setId(this.id);
		copy.setTelefone(this.Telefone);
		copy.setNomeReclamante(this.NomeReclamante);
		return copy;
	}
	
	boolean isEqual(Processo proc){
		if(!proc.getEmail().equals(this.Email))
			return false;
		if(proc.getId()!=this.id)
			return false;	
		if(!proc.getContent().equals(this.Content))
			return false;
		if(!proc.getNomeReclamante().equals(this.NomeReclamante))
			return false;
		if(!proc.getTelefone().equals(this.Telefone))
			return false;
		return true;
	}
	
	public void serialize(String address) throws IOException{
		FileWriter fw = new FileWriter(address);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(String.valueOf(id));
		bw.newLine();
		bw.write(NomeReclamante);
		bw.newLine();
		bw.write(Telefone);
		bw.newLine();
		bw.write(Email+"\n");
		bw.newLine();
		bw.write(Content);
		
		bw.close();
		fw.close();
	}
}
