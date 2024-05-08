package com.magalu.plataformadecomunicacao.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Destinatario {

    @NotNull
    String nome;
    @Min(11)
    @NotNull
    Integer cpf;
}
