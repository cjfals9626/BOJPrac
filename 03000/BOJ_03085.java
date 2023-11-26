import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++){
            max = Math.max(checkRow(arr, i), max);
        }
        for (int i = 0; i < n; i++){
            max = Math.max(checkCol(arr, i), max);
        }

        for (int i = 0; i < n; i++){
            for (int j = 1; j < n; j++){
                if (arr[i][j] != arr[i][j-1]){
                    swap(arr, i,j, i,j-1);
                    max = Math.max(checkCol(arr, j), max);
                    max = Math.max(checkCol(arr, j-1), max);
                    max = Math.max(checkRow(arr, i), max);
                    swap(arr, i,j, i,j-1);
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 1; j < n; j++){
                if (arr[j][i] != arr[j-1][i]){
                    swap(arr, j,i, j-1,i);
                    max = Math.max(checkRow(arr, j), max);
                    max = Math.max(checkRow(arr, j-1), max);
                    max = Math.max(checkCol(arr, i), max);
                    swap(arr, j,i, j-1,i);
                }
            }
        }
        System.out.println(max);
    }

    static int checkRow(char[][] arr, int x){
        int max = 0;

        int count = 0;
        char stand = arr[x][0];

        for (int j = 0; j < arr[x].length; j++){
            if (stand == arr[x][j]){
                count++;
            }else{
                max = Math.max(max, count);
                count = 1;
                stand = arr[x][j];
            }
        }
        max = Math.max(max, count);

        return max;
    }

    static int checkCol(char[][] arr, int y){
        int max = 0;

        int count = 0;
        char stand = arr[0][y];

        for (int j = 0; j < arr.length; j++){
            if (stand == arr[j][y]){
                count++;
            }else{
                max = Math.max(max, count);
                count = 1;
                stand = arr[j][y];
            }
        }
        max = Math.max(max, count);

        return max;
    }
    static void swap(char[][] arr, int x1, int y1, int x2, int y2){
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
}