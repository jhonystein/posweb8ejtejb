package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import modelo.Cliente;
import modelo.Loja;
import remote.GerenciadorPontosRemote;

@SessionScoped
@ManagedBean(name="lojaVirtualUC")
public class LojaVirtualUC {
	
	private Loja loja = new Loja();
	private Cliente cliente = new Cliente();
	private int ponto = 0;
    private GerenciadorPontosRemote gerenciador = null;
    
    public LojaVirtualUC() throws NamingException {
    	 Context ctx = new InitialContext();
    	 gerenciador = (GerenciadorPontosRemote) ctx.lookup("java:global/TrabalhoFinal/ProgramaFidelidadeEJB/GerenciadorPontosUC");
	}
   
    public Loja getLoja(){
        return loja;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public int getPontos(){
        return ponto;
    }
    
    public String validarCliente() throws Exception{
    	if(!gerenciador.existeUsuario(cliente.getCpf()))
    		FacesContext.getCurrentInstance().addMessage("clienteValido", new FacesMessage("Cliente não existe!"));
    	return "formAutenticarLoja";
    }
    
    public String autenticarLoja() throws Exception{
    	gerenciador.login(loja.getNick(), loja.getSenha());
    	return "formAcumularPontuacao";
    }
    
    public String acumularPontuacao() throws Exception{
    	gerenciador.acumular(cliente.getCpf(), ponto);
    	return novo();
    }

    public String novo(){
        loja = new Loja();
        cliente = new Cliente();
        ponto = 0;
        return "formNovaCompra";
    }
}