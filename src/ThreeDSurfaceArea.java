import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class ThreeDSurfaceArea {
    public static int surfaceArea() {
        List<List<Integer>> data = new ArrayList<>(4);
        List<Integer> second = new ArrayList<>();
        second.addAll(List.of(1,3,4));
        List<Integer> third = new ArrayList<>();
        third.addAll(List.of(2,2,3));
        List<Integer> forth = new ArrayList<>();
        forth.addAll(List.of(1,2,4));
        data.add(0,second);
        data.add(1,third);
        data.add(2,forth);
        List<List<Integer>> A = data;
        // Write your code here
        int row = A.size();
        int cloumns = A.get(0).size();
        if(row ==1 && cloumns ==1)
            return  6;
        int result = 0;
        result += calculateFrontSides(A, row);
        result += calculateBackSides(A, row);
        result += calculateEndSides(A,row);
        // Calculate the top layer
        result += (row* cloumns);
        // Calculate the bottom  layer
        result += (row* cloumns);
        result += calculateSidesInBetween(A, row, cloumns);
        return result;

    }

    static int calculateEndSides(List<List<Integer>> A, int rows) {
        // Write your code here
        Optional<Integer> leftSum = A.get(0).stream().reduce((x, y)-> x+y);
        Optional<Integer> rightSum = A.get(rows-1).stream().reduce((x, y)-> x+y);
        return  leftSum.get()+rightSum.get();
    }

    static int calculateFrontSides(List<List<Integer>> A, int rows) {
        // Write your code here
        int result = 0;
        for(int i = 0; i<rows;i++) {
            List<Integer> rowInQuestion = A.get(i);
            int totalSurface = IntStream.range(1, rowInQuestion.size())
                    .map(j -> Math.max(0, rowInQuestion.get(j) - rowInQuestion.get(j - 1) ))
                    .sum();
            totalSurface += rowInQuestion.get(0);
            result += totalSurface;
        }
        return  result;
    }

    static int calculateBackSides(List<List<Integer>> A, int rows) {
        // Write your code here
        int result = 0;
        result = A.stream().map(row-> row.get(row.size()-1)).reduce(0, (a, b)-> a+b);
        return  result;
    }




    static int calculateSidesInBetween(List<List<Integer>> A, int rows,int column) {

        int result = 0;
        for(int row = 1; row<rows;row++) {
            List<Integer> leftRow = A.get(row - 1);
            List<Integer> rightRow = A.get(row);
            result += IntStream.range(0, column)
                    .map(i -> Math.abs(rightRow.get(i) - leftRow.get(i)))
                    .sum();
        }
        return  result;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(ThreeDSurfaceArea.surfaceArea());
    }
}
