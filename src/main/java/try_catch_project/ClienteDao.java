package try_catch_project;

import java.util.List;

public class ClienteDao {

    // Simula uma base de dados em memória
    private static final List<String> CLIENTES = List.of("123", "456", "789");

    /**
     * Verifica se o cliente existe na base simulada.
     * Utiliza Stream apenas para demonstrar conhecimento
     * de operações funcionais de forma simples e legível.
     */
    public boolean existe(String codigo) {
        return CLIENTES.stream()
                .anyMatch(c -> c.equals(codigo));
    }

}
