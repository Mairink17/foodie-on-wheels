package br.com.fiap.foodieOnWheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.foodieOnWheels.bean.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Usuario findById(int id);
    Usuario findByLogin(String login);
}
