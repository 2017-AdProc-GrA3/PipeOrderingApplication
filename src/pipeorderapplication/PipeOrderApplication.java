/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeorderapplication;

import java.util.*;

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
                if (pipeType instanceof PipeType1)
                    createdPipes.add(new PipeType1(1.5, 3, 3, false));
                else if (pipeType instanceof PipeType2)
                    createdPipes.add(new PipeType2(1.5, 3, 3, false));
                else if (pipeType instanceof PipeType3)
                    createdPipes.add(new PipeType3(1.5, 3, 3, false));
                else if (pipeType instanceof PipeType4)
                    createdPipes.add(new PipeType4(1.5, 3, 3, false));
                else if (pipeType instanceof PipeType5)
                    createdPipes.add(new PipeType5(1.5, 3, 3, false));
            }
        }
        if (createdPipes.isEmpty())
            System.out.println("No pipe found for values");
        else
            createdPipes.stream().forEach(p -> p.printInfo());
    }
    
}
