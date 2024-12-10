
package com.api.app.services;

import com.api.app.models.PedidoModel;
import com.api.app.models.ClienteModel;
import com.api.app.repositories.PedidoRepository;
import com.api.app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<PedidoModel> listarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public PedidoModel salvarPedido(PedidoModel pedido) {
        ClienteModel cliente = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        pedido.setCliente(cliente);
        return pedidoRepository.save(pedido);
    }
}
