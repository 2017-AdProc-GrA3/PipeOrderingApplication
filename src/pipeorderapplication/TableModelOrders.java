/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import javax.swing.table.AbstractTableModel;
import java.text.*;

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
        switch (column) {
            case 0:
                return order.getQuantity();
            case 2:
                return (double) pipe.getDetails().get(1) * 2;
            case 5:
            case 6:
            case 7:
                return (boolean) (pipe.getDetails().get(column - 1)) ? "Yes" : "No";
            case 8:
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                return formatter.format(order.getQuantity() * pipe.calculatePrice());
            default:
                return pipe.getDetails().get(column - 1);
        }
    }
    
}
