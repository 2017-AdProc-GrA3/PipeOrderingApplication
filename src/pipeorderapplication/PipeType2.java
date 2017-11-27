/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.util.Arrays;

/**
 *
 * @author up789464
 */
public class PipeType2 extends BasePipe {
    
    private final int[] acceptedGrades = new int[]{2,3,4};
    private final int acceptedColorPrint = 1;
    private final boolean acceptedInnerInsulation = false;
    private final boolean acceptedOuterReinforcement = false;
    
    public PipeType2() {
        super();
    }
    
    public PipeType2(double length, double radius, int plasticGrade, boolean chemicalResistance) {
        super(length, radius, plasticGrade, chemicalResistance);
        this.colorPrint = acceptedColorPrint;
        this.innerInsulation = acceptedInnerInsulation;
        this.outerReinforcement = acceptedOuterReinforcement;
    }
    
    @Override
    public boolean isCreatable(int desiredPlasticGrade, int desiredColorPrint, boolean desiredInnerInsulation, boolean desiredOuterReinforcement) {
        boolean plasticGradeMatch = Arrays.stream(this.acceptedGrades).anyMatch(i -> i == desiredPlasticGrade);
        boolean colorPrintMatch = desiredColorPrint == this.acceptedColorPrint;
        boolean innerInsulationMatch = desiredInnerInsulation == this.acceptedInnerInsulation;
        boolean outerReinforcementMatch = desiredOuterReinforcement == this.acceptedOuterReinforcement;
        return plasticGradeMatch && colorPrintMatch && innerInsulationMatch && outerReinforcementMatch;
    }
    
    @Override
    protected double calculatePrice() {
        double priceMultiplier = (this.chemicalResistance) ? 1.14 : 1;
        priceMultiplier += 0.12;  // add additional color cost (1 color -> 12%)
        return super.calculatePrice() * priceMultiplier;
    }
    
    @Override
    public void printInfo() {
        System.out.println("PipeType: 2");
        System.out.format("Length: %1$s\n", this.length);
        System.out.format("Radius: %1$s\n", this.radius);
        System.out.format("Plastic Grade: %1$s\n", this.plasticGrade);
        System.out.format("Color Print: %1$s\n", this.colorPrint);
        System.out.format("Inner Insulation: %1$s\n", this.innerInsulation);
        System.out.format("Outer Reinforcement: %1$s\n", this.outerReinforcement);
        System.out.format("Chemical Resistance: %1$s\n", this.chemicalResistance);
        System.out.format("Price (£): %1$s\n", calculatePrice());
    }

}