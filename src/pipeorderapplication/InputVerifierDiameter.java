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
 * InputVerifierDiameter.java
 * Purpose: Input Verifier for diameters between 0.2 and 10 inches.
 * 
 * @author up789464
 * @version 1.0 04/12/17
 */
public class InputVerifierDiameter extends InputVerifier {
    
    public JButton button;
    
    /**
     * Constructor for class
     * 
     * @param button    The button to disable/enable depending on if text is verified.
     */
    public InputVerifierDiameter(JButton button) {
        super();
        this.button = button;
    }

    /**
     * Verifies whether the text input is a double between 0.2 and 10
     * 
     * @param input     A JComponent to verify the text of
     * @return          Boolean of whether the text is of type double and between 0.25 and 10
     */
    @Override
    public boolean verify(JComponent input) {
        JTextField component = (JTextField) input;
        String text = component.getText();
        
        try {
            Double.parseDouble(text);
            if (Double.parseDouble(text) < 0.2 || Double.parseDouble(text) > 10) {
                component.setBackground(new Color(255, 90, 90));
                button.setEnabled(false);
                showMessageDialog(null, "Diameter must be between 0.2 and 15 inches");
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
