/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.util.*;

/**
 *
 * @author up789464
 */
public class PipeOrderManager {
    
    private ArrayList<PipeOrder> pipeOrders = new ArrayList<>();
    
    public PipeOrderManager() {}
    
    public ArrayList<PipeOrder> getOrders() {return this.pipeOrders;}
    
    public void addOrder(PipeOrder newOrder) {
        boolean orderExists = false;
        List<Object> newPipeDetails = newOrder.getPipe().getDetails();
        
        for (PipeOrder order : this.pipeOrders) {
            List<Object> pipeDetails = order.getPipe().getDetails();
            if (newPipeDetails.equals(pipeDetails)) {
                order.setQuantity(order.getQuantity() + newOrder.getQuantity());
                orderExists = true;
                break;
            }
        }
        if (!orderExists)
            this.pipeOrders.add(newOrder);
    }
    
    public void removeOrder(int index) {
        this.pipeOrders.remove(index);
    }
    
    public void removeOrder(PipeOrder order) {
        this.pipeOrders.remove(order);
    }
    
    public void removeAllOrders() {
        this.pipeOrders.clear();
    }
}
