package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows;  i++) {
            result.add(getRow(i));
        }
        return  result;
    }


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

class MainClassPascalTriangle {
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

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int numRows = Integer.parseInt(line);

            List<List<Integer>> ret = new PascalTriangle().generate(numRows);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}