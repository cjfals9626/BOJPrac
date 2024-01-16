import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static int n;
    static int[][] colorW;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        colorW = new int[n][3];

        for (int i = 0; i < n; i++){
             StringTokenizer st = new StringTokenizer(br.readLine());

             int r = Integer.parseInt(st.nextToken());
             int g = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());

             colorW[i][0] = r;
             colorW[i][1] = g;
             colorW[i][2] = b;

         }
         dp[0][0] = colorW[0][0];
         dp[0][1] = colorW[0][1];
         dp[0][2] = colorW[0][2];

         int min = Integer.MAX_VALUE;

         for (int j = 0; j < 3; j++){

             min = Math.min(min, recu(n - 1, j, j));
             for (int i = 1; i < n; i++){
                 Arrays.fill(dp[i], 0);
             }
         }


        System.out.println(min);
    }

    static int recu(int house, int start, int color){

        if (house == 0 && start == color){
            return  Integer.MAX_VALUE;
        }

        if (dp[house][color] == 0){

            int o1 = 0;
            int o2 = 0;

            switch (color){
                case 0:
                    o1 = 1;
                    o2 = 2;
                    break;
                case 1:
                    o1 = 0;
                    o2 = 2;
                    break;
                case 2:
                    o1 = 0;
                    o2 = 1;
                    break;
            }

            dp[house][color] = Math.min(recu(house - 1, start, o1), recu(house - 1, start, o2)) + colorW[house][color];

        }
        return dp[house][color];
    }

}
