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
    public void printInfo() {
        System.out.println("PipeType: 2");
        System.out.format("Length: %1$s\n", length);
        System.out.format("Radius: %1$s\n", radius);
        System.out.format("Plastic Grade: %1$s\n", plasticGrade);
        System.out.format("Color Print: %1$s\n", colorPrint);
        System.out.format("Inner Insulation: %1$s\n", innerInsulation);
        System.out.format("Outer Reinforcement: %1$s\n", outerReinforcement);
        System.out.format("Chemical Resistance: %1$s\n", chemicalResistance);
        System.out.format("Price (£): %1$s\n", calculatePrice());
    }
    
    @Override
    public boolean isCreatable(int desiredPlasticGrade, int desiredColorPrint, boolean desiredInnerInsulation, boolean desiredOuterReinforcement) {
        boolean plasticGradeMatch = Arrays.stream(acceptedGrades).anyMatch(i -> i == desiredPlasticGrade);
        boolean colorPrintMatch = desiredColorPrint == acceptedColorPrint;
        boolean innerInsulationMatch = desiredInnerInsulation == acceptedInnerInsulation;
        boolean outerReinforcementMatch = desiredOuterReinforcement == acceptedOuterReinforcement;
        return plasticGradeMatch && colorPrintMatch && innerInsulationMatch && outerReinforcementMatch;
    }
    
    @Override
    protected double calculatePrice() {
        double priceMultiplier = 1;
        priceMultiplier += chemicalResistance ? 0.14 : 0;
        priceMultiplier += 0.12;  // add additional color cost (1 color -> 12%)
        return super.calculatePrice() * priceMultiplier;
    }

}