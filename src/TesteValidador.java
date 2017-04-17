import junit.framework.TestCase;

public class TesteValidador extends TestCase {
	
	IValidadorProcesso validador = new Validador();
	
	public void testandoValidateID(){
		int goodID1 = 1;
		int goodID2 = 100;
		int goodID3 = 99999;
		int badID1 = 0;
		int badID2 = -1;
		int badID3 = -100000;
		
		Processo proc = new Processo();
		proc.setNomeReclamante("rahyan");
		proc.setTelefone("988889999");
		proc.setEmail("rahyan@gmail.com");
		proc.setContent("fui roubado");
		
		proc.setId(goodID1);
		assertTrue(validador.validateProcess(proc));
		proc.setId(goodID2);
		assertTrue(validador.validateProcess(proc));
		proc.setId(goodID3);
		assertTrue(validador.validateProcess(proc));
		proc.setId(badID1);
		assertFalse(validador.validateProcess(proc));
		proc.setId(badID2);
		assertFalse(validador.validateProcess(proc));
		proc.setId(badID3);
		assertFalse(validador.validateProcess(proc));
	}
	
	public void testandoValidateNomeReclamante(){
		String goodName1 = "Rahyan Azin";
		String goodName2 = "Giancarlo Alves Poli";
		String goodName3 = "gabi naosei";
		String badName1 =  "Rahyan  ";
		String badName2 =  "  rahyan";
		String badName3 =  "Rahyan Azin ";
		String badName4 = "Rahyan1 Azin";
		String badName5 = "rahyan-- azin";
		String badName6 = "";
		
		Processo proc = new Processo();
		proc.setId(100);
		proc.setTelefone("988889999");
		proc.setEmail("rahyan@gmail.com");
		proc.setContent("fui roubado");
		
		proc.setNomeReclamante(goodName1);
		assertTrue(validador.validateProcess(proc));
		proc.setNomeReclamante(goodName2);
		assertTrue(validador.validateProcess(proc));
		proc.setNomeReclamante(goodName3);
		assertTrue(validador.validateProcess(proc));
		proc.setNomeReclamante(badName1);
		assertFalse(validador.validateProcess(proc));
		proc.setNomeReclamante(badName2);
		assertFalse(validador.validateProcess(proc));
		proc.setNomeReclamante(badName3);
		assertFalse(validador.validateProcess(proc));
		proc.setNomeReclamante(badName4);
		assertFalse(validador.validateProcess(proc));
		proc.setNomeReclamante(badName5);
		assertFalse(validador.validateProcess(proc));
		proc.setNomeReclamante(badName6);
		assertFalse(validador.validateProcess(proc));
	}
	
	public void testandoValidateTelefone(){
		String goodPhone1 = "12345678";
		String goodPhone2 = "123456789";
		String goodPhone3 = "1234567890";
		String goodPhone4 = "12345678901";
		String goodPhone5 = "123456789012";
		String goodPhone6 = "1234567890123";
		String goodPhone7 = "12345678901234";
		String badPhone1 = "123456";
		String badPhone2 = "1234567";
		String badPhone3 = "123456789012345";
		String badPhone4 = "1234567890123456";
		String badPhone5 = "123456789r";
		String badPhone6 = "1234r56789";
		String badPhone7 = "rahyan";
		String badPhone8 = "";
		
		Processo proc = new Processo();
		proc.setId(100);
		proc.setNomeReclamante("Rahyan Azin");
		proc.setEmail("rahyan@gmail.com");
		proc.setContent("fui roubado");
		
		proc.setTelefone(goodPhone1);
		assertTrue(validador.validateProcess(proc));
		proc.setTelefone(goodPhone2);
		assertTrue(validador.validateProcess(proc));
		proc.setTelefone(goodPhone3);
		assertTrue(validador.validateProcess(proc));
		proc.setTelefone(goodPhone4);
		assertTrue(validador.validateProcess(proc));
		proc.setTelefone(goodPhone5);
		assertTrue(validador.validateProcess(proc));
		proc.setTelefone(goodPhone6);
		assertTrue(validador.validateProcess(proc));
		proc.setTelefone(goodPhone7);
		assertTrue(validador.validateProcess(proc));
		proc.setTelefone(badPhone1);
		assertFalse(validador.validateProcess(proc));
		proc.setTelefone(badPhone2);
		assertFalse(validador.validateProcess(proc));
		proc.setTelefone(badPhone3);
		assertFalse(validador.validateProcess(proc));
		proc.setTelefone(badPhone4);
		assertFalse(validador.validateProcess(proc));
		proc.setTelefone(badPhone5);
		assertFalse(validador.validateProcess(proc));
		proc.setTelefone(badPhone6);
		assertFalse(validador.validateProcess(proc));
		proc.setTelefone(badPhone7);
		assertFalse(validador.validateProcess(proc));
		proc.setTelefone(badPhone8);
		assertFalse(validador.validateProcess(proc));
	}
	
