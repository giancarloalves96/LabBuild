
public class ServicoEmailProcNaoAceito implements IServicoEmail {
	
	JavaEmailApp app;
	
	public ServicoEmailProcNaoAceito () {
		app = new JavaEmailApp();
	}
	
	public boolean sendEmail(String address) {
		app.enviaEmailNaoAceito(address);
		return true;
	}

}
