import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador implements IValidadorProcesso {

	public boolean validateID(int ID){
		if(ID > 0) return true;
		//Se a ID é um número não negativo.
		//deve retornar true 
		
		else return false;
		//Se a ID é um número negativo,
		//deve retornar false
	}
	
	public boolean validateNomeReclamante(String nome){
		Pattern pattern;
		Matcher matcher;
		
		if(nome == null) return false;
		
		final String nomeReclamantePattern = "([A-Za-z]+ )*([A-Za-z])+";
		pattern = Pattern.compile(nomeReclamantePattern);
		
		matcher = pattern.matcher(nome);
		
		return matcher.matches();
	}
	
	public boolean validateTelefone(String telefone){
		Pattern pattern;
		Matcher matcher;
		
		if(telefone == null) return false;
		
		final String telefonePattern = "[0-9]{8,14}";
		pattern = Pattern.compile(telefonePattern);
		
		matcher = pattern.matcher(telefone);
		
		return matcher.matches();
	}
	
	public boolean validateEmail(String email){
		Pattern pattern;
		Matcher matcher;
		
		if(email == null) return false;
		
		final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"
				+ "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(emailPattern);
		
		matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	public boolean validateContent(String content){
		if(new String("").equals(content)) return false;
		else return true;
	}
	
	public boolean validateProcess(Processo proc) {
		// TODO Auto-generated method stub
		return validateID(proc.getId()) &&
				validateNomeReclamante(proc.getNomeReclamante()) &&
				validateTelefone(proc.getTelefone()) &&
				validateEmail(proc.getEmail()) &&
				validateContent(proc.getContent());
	}

}