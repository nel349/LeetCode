package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by normanlopez on 2/23/19.
 */


/**
 * 1
 * 11
 * 121
 * 1331
 * 14641
 *
 *
 * vertical ecuation
 * if (j == 0)
 * 	c[i][j] = 1
 * if (i == j)
 * 	c[i][j] = 1
 *
 * c[i][j] = c[i-1][j-1] + c[i-1][j];
 */

class PascalTriangleII {
    
    public List<Integer> getRow(int rowIndex) {
        Integer[][] matrix = new Integer[rowIndex + 1][rowIndex + 1];

        matrix[0][0] = 1;
        for (int i = 0; i <= rowIndex ; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0){
                    matrix[i][j] = 1;
                }
                else if (j == i) {
                    matrix[i][j] = 1;
                }
                else {
                    matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
                }
            }
        }

        return Arrays.asList(matrix[rowIndex]);
    }

}


class MainClass {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int rowIndex = Integer.parseInt(line);

            List<Integer> ret = new PascalTriangleII().getRow(rowIndex);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
