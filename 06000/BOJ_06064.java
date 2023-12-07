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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean[] visitedN = new boolean[n + 1];

            int D = m - n;

            int year = x;
            int FirstN;

            if (m <= n){
                FirstN = x;

            }else{
                int d;
                if (x == 1){
                    d = 0;
                }else{
                    d = (x-1)/n;
                }
                FirstN = x - d * n;
            }


            int count = 0;

            while (!visitedN[FirstN] && y != FirstN){

                count++;
                visitedN[FirstN] = true;
                FirstN += D;


                while (FirstN <= 0){
                    FirstN = n + FirstN;
                }
                while (FirstN > n){
                    FirstN = FirstN - n;
                }

            }

            if (y != FirstN){
                year = -1;
            }else{
                year += count * m;
            }

            sb.append(year).append('\n');

        }
        System.out.println(sb);
    }
}