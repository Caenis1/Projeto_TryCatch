package try_catch_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    void deveEncontrarClienteQuandoCodigoExiste() {

        ClienteDao daoMock = Mockito.mock(ClienteDao.class);
        Mockito.when(daoMock.existe("123")).thenReturn(true);

        ClienteService service = new ClienteService(daoMock);

        Assertions.assertDoesNotThrow(() ->
                service.consultarCliente("123")
        );
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExiste() {
        
        ClienteDao daoMock = Mockito.mock(ClienteDao.class);
        Mockito.when(daoMock.existe("999")).thenReturn(false);

        ClienteService service = new ClienteService(daoMock);

        
        ClienteNaoEncontradoException exception =
                Assertions.assertThrows(
                        ClienteNaoEncontradoException.class,
                        () -> service.consultarCliente("999")
                );

        Assertions.assertEquals(
                "Cliente com código 999 não foi encontrado.",
                exception.getMessage()
        );
    }

    @Test
    void deveConsultarDaoApenasUmaVez() throws ClienteNaoEncontradoException {
        
        ClienteDao daoMock = Mockito.mock(ClienteDao.class);
        Mockito.when(daoMock.existe("456")).thenReturn(true);

        ClienteService service = new ClienteService(daoMock);

        
        service.consultarCliente("456");

        
        Mockito.verify(daoMock, Mockito.times(1))
                .existe("456");
    }
}
