import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String nums = st.nextToken();

        long base = Long.parseLong(st.nextToken());
        long x = 1;

        long total = 0;

        for (int i = 0; i < nums.length(); i++){

            char c = nums.charAt(nums.length() - i - 1);

            int cToNum = 0;

            if (c >= 'A'){
                cToNum = c - 55;
            }else{
                cToNum = c - '0';
            }

            total += cToNum * x;
            x = x * base;
        }

        System.out.println(total);
    }
}
