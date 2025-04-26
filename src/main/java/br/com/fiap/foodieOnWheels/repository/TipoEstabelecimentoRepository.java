package br.com.fiap.foodieOnWheels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.foodieOnWheels.bean.TipoEstabelecimento;

@Repository
public interface TipoEstabelecimentoRepository extends JpaRepository<TipoEstabelecimento, Integer> {
    
	TipoEstabelecimento findById(int id);
    List<TipoEstabelecimento> findAll();
}
