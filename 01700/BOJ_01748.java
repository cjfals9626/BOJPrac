import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numSt = br.readLine();
        int len = numSt.length();
        int num = Integer.parseInt(numSt);
        int tmpLen = 1;
        int base = 1;
        int sum = 0;

        while (len > tmpLen){
            num -= base * 9;
            sum += base * 9 * tmpLen;
            base *= 10;
            tmpLen++;
        }

        sum += num * tmpLen;

        System.out.println(sum);
    }

}