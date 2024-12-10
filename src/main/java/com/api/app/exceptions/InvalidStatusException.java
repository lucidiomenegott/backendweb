package com.api.app.exceptions;

/**
 * Exceção lançada quando um status de pedido inválido é fornecido.
 */
public class InvalidStatusException extends RuntimeException {
    /**
     * Construtor padrão.
     *
     * @param mensagem Mensagem detalhando o erro.
     */
    public InvalidStatusException(String mensagem) {
        super(mensagem);
    }
}
