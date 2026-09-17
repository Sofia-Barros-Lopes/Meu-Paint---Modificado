package gui.geom;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Estrela extends Forma {

    @Override
    public void desenhar(Graphics g) {
        g.setColor(corContorno);

        int centroX = (iniX + fimX) / 2;
        int centroY = (iniY + fimY) / 2;

        int raioExterno = Math.min(
            Math.abs(fimX - iniX),
            Math.abs(fimY - iniY)
        ) / 2;

        int raioInterno = raioExterno / 2;

        Polygon estrela = new Polygon();

        for (int i = 0; i < 10; i++) {
            double angulo = -Math.PI / 2 + i * Math.PI / 5;

            int raio;

            if (i % 2 == 0) {
                raio = raioExterno;
            } else {
                raio = raioInterno;
            }

            int x = centroX + (int) (Math.cos(angulo) * raio);
            int y = centroY + (int) (Math.sin(angulo) * raio);

            estrela.addPoint(x, y);
        }

        g.drawPolygon(estrela);
        
        if (corPreenchimento != null) {
    g.setColor(corPreenchimento);
    g.fillPolygon(estrela);
    
    g.setColor(corContorno);
    g.drawPolygon(estrela);
}
    }

    @Override
    public boolean contem(Point p) {
        int centroX = (iniX + fimX) / 2;
        int centroY = (iniY + fimY) / 2;

        int raio = Math.min(
            Math.abs(fimX - iniX),
            Math.abs(fimY - iniY)
        ) / 2;

        return p.distance(centroX, centroY) <= raio;
    }

    @Override
    public Forma clonar() {
        Estrela e = new Estrela();

        e.setIniX(this.getIniX());
        e.setIniY(this.getIniY());
        e.setFimX(this.getFimX());
        e.setFimY(this.getFimY());
        e.setCorContorno(this.getCorContorno());
        e.setCorPreenchimento(this.getCorPreenchimento());

        return e;
    }
}