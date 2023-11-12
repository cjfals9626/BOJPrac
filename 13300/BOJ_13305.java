import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] w;
        int[] pricePL;

        int n = Integer.parseInt(br.readLine());

        w = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w.length; i++){
            int len = Integer.parseInt(st.nextToken());
            w[i] = len;
        }

        pricePL = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            int pri = Integer.parseInt(st.nextToken());
            pricePL[i] = pri;
        }

        int cur = 0;

        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < n-1; i++){
            if (pricePL[cur] > pricePL[i]){
                cur = i;
            }
            result = result.add(BigInteger.valueOf(pricePL[cur]).multiply(BigInteger.valueOf(w[i])));
        }

        System.out.println(result);
    }
}
