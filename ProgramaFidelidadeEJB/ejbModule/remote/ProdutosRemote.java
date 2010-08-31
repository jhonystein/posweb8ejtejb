package remote;

import java.util.List;

import javax.ejb.Remote;

import modelo.Produto;

@Remote
public interface ProdutosRemote {

	List<Produto> listar();
	
}
