/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

/**
 * PipeType2.java
 * Purpose: Second Pipe Type.
 * 
 * @author up789464
 * @version 2.0 04/12/17
 */
public class PipeType2 extends BasePipe {
    
    /**
     * Constructor for class. Sets values for the pipe type.
     */
    public PipeType2() {
        super();
        this.gradeLowerBound = 2;
        this.gradeUpperBound = 4;
        this.colorPrint = 1;
        this.innerInsulation = false;
        this.outerReinforcement = false;
    }
    
    
    /**
     * Constructor for class. Sets values for pipe.
     * 
     * @param plasticGrade          The grade of plastic for the pipe as an integer
     * @param chemicalResistance    Whether the pipe should have chemical resistance
     * @param length                The length of the pipe as a double
     * @param radius                The radius of the pipe as a double
     */
    public PipeType2(int plasticGrade, boolean chemicalResistance, double length, double radius) {
        this();
        this.plasticGrade = plasticGrade;
        this.chemicalResistance = chemicalResistance;
        this.length = length;
        this.radius = radius;
    }
    
    /**
     * Calculates the price of the pipe.
     * 
     * @return      The price of the pipe as a double
     */
    @Override
    protected double calculatePrice() {
        double priceMultiplier = 1;
        priceMultiplier += this.chemicalResistance ? 0.14 : 0;
        priceMultiplier += 0.12;  // add additional color cost (1 color -> 12%)
        return super.calculatePrice() * priceMultiplier;
    }

}