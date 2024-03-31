package br.com.curso.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax number inválido", "ON-0001"),
    ON0002("Tax number indisponível", "ON-0002"),
    ON0003("E-mail indisponível", "ON-0003"),
    ON0004("Houve um erro na criação do usuário", "ON-0004"),
    TR0001("Usuário lojista não tem a função tranferência disponível", "TR-0001"),
    TR0002("Saldo indiponível.", "TR-0002"),
    TRP0001("Pin inválido", "TR-0001")
       ;
    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
