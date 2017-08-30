/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import jdraw.geom.Forma;

/**
 *
 * @author David
 */
public class PainelDesenho extends JPanel {
    
    private Color corFundo;
    
    private Forma formaTemporaria;
    private final List<Forma> formas;
    private final List<Forma> listaRefazer;
    
    public PainelDesenho() {
        corFundo = Color.WHITE;
        formas = new ArrayList<>();
        listaRefazer = new ArrayList<>();
    }

    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        desenhar( g );
        
    }
    
    public void desenhar( Graphics g ) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        
        g2d.setPaint( corFundo );
        g2d.fillRect( 0, 0, getWidth(), getHeight() );
        
        for ( Forma f : formas ) {
            f.desenhar( g2d );
        }
        
        if ( formaTemporaria != null ) {
            formaTemporaria.desenhar( g2d );
        }
        
    }
    
    public void adicionarForma( Forma f ) {
        formas.add( f );
        listaRefazer.clear();
    }
    
    public void desfazer() {
        
        if ( formas.size() > 0 ) {
            listaRefazer.add( formas.remove( formas.size() - 1 ) );
        }
        
    }
    
    public void refazer() {
        
        if ( listaRefazer.size() > 0 ) {
            formas.add( listaRefazer.remove( listaRefazer.size() - 1 ) );
        }
        
    }
    
    public boolean possivelDesfazer() {
        return formas.size() > 0;
    }
    
    public boolean possivelRefazer() {
        return listaRefazer.size() > 0;
    }
    
    public void setCorFundo( Color corFundo ) {
        this.corFundo = corFundo;
    }

    public void setFormaTemporaria( Forma formaTemporaria ) {
        this.formaTemporaria = formaTemporaria;
    }

    public List<Forma> getFormas() {
        return formas;
    }
    
}
