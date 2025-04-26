package br.com.fiap.foodieOnWheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import br.com.fiap.foodieOnWheels.bean.Estabelecimento;
import br.com.fiap.foodieOnWheels.repository.EstabelecimentoRepository;

@RestController
@RequestMapping("estabelecimento")
public class EstabelecimentoController {

	 @Autowired
	    private EstabelecimentoRepository estabelecimentoRepository;

	    @PostMapping("/cadastrar")
	    @ResponseStatus(HttpStatus.CREATED)
	    public void cadastrarEstabelecimento(@RequestBody Estabelecimento estabelecimento){
	        estabelecimentoRepository.save(estabelecimento);
	        System.out.println(estabelecimento);
	    }

	    @GetMapping("/dadosEstabelecimento/{id}")
	    public Estabelecimento listar(@PathVariable("id") int id){
	        return estabelecimentoRepository.findById(id);
	    }

	    @GetMapping("/excluir/{id}")
	    public String excluir(@PathVariable("id") int id){
	        Estabelecimento usuario = estabelecimentoRepository.findById(id);
	        if (usuario != null){
	            estabelecimentoRepository.delete(usuario);
	            return "Excluido com sucesso";
	        }else{
	            return "Estabelecimento não localizado";
	        }

	    }
}
