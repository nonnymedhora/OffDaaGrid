/**
 * @author Nonny Medhora
 */
package com.bawaweb.utils;

import java.util.HashMap;
import java.util.Map;

public class PairTest {
    public PairTest() {
    }
    
    public static void main(String[] args) {
        Map<Pair,Pair> mp_existingRpsQstToSraRavMap = new HashMap<Pair, Pair>();
        for ( int i = 0; i < 20; i++) {
            Pair ap = new Pair(i, i+1);
            Pair bp = new Pair(i-1, i-2);
            mp_existingRpsQstToSraRavMap.put(ap, bp);
        }
        
        System.out.println(mp_existingRpsQstToSraRavMap.containsKey(new Pair(7,8)));
        
    }
}
