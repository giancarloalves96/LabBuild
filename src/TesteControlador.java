import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TesteControlador extends TestCase {

	public void testErrado(){
		Processo proc = new Processo();
		proc.setNomeReclamante("João");
		proc.setContent("Sequestraram meu amigo imaginário.");
		proc.setTelefone("0123456789");
		//Não setou email
		
		IValidadorProcesso validador = mock(IValidadorProcesso.class);
		when(validador.validateProcess(proc)).thenReturn(false);
		IRepositorioProcessos repositorio = mock(IRepositorioProcessos.class);
		IServicoEmail emailAceito = mock(IServicoEmail.class);
		IServicoEmail emailNaoAceito = mock(IServicoEmail.class);
		
		ControladorSIAPJ contr = new ControladorSIAPJ(validador, repositorio, emailAceito, 
				emailNaoAceito);
		contr.initProcesso(proc);
	
		verify(validador, times(1)).validateProcess(proc);
		verify(repositorio, never()).addProcesso(proc);
		verify(emailAceito, never()).sendEmail(proc.getEmail());
		verify(emailNaoAceito, times(1)).sendEmail(proc.getEmail());
	}
	
	public void testCerto(){
		Processo proc = new Processo();
		proc.setNomeReclamante("Roberto");
		proc.setContent("Roubaram meu chinelo.");
		proc.setTelefone("99999999");
		proc.setEmail("roberto@gmail.com");
		
		IValidadorProcesso validador = mock(IValidadorProcesso.class);
		when(validador.validateProcess(proc)).thenReturn(true);
		IRepositorioProcessos repositorio = mock(IRepositorioProcessos.class);
		IServicoEmail emailAceito = mock(IServicoEmail.class);
		IServicoEmail emailNaoAceito = mock(IServicoEmail.class);
		
		ControladorSIAPJ contr = new ControladorSIAPJ(validador, repositorio, emailAceito, 
				emailNaoAceito);
		contr.initProcesso(proc);
		
		verify(validador, times(1)).validateProcess(proc);
		verify(repositorio, times(1)).addProcesso(proc);
		verify(emailAceito, times(1)).sendEmail(proc.getEmail());
		verify(emailNaoAceito, never()).sendEmail(proc.getEmail());
	}
}
