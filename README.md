# 🎨 MeuPaint Personalizado

Projeto de um editor gráfico interativo desenvolvido em Java (Swing/AWT). A aplicação permite a criação, preenchimento e manipulação de formas geométricas em tempo real, além de contar com ferramentas de desenho livre e um sistema de histórico para desfazer e refazer ações.

---

## 👨‍🏫 Créditos e Autoria

* **Projeto Base:** Código original e estrutura base desenvolvidos pelo **Prof. Dr. David Buzatto** ([@davidbuzatto](https://github.com/davidbuzatto)).
* **Modificações e Novas Implementações:** Desenvolvidas por **Sofia Barros** ([@Sofia-Barros-Lopes](https://github.com/Sofia-Barros-Lopes)) e **Gleyce Kelly** ([@gleycekelly12](https://github.com/gleycekelly12)).

---

## ✨ Funcionalidades e Melhorias Implementadas

### 📐 Novas Formas e Ferramentas
* **Coração (`Coracao`):** Desenho vetorial curvado feito através de curvas de Bézier cúbicas (`Path2D`).
* **Estrela (`Estrela`):** Geometria de 5 pontas calculada com trigonometria e coordenadas polares.
* **Caneta (`Caneta`):** Traço livre contínuo registrado ponto a ponto.
* **Borracha (`Borracha`):** Especialização da caneta para apagar traços ajustando a cor do pincel dinamicamente para a cor do fundo do painel.
* **Formas Geométricas Padrão:** Linha, Retângulo, Elipse e Polígono ajustável.

### Balde de Tinta Inteligente
* Identificação de colisão do clique com o topo da pilha de formas (`contem(p)`).
* Alteração da cor de preenchimento da forma clicada ou mudança da cor do painel inteiro quando o clique é em área vazia.

### ↺ Sistema Desfazer e Refazer (Undo/Redo)
* **Cópia Profunda (*Deep Copy*):** Implementação do método `clonar()` em todas as formas, impedindo que modificações de cor via balde sobrescrevam o histórico na memória.
* **Estado Completo:** Salva simultaneamente as instâncias isoladas das formas e a cor de fundo do painel a cada alteração.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **GUI Framework:** Java Swing / AWT
* **IDE:** NetBeans
