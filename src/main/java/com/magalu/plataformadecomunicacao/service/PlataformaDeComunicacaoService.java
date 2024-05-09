package com.magalu.plataformadecomunicacao.service;

import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;
import com.magalu.plataformadecomunicacao.model.dto.PlataformaDeComunicacaoDTO;

import java.util.List;

public interface PlataformaDeComunicacaoService {

    PlataformaDeComunicacaoDTO enviarMensagem(PlataformaDeComunicacaoDTO plataforma);
    List<PlataformaDeComunicacao> consultaPorStatus(String mensagem);
    void delete(Long id);
    PlataformaDeComunicacao converToDto(PlataformaDeComunicacaoDTO dto);
}
