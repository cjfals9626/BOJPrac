import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            int chapters = Integer.parseInt(br.readLine());
            long[][] dp = new long[chapters+1][chapters+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] sum = new long[chapters + 1];
            for (int j = 1; j <= chapters; j++){
                sum[j] = sum[j-1] + Long.parseLong(st.nextToken());
            }


            //d (시작과 끝 차이를 0이 아닌 1부터 시작하는 이유는, 만약 차이가 0이라면 같은 챕터, dp[i][i]를 의미하는 것인데,)
            //1페이지와 1페이지는 합친다고 비용이 발생하지 않음.
            //1페이지와 2페이지를 합친다면 비용이 발생함. 실제로 챕터를 합칠 수 있기 때문
            //시작 페이지와 끝 페이지 간의 간격이 1 이상 차이가 나야 비용이 발생함.
            for (int d = 1; d < chapters; d++){
                for (int s = 1; s <= chapters; s++){
                    int e = s+d;
                    if (e > chapters){
                        break;
                    }else{
                        dp[s][e] = Long.MAX_VALUE;
                        for (int j = 0; j < e - s; j++){
                            dp[s][e] = Math.min(dp[s][e], dp[s][s + j] + dp[s + j + 1][e] + (sum[e] - sum[s-1]));
                        }
                    }
                }
            }

            sb.append(dp[1][chapters]).append('\n');

        }
        System.out.println(sb);

    }

}