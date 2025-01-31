import java.io.IOException;
import java.util.Scanner;

public class SpaceStation {
    // Complete the flatlandSpaceStations function below.
    //
    static int flatlandSpaceStations(int n, int[] c) {
            int maxLength  = 0;
            if(n == c.length)
                return 0;
            for(int i =0; i < n ; i++) {
                int minDistanceForCity = c.length;
                for(int j=0;j<c.length; j++) {
                    minDistanceForCity = Math.min(minDistanceForCity,Math.abs(c[j]-i));
                }
                maxLength = Math.max(maxLength, minDistanceForCity);
            }
            return maxLength;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] c = {13, 1, 11, 10, 6};
        SpaceStation.flatlandSpaceStations(20, c);
    }
}
