package com.magalu.plataformadecomunicacao.service.implementation;

import com.magalu.plataformadecomunicacao.exception.PlataformaDeComunicacaoException;
import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;
import com.magalu.plataformadecomunicacao.model.dto.PlataformaDeComunicacaoDTO;
import com.magalu.plataformadecomunicacao.repository.PlataformaDeComunicacaoRepository;
import com.magalu.plataformadecomunicacao.service.PlataformaDeComunicacaoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PlataformaDeComunicacaoServiceImplementation implements PlataformaDeComunicacaoService {
    @Autowired
    private PlataformaDeComunicacaoRepository repository;
    @Override
    @Transactional
    public PlataformaDeComunicacaoDTO enviarMensagem(PlataformaDeComunicacaoDTO plataforma){
        PlataformaDeComunicacao entidade = converToDto(plataforma);
        repository.save(entidade);
        return plataforma;
    }
    @Override
    public List<PlataformaDeComunicacao> consultaPorStatus(String mensagem){
        return repository.findByMensagem(mensagem);

    }
    @Override
    @Transactional
    public void delete(Long id){
        validateInformedId(id);
        repository.deleteById(id);
    }
    private void validateInformedId(Long id){
        if(isEmpty(id)){
            throw new PlataformaDeComunicacaoException("Não existe esse destinatário.");
        }
    }

    @Override
    public PlataformaDeComunicacao converToDto(PlataformaDeComunicacaoDTO dto){
        return PlataformaDeComunicacao.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .mensagem(dto.getMensagem())
                .build();
    }


}
