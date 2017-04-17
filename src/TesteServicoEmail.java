import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import junit.framework.TestCase;

public class TesteServicoEmail extends TestCase {
	
	public void testeNumeroDeChamadasProcessoAceito (){
		
		ServicoEmailProcAceito teste = mock(ServicoEmailProcAceito.class);
		
		teste.sendEmail("Chupel");
		teste.sendEmail("Gabi");
		
		verify(teste, atLeastOnce()).sendEmail("Gabi");
		verify(teste, times(1)).sendEmail("Chupel");
		verify(teste, never()).sendEmail("Anderson");
		
		teste.sendEmail("Gabi");
		verify(teste, times(2)).sendEmail("Gabi");
		
	}
	
	public void testeNumeroDeChamadasProcessoNaoAceito (){
		
		ServicoEmailProcNaoAceito teste = mock(ServicoEmailProcNaoAceito.class);
		
		teste.sendEmail("Chupel");
		teste.sendEmail("Gabi");
		
		verify(teste, atLeastOnce()).sendEmail("Gabi");
		verify(teste, times(1)).sendEmail("Chupel");
		verify(teste, never()).sendEmail("Anderson");
		
		teste.sendEmail("Gabi");
		verify(teste, times(2)).sendEmail("Gabi");
		
	}

}
