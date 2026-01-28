# Sudoku Java 

Aplicação de Sudoku desenvolvida em **Java** utilizando **Swing**, com foco em boas práticas de programação, **Programação Orientada a Objetos (POO)** e organização de código limpa.

---

## 🚀 Funcionalidades

- **Tabuleiro 9x9** com blocos 3x3 destacados
- **Inicialização automática** com números fixos pré-definidos
- **Inserção e remoção** de valores pelo usuário
- **Validação do estado do jogo**, garantindo que regras do Sudoku sejam respeitadas
- **Contador de tempo** da partida para registro de performance

---

## 💻 Tecnologias Utilizadas

- **Java SE**
- **Swing** para interface gráfica
- **POO** para modelagem de classes e separação de responsabilidades (MVC)

---

## 🎯 Objetivo do Projeto

Este projeto tem como propósito:

1. Consolidar conhecimentos em **Programação Orientada a Objetos**.
2. Aplicar lógica de negócio para **validação de regras do Sudoku**.
3. Desenvolver uma **aplicação desktop funcional** e organizada.
4. Servir como **exemplo de portfólio profissional** para recrutadores e futuras oportunidades.

---

## 🏗️ Estrutura do Projeto

O projeto segue uma organização clara em camadas e responsabilidades:

- **Model**: Classes que representam o tabuleiro (`Board`), espaços (`Space`) e lógica do jogo.
- **View**: Interface gráfica (`SudokuFrame`) com painéis, botões e interação do usuário.
- **Controller**: Gerencia a comunicação entre o Model e a View, atualizando o estado do jogo.
- **Util**: Classes utilitárias, como templates de tabuleiro e validação de entrada.

---

## ⚙️ Como Executar

1. **Clonar o repositório**:
   ```bash
   git clone <URL_DO_REPOSITORIO>
Abrir o projeto em sua IDE Java favorita (Eclipse, IntelliJ, NetBeans).

Executar a classe Main:

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SudokuFrame());
    }
}
Interagir com o tabuleiro inserindo ou removendo números.

📈 Aprendizados
Aplicação prática de MVC em Swing

Manipulação de componentes gráficos (JPanel, JButton, JTextField)

Implementação de validação de regras do Sudoku

Controle de tempo de jogo e atualização da interface dinamicamente

Boas práticas de POO e organização de código

📂 Próximos Passos / Evoluções
Implementar geração aleatória de tabuleiros válidos

Adicionar níveis de dificuldade (fácil, médio, difícil)

Salvar o progresso do jogador para retomar partidas

Melhorar a interface gráfica com cores, ícones e feedback visual

📌 Contato

LinkedIn: https://www.linkedin.com/in/enzo-anthony/
