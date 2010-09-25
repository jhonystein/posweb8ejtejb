package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;

import remote.GerenciadorPontosRemote;

@SessionScoped
@ManagedBean(name="AdicionarPontosUC")
public class AdicionarPontosUC {

	private String cpf;
	private int pontos;
	
	public AdicionarPontosUC() {}
	
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
	        
    		Context ctx = new InitialContext();
	        GerenciadorPontosRemote gerenciador = (GerenciadorPontosRemote) ctx.lookup("java:global/TrabalhoFinal/ProgramaFidelidadeEJB/GerenciadorPontosUC");
	        gerenciador.acumular(cpf, pontos);
	        
	        return "formAdicionarPontos";
	        
		} finally {
			
		}    	
    }
	
    public String cancelar(){
        return "formAdicionarPontos";
   }
	
}
