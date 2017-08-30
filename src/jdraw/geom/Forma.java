/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.geom;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author David
 */
public abstract class Forma {
    
    protected Color corTraco;
    protected Color corPreenchimento;
    protected double espessuraTraco;
    
    protected double xIni;
    protected double xFim;
    protected double yIni;
    protected double yFim;
    
    public abstract void desenhar( Graphics2D g2d );
    public abstract boolean intercepta( int x, int y );

    public void mover( double difX, double difY ) {
        xIni += difX;
        xFim += difX;
        yIni += difY;
        yFim += difY;
    }
    
    public void setCorTraco( Color corTraco ) {
        this.corTraco = corTraco;
    }

    public void setCorPreenchimento( Color corPreenchimento ) {
        this.corPreenchimento = corPreenchimento;
    }

    public void setEspessuraTraco( double espessuraTraco ) {
        this.espessuraTraco = espessuraTraco;
    }

    public void setXIni( double xIni ) {
        this.xIni = xIni;
    }

    public void setXFim( double xFim ) {
        this.xFim = xFim;
    }

    public void setYIni( double yIni ) {
        this.yIni = yIni;
    }

    public void setYFim( double yFim ) {
        this.yFim = yFim;
    }

    public double getXIni() {
        return xIni;
    }
    
    public double getXFim() {
        return xFim;
    }

    public double getYIni() {
        return yIni;
    }
    
    public double getYFim() {
        return yFim;
    }
    
    public double getLargura() {
        return xFim - xIni;
    }
    
    public double getAltura() {
        return yFim - yIni;
    }
    
}
