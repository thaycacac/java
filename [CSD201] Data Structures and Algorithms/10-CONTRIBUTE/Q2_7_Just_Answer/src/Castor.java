// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Castor {
  String place;
  int depth,type;
  Castor() {
   }
  Castor(String xPlace, int xDepth, int xType){
    place=xPlace;depth=xDepth; type=xType;
   }
  public String toString(){
    return("(" +place+","+depth + "," + type + ")");
   }
 }
