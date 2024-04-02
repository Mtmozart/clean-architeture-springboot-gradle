package br.com.curso.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax number inválido", "ON-0001"),
    ON0002("Tax number indisponível", "ON-0002"),
    ON0003("E-mail indisponível", "ON-0003"),
    ON0004("Houve um erro na criação do usuário", "ON-0004"),
    TR0001("Usuário lojista não tem a função tranferência disponível", "TR-0001"),
    TR0002("Saldo indiponível.", "TR-0002"),
    TR0003("Houve um erro ao realizar a tranferência.", "TR-0003"),
    TR0004("Tranferência não autorizada.", "TR-0004"),
    TRP0001("Pin inválido", "TR-0001"),
    WA0001("Carteira não encontrada", "WA-0001"),
    NO0001("Houve um erro na notficação do usuário", "N0-0001"),
    ATH0001("Houve um erro na autenticação", "ATH-0001"),
    PIN0001("Pin e transação bloqueado.", "PIN-0001"),
    PIN0002("Pin incorreto, %d tentativa(s) restante(s).", "PIN-0002")

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

    public static String pin0001GetMessage(Integer attempt){
        return String.format(PIN0002.message, attempt);
    }
}
