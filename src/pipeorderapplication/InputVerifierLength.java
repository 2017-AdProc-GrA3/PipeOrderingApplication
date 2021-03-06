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
 * InputerVerifierLength.java
 * Purpose: Input Verifier for lengths between 0.1 and 6 meters.
 * 
 * @author up789464
 * @version 1.0 04/12/17
 */
public class InputVerifierLength extends InputVerifier {
    
    private JButton button;
    
    /**
     * Constructor for class
     * 
     * @param button    The button to disable/enable depending on if text is verified.
     */
    public InputVerifierLength(JButton button) {
        super();
        this.button = button;
    }
    
    /**
     * Verifies whether the text input is a double between 0.1 and 6
     * 
     * @param input     A JComponent to verify the text of
     * @return          Boolean of whether the text is of type double and between 0.1 and 6
     */
    @Override
    public boolean verify(JComponent input) {
        JTextField component = (JTextField) input;
        String text = component.getText();
        
        try {
            Double.parseDouble(text);
            if (Double.parseDouble(text) < 0.1 || Double.parseDouble(text) > 6) {
                component.setBackground(new Color(255, 90, 90));
                button.setEnabled(false);
                showMessageDialog(null, "Length must be between 0.1 and 6 meters");
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
