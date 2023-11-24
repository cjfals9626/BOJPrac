import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static long n;
    static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        System.out.println(recu(1,k));
    }
    static long recu(long low, long high){
        long mid;
        while (low < high){
            mid = (low + high) / 2;
            long count = 0;
            for (int i = 1; i <= n; i++){
                count += Math.min(mid / i, n);
            }

            if (count < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}