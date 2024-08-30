package jpProblems;

public class medianOfsortedArray {
    public static void main(String[] args) {

        medianOfsortedArray msa = new medianOfsortedArray();

       double d = msa.findMedianSortedArrays(new int[]{}, new int[]{2,3});
        System.out.println(d);


    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int lengthofTwo = nums1.length+nums2.length;

       if(nums1.length == 0 && nums2.length == 0){
           return 0;
       }

       int[] newArr;

       if(lengthofTwo %2 == 0){
           newArr = new int[(lengthofTwo/2)+1];
       }else{
           newArr = new int[(lengthofTwo+1)/2];
       }


       int i = 0;
       int j = 0;
       int x = 0;

       while(i < nums1.length && j < nums2.length && x < newArr.length) {
           if(nums1[i]<nums2[j]){
               newArr[x] = nums1[i];
               i++;
               x++;
           }
           else{
               newArr[x] = nums2[j];
               j++;
               x++;
           }
       }
       while(i < nums1.length && x < newArr.length){
           newArr[x] = nums1[i];
           i++;
           x++;
       }
        while(j < nums2.length && x < newArr.length){
            newArr[x] = nums2[j];
            j++;
            x++;
        }

        if(lengthofTwo % 2 ==0){
            return (double) (newArr[newArr.length-1]+newArr[newArr.length-2])/2;
        }else{
            return (double) newArr[newArr.length-1];
        }

    }


}
