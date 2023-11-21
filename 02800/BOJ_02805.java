import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];
        int max = 0;
        for (int i =0; i < n; i++){
            int hight = Integer.parseInt(st.nextToken());
            trees[i] = hight;
            if (max < hight){
                max = hight;
            }
        }
        System.out.println(max - parametric(trees,0,max+1,m, max));
    }

    static int parametric(int[]trees, int low, int high, int stand, int max){
        int mid = 0;
        while (low < high){
            mid = (low + high) / 2;

            //나무의 높이의 합은 1 ≤ M ≤ 2,000,000,000 M보다 크거나 같을 수 있기 때문에 long 타입
            long totalMeter = 0;
            int d = max - mid;
            for (int i = 0; i < trees.length; i++){
                if (d < trees[i]){
                    totalMeter += trees[i] - d;
                }
            }
            //기준에 도달하지 못하는 경우
            if (totalMeter < stand){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return high;
    }
}