/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.geom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class Retangulo extends Forma {
    
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
        g.fillRect( iniXD, iniYD, largura, altura );
    
        g.setColor( corContorno );
        g.drawRect( iniXD, iniYD, largura, altura );
    }

    @Override
    public boolean contem( Point p ) {
        int iniXD = iniX < fimX ? iniX : fimX;
        int iniYD = iniY < fimY ? iniY : fimY;
        int fimXD = iniX > fimX ? iniX : fimX;
        int fimYD = iniY > fimY ? iniY : fimY;

        int largura = fimXD - iniXD;
        int altura = fimYD - iniYD;

        Rectangle retangulo = new Rectangle( iniXD, iniYD, largura, altura );
        return retangulo.contains( p );
    }
    
    @Override
    public Forma clonar() {
        Retangulo r = new Retangulo();
        r.setIniX(this.getIniX());
        r.setIniY(this.getIniY());
        r.setFimX(this.getFimX());
        r.setFimY(this.getFimY());
        r.setCorContorno(this.getCorContorno());
        r.setCorPreenchimento(this.getCorPreenchimento());
        return r;
    }
    
}