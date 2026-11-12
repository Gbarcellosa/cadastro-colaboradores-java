# Cadastro de Colaboradores Java

## Visão geral

Este projeto implementa um sistema simples de cadastro e gerenciamento de colaboradores em Java, com foco em fundamentos de programação orientada a objetos.

## Objetivo

Demonstrar conceitos de:

- herança
- polimorfismo
- encapsulamento
- abstração
- validação de entrada
- manipulação de listas em Java

## Funcionalidades implementadas

Com base nos arquivos do projeto, o sistema oferece:

- cadastro de colaboradores
- listagem completa
- busca por registro
- remoção de colaborador
- cálculo de salário por tipo
- diferentes categorias de colaborador
- validação de registros e nomes

## Tipos de colaboradores

- CLT
- PJ
- Estagiário

## Regras de negócio

- cada colaborador possui um número de registro único;
- o nome não pode estar vazio;
- o sistema aceita entradas numéricas válidas;
- o cálculo do salário varia conforme a categoria do colaborador.

## Estrutura do projeto

```text
cadastro-colaboradores-java/
├── Colaborador.java
├── ColaboradorCLT.java
├── ColaboradorPJ.java
├── Estagiario.java
├── SistemaColaboradores.java
├── README.md
└── .gitattributes
```

## Tecnologias

- Java
- Programação orientada a objetos
- Console / terminal

## Como executar

### Pré-requisitos

- JDK 17 ou superior

### Compilar

```bash
javac *.java
```

### Executar

```bash
java SistemaColaboradores
```

## Exemplo de uso

```text
========================================
      SISTEMA DE COLABORADORES
========================================
1. Cadastrar colaborador
2. Listar colaboradores
3. Calcular salário de um colaborador
4. Buscar colaborador por registro
5. Remover colaborador
6. Sair
========================================
```

## Aprendizados

- modelagem de classes e herança em Java;
- uso de listas para armazenamento em memória;
- organização de lógica em métodos separados;
- validação de entradas do usuário para melhorar a experiência.

## Sugestões de melhorias

- criar testes unitários para validar cálculo de salários e regras de negócio;
- separar a lógica de UI da lógica de domínio;
- criar classes de serviço para facilitar manutenção;
- adicionar persistência em banco para manter dados além da execução atual.

## Status

Este é um projeto excelente para demonstrar no portfólio a base de Java e programação orientada a objetos. Ele mostra clareza conceitual e bom entendimento de modelagem de software.
