/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Boo info;
  Node next;
  Node() {
   }
  Node(Boo x, Node p) {
    info=x;next=p;
   }
  Node(Boo x) {
    this(x,null);
   }
 }


