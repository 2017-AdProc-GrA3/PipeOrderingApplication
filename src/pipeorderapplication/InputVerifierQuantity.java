/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.awt.Color;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * InputVerifierQuantity.java
 * Purpose: Input Verifier for text of type integer greater than 0 and less than 100. Also sets enabled of button.
 * 
 * @author up789464
 * @version 1.0 04/12/17
 */
public class InputVerifierQuantity extends InputVerifier {
    
    public JButton button;
    
    /**
     * Constructor for class
     * 
     * @param button    The button to disable/enable depending on if text is verified.
     */
    public InputVerifierQuantity(JButton button) {
        super();
        this.button = button;
    }

    /**
     * Verifies whether the text input is a positive integer greater than 0.
     * 
     * @param input     A JComponent to verify the text of
     * @return          Boolean of whether the text is of type integer and greater than 0
     */
    @Override
    public boolean verify(JComponent input) {
        JTextField component = (JTextField) input;
        String text = component.getText();
        
        try {
            Integer.parseInt(text);
            if (Integer.parseInt(text) < 1 || Integer.parseInt(text) > 100) {
                component.setBackground(new Color(255, 90, 90));
                button.setEnabled(false);
                showMessageDialog(null, "Quantity must be between 1 and 100");
                return false;
            } else {
                component.setBackground(new Color(255, 255, 255));
                button.setEnabled(true);
            }
        }
        catch(NumberFormatException e) {
            component.setBackground(new Color(255, 90, 90));
            button.setEnabled(false);
            return false;
        }
        return true;
    }
    
}