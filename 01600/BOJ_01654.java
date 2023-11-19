import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];

        long max = 0;
        for (int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        //가장 긴 길이가 1일 경우 mid는 0이 되므로 처음에 high을 넣어줄 때 + 1을 해줌.
        System.out.println(parametic(arr,0,max + 1,n) - 1);
    }

    //low는 항상 0으로 시작. high는 가장 긴 길이
    //갯수를 세기 위한 mid가 0이 되면 안되므로, 만약 2개의 랜선을 가지고 있는데, 둘다 길이가 1이면 high는 1.
    //그럼 mid = (0 + 1) / 2 = 0이 되므로 처음에 high을 넣을 때 + 1을 해줌.
    static long parametic(int[] arr, long low, long high, long stand){
        long mid = 0;

        while (low < high){
            mid = (low + high) / 2;

            int count = 0;
            for (int i = 0; i < arr.length; i++){
                count += arr[i] / mid;
            }

            if (count < stand){
                //갯수 기준에 못 미친다면 길이를 조금씩 줄인다.
                high = mid;

            }else{
                //갯수 기준에 미치더라도 길이를 증가시킨다.
                //더 긴 길이에서도 기준에 만족할 수 있기 때문.
                low = mid + 1;
            }
        }
        return low;
    }

}