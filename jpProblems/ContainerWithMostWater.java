package jpProblems;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int []height={1,8,6,2,5,4,8,3,7};
        int result=maxArea(height);

        System.out.println(result);

    }

    public static int maxArea(int[] height) {
        int s=0;
        int e=0;
        int count=0;
        int max=0;



        if(height.length%2==0) {
             s = (height.length / 2)-1;
             e = height.length / 2;
        }
        else{
            s= (height.length-1)/2;
        }

        while(s>=0&&e< height.length){
            count++;
            int area=Math.min(height[s],height[e])*(e-s);
            if(area>max){

            }
            if(count%2==1){
                            }



        }


        return max;
    }
}
