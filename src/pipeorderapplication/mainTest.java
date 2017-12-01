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
public class mainTest {
    public static void main(String[] args) {
        Class[] pipes = {PipeType1.class, PipeType2.class, PipeType3.class, PipeType4.class, PipeType5.class};
        
        BasePipe pipe = null;
        for (Class type : pipes) {
            pipe = BasePipe.canCreate(type, 3, 2, false, false, 10, 10);
            if (pipe != null)
                break;
        }
        if (pipe != null)
            pipe.printInfo();
        else
            System.out.println("No pipe found for values");
    }
}
