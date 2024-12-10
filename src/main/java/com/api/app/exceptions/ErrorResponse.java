package com.api.app.exceptions;

import java.time.LocalDateTime;

/**
 * Estrutura de resposta de erro padrão.
 */
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    /**
     * Construtor padrão.
     */
    public ErrorResponse() {
    }

    /**
     * Construtor parametrizado.
     *
     * @param timestamp Data e hora do erro.
     * @param status    Código de status HTTP.
     * @param error     Descrição do erro HTTP.
     * @param message   Mensagem detalhada do erro.
     * @param path      Caminho da requisição que causou o erro.
     */
    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters e Setters

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
