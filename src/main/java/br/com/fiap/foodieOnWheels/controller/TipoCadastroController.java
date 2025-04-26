package br.com.fiap.foodieOnWheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.foodieOnWheels.bean.TipoCadastro;
import br.com.fiap.foodieOnWheels.repository.TipoCadastroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("tipoCadastro")
public class TipoCadastroController {


    @Autowired
    private TipoCadastroRepository tipoCadastroRepository;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarTipoCadastro(@Valid @RequestBody TipoCadastro tipoCadastro) {
        tipoCadastroRepository.save(tipoCadastro);
        System.out.println(tipoCadastro);
    }
}
