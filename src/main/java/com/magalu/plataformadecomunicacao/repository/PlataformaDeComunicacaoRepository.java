package com.magalu.plataformadecomunicacao.repository;

import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;
import com.magalu.plataformadecomunicacao.model.dto.PlataformaDeComunicacaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlataformaDeComunicacaoRepository extends JpaRepository<PlataformaDeComunicacao,Long> {

    List<PlataformaDeComunicacao> findByMensagem(Mensagem mensagem);
}
