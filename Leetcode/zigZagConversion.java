package Leetcode;

public class zigZagConversion {
    public static void main(String[] args) {

       // String s = "PAYPALISHIRING";
        String s ="A";
        zigZagConversion zzC = new zigZagConversion();
        String ans = zzC.convert2(s , 1);
        System.out.println(ans);//

    }

    public String convert(String s, int numRows) {
        if(s.length() == 0 || numRows == 1){
            return s;
        }

        StringBuilder ans = new StringBuilder("");
        int cols = 0;

        int count = 0;
        int n = s.length();

        while(count < n){
            cols++;
            count += numRows;
            int i = 0;
            while(i < (numRows-2) && count < n){
                cols++;
                count++;
                i++;
            }
        }


        System.out.println(cols);
        Character[][]matrix = new Character[numRows][cols];

        int tempcol = 0;
        int x = 0;//for traversing string

        while(tempcol < cols){

            int row = 0;

            while(row < numRows &&  x < n){
                matrix[row][tempcol] = s.charAt(x);
                x++;
                row++;
            }
            row = row-2; tempcol++;

            while(row > 0 && tempcol < matrix[row].length && x < n ){
                matrix[row][tempcol] = s.charAt(x);
                x++;
                row--;
                tempcol++;
            }

        }


        for(int i = 0; i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length ;j++){
             if(matrix[i][j] != null){
                 ans.append(matrix[i][j]);
             }
            }
            System.out.println();
        }

        return ans.toString();
    }


    public String convert2(String s, int numRows){
        if(s.length() == 0 || numRows ==1){
            return s;
        }
        StringBuilder ans = new StringBuilder("");
        int gap = numRows + (numRows-2);

        for(int i = 0;i< numRows ; i++){
            int x = i ; int  tempgap = gap-(2*i);
            if(i == 0 || i == numRows-1){
                while(x < s.length()){
                    ans.append(s.charAt(x));
                    x += gap;
                }

            }
            else {
                while (x < s.length()) {
                    ans.append(s.charAt(x));

                    if (x + tempgap < s.length()) {
                        ans.append(s.charAt(x + tempgap));
                    }
                    x += gap;
                }//PINALSIGYAHRPI
            }


        }


        return  ans.toString() ;
    }



}
