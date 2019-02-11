/**
 * @author Nonny Medhora
 */
package com.bawaweb.utils;

import java.util.HashMap;
import java.util.Map;
/**
 * Utility data structure that represents a 'triplet'
 * Note this class has been changed to a generic triplet -- was previously for integers
 */
 public class Triplet<E, F, G> {
 
         /** The first element in the triplet **/
         private E x;
         /** The second element in the triplet **/
         private F y;
         /** The third element in the triplet **/
         private G z;
         
         public Triplet(E x1, F y1, G z1) {
         super();
         this.x = x1;
         this.y = y1;
                 this.z = z1;
     }
         
         public String toString() {
         return "x is |" + this.x + "| and y is |" + this.y + "|" + " and z is |" + this.z + "|" ;
     }
     
         public boolean equals(Object a) {
             if ( a == null ) { System.out.println("NULLLLLLLL Triplet?$@^@$@"); return false; }
             if ( this == a )  { System.out.println("IS A Triplet and == "); return true; }
             if ( ! ( a instanceof Triplet ) ) { System.out.println("Not a Triplet"); return false; }
             if ( a instanceof Triplet ) {  System.out.println("ISa Triplet"); 
                 Triplet other = (Triplet) a;
                 return this.x.equals(other.getX()) && this.y.equals(other.getY()) && this.z.equals(other.getZ());
             }
             System.out.println("NOT A Triplet");
             return false;
         }
     
 /*
     public int compareTo(Integer o) {
         return 0;
     }
 */
     public void setX(E x) {
         this.x = x;
     }

     public E getX() {
         return this.x;
     }

     public void setY(F y) {
         this.y = y;
     }

     public F getY() {
         return this.y;
     }

     public void setZ(G z) {
         this.z = z;
     }

     public G getZ() {
         return this.z;
     }
     
     public int hashCode() {
         return  7 * this.x.hashCode() +  3 * this.y.hashCode() + 14 * this.z.hashCode() - 47;
     }
         
 }