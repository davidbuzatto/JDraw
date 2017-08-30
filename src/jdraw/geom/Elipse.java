/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.geom;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author David
 */
public class Elipse extends Forma {

    @Override
    public void desenhar( Graphics2D g2d ) {
        
        Graphics2D g2 = (Graphics2D) g2d.create();
        
        if ( corPreenchimento != null ) {
            g2.setPaint( corPreenchimento );
            g2.fill( new Ellipse2D.Double( xIni, yIni, xFim-xIni, yFim-yIni ) );
        }
        
        if ( corTraco != null ) {
            g2.setPaint( corTraco );
            g2.setStroke( new BasicStroke( (float) espessuraTraco ) );
            g2.draw( new Ellipse2D.Double( xIni, yIni, xFim-xIni, yFim-yIni ) );
        }
        
        g2.dispose();
        
    }
    
    @Override
    public boolean intercepta( int x, int y ) {
        return x >= xIni && x <= xFim && y >= yIni && y <= yFim;
    }
    
}
