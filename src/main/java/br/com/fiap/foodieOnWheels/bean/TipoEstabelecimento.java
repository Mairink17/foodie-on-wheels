package br.com.fiap.foodieOnWheels.bean;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "tipoEstabelecimento", sequenceName = "SQ_TP_ESTABELECIMENTO", allocationSize = 1)
public class TipoEstabelecimento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoEstabelecimento")
	private int id;

	@NotBlank(message = "Descrição do nome obrigatório")
	@Size(max = 30)
	private String nome;

	@NotBlank(message = "Descrição do tipo de estabelecimento obrigatório")
	@Size(max = 120)
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoEstabelecimento other = (TipoEstabelecimento) obj;
		return Objects.equals(descricao, other.descricao) && id == other.id && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "TipoEstabelecimento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

	public TipoEstabelecimento() {
		super();
	}

	public TipoEstabelecimento(int id, @NotBlank(message = "Descrição do nome obrigatório") @Size(max = 30) String nome,
			@NotBlank(message = "Descrição do tipo de estabelecimento obrigatório") @Size(max = 120) String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
}
