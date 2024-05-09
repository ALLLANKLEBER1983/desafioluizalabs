package com.magalu.plataformadecomunicacao.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PlataformaDeComunicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String mensagem;
    @NotNull
    private String nome;
    @Min(11)
    @NotNull
    private Long cpf;
    @Min(10)
    @NotNull
    private Long telefone;
    private Date dataHora;

    public Date setDataHora(Data dataHora) {
        return this.dataHora = new Date();
    }
}
