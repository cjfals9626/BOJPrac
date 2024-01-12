import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new Long[n + 1];

        dp[0] = 0L;
        dp[1] = 1L;
        System.out.println(recu(n));
    }
    static long recu(int num){
        if (dp[num] == null){
            dp[num] = recu(num - 2) + recu(num - 1);
        }
        return dp[num];
    }
}
