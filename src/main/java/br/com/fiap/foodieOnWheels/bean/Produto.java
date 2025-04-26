package br.com.fiap.foodieOnWheels.bean;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "produto", sequenceName = "SQ_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int id;

	@NotBlank(message = "Nome do produto obrigatório")
	@Size(max = 30)
	private String nome;

	@NotBlank(message = "Valor obrigatório")
	private double preco;

	@NotBlank(message = "Descrição do produto obrigatório")
	@Size(max = 50)
	private String descricao;

	@ManyToOne
	@NotNull
	private Estabelecimento estabelecimento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, estabelecimento, id, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(estabelecimento, other.estabelecimento)
				&& id == other.id && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao
				+ ", estabelecimento=" + estabelecimento + "]";
	}

	public Produto() {
		super();
	}

	public Produto(int id, @NotBlank(message = "Nome do produto obrigatório") @Size(max = 30) String nome,
			@NotBlank(message = "Valor obrigatório") double preco,
			@NotBlank(message = "Descrição do produto obrigatório") @Size(max = 50) String descricao,
			@NotNull Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.estabelecimento = estabelecimento;
	}
	
	
}
