package br.com.fiap.foodieOnWheels.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.foodieOnWheels.bean.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	Produto findById(int id);
    List<Produto> findAll();
    List<Produto> findByNome(String nome);
    List<Produto> findByPrecoBetween(double preco , double preco2);
}
