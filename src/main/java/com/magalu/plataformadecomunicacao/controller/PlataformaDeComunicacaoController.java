package com.magalu.plataformadecomunicacao.controller;

import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;
import com.magalu.plataformadecomunicacao.model.dto.PlataformaDeComunicacaoDTO;
import com.magalu.plataformadecomunicacao.service.PlataformaDeComunicacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plataforma")
@Api(value = "API REST plataforma")
@CrossOrigin(origins = "*")
public class PlataformaDeComunicacaoController {
    @Autowired
    PlataformaDeComunicacaoService service;

    @GetMapping("/status/{mensagem}")
    @ApiOperation(value = "Faz uma busca de destinatário pelo status.")
    public List<PlataformaDeComunicacao> procurarPorStatus(@PathVariable String mensagem){
        return service.consultaPorStatus(mensagem);
    }
    @PostMapping("/inserir")
    @ApiOperation(value = "Adiciona um novo agendamento")
    public  PlataformaDeComunicacaoDTO inserirMensagem(@RequestBody PlataformaDeComunicacaoDTO plataforma){
        return service.enviarMensagem(plataforma);
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation(value = "deleta um agendamento")
    public void deletarDestinatário(@PathVariable Long id){
        service.delete(id);
    }
}
