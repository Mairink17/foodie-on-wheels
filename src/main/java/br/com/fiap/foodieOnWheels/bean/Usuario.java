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
@SequenceGenerator(name="usuario",sequenceName = "SQ_USUARIO",allocationSize = 1)
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    private int id;

    @NotBlank(message = "Login obrigatório")
    @Size(max = 30)
    private String login;

    @NotBlank(message = "Senha obrigatório")
    @Size(max = 30)
    private String senha;

    @NotBlank(message = "Email obrigatório")
    @Size(max = 40)
    private String email;

    @NotBlank(message = "Nome obrigatório")
    @Size(max = 70)
    private String nome;

    @NotBlank(message = "Cpf obrigatório")
    @Size(max = 11)
    private String cpf;

    @ManyToOne
    @NotNull
    private TipoCadastro tipoCadastro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public TipoCadastro getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(TipoCadastro tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, login, nome, senha, tipoCadastro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(login, other.login) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(tipoCadastro, other.tipoCadastro);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", email=" + email + ", nome=" + nome
				+ ", cpf=" + cpf + ", tipoCadastro=" + tipoCadastro + "]";
	}

	public Usuario() {
		super();
	}

	public Usuario(int id, @NotBlank(message = "Login obrigatório") @Size(max = 30) String login,
			@NotBlank(message = "Senha obrigatório") @Size(max = 30) String senha,
			@NotBlank(message = "Email obrigatório") @Size(max = 40) String email,
			@NotBlank(message = "Nome obrigatório") @Size(max = 70) String nome,
			@NotBlank(message = "Cpf obrigatório") @Size(max = 11) String cpf,
			TipoCadastro tipoCadastro) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.tipoCadastro = tipoCadastro;
	}


}
