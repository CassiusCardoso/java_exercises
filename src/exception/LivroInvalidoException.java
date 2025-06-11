package exception;

public class LivroInvalidoException extends RuntimeException {
    public LivroInvalidoException(String mensagem){
        super(mensagem);
    }
}
