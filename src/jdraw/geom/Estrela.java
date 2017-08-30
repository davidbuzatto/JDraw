/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.geom;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

/**
 *
 * @author David
 */
public class Estrela extends Poligono {
    
    @Override
    public void desenhar( Graphics2D g2d ) {
        
        calcular();
        
        Graphics2D g2 = (Graphics2D) g2d.create();
        
        Path2D.Double estrela = new Path2D.Double();
        estrela.moveTo( xs[0], ys[0] );
        
        if ( quantidadeLados % 2 == 0 ) {
            
            // se par, faz em duas partes
            for ( int i = 2; i < quantidadeLados; i += 2 ) {
                estrela.lineTo( xs[i], ys[i] );
            }
            estrela.closePath();
            
            estrela.moveTo( xs[1], ys[1] );
            for ( int i = 3; i < quantidadeLados; i += 2 ) {
                estrela.lineTo( xs[i], ys[i] );
            }
            
        } else {
            
            for ( int i = 2; i < quantidadeLados * 2; i += 2 ) {
                estrela.lineTo( xs[i%quantidadeLados], ys[i%quantidadeLados] );
            }
            
        }
        
        estrela.closePath();
        
        if ( corPreenchimento != null ) {
            g2.setPaint( corPreenchimento );
            g2.fill( estrela );
        }
        
        if ( corTraco != null ) {
            g2.setPaint( corTraco );
            g2.setStroke( new BasicStroke( (float) espessuraTraco ) );
            g2.draw( estrela );
        }
        
        g2.dispose();
        
    }
    
}
