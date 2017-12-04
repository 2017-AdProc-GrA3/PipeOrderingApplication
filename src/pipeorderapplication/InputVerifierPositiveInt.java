/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author up789464
 */
public class InputVerifierPositiveInt extends InputVerifier {
    
    private JButton button;
    
    public InputVerifierPositiveInt(JButton button) {
        super();
        this.button = button;
    }
    
    @Override
    public boolean verify(JComponent input) {
        JTextField component = (JTextField) input;
        String text = component.getText();
        try {
            Integer.parseInt(text);
            if (Integer.parseInt(text) <= 0) {
                component.setBackground(new Color(255, 90, 90));
                button.setEnabled(false);
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