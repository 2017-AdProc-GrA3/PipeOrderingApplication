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
public abstract class BasePipe {
    
    protected int plasticGrade, colorPrint;
    protected boolean innerInsulation, outerReinforcement, chemicalResistance;
    protected double length, radius;
    
    public BasePipe() {}
    
    public BasePipe(double length, double radius, int plasticGrade, boolean chemicalResistance) {
        this.length = length;
        this.radius = radius;
        this.plasticGrade = plasticGrade;
        this.chemicalResistance = chemicalResistance;
    }
    
    public BasePipe(double length, double radius, int plasticGrade, int colorPrint, boolean innerInsulation, boolean outerReinforcement, boolean chemicalResistance) {
        this.length = length;
        this.radius = radius;
        this.plasticGrade = plasticGrade;
        this.colorPrint = colorPrint;
        this.innerInsulation = innerInsulation;
        this.outerReinforcement = outerReinforcement;
        this.chemicalResistance = chemicalResistance;
    }
    
    public int getPlasticGrade() {return this.plasticGrade;}
    public int getColorPrint() {return this.colorPrint;}
    public boolean getInnerInsulation() {return this.innerInsulation;}
    public boolean getOuterReinforcement() {return this.outerReinforcement;}
    public boolean getChemicalResistance() {return this.chemicalResistance;}
    public double getLength() {return this.length;}
    public double getRadius() {return this.radius;}
    
    abstract void printInfo();
    
    protected boolean isCreatable(int desiredPlasticGrade, int desiredColorPrint, boolean desiredInnerInsulation, boolean desiredOuterReinforcement) {
        return true;
    };
    
    protected double calculatePrice() {
        double pipeVolume = metersToInches(this.length) * calculateCrossSectionalArea();
        double pricePerInchCubed = new double[]{0.4, 0.6, 0.75, 0.8, 0.95}[this.plasticGrade - 1];
        return pipeVolume * pricePerInchCubed;
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
