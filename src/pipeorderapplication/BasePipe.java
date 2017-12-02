/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.util.*;
import java.lang.reflect.Constructor;

/**
 *
 * @author up789464
 */
public abstract class BasePipe {
    
    protected int plasticGrade, gradeUpperBound, gradeLowerBound, colorPrint;
    protected boolean innerInsulation, outerReinforcement, chemicalResistance;
    protected double length, radius;
    
    public static <T extends BasePipe> T canCreate(Class<T> pipe, int plasticGrade, int colorPrint, boolean innerInsulation, boolean outerReinforcement, boolean chemicalResistance, double length, double radius) {
        T instance = null;
        try {
            Constructor<T> con = pipe.getConstructor(int.class, boolean.class, double.class, double.class);
            instance = con.newInstance(plasticGrade, chemicalResistance, length, radius);
            
            if (!instance.isCreatable(plasticGrade, colorPrint, innerInsulation, outerReinforcement))
                instance = null;
        }
        catch (Exception e) {
            return null;
        }
        return instance;
    }
    
    public boolean isCreatable(int plasticGrade, int colorPrint, boolean innerInsulation, boolean outerReinforcement) {
        boolean plasticGradeMatch = plasticGrade >= this.gradeLowerBound && plasticGrade <= this.gradeUpperBound;
        boolean colorPrintMatch = this.colorPrint == colorPrint;
        boolean innerInsulationMatch = this.innerInsulation == innerInsulation;
        boolean outerReinforcementMatch = this.outerReinforcement == outerReinforcement;
        return plasticGradeMatch && colorPrintMatch && innerInsulationMatch && outerReinforcementMatch;
    }
    
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
    
    protected double calculatePrice() {
        double pipeVolume = metersToInches(this.length) * calculateCrossSectionalArea();
        double[] pricesPerInch = new double[]{0.4, 0.6, 0.75, 0.8, 0.95};
        return pipeVolume * pricesPerInch[this.plasticGrade - 1];
    }
    
    private double calculateCrossSectionalArea() {
        double outerRadius = this.radius;
        double innerRadius = outerRadius / 100 * 90;
        return Math.PI * (Math.pow(outerRadius, 2) - Math.pow(innerRadius, 2));
    }
    
    private double metersToInches(double lengthMeters) {
        return lengthMeters * 39.37; 
    }
    
}
