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
public class PipeType5 extends BasePipe {
    
    private final int[] acceptedGrades = new int[]{3,4,5};
    private final int acceptedColorPrints = 2;
    private final boolean acceptedInnerInsulation = true;
    private final boolean acceptedOuterReinforcement = true;
    
    public PipeType5() {
        super();
    }
    
    public PipeType5(double length, double radius, int plasticGrade, boolean chemicalResistance) {
        super(length, radius, plasticGrade, chemicalResistance);
        this.colorPrint = acceptedColorPrints;
        this.innerInsulation = acceptedInnerInsulation;
        this.outerReinforcement = acceptedOuterReinforcement;
    }
    
    @Override
    public boolean isCreatable(int desiredPlasticGrade, int desiredColorPrint, boolean desiredInnerInsulation, boolean desiredOuterReinforcement) {
        boolean plasticGradeMatch = Arrays.stream(this.acceptedGrades).anyMatch(i -> i == desiredPlasticGrade);
        boolean colorPrintMatch = desiredColorPrint == this.acceptedColorPrints;
        boolean innerInsulationMatch = desiredInnerInsulation == this.acceptedInnerInsulation;
        boolean outerReinforcementMatch = desiredOuterReinforcement == this.acceptedOuterReinforcement;
        return plasticGradeMatch && colorPrintMatch && innerInsulationMatch && outerReinforcementMatch;
    }
    
    @Override
    protected double calculatePrice() {
        double priceMultiplier = (this.chemicalResistance) ? 1.14 : 1;
        priceMultiplier += 0.16;  // add additional color cost (2 colors -> 16%)
        priceMultiplier += 0.13;  // add additional inner insulation cost (13%)
        priceMultiplier += 0.17;  // add additional outer reinforcement cost (
        return super.calculatePrice() * priceMultiplier;
    }

}

