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
@SequenceGenerator(name = "estabelecimento", sequenceName = "SQ_ESTABELECIMENTO", allocationSize = 1)
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento")
	private int id;

	@NotBlank(message = "Nome do estabelecimento obrigatório")
	@Size(max = 30)
	private String nome;

	@Size(max = 100)
	@NotNull
	@NotBlank
	private String endereco;

	@NotBlank(message = "Descrição obrigatório")
	@Size(max = 200)
	private String descricao;

	@NotBlank(message = "telefone obrigatório")
	@NotNull
	@Size(max = 15)
	private String telefone;

	@NotBlank(message = "Email obrigatório")
	@Size(max = 40)
	private String email;

	@Size(max = 40)
	private String instagram;

	@ManyToOne
	@NotNull
	private Usuario usuario;

	@NotNull
	@ManyToOne
	private TipoEstabelecimento tipoEstabelecimento;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoEstabelecimento getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, email, endereco, id, instagram, nome, telefone, tipoEstabelecimento, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estabelecimento other = (Estabelecimento) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && id == other.id
				&& Objects.equals(instagram, other.instagram) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone)
				&& Objects.equals(tipoEstabelecimento, other.tipoEstabelecimento)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", descricao=" + descricao
				+ ", telefone=" + telefone + ", email=" + email + ", instagram=" + instagram + ", usuario=" + usuario
				+ ", tipoEstabelecimento=" + tipoEstabelecimento + "]";
	}

	public Estabelecimento() {
		super();
	}

	public Estabelecimento(int id,
			@NotBlank(message = "Nome do estabelecimento obrigatório") @Size(max = 30) String nome,
			@Size(max = 100) @NotNull @NotBlank String endereco,
			@NotBlank(message = "Descrição obrigatório") @Size(max = 200) String descricao,
			@NotBlank(message = "telefone obrigatório") @NotNull @Size(max = 15) String telefone,
			@NotBlank(message = "Email obrigatório") @Size(max = 40) String email, @Size(max = 40) String instagram,
			@NotNull Usuario usuario, @NotNull TipoEstabelecimento tipoEstabelecimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.descricao = descricao;
		this.telefone = telefone;
		this.email = email;
		this.instagram = instagram;
		this.usuario = usuario;
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	
}
