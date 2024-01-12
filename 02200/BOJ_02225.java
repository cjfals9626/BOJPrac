import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++){
            dp[i][1] = 1;
        }
        for (int i = 0; i <= k; i++){
            dp[0][i] = 1;
        }

        System.out.println(recu(n, k));
    }
    static int recu(int node, int digit){
        if (dp[node][digit] == 0){
            dp[node][digit] = (recu(node - 1, digit) + recu(node, digit - 1)) % 1000000000;
        }
        return dp[node][digit];
    }
}
