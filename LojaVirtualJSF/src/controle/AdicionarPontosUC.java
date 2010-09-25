package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import remote.GerenciadorPontosRemote;

@SessionScoped
@ManagedBean(name = "adicionarPontosUC")
public class AdicionarPontosUC {

	private List<String> produtos;
	private String cpf;
	private GerenciadorPontosRemote gerenciador = null;

	public AdicionarPontosUC() throws NamingException {
		Context ctx = new InitialContext();
		gerenciador = (GerenciadorPontosRemote) ctx
				.lookup("java:global/TrabalhoFinal/ProgramaFidelidadeEJB/GerenciadorPontosUC");
	}

	public List<String> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String salvar() throws Exception {

		Integer pontos = 0;

		for (String ponto : produtos) {
			pontos += Integer.parseInt(ponto);
		}

		if (pontos > 0) {
			;
			if (gerenciador.existeUsuario(cpf)) {
				gerenciador.login("big", "big");
				gerenciador.acumular(cpf, pontos);
				return "formAdicionarPontos";
				
			} else { return null; }
		}
		return null;

	}

	public String cancelar() {
		return "formAdicionarPontos";
	}

}
