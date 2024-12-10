package com.api.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.app.dtos.ClienteDTO;
import com.api.app.exceptions.DuplicateCpfException;
import com.api.app.exceptions.ResourceNotFoundException;
import com.api.app.models.ClienteModel;
import com.api.app.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Criar Cliente
    public ClienteModel criarCliente(ClienteDTO clienteDTO) {
        Optional<ClienteModel> existente = clienteRepository.findByCpf(clienteDTO.getCpf());
        if (existente.isPresent()) {
            throw new DuplicateCpfException("CPF " + clienteDTO.getCpf() + " já está cadastrado.");
        }

        ClienteModel cliente = new ClienteModel();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEndereco(clienteDTO.getEndereco());

        return clienteRepository.save(cliente);
    }

    // Listar Todos os Clientes
    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll();
    }

    // Buscar Cliente por ID
    public ClienteModel buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + id + " não encontrado."));
    }

    // Atualizar Cliente
    public ClienteModel atualizarCliente(Long id, ClienteDTO clienteDTO) {
        ClienteModel cliente = buscarClientePorId(id);

        if (!cliente.getCpf().equals(clienteDTO.getCpf())) {
            // Verifica se o novo CPF já está em uso
            Optional<ClienteModel> existente = clienteRepository.findByCpf(clienteDTO.getCpf());
            if (existente.isPresent()) {
                throw new DuplicateCpfException("CPF " + clienteDTO.getCpf() + " já está cadastrado.");
            }
            cliente.setCpf(clienteDTO.getCpf());
        }

        cliente.setNome(clienteDTO.getNome());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEndereco(clienteDTO.getEndereco());

        return clienteRepository.save(cliente);
    }

    // Remover Cliente
    public boolean removerCliente(Long id) {
        ClienteModel cliente = buscarClientePorId(id);
        if (!cliente.getPedidos().isEmpty()) {
            throw new IllegalArgumentException("Não é possível remover cliente com pedidos vinculados.");
        }
        clienteRepository.delete(cliente);
        return true;  // Retornando 'true' indicando que a remoção foi bem-sucedida
    }
}
