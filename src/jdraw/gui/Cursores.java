/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author David
 */
public class Cursores {
    
    private Cursor cBalde;
    private Cursor cMover;
    private Cursor cLapis;
    private Cursor cCruz;
    
    private static final Cursores INSTANCE;
    
    public enum Tipo {
        BALDE,
        MOVER,
        LAPIS,
        CRUZ
    }
    
    static {
        INSTANCE = new Cursores();
    }
    
    private Cursores() {
        
        try {
            
            Toolkit t = Toolkit.getDefaultToolkit();
            
            BufferedImage imgCruz = new BufferedImage( 32, 32, BufferedImage.TYPE_INT_ARGB );
            BufferedImage imgBalde = new BufferedImage( 32, 32, BufferedImage.TYPE_INT_ARGB );
            BufferedImage imgMover = new BufferedImage( 32, 32, BufferedImage.TYPE_INT_ARGB );
            BufferedImage imgLapis = new BufferedImage( 32, 32, BufferedImage.TYPE_INT_ARGB );
            
            Graphics g = imgCruz.createGraphics();
            g.setColor( Color.BLACK );
            g.drawOval( 8, 8, 6, 6 );
            g.drawLine( 11, 0, 11, 8 );
            g.drawLine( 11, 14, 11, 21 );
            g.drawLine( 0, 11, 8, 11 );
            g.drawLine( 14, 11, 21, 11 );
            
            g.dispose();
            
            imgBalde.getGraphics().drawImage( ImageIO.read( 
                    getClass().getResource( "/jdraw/gui/icones/balde.png" ) ), 0, 0, null );
            imgMover.getGraphics().drawImage( ImageIO.read( 
                    getClass().getResource( "/jdraw/gui/icones/cursor-openhand.png" ) ), 0, 0, null );
            imgLapis.getGraphics().drawImage( ImageIO.read( 
                    getClass().getResource( "/jdraw/gui/icones/lapis.png" ) ), 0, 0, null );
            
            cBalde = t.createCustomCursor( imgBalde, new Point( 0, 12 ),  "balde" );
            cMover = t.createCustomCursor( imgMover, new Point( 7, 7 ), "mover" );
            cLapis = t.createCustomCursor( imgLapis, new Point( 0, 14 ), "lapis" );
            cCruz = t.createCustomCursor( imgCruz, new Point( 11, 11 ), "cruz" );
        
        } catch ( IOException exc ) {
            exc.printStackTrace();
        }
        
    }
    
    public static Cursor getCursor( Tipo tipo ) {
        
        switch ( tipo ) {
            case BALDE:
                return INSTANCE.cBalde;
            case MOVER:
                return INSTANCE.cMover;
            case LAPIS:
                return INSTANCE.cLapis;
            case CRUZ:
                return INSTANCE.cCruz;
            
        }
        
        return INSTANCE.cCruz;
        
    }
    
    
}
