package gui.geom;

import java.awt.Graphics;
import java.awt.Point;

public class Coracao extends Forma {

    @Override
    public void desenhar(Graphics g) {
        g.setColor(corContorno);

        int largura = Math.abs(fimX - iniX);
        int altura = Math.abs(fimY - iniY);

        int x = Math.min(iniX, fimX);
        int y = Math.min(iniY, fimY);

        // Parte de cima do coração
        g.drawArc(x, y, largura / 2, altura / 2, 0, 180);
        g.drawArc(x + largura / 2, y, largura / 2, altura / 2, 0, 180);

        // Parte de baixo
        int[] pontosX = {
            x,
            x + largura / 2,
            x + largura
        };

        int[] pontosY = {
            y + altura / 3,
            y + altura,
            y + altura / 3
        };

        g.drawLine(pontosX[0], pontosY[0], pontosX[1], pontosY[1]);
        g.drawLine(pontosX[1], pontosY[1], pontosX[2], pontosY[2]);
    }

    @Override
    public boolean contem(Point p) {
        int x = Math.min(iniX, fimX);
        int y = Math.min(iniY, fimY);

        int largura = Math.abs(fimX - iniX);
        int altura = Math.abs(fimY - iniY);

        return p.x >= x && p.x <= x + largura
                && p.y >= y && p.y <= y + altura;
    }

    @Override
    public Forma clonar() {
        Coracao c = new Coracao();

        c.setIniX(this.getIniX());
        c.setIniY(this.getIniY());
        c.setFimX(this.getFimX());
        c.setFimY(this.getFimY());
        c.setCorContorno(this.getCorContorno());
        c.setCorPreenchimento(this.getCorPreenchimento());

        return c;
    }
}
