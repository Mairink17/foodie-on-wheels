package br.com.fiap.foodieOnWheels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.foodieOnWheels.bean.TipoCadastro;

@Repository
public interface TipoCadastroRepository extends JpaRepository<TipoCadastro, Integer> {

	  List<TipoCadastro> findByDescricao(String desc);
	  TipoCadastro findById(int id);
	  List<TipoCadastro> findAll();
}
