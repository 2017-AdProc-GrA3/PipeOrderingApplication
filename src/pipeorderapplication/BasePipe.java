/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.util.*;
import java.lang.reflect.Constructor;

/**
 * BasePipe.java
 * Purpose: Base Class for all Pipe types.
 * 
 * @author up789464
 * @version 3.0 04/12/17
 */
public abstract class BasePipe {
    
    protected int plasticGrade, gradeUpperBound, gradeLowerBound, colorPrint;
    protected boolean innerInsulation, outerReinforcement, chemicalResistance;
    protected double length, radius;
    
    /**
     * Empty Constructor for class.
     */
    public BasePipe() {}

    /**
     * Create a pipe of class given, returns null if pipe cannot be created.
     * 
     * @param <T>                   The subclass of BasePipe to create
     * @param pipeType              The class type of pipe to attempt to create
     * @param plasticGrade          The plastic grade for the pipe as an integer
     * @param colorPrint            The colour print for the pipe as an integer
     * @param innerInsulation       Whether the pipe should have inner insulation
     * @param outerReinforcement    Whether the pipe should have outer reinforcement
     * @param chemicalResistance    Whether the pipe should have chemical resistance
     * @param length                The length of the pipe as a double
     * @param radius                The radius of the pipe as a double
     * @return                      A pipe object of the given class or null if the pipe cannot be created
     */
    public static <T extends BasePipe> T createPipe(Class<T> pipeType, int plasticGrade, int colorPrint, boolean innerInsulation, boolean outerReinforcement, boolean chemicalResistance, double length, double radius) {
        T pipe;
        try {
            Constructor<T> con = pipeType.getConstructor(int.class, boolean.class, double.class, double.class);
            pipe = con.newInstance(plasticGrade, chemicalResistance, length, radius);
            
            if (!pipe.isCreatable(plasticGrade, colorPrint, innerInsulation, outerReinforcement))
                pipe = null;
        }
        catch (Exception e) {
            return null;
        }
        return pipe;
    }

    /**
     * Checks whether a pipe can be created from the parameters.
     * 
     * @param plasticGrade          The int grade of plastic to be checked
     * @param colorPrint            The int colour value to check
     * @param innerInsulation       The boolean insulation value to check
     * @param outerReinforcement    The boolean reinforcement value to check
     * @return                      Boolean of whether the pipe can be created from the given parameters
     */
    public boolean isCreatable(int plasticGrade, int colorPrint, boolean innerInsulation, boolean outerReinforcement) {
        boolean plasticGradeMatch = plasticGrade >= this.gradeLowerBound && plasticGrade <= this.gradeUpperBound;
        boolean colorPrintMatch = this.colorPrint == colorPrint;
        boolean innerInsulationMatch = this.innerInsulation == innerInsulation;
        boolean outerReinforcementMatch = this.outerReinforcement == outerReinforcement;
        return plasticGradeMatch && colorPrintMatch && innerInsulationMatch && outerReinforcementMatch;
    }

    /**
     * Creates an arraylist of the Pipes attributes.
     * 
     * @return      An object arraylist of the pipes attributes
     */
    public ArrayList<Object> getDetails() {
        ArrayList<Object> details = new ArrayList<>();
        details.add(this.length);
        details.add(this.radius);
        details.add(this.plasticGrade);
        details.add(this.colorPrint);
        details.add(this.innerInsulation);
        details.add(this.outerReinforcement);
        details.add(this.chemicalResistance);
        return details;
    }

    /**
     * Prints information about the pipes attributes.
     */
    public void printInfo() {
        System.out.println(this.getClass().getSimpleName());
        System.out.format("Length: %1$s\n", this.length);
        System.out.format("Radius: %1$s\n", this.radius);
        System.out.format("Plastic Grade: %1$s\n", this.plasticGrade);
        System.out.format("Color Print: %1$s\n", this.colorPrint);
        System.out.format("Inner Insulation: %1$s\n", this.innerInsulation);
        System.out.format("Outer Reinforcement: %1$s\n", this.outerReinforcement);
        System.out.format("Chemical Resistance: %1$s\n", this.chemicalResistance);
        System.out.format("Price (£): %1$s\n", calculatePrice());
    }

    /**
     * Calculates the price of the pipe.
     * 
     * @return      The price of the pipe as a double
     */
    protected double calculatePrice() {
        double pipeVolume = metersToInches(this.length) * calculateCrossSectionalArea();
        double[] pricesPerInch = new double[]{0.4, 0.6, 0.75, 0.8, 0.95};
        return pipeVolume * pricesPerInch[this.plasticGrade - 1];
    }

    /**
     * Calculates the cross sectional area of the pipe.
     * 
     * @return      The cross sectional area of the pipe as a double
     */
    private double calculateCrossSectionalArea() {
        double outerRadius = this.radius;
        double innerRadius = outerRadius / 100 * 90;
        return Math.PI * (Math.pow(outerRadius, 2) - Math.pow(innerRadius, 2));
    }

    /**
     * Converts meters to inches
     * 
     * @param lengthMeters      The length of the pipe as a double
     * @return                  The length converted from meters to inches
     */
    private double metersToInches(double lengthMeters) {
        return lengthMeters * 39.37; 
    }
    
}
