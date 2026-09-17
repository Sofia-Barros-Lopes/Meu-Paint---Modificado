/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import gui.geom.Forma;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JPanel;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class PainelDesenho extends JPanel {
    
    private List<Forma> formas;
    private Stack<Estado> pilhaDesfazer;
    private Stack<Estado> pilhaRefazer;
    
    public PainelDesenho() {
        formas = new ArrayList<>();
        pilhaDesfazer = new Stack<>();
        pilhaRefazer = new Stack<>();
    }

    @Override
    protected void paintComponent( Graphics g ) {
    super.paintComponent( g );

    g.setColor( getBackground() );
    g.fillRect( 0, 0, getWidth(), getHeight() );

    for ( Forma forma : formas ) {
        forma.desenhar( g );
    }

    // Borda 
    g.setColor(new Color(255, 105, 180));

for (int i = 0; i < 6; i++) {
    g.drawRoundRect(8 + i, 8 + i, getWidth() - 16 - (i * 2), getHeight() - 16 - (i * 2), 25, 25);
}
    g.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 60));
    
    g.drawString("♡", 15, 60);
    g.drawString("♡", getWidth() - 60, 60);
    g.drawString("♡", 16, getHeight() - 16);
    g.drawString("♡", getWidth() - 60, getHeight() - 16);
}
    public void adicionarForma(Forma forma) {
    salvarEstado();
    formas.add(forma);
    repaint();
}



    // Balde de tinta
    public void preencher(java.awt.Point p, Color cor) {
        salvarEstado();
        boolean encontrouForma = false;

        for (int i = formas.size() - 1; i >= 0; i--) {
            Forma forma = formas.get(i);
            if (forma.contem(p)) {
                forma.setCorPreenchimento(cor);
                encontrouForma = true;
                break;
            }
        }

        if (!encontrouForma) {
            setBackground(cor);
        }

        repaint();
    }
    
    public void apagarForma(java.awt.Point p) {
    for (int i = formas.size() - 1; i >= 0; i--) {
        Forma forma = formas.get(i);
System.out.println("TESTANDO FORMA: " + forma.getClass().getSimpleName());
        if (forma.contem(p)) {
            salvarEstado();
            formas.remove(i);
            repaint();
            return;
        }
    }
}

    public void salvarEstado() {
        List<Forma> copiaFormas = new ArrayList<>();
        for (Forma f : formas) {
            copiaFormas.add(f.clonar());
        }
        
        pilhaDesfazer.push(new Estado(copiaFormas, getBackground()));
        pilhaRefazer.clear();
    }

    public boolean podeDesfazer() {
        return !pilhaDesfazer.isEmpty();
    }

    public boolean podeRefazer() {
        return !pilhaRefazer.isEmpty();
    }

    public void desfazer() {
        if (podeDesfazer()) {
            List<Forma> copiaAtual = new ArrayList<>();
            for (Forma f : formas) {
                copiaAtual.add(f.clonar());
            }
            pilhaRefazer.push(new Estado(copiaAtual, getBackground()));
            
            Estado estadoAnterior = pilhaDesfazer.pop();
            this.formas = estadoAnterior.getFormas();
            this.setBackground(estadoAnterior.getCorFundo());

            repaint();
        }
    }

    public void refazer() {
        if (podeRefazer()) {
            List<Forma> copiaAtual = new ArrayList<>();
            for (Forma f : formas) {
                copiaAtual.add(f.clonar());
            }
            pilhaDesfazer.push(new Estado(copiaAtual, getBackground()));

            Estado proximoEstado = pilhaRefazer.pop();
            this.formas = proximoEstado.getFormas();
            this.setBackground(proximoEstado.getCorFundo());

            repaint();
        }
    }

    private static class Estado {
        private final List<Forma> formas;
        private final Color corFundo;

        public Estado(List<Forma> formas, Color corFundo) {
            this.formas = formas;
            this.corFundo = corFundo;
        }

        public List<Forma> getFormas() {
            return formas;
        }

        public Color getCorFundo() {
            return corFundo;
        }
    }
}