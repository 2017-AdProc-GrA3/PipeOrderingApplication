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
    
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public BasePipe getPipe() {return pipe;}
    public void setPipe(BasePipe pipe) {this.pipe = pipe;}
    
    public boolean addPipe(BasePipe pipe) {
        if (this.pipe.getInfo() == pipe.getInfo()) {
            quantity += 1;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("%1$s - %2$s", quantity, pipe);
    }
}
