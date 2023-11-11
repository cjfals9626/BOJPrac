import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] split = s.split("-");
        int[] numArr = new int[split.length];

        for (int i = 0; i < split.length; i++){

            String[] plusNums = split[i].split("\\+");
            int tmp = 0;
            for (int j = 0; j < plusNums.length; j++){
                tmp += Integer.parseInt(plusNums[j]);
            }
            numArr[i] = tmp;
        }

        int result = numArr[0];

        for (int i = 1; i < numArr.length; i++){
            result -= numArr[i];
        }
        System.out.println(result);
    }
}
