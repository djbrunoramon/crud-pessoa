package com.spring.crudpessoa.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf", length = 14, unique = true)
    private String cpf;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Column(name = "altura",precision = 4, scale = 2)
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,##0.00")
    private BigDecimal altura;

    @Column(name = "peso")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,##0.00")
    private Double peso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
