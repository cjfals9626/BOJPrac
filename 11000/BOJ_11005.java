import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long nums = Long.parseLong(st.nextToken());

        long base = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (nums / base > 0){
            long edge = nums % base;
            nums = nums / base;

            if (edge > 9){
                sb.insert(0, (char)(edge + 'A' - 10));
            }else{
                sb.insert(0, edge);
            }

        }
        if (nums > 9){
                sb.insert(0, (char)(nums + 'A' - 10));
            }else{
                sb.insert(0, nums);

            }


        System.out.println(sb);

    }
}