public class Main {
    public static void main(String[] args) {
     MyHashTable m = new MyHashTable();
     int [] a = {2,4,12,21,7,9,0,72,11,17,22};
     for(int x: a) m.add(x);
     m.traversal();
    }
}
