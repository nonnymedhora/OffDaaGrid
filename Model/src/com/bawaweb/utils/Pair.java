/**
 * @author Nonny Medhora
 */
package com.bawaweb.utils;
 
/**
 * Utility data structure that comprises of a 'pair'
 * Note this class has been changed to a generic pair -- was previously for integers
 */
 public class Pair<E, F> {
     /** The first element in the pair **/
         private E x;
     /** The second element  in the pair **/
         private F y;
         
         public Pair(E x1, F y1) {
             super();
             this.x = x1;
             this.y = y1;
     }
         
     public String toString() {
         return "x is |" + this.x + "| and y is |" + this.y + "|";
     }
 
     public boolean equals(Object a) {
         if ( a == null ) { System.out.println("NULLLLLLLL PAIR?$@^@$@"); return false; }
         if ( this == a )  { System.out.println("IS A pair and == "); return true; }
         if ( ! ( a instanceof Pair ) ) { System.out.println("Not a pair"); return false; }
         if ( a instanceof Pair ) {  System.out.println("ISa pair"); 
             Pair other = (Pair) a;
             return this.x.equals(other.getX()) && this.y.equals(other.getY());
         }
         System.out.println("NOT A PAIR");
         return false;
     }
     
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
     
     public int hashCode() {
        
         return  7 * this.x.hashCode() +  3 * this.y.hashCode() - 47;
     }
     
 }