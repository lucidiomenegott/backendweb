package com.api.app.exceptions;

/**
 * Exceção lançada quando um recurso não é encontrado.
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Construtor padrão.
     *
     * @param mensagem Mensagem detalhando o erro.
     */
    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
