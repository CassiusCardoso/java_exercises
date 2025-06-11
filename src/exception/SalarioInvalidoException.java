package exception;

public class SalarioInvalidoException extends RuntimeException {
    public  SalarioInvalidoException(String mensagem){
        super(mensagem);
    }
}
