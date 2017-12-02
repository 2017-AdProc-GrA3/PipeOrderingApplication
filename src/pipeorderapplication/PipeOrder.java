/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

/**
 *
 * @author up789464
 */
public class PipeOrder {
    
    private int quantity;
    private BasePipe pipe;
    
    public PipeOrder() {}
    
    public PipeOrder(int quantity, BasePipe pipe) {
        this.quantity = quantity;
        this.pipe = pipe;
    }
    
    public BasePipe getPipe() {return this.pipe;}
    public void setPipe(BasePipe pipe) {this.pipe = pipe;}
    public int getQuantity() {return this.quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    
    @Override
    public String toString() {
        return String.format("%1$s - %2$s", this.quantity, this.pipe.getDetails());
    }
}
