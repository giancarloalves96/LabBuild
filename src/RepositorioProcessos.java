import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class RepositorioProcessos implements IRepositorioProcessos{
	
	private HashMap <Integer, Processo> repositorio = new HashMap <Integer, Processo>();
	private String folderPath = ".//Processos";
	private File folder;
	
	public RepositorioProcessos(){
		folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		for(int i=0;i<listOfFiles.length;i++){
			Processo proc = new Processo(listOfFiles[i]);
			repositorio.put(proc.getId(), proc);
		}
	}
	
	public boolean addProcesso(Processo processo){
		int id = processo.getId();
		//Nao armazena processos com mesmo Ids
		if(repositorio.containsKey(id))
			return false;
		else{
			repositorio.put(id, processo.copyProcesso());
			UUID uuid = UUID.randomUUID();
			try {
				processo.serialize(folderPath+"//"+uuid.toString()+".txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}
	
	public Processo getProcesso(int id){
		//Para nao alterar o banco de processos, o metodo retorna 
		//uma copia do processo requisitado
		if(repositorio.containsKey(id)){
			return repositorio.get(id).copyProcesso();
		}
		else return null;
	}
}
