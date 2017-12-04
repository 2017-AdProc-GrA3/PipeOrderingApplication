/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

/**
 * PipeType3.java
 * Purpose: Third Pipe Type.
 * 
 * @author up789464
 * @version 2.0 04/12/17
 */
public class PipeType3 extends BasePipe {
    
    /**
     * Constructor for class. Sets values for the pipe type.
     */
    public PipeType3() {
        super();
        this.gradeLowerBound = 2;
        this.gradeUpperBound = 5;
        this.colorPrint = 2;
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
    public PipeType3(int plasticGrade, boolean chemicalResistance, double length, double radius) {
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
        priceMultiplier += 0.16;  // add additional color cost (2 colors -> 16%)
        return super.calculatePrice() * priceMultiplier;
    }

}