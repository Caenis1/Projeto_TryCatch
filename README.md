Try-Catch Project — Exceções e Regras de Negócio em Java

Visão Geral:

Este projeto demonstra a aplicação de tratamento de exceções em Java com foco em clareza, boas práticas e organização de código.

A aplicação simula a consulta de clientes por código, validando regras de negócio e tratando erros de forma controlada por meio de exceções de domínio, evitando fluxos condicionais excessivos e melhorando a legibilidade.

Objetivo Técnico:

Aplicar try/catch de forma semântica (não apenas defensiva);

Criar e utilizar exceções personalizadas;

Separar responsabilidades entre Service e DAO;

Demonstrar domínio básico de Streams API;

Desenvolver testes automatizados com JUnit 5;

Simular dependências com Mockito;


Tecnologias Utilizadas:

Java 17+;

Maven;

JUnit 5;

Mockito;

Streams API;

Swing (JOptionPane) para simulação de entrada;



Lógica de negócio espalhada pela aplicação:

App: Responsável apenas pela interação com o usuário, trata a exceção de forma centralizada e mantém o fluxo principal limpo;

Testes Automatizados;

Os testes validam:

Cenários de sucesso;

Lançamento correto de exceções;

Interação entre Service e DAO;


Comportamento esperado sem dependência de implementação real



✔ Concluído
📚 Projeto educacional com foco em boas práticas
🧩 Parte do portfólio de estudos em Java

Autor

Carlos
Projeto desenvolvido para estudo e evolução técnica em Java.
