import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for (int j = 0; j <= n; j++){
            int curVal = j;
            for (int i = 2; i <= Math.sqrt(curVal); i++){
                while (curVal % i == 0){
                    curVal = curVal / i;
                    if (i == 5){
                        count++;
                    }
                }
            }
            if (curVal == 5){
                count++;
            }
        }
        System.out.println(count);
    }
}