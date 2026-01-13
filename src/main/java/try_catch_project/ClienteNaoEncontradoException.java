package try_catch_project;

/**
 * Exceção de domínio lançada quando uma operação
 * tenta acessar um cliente inexistente.
 */
public class ClienteNaoEncontradoException extends Exception {

      public ClienteNaoEncontradoException(String msg) {
        super(msg);
    }

}
