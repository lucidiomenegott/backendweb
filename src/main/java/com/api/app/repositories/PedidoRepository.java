package com.api.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.app.models.PedidoModel;
import com.api.app.models.ClienteModel;
import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
    List<PedidoModel> findAllByCliente(ClienteModel cliente);
}