	public void testandoValidateEmail(){
		String goodEmail1 = "rahyan@gmail.com";
		String goodEmail2 = "rahyan.azin@gmail.com";
		String goodEmail3 = "rahyan@ita.br";
		String goodEmail4 = "rahyan1000@dominioqualquer.com.fr";
		String goodEmail5 = "regexRulez@regex.hex";
		String badEmail1 = "rahyan azin@gmail.com";
		String badEmail2 = "sãoPaulo@hotmail.com";
		String badEmail3 = "rahyan#gmail.com";
		String badEmail4 = "rahyan@gmail";
		String badEmail5 = "";
		
		Processo proc = new Processo();
		proc.setId(100);
		proc.setNomeReclamante("Rahyan Azin");
		proc.setTelefone("988889999");
		proc.setContent("fui roubado");
		
		proc.setEmail(goodEmail1);
		assertTrue(validador.validateProcess(proc));
		proc.setEmail(goodEmail2);
		assertTrue(validador.validateProcess(proc));
		proc.setEmail(goodEmail3);
		assertTrue(validador.validateProcess(proc));
		proc.setEmail(goodEmail4);
		assertTrue(validador.validateProcess(proc));
		proc.setEmail(goodEmail5);
		assertTrue(validador.validateProcess(proc));
		proc.setEmail(badEmail1);
		assertFalse(validador.validateProcess(proc));
		proc.setEmail(badEmail2);
		assertFalse(validador.validateProcess(proc));
		proc.setEmail(badEmail3);
		assertFalse(validador.validateProcess(proc));
		proc.setEmail(badEmail4);
		assertFalse(validador.validateProcess(proc));
		proc.setEmail(badEmail5);
		assertFalse(validador.validateProcess(proc));
	}

	public void testandoValidateContent(){
		String goodContent1 = "fui roubado";
		String goodContent2 = "levaram minha bike";
		String goodContent3 = "levei um tiro";
		String goodContent4 =  "roubaram minha carteira";
		String badContent1 = "";
		
		Processo proc = new Processo();
		proc.setId(100);
		proc.setNomeReclamante("Rahyan Azin");
		proc.setTelefone("988889999");
		proc.setEmail("rahyan@gmail.com");
		
		proc.setContent(goodContent1);
		assertTrue(validador.validateProcess(proc));
		proc.setContent(goodContent2);
		assertTrue(validador.validateProcess(proc));
		proc.setContent(goodContent3);
		assertTrue(validador.validateProcess(proc));
		proc.setContent(goodContent4);
		assertTrue(validador.validateProcess(proc));
		proc.setContent(badContent1);
		assertFalse(validador.validateProcess(proc));
	}
	
	public void testandoVariosProcessos(){
		Processo proc = new Processo();
		proc.setId(100);
		proc.setNomeReclamante("Rahyan Azin");
		proc.setTelefone("988889999");
		proc.setEmail("rahyan@gmail.com");
		proc.setContent("roubaram minha bike");
		
		assertTrue(validador.validateProcess(proc));
		
		proc.setId(-200);
		assertFalse(validador.validateProcess(proc));
		
		proc.setId(100);
		proc.setNomeReclamante("rahyan ");
		assertFalse(validador.validateProcess(proc));
		
		proc.setNomeReclamante("Rahyan Azin");
		proc.setTelefone("1");
		assertFalse(validador.validateProcess(proc));
		
		proc.setTelefone("988889999");
		proc.setEmail("rahyan#ita.com");
		assertFalse(validador.validateProcess(proc));
		
		proc.setEmail("rahyan@gmail.com");
		proc.setContent("");
		assertFalse(validador.validateProcess(proc));
	}
}