/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

/**
 * PipeOrder.java
 * Purpose: To store the quantity and pipe of an order.
 * 
 * @author up789464
 * @version 1.0 04/12/17
 */
public class PipeOrder {
    
    private int quantity;
    private BasePipe pipe;
    
    /**
     * Empty Constructor for class.
     */
    public PipeOrder() {}

    /**
     * Constructor for class.
     * 
     * @param quantity      The quantity of the order
     * @param pipe          The pipe of the order
     */
    public PipeOrder(int quantity, BasePipe pipe) {
        this.quantity = quantity;
        this.pipe = pipe;
    }

    public BasePipe getPipe() {return this.pipe;}
    public void setPipe(BasePipe pipe) {this.pipe = pipe;}
    public int getQuantity() {return this.quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    /**
     * Formats information about the PipeOrder as a String.
     * 
     * @return              A String of the Pipe Order quantity followed by the details of the BasePipe
     */
    @Override
    public String toString() {
        return String.format("%1$s - %2$s", this.quantity, this.pipe.getDetails());
    }
    
}
