package com.magalu.plataformadecomunicacao.repository;

import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaDeComunicacaoRepository extends JpaRepository<PlataformaDeComunicacao,Long> {

    PlataformaDeComunicacao findByMensagem(Mensagem mensagem);
    Boolean existsByDestinatario_Cpf(Integer cpf);
}
