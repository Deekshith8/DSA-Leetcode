package Leetcode;

import java.util.*;

public class CourseSchedule_207 {


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }


    public static void main(String[] args) {

        int numOfCourses = 4;

      //  int[][]prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};

        int[][]prerequisites = new int[][]{{2,0},{1,0},{3,1},{3,2},{1,3}};

        CourseSchedule_207 obj = new CourseSchedule_207();

        System.out.println(obj.canFinish(numOfCourses , prerequisites));



    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 1 || prerequisites.length == 0){
            return true;
        }

        Map<Integer, Node> map = new HashMap<>();

        for(int i = 0; i< numCourses ; i++){
            Node temp = new Node(i);
            map.put( i ,temp);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];

            Node courseNode = map.get(course);
            Node preReqNode = map.get(preReq);

            preReqNode.neighbors.add(courseNode);


        }// for end

        boolean isVisited[] = new boolean[numCourses];
        for (int i = 0; i < numCourses ; i++){
            if(!isVisited[i]){
                if(topoSort(map.get(i) , isVisited)){
                    continue;
                }else{
                    return false;
                }
            }
        }//

        return true;
    }

    private boolean topoSort(Node node , boolean[]isVisited) {

        Set<Node> isrepeated = new HashSet<>();

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.poll();

               isrepeated.add(temp);

                for(Node tempNode : temp.neighbors){
                    if(tempNode == node){
                        return false;
                    }
                    if(!isrepeated.contains(tempNode)){
                    queue.add(tempNode);}
                }

        }


        return  true;
    }

    public void createconnection(Node from, Node to) {

    }

}
