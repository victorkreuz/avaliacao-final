package com.example.avaliacao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

import static org.apache.catalina.valves.rewrite.InternalRewriteMap.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Cripto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo é obrigatório")
    @Size(min = 3, max = 100, message = "Número de caracteres inválido.")
    private String nome;

    @NotNull(message = "O campo é obrigatório")
    @Pattern(regexp = "[A-Z]{3}", message = "A sigla deve conter 3 letras")
    private String sigla;

    @NotNull(message = "O campo é obrigatório")
    @Positive
    private String precoAtual;

    @NotNull(message = "O campo é obrigatório")
    @PositiveOrZero
    private String volumeNegociado;

    @NotNull(message = "O campo é obrigatório")
    @PastOrPresent(message = "A data de cadastro deve ser anterior á atual")
    private LocalDate dataCadastro;

    @NotNull(message = "O campo é obrigatório")
    private Boolean ativo;

    @Size(min = 0, max = 255, message = "Número de caracteres inválido.")
    private String descricao;

    @NotNull(message = "O campo é obrigatório")
    @Size(min = 2, max = 60, message = "Número de caracteres inválido.")
    private String pais;

    private String siteOficial;

}
