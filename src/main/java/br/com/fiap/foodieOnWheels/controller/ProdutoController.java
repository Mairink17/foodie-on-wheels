package br.com.fiap.foodieOnWheels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import br.com.fiap.foodieOnWheels.bean.Produto;
import br.com.fiap.foodieOnWheels.repository.ProdutoRepository;

@RestController
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrarProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		System.out.println(produto);
	}

	@GetMapping("/lista")
	public List<Produto> listar() {
		return produtoRepository.findAll();

	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") int id) {
		Produto produto = produtoRepository.findById(id);
		if (produto != null) {
			produtoRepository.delete(produto);
			return "Excluido com sucesso";
		} else {
			return "Tipo de cadastro não localizado";
		}

	}

	@GetMapping("/filtraPreco/{valor}&{valor2}")
	public List<Produto> filtrarPrecos(@PathVariable("valor") double valor, @PathVariable("valor2") double valor2) {
		return produtoRepository.findByPrecoBetween(valor, valor2);

	}

}
