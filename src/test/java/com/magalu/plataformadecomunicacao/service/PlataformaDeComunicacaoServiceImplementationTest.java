package com.magalu.plataformadecomunicacao.service;

import com.magalu.plataformadecomunicacao.exception.PlataformaDeComunicacaoException;
import com.magalu.plataformadecomunicacao.model.Mensagem;
import com.magalu.plataformadecomunicacao.model.PlataformaDeComunicacao;
import com.magalu.plataformadecomunicacao.model.dto.PlataformaDeComunicacaoDTO;
import com.magalu.plataformadecomunicacao.repository.PlataformaDeComunicacaoRepository;
import com.magalu.plataformadecomunicacao.service.implementation.PlataformaDeComunicacaoServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.magalu.plataformadecomunicacao.model.Mensagem.AGENDADO;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PlataformaDeComunicacaoServiceImplementationTest {

    @Mock
    private PlataformaDeComunicacaoRepository repository;

    @InjectMocks
    private PlataformaDeComunicacaoServiceImplementation service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEnviarMensagem() {
        PlataformaDeComunicacaoDTO plataformaDTO = new PlataformaDeComunicacaoDTO();
        plataformaDTO.setNome("Teste");
        plataformaDTO.setCpf(12345678901l);
        plataformaDTO.setTelefone(123456789l);
        plataformaDTO.setMensagem(AGENDADO);

        PlataformaDeComunicacao plataforma = new PlataformaDeComunicacao();
        plataforma.setNome("Teste");
        plataforma.setCpf(12345678901l);
        plataforma.setTelefone(123456789l);
        plataforma.setMensagem(AGENDADO);

        when(repository.save(any())).thenReturn(plataforma);

        PlataformaDeComunicacaoDTO result = service.enviarMensagem(plataformaDTO);

        assertNotNull(result);
        assertEquals(plataformaDTO, result);
        verify(repository, times(1)).save(any());
    }

    @Test
    public void testConsultaPorStatus() {
        Mensagem mensagem = AGENDADO;


        PlataformaDeComunicacao plataforma1 = new PlataformaDeComunicacao();
        plataforma1.setId(1L);
        plataforma1.setMensagem(mensagem);

        PlataformaDeComunicacao plataforma2 = new PlataformaDeComunicacao();
        plataforma2.setId(2L);
        plataforma2.setMensagem(mensagem);

        when(repository.findByMensagem(mensagem)).thenReturn(List.of(plataforma1, plataforma2));

        List<PlataformaDeComunicacao> result = service.consultaPorStatus(mensagem);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(repository, times(1)).findByMensagem(mensagem);
    }

    @Test
    public void testDelete() {
        Long id = 1L;

        doNothing().when(repository).deleteById(id);

        assertDoesNotThrow(() -> service.delete(id));
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    public void testValidateInformedId() {
        Long id = null;

        assertThrows(PlataformaDeComunicacaoException.class, () -> service.validateInformedId(id));
    }

    @Test
    public void testConverToDto() {
        PlataformaDeComunicacaoDTO plataformaDTO = new PlataformaDeComunicacaoDTO();
        plataformaDTO.setNome("Teste");
        plataformaDTO.setCpf(12345678901l);
        plataformaDTO.setTelefone(123456789l);
        plataformaDTO.setMensagem(AGENDADO);

        PlataformaDeComunicacao plataforma = service.converToDto(plataformaDTO);

        assertNotNull(plataforma);
        assertEquals(plataformaDTO.getNome(), plataforma.getNome());
        assertEquals(plataformaDTO.getCpf(), plataforma.getCpf());
        assertEquals(plataformaDTO.getTelefone(), plataforma.getTelefone());
        assertEquals(plataformaDTO.getMensagem(), plataforma.getMensagem());
    }
}

