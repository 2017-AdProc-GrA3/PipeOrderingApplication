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
public class PipeType2 extends BasePipe {
    
    public PipeType2() {
        this.gradeLowerBound = 2;
        this.gradeUpperBound = 4;
        this.colorPrint = 1;
        this.innerInsulation = false;
        this.outerReinforcement = false;
    }
    
    public PipeType2(int plasticGrade, boolean chemicalResistance, double length, double radius) {
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
        priceMultiplier += 0.12;  // add additional color cost (1 color -> 12%)
        return super.calculatePrice() * priceMultiplier;
    }

}