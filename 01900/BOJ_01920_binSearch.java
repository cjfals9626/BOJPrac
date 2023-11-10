import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(num, 0, arr.length - 1, arr)).append('\n');


        }
        System.out.println(sb);
    }

    static int binarySearch(int key, int low, int high, int[] arr){
        int mid;

        while (low <= high){

            mid = (low + high) / 2;

            if (arr[mid] == key){
                return 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }

        }
        return 0;
    }
}
