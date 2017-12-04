/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import javax.swing.table.AbstractTableModel;
import java.text.*;

/**
 * TableModelOrders.java
 * Purpose: A TabelModel for formatting data from a PipeOrderManager into a table.
 * 
 * @author up789464
 * @version 1.0 04/12/17
 */
public class TableModelOrders extends AbstractTableModel {
    
    private PipeOrderManager pipeOrderManager;
    private final String[] columns = new String[]{"Quantity", "Length", "Diameter", "Plastic Grade", "Colours", "Insulation", "Reinforcement", "Chemical Resistance", "Total Price"};
    
    /**
     * Constructor for the table model. Sets the PipeOrderManager.
     * 
     * @param pipeOrderManager      The PipeOrderManager to use for the data.
     */
    public TableModelOrders(PipeOrderManager pipeOrderManager) {
        super();
        this.pipeOrderManager = pipeOrderManager;
    }
    
    /**
     * Gets the count of columns in the table model.
     * 
     * @return      An integer representation of the column count
     */
    @Override
    public int getColumnCount() {
        return this.columns.length;
    }
    
    /**
     * Gets the count of rows in the table model.
     * 
     * @return      An integer representation of the row count
     */
    @Override
    public int getRowCount() {
        return pipeOrderManager.getOrders().size();
    }
    
    /**
     * Gets the column name from index of column.
     * 
     * @param index     The index of column to retrieve the name of
     * @return          A String representation of the columns name
     */
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }
    
    /**
     * Retrieves the PipeOrder for the given row index.
     * 
     * @param row       The index of PipeOrder to retrieve from the PipeManager
     * @return          The PipeOrder for the given index
     */
    public PipeOrder getOrderAtRow(int row) {
        return pipeOrderManager.getOrders().get(row);
    }
    
    /**
     * Gets the value for the current row/column.
     * 
     * @param row       The row index to retrieve the value of
     * @param column    The column index to retrieve the value of
     * @return          The Object value for the given row/column
     */
    @Override
    public Object getValueAt(int row, int column) {
        PipeOrder order = this.pipeOrderManager.getOrders().get(row);
        BasePipe pipe = order.getPipe();
        
        switch (column) {
            case 0:
                return order.getQuantity();
            case 2:
                return (double) pipe.getDetails().get(1) * 2;
            case 5: case 6: case 7:
                return (boolean) (pipe.getDetails().get(column - 1)) ? "Yes" : "No";
            case 8:
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                return formatter.format(order.getQuantity() * pipe.calculatePrice());
            default:
                return pipe.getDetails().get(column - 1);
        }
    }
    
}
