import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Integer[1001];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2;

        for (int i = 2; i <= 1000; i++){
            System.out.println(recu(i));
        }
    }

    static int recu(int num){
        if (dp[num] == null){

            int divide = Integer.MAX_VALUE;

            for (int i = 1; i <= num / 2; i++){
                if (num % i == 0){
                    divide = Math.min(divide, recu(i) + (num / i));
                }
            }

            return dp[num] = Math.min(divide, recu(num + 1) + 1);
        }
        return dp[num];
    }
}
