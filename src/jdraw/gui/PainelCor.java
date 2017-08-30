/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class PainelCor extends JPanel {
    
    private boolean semCor;

    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        
        if ( semCor ) {
            
            g2d.setPaint( Color.WHITE );
            g2d.fillRect( 0, 0, getWidth(), getHeight() );
            
            g2d.setPaint( Color.RED );
            g2d.setStroke( new BasicStroke( 2 ) );
            g2d.drawLine( 0, getHeight(), getWidth(), 0 );
            
        }
        
    }

    public void setSemCor( boolean semCor ) {
        this.semCor = semCor;
    }
    
}
