/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.geom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class Curva extends Forma {

    private List<Double> xs;
    private List<Double> ys;
    
    public Curva() {
        xs = new ArrayList<>();
        ys = new ArrayList<>();
    }
    
    @Override
    public void desenhar( Graphics2D g2d ) {
        
        Graphics2D g2 = (Graphics2D) g2d.create();
        
        Path2D path = new Path2D.Double();
        boolean mover = true;
        int p = 0;

        for ( double x : xs ) {

            if ( mover ) {
                path.moveTo( x, ys.get( p ) );
                mover = false;
            } else {
                path.lineTo( x, ys.get( p ) );
            }

            p++;

        }
            
        if ( corPreenchimento != null ) {
            g2.setPaint( corPreenchimento );
            g2.fill( path );
        }
        
        if ( corTraco != null ) {
            g2.setPaint( corTraco );
            g2.setStroke( new BasicStroke( (float) espessuraTraco ) );
            g2.draw( path );
        }
        
        g2.dispose();
        
    }

    public void adicionarX( double x ) {
        
        xs.add( x );
        
        if ( xs.size() == 1 ) {
            xIni = x;
            xFim = x;
        } else if ( x < xIni ) {
            xIni = x;
        } else if ( x > xFim ) {
            xFim = x;
        }
        
    }

    public void adicionarY( double y ) {
        
        ys.add( y );
        
        if ( ys.size() == 1 ) {
            yIni = y;
            yFim = y;
        } else if ( y < yIni ) {
            yIni = y;
        } else if ( y > yFim ) {
            yFim = y;
        }
        
    }
    
    @Override
    public void mover( double difX, double difY ) {
        
        super.mover( difX, difY );
        
        for ( int i = 0; i < xs.size(); i++ ) {
            xs.set( i, xs.get( i ) + difX );
            ys.set( i, ys.get( i ) + difY );
        }
        
    }
    
    @Override
    public boolean intercepta( int x, int y ) {
        return x >= xIni && x <= xFim && y >= yIni && y <= yFim;
    }
    
}
