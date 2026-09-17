/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sofia Barros e Gleyce Kelly
 */
package gui.geom;


import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class Caneta extends Forma {

    private List<Point> pontos;

    public Caneta() {
        this.pontos = new ArrayList<>();
    }

    public void adicionarPonto(int x, int y) {
        pontos.add(new Point(x, y));
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(corContorno);
        
        for (int i = 0; i < pontos.size() - 1; i++) {
            Point p1 = pontos.get(i);
            Point p2 = pontos.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    
    @Override
    public boolean contem(java.awt.Point p) {
    for (int i = 0; i < pontos.size() - 1; i++) {
        Point p1 = pontos.get(i);
        Point p2 = pontos.get(i + 1);

        double distancia = java.awt.geom.Line2D.ptSegDist(
            p1.x, p1.y,
            p2.x, p2.y,
            p.x, p.y
        );

        if (distancia <= 10) {
            return true;
        }
    }

    return false;
}
    
    @Override
    public Forma clonar() {
        Caneta c = new Caneta();
        c.setIniX(this.getIniX());
        c.setIniY(this.getIniY());
        c.setFimX(this.getFimX());
        c.setFimY(this.getFimY());
        c.setCorContorno(this.getCorContorno());
        c.setCorPreenchimento(this.getCorPreenchimento());

        if (this.pontos != null) {
            for (Point p : this.pontos) {
                c.adicionarPonto(p.x, p.y);
            }
        }

        return c;
    }
}