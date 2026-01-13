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
        // Arrange
        ClienteDao daoMock = Mockito.mock(ClienteDao.class);
        Mockito.when(daoMock.existe("123")).thenReturn(true);

        ClienteService service = new ClienteService(daoMock);

        // Act & Assert
        Assertions.assertDoesNotThrow(() ->
                service.consultarCliente("123")
        );
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExiste() {
        // Arrange
        ClienteDao daoMock = Mockito.mock(ClienteDao.class);
        Mockito.when(daoMock.existe("999")).thenReturn(false);

        ClienteService service = new ClienteService(daoMock);

        // Act & Assert
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
        // Arrange
        ClienteDao daoMock = Mockito.mock(ClienteDao.class);
        Mockito.when(daoMock.existe("456")).thenReturn(true);

        ClienteService service = new ClienteService(daoMock);

        // Act
        service.consultarCliente("456");

        // Assert (verificação de interação)
        Mockito.verify(daoMock, Mockito.times(1))
                .existe("456");
    }
}
