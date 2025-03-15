```markdown
# Board de Tarefas em Java

Este projeto é um exemplo prático de como construir um board de tarefas em Java, aplicando boas práticas de programação e utilizando uma arquitetura em camadas (Model, Repository, Service e Controller). O projeto permite a criação, listagem, atualização e remoção de tarefas por meio de um menu interativo no console.

## Sumário

- [Descrição](#descrição)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

## Descrição

O "Board de Tarefas" foi desenvolvido para demonstrar um fluxo completo de gerenciamento de tarefas, desde o planejamento até a implementação de funcionalidades, passando pela separação de responsabilidades em diferentes camadas. Esse projeto é uma ótima base para quem deseja aprender mais sobre a organização de aplicações em Java e pode ser expandido para incluir interfaces gráficas, persistência em banco de dados ou uma API REST.

## Estrutura do Projeto

A organização do código segue a estrutura abaixo:

```
src/
└── com.boardtarefas
    ├── controller
    │      └── TaskBoardApp.java       // Classe principal com o menu interativo
    ├── model
    │      ├── Task.java                // Modelo da tarefa
    │      └── TaskStatus.java          // Enum com os status (TODO, DOING, DONE)
    ├── repository
    │      └── TaskRepository.java      // Armazenamento das tarefas (em memória)
    └── service
           └── TaskService.java         // Lógica de negócio para manipulação das tarefas
```

## Funcionalidades

- **Criar Tarefa:** Permite adicionar uma nova tarefa com título e descrição.
- **Listar Tarefas:** Exibe todas as tarefas cadastradas no sistema.
- **Atualizar Status:** Altera o status de uma tarefa para um dos valores disponíveis (TODO, DOING, DONE).
- **Remover Tarefa:** Exclui uma tarefa do board utilizando seu identificador único.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação utilizada no desenvolvimento.
- **Programação Orientada a Objetos (POO):** Estruturação do código em classes e métodos para promover a reutilização e modularidade.
- **Arquitetura em Camadas:** Separação clara das responsabilidades entre Model, Repository, Service e Controller.
