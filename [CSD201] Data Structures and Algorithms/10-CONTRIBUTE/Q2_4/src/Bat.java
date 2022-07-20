// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Bat {
  String owner;
  int price,color;
  Bat() {
   }
  Bat(String xOwner, int xPrice, int xColor){
    owner=xOwner;price=xPrice; color=xColor;
   }
  public String toString(){
    return("(" +owner+","+price + "," + color + ")");
   }
 }
