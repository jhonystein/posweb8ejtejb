package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
@NamedQuery(name="clientePorCPF", query="select c from Cliente as c where c.cpf = ?1 "),
@NamedQuery(name="loginCliente", query="select c from Cliente as c where c.cpf = ?1 and c.senha = ?2 "), 
//@NamedQuery(name="clienteUltimaTroca", query="select c, ((select sum(m.ponto) from Movimentacao m where m.cliente.codigo = c.codigo and tipo = 'Entrada') - (select sum(m.ponto) from Movimentacao m where m.cliente.codigo = c.codigo and tipo = 'Saída')) saldo from Cliente as c where c.codigo not in (select m.cliente.codigo from Movimentacao m where m.tipo = TipoMovimentacao.SAIDA and max(m.data) >= ?1 group by m.cliente.codigo) group by c.codigo"),
//@NamedQuery(name="clienteSaldoPontos", query="select c, sum(case m.tipo when TipoMovimentacao.ENTRADA then m.ponto * -1 else m.ponto end) from Movimentacao m left outer join Cliente c where c.codigo not in (select m.cliente.codigo from Movimentacao m where m.tipo = TipoMovimentacao.SAIDA and max(m.data) >= ?1 group by m.cliente.codigo) group by c"),
})
public class Cliente extends Entidade{

	private static final long serialVersionUID = 1L;
	
	@Column(name="ds_cliente")
	private String nome;
	
	@Column(name="nr_cpf", unique=true, nullable=false)
	private String cpf;
	
	@Column(name="ds_senha")
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
