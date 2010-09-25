package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import remote.GerenciadorPontosRemote;

@SessionScoped
@ManagedBean
public class AdicionarPontosUC {

	private String cpf;
	private int pontos;
	private GerenciadorPontosRemote gerenciador = null;
	
	public AdicionarPontosUC() throws NamingException {
		Context ctx = new InitialContext();
        gerenciador = (GerenciadorPontosRemote) ctx.lookup("java:global/TrabalhoFinal/ProgramaFidelidadeEJB/GerenciadorPontosUC");
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
    public String salvar() throws Exception{
    	
    	try {
	        gerenciador.acumular(cpf, pontos);
	        return "formAdicionarPontos";
	        
		} finally {
			
		}    	
    }
	
    public String cancelar(){
        return "formAdicionarPontos";
   }
	
}
