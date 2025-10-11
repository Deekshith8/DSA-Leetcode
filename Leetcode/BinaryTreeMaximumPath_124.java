package Leetcode;

public class BinaryTreeMaximumPath_124 {

    public static void main(String[] args) {
//                TreeNod root = new TreeNod(9);
//        root.left = new TreeNod(6);
//        root.right = new TreeNod(-3);
//
//        root.right.left = new TreeNod(-6);
//        root.right.right = new TreeNod(2);
//
//        root.right.right.left = new TreeNod(2);
//        root.right.right.left.left = new TreeNod(-6);
//        root.right.right.left.right =   new TreeNod(-6);

//        TreeNod root = new TreeNod(2);
//        root.left = new TreeNod(9);
//         root.right = new TreeNod(-1);

        TreeNod root = new TreeNod(-1);
           root.left = new TreeNod(2);
              root.right = new TreeNod(2);

        BinaryTreeMaximumPath_124 obj = new BinaryTreeMaximumPath_124();

        System.out.println(obj.maxPathSum(root));

    }

    public int maxPathSum(TreeNod root) {

        int[]maxPath = new int[1];
        maxPath[0] = Integer.MIN_VALUE;

       helpingMethod(root , maxPath);

//       int temp = Integer.MIN_VALUE;

//       for(int n : sums){
//           if(temp < n){
//               temp = n;
//           }
//       }


       return maxPath[0];
    }


    public int helpingMethod(TreeNod root , int[]maxPath){

        if(root == null){
            return 0;
        }


           int   left = helpingMethod(root.left , maxPath);

           int right = helpingMethod(root.right , maxPath);


         if(left < 0 && right < 0){
             if(maxPath[0] < root.val){
                 maxPath[0] = root.val;
             }
             return root.val;
         }

        if(left < 0 && right >= 0){
            if(maxPath[0] < root.val+right){
                maxPath[0] = root.val+right;
            }
            return  root.val+right;
        }

        if(right < 0 && left >= 0){
            if(maxPath[0] < root.val+left){
                maxPath[0] = root.val+left;
            }
            return  root.val+left;
        }


        if(left >= 0 && right >=0){
            if(maxPath[0] <= root.val+ left + right){
                maxPath[0] = root.val+left+right;
            }

            if(left < right){
                return  right + root.val;
            }else{
                return left + root.val;
            }
        }

        return root.val;
    }
}
