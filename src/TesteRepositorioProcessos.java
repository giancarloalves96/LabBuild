import java.util.Random;
import junit.framework.TestCase;

public class TesteRepositorioProcessos extends TestCase {

	public void testAdicionarProcesso(){
		Processo proc = new Processo();
		Random rnd = new Random();
		int id = rnd.nextInt();
		proc.setId(id);
		proc.setNomeReclamante("Roberto");
		proc.setContent("Roubaram meu chinelo.");
		proc.setTelefone("99999999");
		proc.setEmail("roberto@gmail.com");
		
		RepositorioProcessos DB = new RepositorioProcessos();
		assertTrue(DB.addProcesso(proc));
	}
	
	public void testRecuperarProcesso(){
		Processo proc = new Processo();
		Random rnd = new Random();
		int id = rnd.nextInt();
		proc.setId(id);
		proc.setNomeReclamante("Roberto");
		proc.setContent("Roubaram meu chinelo.");
		proc.setTelefone("99999999");
		proc.setEmail("roberto@gmail.com");
		
		RepositorioProcessos DB = new RepositorioProcessos();
		assertTrue(DB.addProcesso(proc));
		assertTrue(DB.getProcesso(id).isEqual(proc));
			
	}
	
	public void testAdicionarProcessosComMesmosIds(){
		Processo proc = new Processo();
		Random rnd = new Random();
		int id = rnd.nextInt();
		proc.setId(id);
		proc.setNomeReclamante("Roberto");
		proc.setContent("Roubaram meu chinelo.");
		proc.setTelefone("99999999");
		proc.setEmail("roberto@gmail.com");
		
		Processo proc2 = new Processo();
		proc2.setId(id);
		proc2.setNomeReclamante("Marcos");
		proc2.setContent("Cadê meu óculos?");
		proc2.setTelefone("66666666");
		proc2.setEmail("dp12@gmail.com");
		
		RepositorioProcessos DB = new RepositorioProcessos();
		assertTrue(DB.addProcesso(proc));
		assertFalse(DB.addProcesso(proc2));
	}
}