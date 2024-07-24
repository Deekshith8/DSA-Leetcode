package DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class HashTable<K,V>{

    private LinkedList<HashNode>[]buckets ;

    private  int numOfBuckets ; //size of hashnode array

    private  int size;// no of value stored in array

    private ArrayList<K> keySet; // if you want you can add it as a method,this ,ay take o(n), but takes o(1) complexity

    public  HashTable(int noOfBuckets){
        this.numOfBuckets = noOfBuckets;

        buckets = new LinkedList[noOfBuckets];
        for(int i = 0;i< noOfBuckets ;i++){
            buckets[i]= new LinkedList<>();
        }

        keySet = new ArrayList<>();
    }

    class HashNode{

        private K key ;

        private V value ;//can be used a Generic  type

        private  HashNode next ;

        public HashNode(K key ,V value){
            this.key = key;
            this.value = value;

        }



    }

    public int  hashmethod(K key){
        int index = key.hashCode();
        return  Math.abs(index) % this.numOfBuckets;
    }


    public void rehashing(){

        LinkedList<HashNode>[] oldbuckets = this.buckets;

       this. buckets = new LinkedList[numOfBuckets*2];

        for(int i = 0;i< buckets.length ;i++){
            this.buckets[i] = new LinkedList<>();
        }

        for(int i = 0 ; i<oldbuckets.length ;i++){
            LinkedList<HashNode> list =  oldbuckets[i];
            for(int j = 0;j< list.size() ; j++){
                HashNode node = list.get(j);
                put( node.key,  node.value);
            }

        }




    }

    public void put(K key , V value){

        int index = hashmethod( key);

      if( this.buckets[index].isEmpty()){
          this.buckets[index].add(new HashNode(key , value));
          this.size++;
          this.keySet.add(key);
          return;
      }

      for(int i = 0 ; i< this.buckets[index].size() ;i++){
          HashNode current = this.buckets[index].get(i);
          if(current.key == key){
              current.value = value;
              return;
          }

      }
        this.buckets[index].add(new HashNode(key, value));
        this.size++;
        this.keySet.add(key);

        if( size / numOfBuckets > 2){

            rehashing();
        }

    }

    public V get(K key){
        int index = hashmethod(key);

        for(int i = 0 ;i< this.buckets[index].size() ;i++){
            HashNode node = this.buckets[index].get(i);

            if(node.key == key){
                return  node.value;
            }

        }
        return  null ;
    }

    public boolean containsKey(K key){
        int index = hashmethod(key);

        for(int i = 0 ;i< this.buckets[index].size() ;i++){
            HashNode node = this.buckets[index].get(i);

            if(node.key == key){
                return  true;
            }

        }

        return  false;
    }

    public V remove(K key){
        int index = hashmethod(key);

        for(int i = 0 ;i< this.buckets[index].size() ;i++){
            HashNode node = this.buckets[index].get(i);

            if(node.key == key){
                this.buckets[index].remove(i);
                this.size--;
                this.keySet.remove(key);
                return  node.value;
            }

        }
        return  null ;
    }

    public boolean isEmpty(){
        return  this.size == 0;
    }


    public static void main(String[] args) {

        HashTable<Integer , String>ht = new HashTable(10);

        ht.put(5 , "Deek");
        ht.put(15,"Divya");
        ht.put(20 , "Harsha");
        ht.put(10, "Indhu");

        /*ht.*/

        System.out.println( ht.buckets[0].get(0).value);
        System.out.println(ht.size);
        System.out.println(ht.get(15));
        System.out.println(ht.containsKey(12) +" "+ ht.containsKey(15));
        System.out.println(ht.keySet);
        System.out.println("-----Removing------");
        System.out.println(ht.remove(10)+"  "+ ht.remove(1));
        System.out.println(ht.keySet);
        System.out.println(ht.size);




    }






}
