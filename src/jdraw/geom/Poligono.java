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
public class Poligono extends Forma {

    protected double xCentro;
    protected double yCentro;
    protected double[] xs;
    protected double[] ys;
    
    protected double raio;
    protected double angulo;
    protected int quantidadeLados;
    
    protected void calcular() {
        
        xs = new double[quantidadeLados];
        ys = new double[quantidadeLados];
        double incrementoAngulo = 360.0 / quantidadeLados;
        
        for ( int i = 0; i < quantidadeLados; i++ ) {
            xs[i] = xCentro + Math.cos( Math.toRadians( angulo ) ) * raio;
            ys[i] = yCentro + Math.sin( Math.toRadians( angulo ) ) * raio;
            angulo += incrementoAngulo;
        }
        
    }
    
    @Override
    public void desenhar( Graphics2D g2d ) {
        
        calcular();
        
        Graphics2D g2 = (Graphics2D) g2d.create();
        
        Path2D.Double poligono = new Path2D.Double();
        poligono.moveTo( xs[0], ys[0] );
        
        for ( int i = 1; i < quantidadeLados; i++ ) {
            poligono.lineTo( xs[i], ys[i] );
        }
        
        poligono.closePath();
        
        if ( corPreenchimento != null ) {
            g2.setPaint( corPreenchimento );
            g2.fill( poligono );
        }
        
        if ( corTraco != null ) {
            g2.setPaint( corTraco );
            g2.setStroke( new BasicStroke( (float) espessuraTraco ) );
            g2.draw( poligono );
        }
        
        g2.dispose();
        
    }

    @Override
    public boolean intercepta( int x, int y ) {
        
        double c1 = x - xCentro;
        double c2 = y - yCentro;
        
        return c1 * c1 + c2 * c2 <= raio * raio;
        
    }

    @Override
    public void mover( double difX, double difY ) {
        super.mover( difX, difY );
        setXCentro( xIni + raio );
        setYCentro( yIni + raio );
    }
    
    @Override
    public void setXIni( double xIni ) {
        super.setXIni( xIni );
        setXCentro( xIni + raio );
    }
    
    @Override
    public void setYIni( double yIni ) {
        super.setYIni( yIni );
        setYCentro( yIni + raio );
    }
    
    public void setXCentro( double xCentro ) {
        this.xCentro = xCentro;
        xIni = xCentro - raio;
        xFim = xCentro + raio;
    }

    public void setYCentro( double yCentro ) {
        this.yCentro = yCentro;
        yIni = yCentro - raio;
        yFim = yCentro + raio;
    }

    public void setRaio( double raio ) {
        this.raio = raio;
    }

    public void setAngulo( double angulo ) {
        this.angulo = angulo;
    }

    public void setQuantidadeLados( int quantidadeLados ) {
        this.quantidadeLados = quantidadeLados;
    }
    
}
