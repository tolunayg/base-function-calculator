/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functioncalculator;

/**
 *
 * @author TolunayGedikoðlu
 */
public class Demo {
    
    public static void main(String[] args) {
		
        BaseFunctionCalculator myCalculator = new BaseFunctionCalculator();
        myCalculator.setCacheSize(3);
        myCalculator.printCache();

        System.out.println("n=5: \t" + myCalculator.calculate(5));
        myCalculator.printCache();

        System.out.println("n=20: \t" + myCalculator.calculate(20));
        myCalculator.printCache();

        System.out.println("n=10: \t" + myCalculator.calculate(10));
        myCalculator.printCache();

        System.out.println("n=5: \t" + myCalculator.calculate(5));
        myCalculator.printCache();

        System.out.println("n=5: \t" + myCalculator.calculate(5));
        myCalculator.printCache();

        System.out.println("n=5: \t" + myCalculator.calculate(5));
        myCalculator.printCache();

        System.out.println("n=2: \t" + myCalculator.calculate(2));
        myCalculator.printCache();

        System.out.println("n=3: \t" + myCalculator.calculate(3));
        myCalculator.printCache();

        System.out.println("Cache element=0: " + myCalculator.getCacheElement(0));
        System.out.println("Cache element=1: " + myCalculator.getCacheElement(1));
        System.out.println("Cache element=2: " + myCalculator.getCacheElement(2));
        System.out.println("Cache element=3: " + myCalculator.getCacheElement(3));
    }
}
