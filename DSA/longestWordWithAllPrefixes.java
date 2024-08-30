package DSA;

public class longestWordWithAllPrefixes {

    public static  String ans = "";

    public static void main(String[] args) {
        String [] words = {"a","banana" , "app" , "appl" , "ap" , "apply" , "apple"};
        Trie trie = new Trie();

        for(String s:words){
            trie.insert(s);
        }


        longestWordWithAllPrefixes lWAP = new longestWordWithAllPrefixes();
        lWAP.longestWord(trie.root , new StringBuilder(""));
        System.out.println(longestWordWithAllPrefixes.ans);
    }


    public void longestWord(Trie.Node current , StringBuilder temp){

        if(current == null){
            return;
        }

        for(int i = 0; i<current.childrens.length ;i++){
            Trie.Node tempNode = current.childrens[i];
            if(tempNode != null && tempNode.endOfWord){
                temp.append((char) ('a'+i));
                if(ans.length() < temp.length()){
                    ans = String.valueOf(temp);
                }
                longestWord(current.childrens[i],temp );
                temp.deleteCharAt(temp.length()-1);
            }


        }

    }








}
