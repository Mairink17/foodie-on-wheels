package br.com.fiap.foodieOnWheels.bean;


import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@SequenceGenerator(name="tipo_cadastro",sequenceName = "SQ_CADASTRO",allocationSize = 1)
public class TipoCadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_cadastro")
    private int id;

    @Size(max = 30)
    @NotBlank(message = "Campo descrição obrigatório")
    @NotNull
    private String descricao;
        
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoCadastro other = (TipoCadastro) obj;
		return Objects.equals(descricao, other.descricao) && id == other.id;
	}

	public TipoCadastro() {
    }

    public TipoCadastro(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    } 
}
