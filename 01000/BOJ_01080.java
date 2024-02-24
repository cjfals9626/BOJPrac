import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrixA;
    static int[][] matrixB;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrixA = new int[n][m];
        matrixB = new int[n][m];

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++){
                matrixA[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++){
                matrixB[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int count = 0;
        for(int i = 0; i < n - 2; i++){
            for (int j = 0; j < m - 2; j++){
                if (matrixA[i][j] != matrixB[i][j]){
                    convert(matrixA, i, j);
                    count++;
                }
            }
        }

        if (Arrays.deepEquals(matrixA, matrixB)){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }

    }
    static void convert(int[][] matrix, int x, int y){
        for (int i = x; i < x + 3; i++){
            for (int j = y; j < y + 3; j++){
                if (matrix[i][j] == 1){
                    matrix[i][j] = 0;
                }else{
                    matrix[i][j] = 1;
                }
            }
        }
    }
}


