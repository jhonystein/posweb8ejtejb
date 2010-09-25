package remote;

import javax.ejb.Remote;

@Remote
public interface GerenciadorPontosRemote {

	boolean existeUsuario(String cpf);
	
	void login(String nick, String senha) throws Exception;
	
	void acumular(String cpf, int pontos);
	
}
