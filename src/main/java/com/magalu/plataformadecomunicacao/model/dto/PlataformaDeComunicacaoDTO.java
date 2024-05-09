package com.magalu.plataformadecomunicacao.model.dto;

import com.magalu.plataformadecomunicacao.model.Mensagem;
import lombok.*;


@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
public class PlataformaDeComunicacaoDTO {
    private String mensagem;
    private String nome;
    private Long cpf;
    private long telefone;
}
