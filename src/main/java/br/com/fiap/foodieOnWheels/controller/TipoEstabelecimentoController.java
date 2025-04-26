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
import br.com.fiap.foodieOnWheels.bean.TipoEstabelecimento;
import br.com.fiap.foodieOnWheels.repository.TipoEstabelecimentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("tipoEstabelecimento")
public class TipoEstabelecimentoController {

	@Autowired
	private TipoEstabelecimentoRepository tipoEstabelecimentoRepository;

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrarTipoEstabelecimento(@Valid @RequestBody TipoEstabelecimento tipoEstabelecimento) {
		tipoEstabelecimentoRepository.save(tipoEstabelecimento);
		System.out.println(tipoEstabelecimento);
	}

	@GetMapping("/lista")
	public List<TipoEstabelecimento> listar() {
		return tipoEstabelecimentoRepository.findAll();

	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") int id) {
		TipoEstabelecimento tipoEstabelecimento = tipoEstabelecimentoRepository.findById(id);
		if (tipoEstabelecimento != null) {
			tipoEstabelecimentoRepository.delete(tipoEstabelecimento);
			return "Excluido com sucesso";
		} else {
			return "Tipo de estabelecimento não localizado";
		}

	}

}
