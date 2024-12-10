package com.api.app.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.app.dtos.ClienteDTO;
import com.api.app.models.ClienteModel;
import com.api.app.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Criar Cliente
    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteModel clienteCriado = clienteService.criarCliente(clienteDTO);
            return ResponseEntity.status(201).body(clienteCriado);  // Retorna status 201 em vez de 200
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Listar Todos os Clientes
    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarClientes() {
        try {
            List<ClienteModel> clientes = clienteService.listarClientes();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Buscar Cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarClientePorId(@PathVariable Long id) {
        try {
            ClienteModel cliente = clienteService.buscarClientePorId(id);
            if (cliente == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Atualizar Cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(
            @PathVariable Long id,
            @Valid @RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteModel clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
            if (clienteAtualizado == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(clienteAtualizado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Remover Cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable Long id) {
        try {
            boolean removido = clienteService.removerCliente(id);
            if (!removido) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
