import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        cost = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = cost[1];


        System.out.println(recu(n));
    }
    static int recu(int n){
        if (dp[n] == 0){
            int tmp = 0;
            for (int i = 1; i <= n / 2; i++){
                tmp = Math.max(tmp, recu(i) + recu(n - i));
            }
            tmp = Math.max(cost[n], tmp);
            dp[n] = tmp;
        }
        return dp[n];
    }
}
