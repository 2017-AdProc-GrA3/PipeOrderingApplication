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
public class PipeType5 extends BasePipe {
    
    public PipeType5() {
        this.gradeLowerBound = 3;
        this.gradeUpperBound = 5;
        this.colorPrint = 2;
        this.innerInsulation = true;
        this.outerReinforcement = true;
    }
    
    public PipeType5(int pg, double len, double rad) {
        this();
        this.plasticGrade = pg;
        this.length = len;
        this.radius = rad;
    }
    
    @Override
    protected double calculatePrice() {
        double priceMultiplier = 1;
        priceMultiplier += this.chemicalResistance ? 0.14 : 0;
        priceMultiplier += 0.16;  // add additional color cost (2 colors -> 16%)
        priceMultiplier += 0.13;  // add additional inner insulation cost (13%)
        priceMultiplier += 0.17;  // add additional outer reinforcement cost (17%)
        return super.calculatePrice() * priceMultiplier;
    }

}

