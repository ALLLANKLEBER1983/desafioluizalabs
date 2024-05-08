package com.magalu.plataformadecomunicacao.service.implementation;

import com.magalu.plataformadecomunicacao.exception.PlataformaDeComunicacaoException;
import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;
import com.magalu.plataformadecomunicacao.repository.PlataformaDeComunicacaoRepository;
import com.magalu.plataformadecomunicacao.service.PlataformaDeComunicacaoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PlataformaDeComunicacaoServiceImplementation implements PlataformaDeComunicacaoService {

    private PlataformaDeComunicacaoRepository repository;

    public PlataformaDeComunicacao enviarMensagem(PlataformaDeComunicacao plataforma,Integer cpf){
        if(repository.existsByDestinatario_Cpf(cpf)){
            throw new PlataformaDeComunicacaoException("Já existe esse destinatário");
        }
        repository.save(plataforma);
        return plataforma;
    }

    public PlataformaDeComunicacao consultaPorStatus(Mensagem mensagem){
        return repository.findByMensagem(mensagem);

    }


}
