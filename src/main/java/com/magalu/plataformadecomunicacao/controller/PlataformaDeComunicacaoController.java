package com.magalu.plataformadecomunicacao.controller;

import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;
import com.magalu.plataformadecomunicacao.service.PlataformaDeComunicacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plataforma")
public class PlataformaDeComunicacaoController {

    PlataformaDeComunicacaoService service;

    @GetMapping("/status/{mensagem}")
    public PlataformaDeComunicacao procurarPorStatus(@PathVariable Mensagem mensagem){
        return service.consultaPorStatus(mensagem);
    }
}
