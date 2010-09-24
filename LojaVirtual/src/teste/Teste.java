package teste;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import remote.GerenciadorPontosRemote;

public class Teste {
	

   public static void main(String[] args) throws NamingException {
	        Context ctx = new InitialContext();

	        GerenciadorPontosRemote gerenciador = (GerenciadorPontosRemote) ctx.lookup("java:global/TrabalhoFinal/ProgramaFidelidadeEJB/GerenciadorPontosUC");
	        
	        System.out.println(gerenciador.existeUsuario("6"));
	        System.out.println("Gol!");
	    }
}
