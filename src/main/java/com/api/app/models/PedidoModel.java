
package com.api.app.models;

import jakarta.persistence.*;
import com.api.app.models.ClienteModel;
import com.api.app.models.StatusPedido;

@Entity
@Table(name = "pedidos")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    // Getters e Setters
}
