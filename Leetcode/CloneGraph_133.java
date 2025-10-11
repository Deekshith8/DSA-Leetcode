package Leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CloneGraph_133 {

    public static void main(String[] args) {

        Nod root = new Nod(1);

        root.neighbors.add(new Nod(2));
        root.neighbors.add(new Nod(4));

        root.neighbors.get(0).neighbors.add(root);

        root.neighbors.get(1).neighbors.add(root);

        CloneGraph_133 obj = new CloneGraph_133();

        Nod temp  = obj.cloneGraph(root);

        System.out.println(temp.val);

        System.out.println(temp.neighbors);

        for(Nod n : temp.neighbors){
            System.out.println(n.val);
        }

    }

    public Nod cloneGraph(Nod node) {

        if(node == null){
            return  null;
        }

        Queue<Nod> queue = new ArrayDeque<>();

        Map<Nod , Nod> map = new HashMap<>();

        queue.add(node);

        Nod root = new Nod();

        Nod temp = null;

        while (!queue.isEmpty()){

            Nod realNode = queue.poll();

            if(map.containsKey(realNode)){
                continue;
            }

            if(temp == null){
                root = new Nod(realNode.val);
                temp = root;
            }else{
                temp = new Nod(realNode.val);
            }
            map.put(realNode , temp);

            for(Nod n: realNode.neighbors){
                if(map.containsKey(n)){
                    Nod get = map.get(n);

                    get.neighbors.add(temp);
                    temp.neighbors.add(get);
                }else {
                    queue.add(n);
                }
            }

        }

      return  root;
    }

}
