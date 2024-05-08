package com.magalu.plataformadecomunicacao.service;

import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;

public interface PlataformaDeComunicacaoService {

    PlataformaDeComunicacao enviarMensagem(PlataformaDeComunicacao plataforma,Integer cpf);
    PlataformaDeComunicacao consultaPorStatus(Mensagem mensagem);
}
