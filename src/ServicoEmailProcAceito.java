
public class ServicoEmailProcAceito implements IServicoEmail {

	JavaEmailApp app;
	
	public ServicoEmailProcAceito () {
		app = new JavaEmailApp();
	}
	
	public boolean sendEmail(String address) {
		app.enviaEmailAceito(address);
		return true;
	}

}
