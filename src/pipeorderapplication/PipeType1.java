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
public class PipeType1 extends BasePipe {
    
    private final int[] acceptedGrades = new int[]{1,2,3};
    private final int acceptedColorPrints = 0;
    private final boolean acceptedInnerInsulation = false;
    private final boolean acceptedOuterReinforcement = false;
    
    public PipeType1() {
        super();
    }
    
    public PipeType1(double length, double radius, int plasticGrade, boolean chemicalResistance) {
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
        return super.calculatePrice() * priceMultiplier;
    }
    
    public void printInfo() {
        System.out.println(this.length);
        System.out.println(this.radius);
        System.out.println(this.plasticGrade);
        System.out.println(this.colorPrint);
        System.out.println(this.innerInsulation);
        System.out.println(this.outerReinforcement);
        System.out.println(this.chemicalResistance);
        System.out.println(calculatePrice());
    }
    
}
