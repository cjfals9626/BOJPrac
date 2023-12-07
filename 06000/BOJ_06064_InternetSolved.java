import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            boolean isAns = false;

            int year = 0;

            for (int j = x; j < m*n; j += m){
                if (j % m == x && j % n == y){
                    year = j;
                    isAns = true;
                    break;
                }
            }
            if (isAns){
                sb.append(year + 1).append('\n');
            }else{
                sb.append(-1).append('\n');
            }

        }
        System.out.println(sb);
    }
}