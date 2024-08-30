package DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class longestSubstringUsingTrie {

        static int  maxcount = 0;




        public static void main(String[] args) {

            longestSubstringUsingTrie lst = new longestSubstringUsingTrie();
//           lst.lengthOfLongestSubstring("bbbbb");
            System.out.println(lst.lengthOfLongestSubstring("abcdefhc"));
           // System.out.println(lst.lengthOfLongestSubstring("abcabcbb"));
            System.out.println(lst.lengthOfLongestSubstring(" "));
            System.out.println(lst.lengthOfLongestSubstring("pwkeww"));

        }


    public int lengthOfLongestSubstring(String s) {

            Trie1 trie = new Trie1();
             maxcount = 0;

        for( int i = 0 ;i <= s.length()   ; i++){
          trie.insert (s.substring(i,s.length()));
        }

        Trie1.Node current = trie.root;

        for(Character c : current.childrens.keySet()) {
            Trie1.Node temp = current.childrens.get(c);

                recursivemethod(temp,0, new HashSet<>() , c);

        }

         return maxcount ;
    }

    public void recursivemethod(Trie1.Node node , int count , HashSet<Character>set , char c ){

            if(set.contains(c)){
                return ;
            }
            count++;
           set.add(c);
           if(count > maxcount){
            maxcount = count;
           }
            for(char ch : node.childrens.keySet()){

                if( !set.contains(ch)){

                   recursivemethod(node.childrens.get(ch), count ,set , ch );
                }

            }
            set.remove(c);


    }



}
class Trie1 {

    public Node root;

    public Trie1() {
        this.root = new Node();
    }

    class Node {


        public HashMap<Character, Node>childrens;

        public boolean endOfWord;


        public Node() {
           this.childrens = new HashMap<>();
            this.endOfWord = false;
        }

    }


    public void insert(String word) {


        Node current = this.root;

        for (int i = 0; i < word.length(); i++) {


            char c  = word.charAt(i);



            if (!current.childrens.containsKey(c)) {
                current.childrens.put(c, new Node());
            }
            if (i == word.length() - 1) {
                current.childrens.get(c).endOfWord = true;
            }
            current = current.childrens.get(c);

        }
    }
}