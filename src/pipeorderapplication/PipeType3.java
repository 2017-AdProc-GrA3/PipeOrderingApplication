/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

/**
 *
 * @author up789464
 */
public class PipeType3 extends BasePipe {
    
    public PipeType3() {
        this.gradeLowerBound = 2;
        this.gradeUpperBound = 5;
        this.colorPrint = 2;
        this.innerInsulation = false;
        this.outerReinforcement = false;
    }
    
    public PipeType3(int plasticGrade, boolean chemicalResistance, double length, double radius) {
        this();
        this.plasticGrade = plasticGrade;
        this.chemicalResistance = chemicalResistance;
        this.length = length;
        this.radius = radius;
    }
    
    @Override
    protected double calculatePrice() {
        double priceMultiplier = 1;
        priceMultiplier += this.chemicalResistance ? 0.14 : 0;
        priceMultiplier += 0.16;  // add additional color cost (2 colors -> 16%)
        return super.calculatePrice() * priceMultiplier;
    }

}