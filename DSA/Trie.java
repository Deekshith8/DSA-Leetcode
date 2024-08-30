package DSA;

import java.io.FilterOutputStream;

public class Trie{

    public Node root;

    public  Trie(){
        this.root = new Node();
    }

     class Node {

       public Node[] childrens;

       public  boolean endOfWord;



       public  Node(){
           this.childrens = new Node[26];
           for(int i=0;i<26 ;i++){
               childrens[i] = null;
           }
           this.endOfWord = false;
       }

    }


    public void insert(String word){



            Node current = this.root;

            for(int i = 0;i< word.length() ;i++){
                int index = word.charAt(i) - 'a';

                if(current.childrens[index] == null){
                    current.childrens[index] = new Node();
                }
                if(i == word.length()-1){
                    current.childrens[index].endOfWord = true;
                }
                current = current.childrens[index];

            }





    }

    public boolean search(String word){

        Node current =  this.root;

        for(int i = 0;i< word.length();i++){

            int index = word.charAt(i) - 'a';
            if(current.childrens[index] == null){
                return false;
            }
            if(i == word.length()-1 && !current.childrens[index].endOfWord){
                return false;
            }
            current = current.childrens[index];

        }

        return true;
    }



    public static void main(String[] args) {

        String [] words = {"the", "a", "their","there","any"};

        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }

        System.out.println(trie.search("the"));


    }

}
