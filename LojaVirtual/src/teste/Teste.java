package teste;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import remote.GerenciadorPontosRemote;

public class Teste {
	

   public static void main(String[] args) throws NamingException {
	        Context ctx = new InitialContext();

	        GerenciadorPontosRemote Gerenciador = (GerenciadorPontosRemote) ctx.lookup("java:global/TrabalhoFinal/ProgramaFidelidadeEJB/GerenciadorPontosUC");
	        
	        //System.out.println(Gerenciador.existeUsuario("060.747.709-13"));
	        
	    }
}
