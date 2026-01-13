Try-Catch Project — Exceções e Regras de Negócio em Java

Visão Geral

Este projeto demonstra a aplicação de tratamento de exceções em Java com foco em clareza, boas práticas e organização de código.

A aplicação simula a consulta de clientes por código, validando regras de negócio e tratando erros de forma controlada por meio de exceções de domínio, evitando fluxos condicionais excessivos e melhorando a legibilidade.

Objetivo Técnico

Aplicar try/catch de forma semântica (não apenas defensiva)

Criar e utilizar exceções personalizadas

Separar responsabilidades entre Service e DAO

Demonstrar domínio básico de Streams API

Desenvolver testes automatizados com JUnit 5

Simular dependências com Mockito

Tecnologias Utilizadas

Java 17+

Maven

JUnit 5

Mockito

Streams API

Swing (JOptionPane) para simulação de entrada

Estrutura do Projeto

src/
 ├── main/java/try_catch_project
 │   ├── App.java
 │   ├── ClienteDao.java
 │   ├── ClienteService.java
 │   └── ClienteNaoEncontradoException.java
 │
 └── test/java/try_catch_project
     └── AppTest.java

Arquitetura e Decisões

ClienteDao

Simula uma base de dados em memória

Utiliza Stream.anyMatch() para demonstrar operações funcionais simples e legíveis

public boolean existe(String codigo) {
    return CLIENTES.stream()
            .anyMatch(c -> c.equals(codigo));
}

ClienteService

Centraliza a regra de negócio

Lança uma exceção de domínio quando a regra não é satisfeita

public void consultarCliente(String codigo)
        throws ClienteNaoEncontradoException {

    if (!clienteDAO.existe(codigo)) {
        throw new ClienteNaoEncontradoException(
                "Cliente com código " + codigo + " não foi encontrado."
        );
    }
}


Essa abordagem evita:

Retornos ambíguos

Uso excessivo de if/else

Lógica de negócio espalhada pela aplicação

App

Responsável apenas pela interação com o usuário

Trata a exceção de forma centralizada

Mantém o fluxo principal limpo

Testes Automatizados

Os testes validam:

Cenários de sucesso

Lançamento correto de exceções

Interação entre Service e DAO

Comportamento esperado sem dependência de implementação real

Execução:

mvn test


Observação: Em versões mais recentes do Java (ex: Java 23), o Mockito pode apresentar limitações relacionadas ao Byte Buddy.
O projeto está compatível com ambientes acadêmicos e avaliativos padrão.

Boas Práticas Aplicadas

Exceções específicas de domínio

Separação clara de responsabilidades

Código legível e comentado com propósito técnico

Uso consciente de Streams

Testes focados em comportamento

Status

✔ Concluído
📚 Projeto educacional com foco em boas práticas
🧩 Parte do portfólio de estudos em Java

Autor

Carlos
Projeto desenvolvido para estudo e evolução técnica em Java.
