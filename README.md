# 🧩 Sudoku em Java (Swing)

Um jogo de **Sudoku desktop** desenvolvido em **Java**, utilizando **Swing** para a interface gráfica e uma arquitetura bem definida entre **modelo, interface e lógica do jogo**.

O jogo inicia com um tabuleiro gerado automaticamente, contendo números fixos e espaços editáveis, simulando a experiência de um Sudoku real.

---

## 📸 Demonstração

> Tabuleiro 9x9 dividido em **9 blocos (3x3)**, com números iniciais fixos e células editáveis.

*(adicione prints do jogo aqui para deixar o repositório mais profissional)*

---

## 🚀 Funcionalidades

- 🎲 Geração automática do tabuleiro
- 🔢 Números iniciais fixos distribuídos aleatoriamente
- ✏️ Inserção de números pelo usuário
- ❌ Remoção de números não fixos
- 🔒 Proteção contra edição de células fixas
- 🧹 Reset do jogo
- ⏱️ Cronômetro em tempo real
- 🏁 Validação de finalização do jogo
- 🎨 Interface gráfica organizada em blocos 3x3

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Java Swing**
- **Programação Orientada a Objetos (POO)**

---

## 📂 Estrutura do Projeto

Sudoku/
├── Model/
│ ├── Board.java
│ ├── Space.java
│ └── GameStatusEnum.java
│
├── ui/
│ ├── MenuFrame.java
│ └── SudokuFrame.java
│
├── Util/
│ └── BoardTemplate.java
│
└── Main.java


---

## 🧠 Arquitetura

- **Model**
  - Responsável pelas regras do jogo, estado e validações
- **UI**
  - Interface gráfica e interação com o usuário
- **Util**
  - Componentes auxiliares
- **Main**
  - Inicialização da aplicação

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/sudoku-java.git
Abra o projeto em uma IDE (IntelliJ, Eclipse ou VS Code).

Execute a classe:

Main.java
🎯 Objetivo do Projeto
Este projeto foi desenvolvido com o objetivo de:

Praticar Java Swing

Aplicar Programação Orientada a Objetos

Trabalhar com eventos e interfaces gráficas

Desenvolver um projeto completo para portfólio

📌 Melhorias Futuras
✅ Seleção de nível de dificuldade

💡 Validação em tempo real dos números

🎨 Melhorias visuais na interface

💾 Salvamento de progresso

🌍 Versão internacional (i18n)

👤 Autor
Enzo Anthony

📌 Projeto desenvolvido para fins de estudo e portfólio.

