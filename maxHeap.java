package DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class maxHeap{

     ArrayList<Integer> maxheap;

    int n;//size of maxHeap;

    public maxHeap(){
        maxheap = new ArrayList<>();
        n = 0;
    }

    public boolean isEmpty(){
        return this.n == 0;
    }

    public int size(){
        return  this.n;
    }

    public void insert(int val){

        if(this.n == 0){
            this.maxheap.add(n , null );
            this.maxheap.add(n+1,val);
            n++;
            return;
        }

        this.maxheap.add(n+1,val);
        n++;
       this.upheap(n);

    }

    private void upheap(int n){
        int parent = n/2;
        if(parent <= 0){
            return;
        }

        if(this.maxheap.get(n) > this.maxheap.get(parent)){
            swap(n , parent);
            upheap(parent);
        }

    }

    private void swap(int a , int b){

        int temp = this.maxheap.get(a);
        this.maxheap.set(a, this.maxheap.get(b));
        this.maxheap.set(b , temp);

    }

    public void remove(){

        if(this.n == 0){
           return;
        }
        if(this.n == 1){
            this.maxheap.remove(n);
            n--;
            return;
        }
        this.maxheap.set(1 , this.maxheap.get(n));
        this.maxheap.remove(n);
        n--;
        this.downHeap(1);
    }

    private void downHeap(int n){

        int child1 = n*2;
        int child2 = n*2+1;

        if(child1 > this.size()){
            return;
        }

        int j = child1;
        if(j+1 <= this.size() && this.maxheap.get(child1) < this.maxheap.get(child2)){
            j = child2;
        }

        if(this.maxheap.get(n) < this.maxheap.get(j)){
            swap(n,j);
            this.downHeap(j);
        }

    }



    public static void main(String[] args) {
        maxHeap mh = new maxHeap();
        mh.insert(9);
        System.out.println(mh.maxheap);
        mh.insert(3);
        mh.insert(6);
        mh.insert(2);
        mh.insert(1);
        mh.insert(10);
        mh.insert(11);
        System.out.println(mh.maxheap);
        System.out.println(mh.size());

        System.out.println("-------Removing--------");
        mh.remove();
        System.out.println(mh.maxheap);
        System.out.println(mh.size());





    }


}
