package br.com.fiap.foodieOnWheels.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.foodieOnWheels.bean.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer>{
	
    Estabelecimento findById(int id);
    List<Estabelecimento> findByNome(String nome);
    List<Estabelecimento> findByEnderecoContains(String endereco);
	

}
