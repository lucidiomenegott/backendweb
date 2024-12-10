package com.api.app.exceptions;

/**
 * Exceção lançada quando há duplicidade de CPF.
 */
public class DuplicateCpfException extends RuntimeException {
    /**
     * Construtor padrão.
     *
     * @param mensagem Mensagem detalhando o erro.
     */
    public DuplicateCpfException(String mensagem) {
        super(mensagem);
    }
}
