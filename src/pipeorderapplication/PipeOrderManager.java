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
    
    private final ArrayList<BasePipe> pipeTypes = new ArrayList<>();
    private final ArrayList<PipeOrder> pipeOrders = new ArrayList<>();
    
    public PipeOrderManager() {
        this.pipeTypes.add(new PipeType1());
        this.pipeTypes.add(new PipeType2());
        this.pipeTypes.add(new PipeType3());
        this.pipeTypes.add(new PipeType4());
        this.pipeTypes.add(new PipeType5());
    }
    
    public ArrayList<PipeOrder> getPipeOrders() {return pipeOrders;}
    
    public boolean createPipe(ArrayList<Object> inputs) {
        double length = (Double) inputs.get(0);
        double radius = (Double) inputs.get(1);
        int plasticGrade = (int) inputs.get(2);
        int colorPrint = (int) inputs.get(3);
        boolean innerInsulation = (boolean) inputs.get(4);
        boolean outerReinforcement = (boolean) inputs.get(5);
        boolean chemicalResistance = (boolean) inputs.get(6);
        int quantity = (int) inputs.get(7);
        return createPipe(length, radius, plasticGrade, colorPrint, innerInsulation, outerReinforcement, chemicalResistance, quantity);
    }
    
    public boolean createPipe(double length, double radius, int plasticGrade, int colorPrint, boolean innerInsulation, boolean outerReinforcement, boolean chemicalResistance, int quantity) {
        int currentPipeCount = pipeOrders.size();
        for (BasePipe pipeType : pipeTypes) {
            if (pipeType.isCreatable(plasticGrade, colorPrint, innerInsulation, outerReinforcement)) {
                if (pipeType instanceof PipeType1)
                    addPipeToOrders(new PipeOrder(quantity, new PipeType1(length, radius, plasticGrade, chemicalResistance)));
                else if (pipeType instanceof PipeType2)
                    addPipeToOrders(new PipeOrder(quantity, new PipeType2(length, radius, plasticGrade, chemicalResistance)));
                else if (pipeType instanceof PipeType3)
                    addPipeToOrders(new PipeOrder(quantity, new PipeType3(length, radius, plasticGrade, chemicalResistance)));
                else if (pipeType instanceof PipeType4)
                    addPipeToOrders(new PipeOrder(quantity, new PipeType4(length, radius, plasticGrade, chemicalResistance)));
                else if (pipeType instanceof PipeType5)
                    addPipeToOrders(new PipeOrder(quantity, new PipeType5(length, radius, plasticGrade, chemicalResistance)));
            }
        }
        return pipeOrders.size() != currentPipeCount;
    }
    
    public void clearCreatedPipes() {
        pipeOrders.clear();
    }
    
    private void addPipeToOrders(PipeOrder newOrder) {
        boolean added = false;
        for (PipeOrder order : pipeOrders) {
            added = order.addPipe(newOrder.getPipe());
        }
    }
}
