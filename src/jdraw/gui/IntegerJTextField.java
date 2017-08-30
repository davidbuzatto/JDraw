/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.gui;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * 
 *
 * @author David
 */
public class IntegerJTextField extends JTextField {

    public IntegerJTextField() {
        super();
    }

    @Override
    protected Document createDefaultModel() {
        
        return new PlainDocument() {
            
            @Override
            public void insertString( int offs, String str, AttributeSet a )
                    throws BadLocationException {

                if ( str == null ) {
                    return;
                }

                boolean ok = true;

                try {
                    Integer.parseInt( str );
                } catch ( NumberFormatException exc ) {
                    ok = false;
                }

                if ( ok ) {
                    super.insertString( offs, str, a );
                }

            }
            
        };
        
    }

}
