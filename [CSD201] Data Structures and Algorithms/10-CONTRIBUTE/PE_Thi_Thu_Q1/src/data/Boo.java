/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Trung.Hoang
 */

// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
public class Boo{
  String forest;
  int rate,sound;
  Boo() {
   }
  Boo(String xForest, int xRate, int xSound){
    forest=xForest;rate=xRate; sound=xSound;
   }
  public String toString(){
    return("(" +forest+","+rate + "," + sound + ")");
   }
 }

