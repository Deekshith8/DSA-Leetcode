package DSA;


import java.util.*;

public class countUniqueSubstrings {

    public static void main(String[] args) {


        String key = "ababa";
//        String key = "cac";

        List<String> words = new ArrayList<String>();

        for(int i = 0 ; i<= key.length() ;i++){
            String s = key.substring(i, key.length());
            words.add(s);
        }

        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        countUniqueSubstrings cus = new countUniqueSubstrings();
        Trie.Node current = trie.root;

      int count =   cus.countofUniqueSubstrings( current );

        System.out.println(count);
    }

    public int countofUniqueSubstrings(Trie.Node current ){


        int count = 0;
       for(int i = 0;i < current.childrens.length ; i++){
           if(current.childrens[i] != null){

                count += countofUniqueSubstrings( current.childrens[i] );
           }

       }
       return count+1;
    }






}
