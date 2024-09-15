package Leetcode;

public class ValidateBinarySearchTree_98 {
    public static void main(String[] args) {


    }

    public boolean isValidBST(TreeNode root) {


        boolean isvalid = helpingMethod(root , Long.MIN_VALUE , Long.MAX_VALUE);



        return isvalid;
    }

    public boolean helpingMethod(TreeNode root , Long leftMin , Long rightMax){

        if(root == null){
            return true;
        }

        if(root.val > rightMax || root.val < leftMin){
            return false;
        }

        if(helpingMethod(root.left , leftMin , (long) root.val)  == false){
            return false;
        }
        if(helpingMethod(root.right , (long) root.val, rightMax)  == false){
            return false;
        }


       return true;
    }
}
