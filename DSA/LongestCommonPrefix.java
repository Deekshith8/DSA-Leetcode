package DSA;

import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix LCP = new LongestCommonPrefix();

        System.out.println(LCP.longestCommonPrefixusingTrie(new String[]{""}));

    }

    public String longestCommonPrefix(String[] strs) {
        // we can use trie data structuyre here


        StringBuilder answer = new StringBuilder(strs[0]);

        for(int i = 1 ; i < strs.length ; i++){
            StringBuilder temp = new StringBuilder();
            int j = 0;
            int k = 0;
           while(j < answer.length() && k< strs[i].length()){

               if(strs[i].charAt(k) == answer.charAt(j)){
                   temp = temp.append(answer.charAt(j));
                   k++;
                   j++;
               }
               else{
                   break;
               }

            }

           if(temp.length() == 0){
               return "";
           }

           answer = temp;

        }

      return answer.toString();
    }


    public String longestCommonPrefixusingTrie(String[] strs){
       String ans = "";

       Trie2 trie2 = new Trie2();


       for(String word : strs){

           trie2.insert(word);

       }

        Trie2.Node current = trie2.root;
       while(current != null){
           int count = 0;
          int temp = 0;
           for(int i = 0 ; i< current.childrens.length ; i++) {

           if (current.childrens[i] != null) {
                count++;
                temp = i;
           }

        }
           if(count != 1){
               return ans;
           }
           else if(count == 1){
               ans = ans+""+(char)(temp+'a');
               current =current.childrens[temp];
           }
       }


       return ans;
    }



    class Trie2 {

        public Node root;

        public Trie2() {
            this.root = new Node();
        }

        class Node {

            public Node[] childrens;

            public boolean endOfWord;


            public Node() {
                this.childrens = new Node[26];
                for (int i = 0; i < 26; i++) {
                    childrens[i] = null;
                }
                this.endOfWord = false;
            }

        }


        public void insert(String word) {


            Node current = this.root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                if (current.childrens[index] == null) {
                    current.childrens[index] = new Node();
                }
                if (i == word.length() - 1) {
                    current.childrens[index].endOfWord = true;
                }
                current = current.childrens[index];

            }


        }
    }

}
