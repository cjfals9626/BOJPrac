import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] alphas = new Integer[26];
        Arrays.fill(alphas, 0);

        for (int i = 0; i < n; i++){
            String s = br.readLine();

            int digit = (int) Math.pow(10, s.length() - 1);

            for (int j = 0; j < s.length(); j++){
                char c = s.charAt(j);

                alphas[c - 'A'] += digit;
                digit /= 10;
            }
        }

        Arrays.sort(alphas, Collections.reverseOrder());

        int num = 9;
        int total = 0;
        for (int i = 0; i < 26; i++){
            if (alphas[i] != 0){
                total += alphas[i] * num--;
            }
        }
        System.out.println(total);
    }
}


