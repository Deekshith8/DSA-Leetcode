package Leetcode;

import DSA.Trie;

import java.util.HashSet;
import java.util.Set;

public class wordBreaakProblem {

    public static void main(String[] args) {

//        String words[] = {"i","like","sam", "samsung","mobile","ice"};
//
//        String key = "ilikesamsung";
//
//        String words[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        String key = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";


      String  key = "catskicatcats";
        String[]words = {"cats","cat","dog","ski"};
        Trie trie = new Trie();

        for(String word:words){
        trie.insert(word);
        }
        wordBreaakProblem wbp = new wordBreaakProblem();
        Set<String> notthere = new HashSet<>();
        boolean result = wbp.checkmethod(trie , key , notthere);
        System.out.println(result);

    }

    public boolean checkmethod(Trie trie , String key , Set<String>notthere){
        if(key.length() == 0){
            return  true;
        }

        for(int i = 1;i <= key.length() ;i++){
            String part1 = key.substring(0,i);
            String part2 = key.substring(i,key.length());


            if(trie.search(part1) ){

                if(notthere.contains(part2)){

                }
                else if(checkmethod(trie,part2 , notthere)){
                     return  true;
                }

            }else{
                notthere.add(part1);
            }


        }



        return false;
    }

}
