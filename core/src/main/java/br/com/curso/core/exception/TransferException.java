package br.com.curso.core.exception;

public class TransferException extends Exception {

    public String code;
    public TransferException(Object message, Object code) {
        super((String) message);
        this.code = (String) code;
    }
}
