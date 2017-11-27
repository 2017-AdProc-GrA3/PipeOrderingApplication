/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.util.*;
import java.lang.reflect.*;

/**
 *
 * @author up789464
 */
public class PipeOrderApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<BasePipe> pipeTypes = new ArrayList<>();
        pipeTypes.add(new PipeType1());
        pipeTypes.add(new PipeType2());
        pipeTypes.add(new PipeType3());
        pipeTypes.add(new PipeType4());
        pipeTypes.add(new PipeType5());
        
        ArrayList<BasePipe> createdPipes = new ArrayList<>();
        for (BasePipe pipeType : pipeTypes) {
            if (pipeType.isCreatable(3, 1, false, false)) {
                if (pipeType instanceof PipeType1) {PipeType1 pipe = new PipeType1(10, 3, 3, false); pipe.printInfo();}
                else if (pipeType instanceof PipeType2) {PipeType2 pipe = new PipeType2(10, 3, 3, false); pipe.printInfo();}
                else if (pipeType instanceof PipeType3) {PipeType3 pipe = new PipeType3(10, 3, 3, false); pipe.printInfo();}
                else if (pipeType instanceof PipeType4) {PipeType4 pipe = new PipeType4(10, 3, 3, false); pipe.printInfo();}
                else if (pipeType instanceof PipeType5) {PipeType5 pipe = new PipeType5(10, 3, 3, false); pipe.printInfo();}
                /*
                try {
                    Class<?> typeOfPipe = pipeType.getClass();
                    Constructor<?> cons = typeOfPipe.getConstructor(double.class, double.class, int.class, boolean.class);
                    Object obj = cons.newInstance(10, 3, 3, false);
                    obj.printInfo() // ERRORS Object doesnt have method printInfo
                } 
                catch(Exception e) {
                    System.err.println(e);
                }
                */
            }
        }
    }
    
}
