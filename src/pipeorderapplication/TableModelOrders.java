/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author up789464
 */
public class TableModelOrders extends AbstractTableModel {
    
    private PipeOrderManager pipeOrderManager;
    private String[] columns;
    
    public TableModelOrders(PipeOrderManager pipeOrderManager) {
        super();
        this.pipeOrderManager = pipeOrderManager;
        this.columns = new String[]{"Quantity", "Length", "Diameter", "Plastic Grade", "Colours", "Insulation", "Reinforcement", "Chemical Resistance", "Total Price"};
    }
    
    @Override
    public int getColumnCount() {
        return this.columns.length;
    }
    
    @Override
    public int getRowCount() {
        return pipeOrderManager.getOrders().size();
    }
    
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }
    
    public PipeOrder getOrderAtRow(int row) {
        return pipeOrderManager.getOrders().get(row);
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        PipeOrder order = this.pipeOrderManager.getOrders().get(row);
        BasePipe pipe = order.getPipe();
        if (column == 0)
            return order.getQuantity();
        else if (column == 2)
            return ((double) pipe.getDetails().get(1)) * 2;
        else if (column < 8)
            return pipe.getDetails().get(column - 1);
        else if (column == 8)
            return order.getQuantity() * pipe.calculatePrice();
        else
            return null;
    }
    
}
