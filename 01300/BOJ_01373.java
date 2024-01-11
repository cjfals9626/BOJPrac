import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numSt = br.readLine();

        BigInteger bigInteger = new BigInteger(numSt, 2);

        System.out.println(bigInteger.toString(8));

    }
}
