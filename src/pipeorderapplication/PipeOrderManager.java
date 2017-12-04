/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.util.*;

/**
 * PipeOrderManager.java
 * Purpose: To store all PipeOrders that are placed.
 * 
 * @author up789464
 * @version 1.0 04/12/17
 */
public class PipeOrderManager {
    
    private ArrayList<PipeOrder> pipeOrders = new ArrayList<>();
    
    /**
     * Empty Constructor for class.
     */
    public PipeOrderManager() {}

    public ArrayList<PipeOrder> getOrders() {return this.pipeOrders;}

    /**
     * Adds an order to the order list if it doesn't already exist. If it already exists then it increases the quantity of the existing order.
     * 
     * @param newOrder      A PipeOrder to add to the order list
     */
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

    /**
     * Removes an order from the list by index.
     * 
     * @param index     The index of PipeOrder to remove
     */
    public void removeOrder(int index) {
        this.pipeOrders.remove(index);
    }

    /**
     * Removes an order from the list by PipeOrder.
     * 
     * @param order     The PipeOrder to remove 
    */
    public void removeOrder(PipeOrder order) {
        this.pipeOrders.remove(order);
    }
    
    /**
     * Clears the PipeOrder list.
     */
    public void removeAllOrders() {
        this.pipeOrders.clear();
    }
    
}
