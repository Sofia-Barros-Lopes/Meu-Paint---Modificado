/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.geom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class Linha extends Forma {

    public void desenhar( Graphics g ) {
        g.setColor( corContorno );
        g.drawLine( iniX, iniY, fimX, fimY );
    }
    
    @Override
public boolean contem(java.awt.Point p) {
    return Line2D.ptSegDist(
        iniX, iniY,
        fimX, fimY,
        p.x, p.y
    ) <= 10;
}
    
    @Override
    public Forma clonar() {
        Linha l = new Linha();
        l.setIniX(this.getIniX());
        l.setIniY(this.getIniY());
        l.setFimX(this.getFimX());
        l.setFimY(this.getFimY());
        l.setCorContorno(this.getCorContorno());
        l.setCorPreenchimento(this.getCorPreenchimento());
        return l;
    }
    
}
