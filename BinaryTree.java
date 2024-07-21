package DSA;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private  Node root;

    public  static  class Node {

        private int val;
        private Node right;

        private Node left;

        public Node(int data) {
            this.val = data;
            this.right = null;
            this.left = null;
        }

    }


    public void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }


    public void preOrderTraversal(Node root){

        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(this.root);
        while(!stack.isEmpty()){

            Node temp = stack.pop();

            System.out.println(temp.val);

            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }

        }


    }

    public void inOrderTraversal(Node root){

        if(root == null){
            return;
        }

        inOrderTraversal(root.left);

        System.out.println(root.val);

        inOrderTraversal(root.right);

    }


    public void iterativeInOrderTraversal(Node root){


        Stack<Node> stack = new Stack<>();

        Node temp = root;

        while(! stack.isEmpty() || temp != null){

            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else{
                temp = stack.pop();
                System.out.print(temp.val+" ");
                temp = temp.right;
            }

        }

        System.out.println();
    }


    public void postOrderTraversal(Node root){

        if(root == null){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);

    }


    public void postOrtderTraversalIterative(Node root){

        Stack<Node>stack = new Stack<>();

        Node current  = root;

        while(!stack.isEmpty() || current != null){

            if(current != null){
                stack.push(current) ;
                current = current.left;
            }
            else{
               Node  temp  = stack.peek();

                if(temp.right != null){
                    current = temp.right;

                }
                else{
                    temp = stack.pop();
                    System.out.println(temp.val);

                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.println( temp.val);
                    }


                }


            }


        }


    }

    public  void levelOrderTraversal(Node root){

        Queue<Node>queue = new ArrayDeque<>();

        Node current = root;
        queue.add(root);

        while(!queue.isEmpty()){

            Node temp = queue.poll();

            if(temp.left !=null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            System.out.println(temp.val+" ");

        }

    }

    public int findMax(Node root){

        if(root == null){
            return  Integer.MIN_VALUE;
        }
        int result = root.val;

        int left = findMax(root.left);

        int right = findMax(root.right);

        if(right>result){
            result = right;
        }
        if(left > result){
            result = left;
        }

        return result;
    }

    public int findMin(Node root){

        if(root == null){
            return  Integer.MAX_VALUE;
        }
        int result = root.val;

        int left = findMax(root.left);

        int right = findMax(root.right);

        if(right < result){
            result = right;
        }
        if(left < result){
            result = left;
        }

        return result;

    }

    public Node createTree(){


        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        this.root = first;
        first.left = second ;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        return  this.root;

    }


    public static void main(String[] args) {

        BinaryTree obj = new BinaryTree();



        BinaryTree tree = new BinaryTree();

//       Node root = tree.createTree();
//        System.out.println(root.val);
//       tree.preOrder(root);
//        tree.preOrderTraversal(root);


//        System.out.println("Inorder traversel");
//
//        BinaryTree tree2 = new BinaryTree();
//        Node root1 = new Node(1);
//        Node left1 = new Node (2);
//        Node right1= new Node(3);
//        Node left2 = new Node(4);
//        Node left3 = new Node(5);
//        Node right2= new Node(6);
//        Node right3 = new Node(7);
//
//        tree2.root = root1;
//        tree2.root.left = left1;
//        tree2.root.right = right1;
//
//        left1.left = left2;
//        left1.right = left3;
//
//        right1.left = right2;
//        right1.right = right3;
//
//        obj.inOrderTraversal(tree2.root);


//        System.out.println("Inorder traversal Iterative");
        BinaryTree tree2 = new BinaryTree();
        Node root1 = new Node(1);
        Node left1 = new Node (2);
        Node right1= new Node(3);
        Node left2 = new Node(4);
        Node left3 = new Node(5);
        Node right2= new Node(6);
        Node right3 = new Node(7);

        tree2.root = root1;
        tree2.root.left = left1;
        tree2.root.right = right1;

        left1.left = left2;
        left1.right = left3;

        right1.left = right2;
        right1.right = right3;

       // obj.iterativeInOrderTraversal(tree2.root);
       // obj.postOrtderTraversalIterative(tree2.root);
        obj.levelOrderTraversal(tree2.root);

        System.out.println(obj.findMax(tree2.root));
        System.out.println(obj.findMin(tree2.root));


//        System.out.println("creating Binary Tree ");
//        BinaryTree tree3 = new BinaryTree();
//        tree3.add(6);
//        tree3.add(3);
//        tree3.add(8);
//        tree3.add(2);
//        tree3.add(4);
//        tree3.add(7);
//        tree3.add(9);
//        tree3.postOrderTraversal(tree3.root);
//        System.out.println(tree3.root.val);


        System.out.println("creating Binary Tree ");
        BinaryTree tree3 = new BinaryTree();
        tree3.root = new Node(6);
        tree3.insert(tree3.root,3);
        tree3.insert(tree3.root,8);
        tree3.insert(tree3.root,2);
        tree3.insert(tree3.root,4);
        tree3.insert(tree3.root,7);
        tree3.insert(tree3.root,9);
        tree3.postOrderTraversal(tree3.root);
        System.out.println(tree3.root.val);

        System.out.println(obj.search(tree3.root , 20));

        System.out.println(obj.searchNode(tree3.root , 3).right.val);

        System.out.println(obj.validate(tree3.root,Integer.MIN_VALUE ,Integer.MAX_VALUE));




    }


    public void add(int val){

        Node newNode = new Node(val);

        if(this.root == null){
            this.root = newNode;
            return;
        }

        Node temp = this.root;
        Node current = null;
        while(temp != null){
            current = temp ;
            if(temp.val > val){
                temp = temp.left;
            }
           else{
                temp = temp.right;
            }

        }
        if(current.val < val){
            current.right = newNode;
        }
        else{
            current.left = newNode;
        }

    }

    public Node insert(Node root , int val){

        if(root == null){
            root = new Node(val);
            return  root;
        }

        if(root.val > val){
            root.left = insert(root.left , val);
        }
        else{
            root.right = insert(root.right , val);
        }

        return  root;
    }

    public boolean search(Node root , int val){

        if(root == null ){
            return false;
        }
        if(root.val == val){
            return true;
        }

        boolean result = false;

        if(val < root.val){
            result = search(root.left , val);
        }
        else{
            result = search( root.right , val);
        }

        return  result;// we can return Node as well

    }

    public Node searchNode(Node root , int val){

        if(root == null ){
            return null;
        }
        if(root.val == val){
            return root;
        }

        Node result = null;

        if(val < root.val){
            result = searchNode(root.left , val);
        }
        else{
            result = searchNode( root.right , val);
        }

        return  result;// we can return Node as well

    }


    public boolean validate(Node root , long min , long max){

        if(root == null){
            return  true;
        }


       if(root.val <= min || root.val >= max){
           return  false;
       }
       boolean left = validate(root.left , min ,root.val);
        boolean right = false;
       if(left){
            right = validate(root.right , root.val,  max);
       }
       return left && right;

    }


}
