import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static long P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long top = factorialMod(n);
        long bottom = pow(factorialMod(k) * factorialMod(n-k), P - 2) % P;

        System.out.println((top * bottom) % P);
    }

    static long factorialMod(long num){
        long result = num % P;

        if (num <= 1){
            return 1;
        }

        result = (result * factorialMod(num - 1)) % P;

        return result;
    }

    static long pow(long base, long exp){

        if (exp == 1){
            return base % P;
        }

        long tmp = pow(base, exp/2);

        if (exp % 2 == 1){
            return ((base % P) * ((tmp * tmp) % P)) % P;
        }else{
            return (tmp * tmp) % P;
        }
    }
}