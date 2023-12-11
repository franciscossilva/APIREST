package com.example.tarefas.APIREST.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Date dataVencimento;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Tarefas(long l, String título, String descrição, Date dataVencimento, boolean b, Object o) {
    }
}
