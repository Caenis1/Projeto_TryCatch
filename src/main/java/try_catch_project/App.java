package try_catch_project;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // Entrada de dados simulada via interface gráfica
        String codigo = JOptionPane.showInputDialog(
                null,
                "Digite o código do cliente:"
        );

        ClienteService service = new ClienteService();

        try {
            service.consultarCliente(codigo);

            // Fluxo de sucesso
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente encontrado com sucesso."
            );

        } catch (ClienteNaoEncontradoException e) {

            // Tratamento centralizado da exceção de domínio
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
