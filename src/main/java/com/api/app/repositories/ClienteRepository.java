package com.api.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.app.models.ClienteModel;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> findByCpf(String cpf);
}
