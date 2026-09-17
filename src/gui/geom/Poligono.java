/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.geom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class Poligono extends Forma {

    private int quantidadeLados;
    
    public Poligono( int quantidadeLados ) {
        this.quantidadeLados = quantidadeLados;
    }
    
    @Override
    public void desenhar( Graphics g ) {
        int cat1 = fimX - iniX;
        int cat2 = fimY - iniY;
        double tamanho = Math.hypot( cat1, cat2 );
        double tamanhoAngulo = 360.0 / quantidadeLados;
        double anguloAtual = Math.toDegrees( Math.atan2( cat2, cat1 ) );
        
        int[] xs = new int[quantidadeLados];
        int[] ys = new int[quantidadeLados];
        
        for ( int i = 0; i < quantidadeLados; i++ ) {
            double x = iniX + tamanho * Math.cos( Math.toRadians( anguloAtual ) );
            double y = iniY + tamanho * Math.sin( Math.toRadians( anguloAtual ) );
            xs[i] = (int) x;
            ys[i] = (int) y;
            anguloAtual += tamanhoAngulo;
        }
        
        // Se o balde pintou a forma, usa a cor do balde; senão usa a cor de preenchimento original
        Color corAUsar = (corPreenchimentoBalde != null) ? corPreenchimentoBalde : corPreenchimento;
        
        g.setColor( corAUsar );
        g.fillPolygon( xs, ys, quantidadeLados );
        
        g.setColor( corContorno );
        g.drawPolygon( xs, ys, quantidadeLados );
    }

    @Override
    public boolean contem( Point p ) {
        int cat1 = fimX - iniX;
        int cat2 = fimY - iniY;
        double tamanho = Math.hypot( cat1, cat2 );
        double tamanhoAngulo = 360.0 / quantidadeLados;
        double anguloAtual = Math.toDegrees( Math.atan2( cat2, cat1 ) );
        
        int[] xs = new int[quantidadeLados];
        int[] ys = new int[quantidadeLados];
        
        for ( int i = 0; i < quantidadeLados; i++ ) {
            double x = iniX + tamanho * Math.cos( Math.toRadians( anguloAtual ) );
            double y = iniY + tamanho * Math.sin( Math.toRadians( anguloAtual ) );
            xs[i] = (int) x;
            ys[i] = (int) y;
            anguloAtual += tamanhoAngulo;
        }
        
        Polygon poly = new Polygon( xs, ys, quantidadeLados );
        return poly.contains( p );
    }
    
    @Override
    public Forma clonar() {
        
        Poligono p = new Poligono(this.quantidadeLados); 
        p.setIniX(this.getIniX());
        p.setIniY(this.getIniY());
        p.setFimX(this.getFimX());
        p.setFimY(this.getFimY());
        p.setCorContorno(this.getCorContorno());
        p.setCorPreenchimento(this.getCorPreenchimento());
        return p;
    }
}