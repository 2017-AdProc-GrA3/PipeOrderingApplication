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
public class PipeType1 extends BasePipe {
    
    public PipeType1() {
        this.gradeLowerBound = 1;
        this.gradeUpperBound = 3;
        this.colorPrint = 0;
        this.innerInsulation = false;
        this.outerReinforcement = false;
    }
    
    public PipeType1(int pg, double len, double rad) {
        this();
        this.plasticGrade = pg;
        this.length = len;
        this.radius = rad;
    }
    
    @Override
    protected double calculatePrice() {
        double priceMultiplier = 1;
        priceMultiplier += this.chemicalResistance ? 0.14 : 0;
        return super.calculatePrice() * priceMultiplier;
    }
    
}
