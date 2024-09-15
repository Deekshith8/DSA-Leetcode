package Leetcode;

public class LowestCommonAncestorOfBST_235 {
    public static void main(String[] args) {

        LowestCommonAncestorOfBST_235 obj = new LowestCommonAncestorOfBST_235();

//        TreeNode root = new TreeNode(6);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(4);
//
//        root.right.left = new TreeNode(7);
//        root.right .right = new TreeNode(9);
//
//        TreeNode p = root.right.left ;
//        TreeNode q = root.right .right ;

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        TreeNode p = root;
        TreeNode q = root.left;




        System.out.println(obj.lowestCommonAncestor(root,p,q).val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if((root.val <= q.val && root.val >= p.val)||(root.val <= p.val && root.val >= q.val) ){
            return root;
        }

        if(root.val < p.val){
            return lowestCommonAncestor(root.right , p,q);
        }else if(root.val > q.val){
            return lowestCommonAncestor(root.left , p ,q);
        }


        return root;
    }

}
