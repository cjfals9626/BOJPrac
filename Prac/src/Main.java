import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int max = 0;

        for (int s = 0; s < (1 << n * m); s++) {
            int sum = 0;

            //가로
            for (int i = 0; i < n; i++) {
                int cur = 0;
                for (int j = 0; j < m; j++) {
                    int k = i * m + j;

                    if ((s & (1 << k)) == 0) {
                        cur *= 10;
                        cur += arr[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                //마지막
                sum += cur;
            }

            //세로
            for (int j = 0; j < m; j++) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    int k = i * m + j;

                    if ((s & (1 << k)) != 0) {
                        cur *= 10;
                        cur += arr[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                //마지막
                sum += cur;
            }

            max = Math.max(max, sum);
        }


        System.out.println(max);
    }
}
