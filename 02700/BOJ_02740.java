import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                arr1[i][j] = num;
            }
        }

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[m][k];

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++){
                int num = Integer.parseInt(st.nextToken());
                arr2[i][j] = num;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < k; j++){
                int num = 0;

                for (int l = 0; l < m; l++){
                    num += (arr1[i][l] * arr2[l][j]);
                }
                sb.append(num + " ");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }
}