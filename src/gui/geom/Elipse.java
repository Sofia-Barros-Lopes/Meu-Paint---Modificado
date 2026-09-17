/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.geom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class Elipse extends Forma {

    @Override
    public void desenhar( Graphics g ) {
        int iniXD = iniX < fimX ? iniX : fimX;
        int iniYD = iniY < fimY ? iniY : fimY;
        int fimXD = iniX > fimX ? iniX : fimX;
        int fimYD = iniY > fimY ? iniY : fimY;

        int largura = fimXD - iniXD;
        int altura = fimYD - iniYD;

       
        Color corAUsar = (corPreenchimentoBalde != null) ? corPreenchimentoBalde : corPreenchimento;

        g.setColor( corAUsar );
        g.fillOval( iniXD, iniYD, largura, altura );

        g.setColor( corContorno );
        g.drawOval( iniXD, iniYD, largura, altura );
    }

    @Override
    public boolean contem( Point p ) {
        int iniXD = iniX < fimX ? iniX : fimX;
        int iniYD = iniY < fimY ? iniY : fimY;
        int fimXD = iniX > fimX ? iniX : fimX;
        int fimYD = iniY > fimY ? iniY : fimY;

        int largura = fimXD - iniXD;
        int altura = fimYD - iniYD;

        Ellipse2D elipse = new Ellipse2D.Double( iniXD, iniYD, largura, altura );
        return elipse.contains( p );
    }
    
    @Override
    public Forma clonar() {
        Elipse e = new Elipse();
        e.setIniX(this.getIniX());
        e.setIniY(this.getIniY());
        e.setFimX(this.getFimX());
        e.setFimY(this.getFimY());
        e.setCorContorno(this.getCorContorno());
        e.setCorPreenchimento(this.getCorPreenchimento());
        return e;
    }
}