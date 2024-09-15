package Leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CloneGraph_133 {

    public static void main(String[] args) {

        Node root = new Node(1);

        root.neighbors.add(new Node(2));
        root.neighbors.add(new Node(4));

        root.neighbors.get(0).neighbors.add(root);

        root.neighbors.get(1).neighbors.add(root);

        CloneGraph_133 obj = new CloneGraph_133();

        Node temp  = obj.cloneGraph(root);

        System.out.println(temp.val);

        System.out.println(temp.neighbors);

        for(Node n : temp.neighbors){
            System.out.println(n.val);
        }

    }

    public Node cloneGraph(Node node) {

        if(node == null){
            return  null;
        }

        Queue<Node> queue = new ArrayDeque<>();

        Map<Node , Node> map = new HashMap<>();

        queue.add(node);

        Node root = new Node();

        Node temp = null;

        while (!queue.isEmpty()){

            Node realNode = queue.poll();

            if(map.containsKey(realNode)){
                continue;
            }

            if(temp == null){
                root = new Node(realNode.val);
                temp = root;
            }else{
                temp = new Node(realNode.val);
            }
            map.put(realNode , temp);

            for(Node n: realNode.neighbors){
                if(map.containsKey(n)){
                    Node get = map.get(n);

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
