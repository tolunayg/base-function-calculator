/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functioncalculator;

import java.util.LinkedList;

/**
 * BaseFunctionCalculator --- program to calculate the mathematical function
 *                            [sum of (sin(i°)*i) values where 0<=i<=n]
 * @author TolunayGedikoðlu
 */
public class BaseFunctionCalculator {

    private class KeyValuePair {
        int n;
        double value;

        public KeyValuePair(int n, double val) {
            this.n = n;
            this.value = val;
        }

        public int getKey() {
            return n;
        }

        public double getValue() {
            return value;
        }
    }

    private LinkedList<KeyValuePair> cache; // stores the results for given values
    private int lastSearch;                 // stores latest searched value
    private int prefferedCacheSize;         // user defined cache size

    public BaseFunctionCalculator() {
        cache = new LinkedList<>();
        lastSearch = -1;
        prefferedCacheSize = 1;
    }

    /**
    * Sets the cache size
     * @param size  the integer indicating the preffered cache size
    */
    public void setCacheSize(int size) {
        this.prefferedCacheSize = size;
    }

    /**
    * Calculates the value of the function defined in assesment
     * @param n the integer n to be calculated on the function
     * @return  the result of the function with the given input
    */
    public double calculate(int n) {
        // Search n in cache
        double valueInCache = searchInCache(n);
        if (valueInCache != -1) {
            return valueInCache;
        }

        // n could not be found in cache, calculate it
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.sin(Math.toRadians(i)) * i;
        }
        addValueToCache(n, result);
        return result;
    }

    /**
    * Returns the key (n value) that is stored at index i of the cache
     * @param index the index of the desired element in cache
     * @return      the key value of the specified element
    */
    public int getCacheElement(int index) {		
        if (cache.size() <= index)
            return -1;

        return cache.get(index).getKey();
    }

    /**
    * Prints all the keys that are stored in the cache
    */
    public void printCache() {
        String cacheString = "";
        for (int i = 0; i < prefferedCacheSize; i++) {
            // If cache actually has a value at index i, print it. If not, print hyphen ("-")
            cacheString += (i < cache.size()) ? cache.get(i).getKey() : "-";

            // Insert comma (",") between values if it is not the last value
            cacheString += (i != prefferedCacheSize-1) ? ", " : "";
        }
        System.out.println(cacheString + "\n");
    }

    // Inserts the value to cache
    private void addValueToCache(int n, double result) {
        // Check size of cache (linkedList) before adding new element. 
        // Remove last element if it has the same value with the user defined cache size.
        // Therefore actual cache size will never exceed the user defined size.
        if (cache.size() == prefferedCacheSize) {
            cache.removeLast();
        }
        cache.addFirst(new KeyValuePair(n, result));
    }

    // Returns the value of function with given n parameter, or -1 if cache does not contain the element
    private double searchInCache(int n) {
        for (int i=0; i<cache.size(); i++) {

            // The key n is found
            if (cache.get(i).getKey() == n) {

                // Priority is increased if the same value is searched again
                if (lastSearch == n) {
                        increasePriority(i);
                }
                lastSearch = n;
                return cache.get(i).getValue();
            }
        }
        return -1;
    }

    // Increases the priority of the element specified in the specified index
    private void increasePriority(int i) {
        /**
        * Used linked list to make a cache mechanism. 
        * The first element in the list has the highest priority,
        * last element has the lowest.
        *        
        * Priority cannot be higher than 0, it should only be increased 
        * when index of the given "n" is not 0.
        */
        if (i != 0) {
            KeyValuePair toBeIncreased = cache.get(i);
            KeyValuePair toBeDecreased = cache.get(i-1);
            cache.set(i-1, toBeIncreased);
            cache.set(i, toBeDecreased);
        }
    }
}
