/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import gui.geom.Elipse;
import gui.geom.Forma;
import gui.geom.Linha;
import gui.geom.Poligono;
import gui.geom.Retangulo;
import gui.geom.Caneta;
import gui.geom.Estrela;
import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger( JanelaPrincipal.class.getName() );
    
    private Forma novaForma;
    private int quantidadeLados;

    
    public JanelaPrincipal() {
        initComponents();
        
        quantidadeLados = 3;
        
        btnLinha.setFocusable(false);
        btnRetangulo.setFocusable(false);
        btnElipse.setFocusable(false);
        btnPoligono.setFocusable(false);
        btnCaneta.setFocusable(false);
        btnBalde.setFocusable(false);
        configurarAtalhosTeclado();
        btnborracha.setFocusable(false);
        btnGroupFerramentas.add(btnborracha);
        btnEstrela.setFocusable(false);
        btnGroupFerramentas.add(btnEstrela);
               
        
        personalizarVisual();
    }
    
private void personalizarVisual() {
    Color rosaClaro = new Color(255, 214, 236);
    Color rosaForte = new Color(255, 105, 180);

    painelFerramentas.setBackground(rosaClaro);
    painelFerramentas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 4, rosaForte));

    javax.swing.JToggleButton[] botoes = {
        btnLinha, btnRetangulo, btnElipse, btnEstrela,
        btnPoligono, btnCaneta, btnborracha, btnBalde
    };

    java.awt.Dimension tamanho = new java.awt.Dimension(55, 40);

    for (javax.swing.JToggleButton btn : botoes) {
        btn.setBackground(Color.WHITE);
        btn.setBorder(javax.swing.BorderFactory.createLineBorder(rosaForte, 2, true));
        btn.setFocusPainted(false);
        btn.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 18));
        btn.setPreferredSize(tamanho);
        btn.setMinimumSize(tamanho);
        btn.setMaximumSize(tamanho);
        btn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    javax.swing.JPanel painelCores = new javax.swing.JPanel();
    painelCores.setOpaque(false);
    painelCores.add(painelCorContorno);
    painelCores.add(painelCorPreenchimento);
    painelCores.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

    painelFerramentas.removeAll();
    painelFerramentas.setLayout(new javax.swing.BoxLayout(painelFerramentas, javax.swing.BoxLayout.Y_AXIS));

    
    javax.swing.JToggleButton[] antesDasCores = {
        btnLinha, btnRetangulo, btnElipse, btnEstrela, btnPoligono, btnCaneta, btnborracha
    };

    for (javax.swing.JToggleButton btn : antesDasCores) {
        painelFerramentas.add(javax.swing.Box.createVerticalStrut(10));
        painelFerramentas.add(btn);
    }

    painelFerramentas.add(javax.swing.Box.createVerticalStrut(10));
    painelFerramentas.add(painelCores);

    painelFerramentas.add(javax.swing.Box.createVerticalStrut(10));
    painelFerramentas.add(btnBalde);

    painelFerramentas.revalidate();

    pack();
    setLocationRelativeTo(null);
}
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFerramentas = new javax.swing.ButtonGroup();
        painelDesenho = new gui.PainelDesenho();
        painelFerramentas = new javax.swing.JPanel();
        btnLinha = new javax.swing.JToggleButton();
        btnRetangulo = new javax.swing.JToggleButton();
        btnElipse = new javax.swing.JToggleButton();
        btnCaneta = new javax.swing.JToggleButton();
        btnborracha = new javax.swing.JToggleButton();
        btnEstrela = new javax.swing.JToggleButton();
        btnPoligono = new javax.swing.JToggleButton();
        btnBalde = new javax.swing.JToggleButton();
        painelCorContorno = new javax.swing.JPanel();
        painelCorPreenchimento = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meu Paint");

        painelDesenho.setBackground(new java.awt.Color(255, 255, 255));
        painelDesenho.setBorder(new javax.swing.border.MatteBorder(null));
        painelDesenho.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                painelDesenhoMouseDragged(evt);
            }
        });
        painelDesenho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelDesenhoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                painelDesenhoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout painelDesenhoLayout = new javax.swing.GroupLayout(painelDesenho);
        painelDesenho.setLayout(painelDesenhoLayout);
        painelDesenhoLayout.setHorizontalGroup(
            painelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );
        painelDesenhoLayout.setVerticalGroup(
            painelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        painelFerramentas.setBackground(new java.awt.Color(204, 204, 204));

        btnGroupFerramentas.add(btnLinha);
        btnLinha.setText("╱");
        btnLinha.setToolTipText("Linha");
        btnLinha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnGroupFerramentas.add(btnRetangulo);
        btnRetangulo.setText("▭");
        btnRetangulo.setToolTipText("Retângulo");
        btnRetangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRetangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnGroupFerramentas.add(btnElipse);
        btnElipse.setText("○");
        btnElipse.setToolTipText("Elipse");
        btnElipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnElipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnGroupFerramentas.add(btnCaneta);
        btnCaneta.setText("✎");
        btnCaneta.setToolTipText("Caneta");
        btnCaneta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCaneta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCaneta.addActionListener(this::btnCanetaActionPerformed);

        btnborracha.setText("⌫");
        btnborracha.setToolTipText("Borracha");
        btnborracha.addActionListener(this::btnborrachaActionPerformed);

        btnEstrela.setText("★");
        btnEstrela.setToolTipText("Estrela");
        btnEstrela.addActionListener(this::btnEstrelaActionPerformed);

        btnGroupFerramentas.add(btnPoligono);
        btnPoligono.setText("⬠");
        btnPoligono.setToolTipText("Polígono");
        btnPoligono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPoligono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPoligono.addActionListener(this::btnPoligonoActionPerformed);

        btnGroupFerramentas.add(btnBalde);
        btnBalde.setText("Balde");
        btnBalde.setToolTipText("Balde");
        btnBalde.addActionListener(this::btnBaldeActionPerformed);

        painelCorContorno.setBackground(new java.awt.Color(0, 0, 0));
        painelCorContorno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelCorContorno.setToolTipText("Contorno");
        painelCorContorno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelCorContorno.setPreferredSize(new java.awt.Dimension(20, 20));
        painelCorContorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelCorContornoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelCorContornoLayout = new javax.swing.GroupLayout(painelCorContorno);
        painelCorContorno.setLayout(painelCorContornoLayout);
        painelCorContornoLayout.setHorizontalGroup(
            painelCorContornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        painelCorContornoLayout.setVerticalGroup(
            painelCorContornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        painelCorPreenchimento.setBackground(new java.awt.Color(255, 255, 255));
        painelCorPreenchimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelCorPreenchimento.setToolTipText("Preenchimento");
        painelCorPreenchimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelCorPreenchimento.setPreferredSize(new java.awt.Dimension(20, 20));
        painelCorPreenchimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelCorPreenchimentoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelCorPreenchimentoLayout = new javax.swing.GroupLayout(painelCorPreenchimento);
        painelCorPreenchimento.setLayout(painelCorPreenchimentoLayout);
        painelCorPreenchimentoLayout.setHorizontalGroup(
            painelCorPreenchimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        painelCorPreenchimentoLayout.setVerticalGroup(
            painelCorPreenchimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelFerramentasLayout = new javax.swing.GroupLayout(painelFerramentas);
        painelFerramentas.setLayout(painelFerramentasLayout);
        painelFerramentasLayout.setHorizontalGroup(
            painelFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFerramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLinha)
                    .addComponent(btnRetangulo)
                    .addComponent(btnElipse)
                    .addComponent(btnEstrela)
                    .addComponent(btnPoligono)
                    .addComponent(btnCaneta)
                    .addComponent(btnBalde)
                    .addGroup(painelFerramentasLayout.createSequentialGroup()
                        .addComponent(painelCorContorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelCorPreenchimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnborracha, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFerramentasLayout.setVerticalGroup(
            painelFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFerramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRetangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnElipse, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstrela)
                .addGap(18, 18, 18)
                .addComponent(btnPoligono, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCaneta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnborracha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFerramentasLayout.createSequentialGroup()
                        .addComponent(painelCorContorno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBalde))
                    .addComponent(painelCorPreenchimento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDesenho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void painelDesenhoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelDesenhoMousePressed
        this.requestFocusInWindow();
        
        if (btnborracha.isSelected()) {
        System.out.println("BORRACHA FOI ACIONADA");
    novaForma = null;
    painelDesenho.apagarForma(evt.getPoint());
    return;

}

        if (btnBalde.isSelected()) {
            novaForma = null;
            painelDesenho.preencher(evt.getPoint(), painelCorPreenchimento.getBackground());
            painelDesenho.repaint();
            return;
        }

        if ( btnLinha.isSelected() ) {
    novaForma = new Linha();
    System.out.println("LINHA SELECIONADA");

} else if ( btnRetangulo.isSelected() ) {
    novaForma = new Retangulo();

} else if ( btnElipse.isSelected() ) {
    novaForma = new Elipse();

} else if ( btnPoligono.isSelected() ) {
    novaForma = new Poligono( quantidadeLados );

} else if ( btnEstrela.isSelected() ) {
    novaForma = new Estrela();
    
} else if ( btnCaneta.isSelected() ) {
    novaForma = new Caneta();
}

novaForma.setIniX( evt.getX() );
novaForma.setIniY( evt.getY() );
novaForma.setFimX( evt.getX() );
novaForma.setFimY( evt.getY() );
novaForma.setCorContorno( painelCorContorno.getBackground() );
novaForma.setCorPreenchimento( painelCorPreenchimento.getBackground() );

if ( novaForma instanceof gui.geom.Caneta ) {
    ((gui.geom.Caneta) novaForma).adicionarPonto( evt.getX(), evt.getY() );
}

painelDesenho.adicionarForma( novaForma );
    }//GEN-LAST:event_painelDesenhoMousePressed

    private void painelDesenhoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelDesenhoMouseReleased
        if (novaForma == null) {
            return;
        }

        if (novaForma instanceof gui.geom.Caneta) {
            ((gui.geom.Caneta) novaForma).adicionarPonto(evt.getX(), evt.getY());
        } else {
            novaForma.setFimX(evt.getX());
            novaForma.setFimY(evt.getY());
        }

        painelDesenho.repaint();
    }//GEN-LAST:event_painelDesenhoMouseReleased

    private void painelDesenhoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelDesenhoMouseDragged
        if (novaForma == null) {
            return;
        }

        if (novaForma instanceof gui.geom.Caneta) {
            ((gui.geom.Caneta) novaForma).adicionarPonto(evt.getX(), evt.getY());
        } else {
            novaForma.setFimX(evt.getX());
            novaForma.setFimY(evt.getY());
        }

        painelDesenho.repaint();
    }//GEN-LAST:event_painelDesenhoMouseDragged

    private void painelCorContornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCorContornoMouseClicked
        
        Color corSelecionada = JColorChooser.showDialog( 
                this, "Cor do Contorno", painelCorContorno.getBackground() );
        
        if ( corSelecionada != null ) {
            painelCorContorno.setBackground( corSelecionada );
        }
        
    }//GEN-LAST:event_painelCorContornoMouseClicked

    private void painelCorPreenchimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCorPreenchimentoMouseClicked
        
        Color corSelecionada = JColorChooser.showDialog( 
                this, "Cor do Preenchimento", painelCorPreenchimento.getBackground() );
        
        if ( corSelecionada != null ) {
            painelCorPreenchimento.setBackground( corSelecionada );
        }
        
    }//GEN-LAST:event_painelCorPreenchimentoMouseClicked

    private void btnPoligonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoligonoActionPerformed
        
        try {
            String valor = JOptionPane.showInputDialog( "Quantidade de Lados:" );
            int quantidade = Integer.parseInt( valor );
            if ( quantidade >= 3 ) {
                quantidadeLados = quantidade;
            }
        } catch ( NumberFormatException exc ) {}
        
    }//GEN-LAST:event_btnPoligonoActionPerformed

    private void btnBaldeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaldeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaldeActionPerformed

    private void btnCanetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCanetaActionPerformed

    private void btnborrachaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrachaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnborrachaActionPerformed

    private void btnEstrelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstrelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEstrelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main( String args[] ) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if ( "Nimbus".equals( info.getName() ) ) {
                    javax.swing.UIManager.setLookAndFeel( info.getClassName() );
                    break;
                }
            }
        } catch ( ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex ) {
            logger.log( java.util.logging.Level.SEVERE, null, ex );
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater( () -> new JanelaPrincipal().setVisible( true ) );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBalde;
    private javax.swing.JToggleButton btnCaneta;
    private javax.swing.JToggleButton btnElipse;
    private javax.swing.JToggleButton btnEstrela;
    private javax.swing.ButtonGroup btnGroupFerramentas;
    private javax.swing.JToggleButton btnLinha;
    private javax.swing.JToggleButton btnPoligono;
    private javax.swing.JToggleButton btnRetangulo;
    private javax.swing.JToggleButton btnborracha;
    private javax.swing.JPanel painelCorContorno;
    private javax.swing.JPanel painelCorPreenchimento;
    private gui.PainelDesenho painelDesenho;
    private javax.swing.JPanel painelFerramentas;
    // End of variables declaration//GEN-END:variables
    
    private void configurarAtalhosTeclado() {
       
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK), "desfazer");
    
        getRootPane().getActionMap().put("desfazer", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (painelDesenho.podeDesfazer()) {
                    painelDesenho.desfazer();
                }
            }
        });

       
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK), "refazer");
    
        getRootPane().getActionMap().put("refazer", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (painelDesenho.podeRefazer()) {
                    painelDesenho.refazer();
                }
            }
        });
    }
    
        
}