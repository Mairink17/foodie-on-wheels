package br.com.fiap.foodieOnWheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.foodieOnWheels.bean.Login;
import br.com.fiap.foodieOnWheels.bean.Usuario;
import br.com.fiap.foodieOnWheels.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
		Usuario loginCompar = usuarioRepository.findByLogin(usuario.getLogin());
		if (loginCompar != null) {
			if (loginCompar.getLogin().equals(usuario.getLogin())) {
				return "usuário informado já existe, favor selecionar um diferente";
			} else {
				usuarioRepository.save(usuario);
				System.out.println(usuario);
				return "Cadastro realizado com sucesso";
			}
		} else {
			usuarioRepository.save(usuario);
			System.out.println(usuario);
			return "Cadastro realizado com sucesso";
		}
	}

	@PostMapping("/login")
	public String login(@RequestBody Login login) {

		Usuario usuario = usuarioRepository.findByLogin(login.getLogin());
		if (usuario.getLogin().equals(login.getLogin()) && usuario.getSenha().equals(login.getSenha())) {
			return "Logado com sucesso";
		} else {
			return "Usuario ou senha incorretos";
		}

	}

	@GetMapping("/dadoscadastrais/{id}")
	public Usuario listarDadosUsuario(@PathVariable("id") int id) {
		return usuarioRepository.findById(id);

	}

	@GetMapping("/excluir/{id}")
	public String excluirUsuario(@PathVariable("id") int id) {
		Usuario usuario = usuarioRepository.findById(id);
		if (usuario != null) {
			usuarioRepository.delete(usuario);
			return "Excluido com sucesso";
		} else {
			return "Usuario não localizado";
		}

	}

}
