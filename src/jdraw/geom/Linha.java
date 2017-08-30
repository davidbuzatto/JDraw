/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.geom;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author David
 */
public class Linha extends Forma {

    @Override
    public void desenhar( Graphics2D g2d ) {
        
        Graphics2D g2 = (Graphics2D) g2d.create();
        
        if ( corTraco != null ) {
            g2.setPaint( corTraco );
            g2.setStroke( new BasicStroke( (float) espessuraTraco ) );
        }
        
        g2.draw( new Line2D.Double( xIni, yIni, xFim, yFim ) );
        
        g2.dispose();
        
    }
    
    @Override
    public boolean intercepta( int x, int y ) {
        
        double xrIni = xIni < xFim ? xIni : xFim;
        double xrFim = xIni < xFim ? xFim : xIni;
        double yrIni = yIni < yFim ? yIni : yFim;
        double yrFim = yIni < yFim ? yFim : yIni;
        
        return x >= xrIni && x <= xrFim && y >= yrIni && y <= yrFim;
        
    }
    
}
