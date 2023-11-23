import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lis = new int[n];

        int lastIdx = 0;
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            if (lastIdx == 0 || (lastIdx > 0 && lis[lastIdx - 1] < num)){
                lis[lastIdx++] = num;
            }else {
                int idx = parametric(lis, 0, lastIdx - 1, num);
                lis[idx] = num;
            }
        }
        System.out.println(lastIdx);
    }
    static int parametric(int[] lis, int low, int high, int key){
        int mid = 0;
        while (low < high){
            mid = (low + high) / 2;

            if (lis[mid] < key){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

}