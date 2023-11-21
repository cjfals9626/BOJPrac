import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] home = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++){
            int position = Integer.parseInt(br.readLine());
            home[i] = position;
            if (max < position){
                max = position;
            }
        }
        Arrays.sort(home);
        System.out.println(parametric(home, 0, max + 1, c) - 1);
    }

    static int parametric(int[]home, int low, int high, int stand){
        int mid = 0;
        while (low < high){
            mid = (low + high) / 2;

            //기준은 집 간격 거리에 따라 공유기 수 만큼 집이 존재하는가.
            //간격을 줄이거나 늘리면서 공유기 설치한 집의 갯수가 기준에 부합한가.

            //첫 집에는 무조건 설치
            int count = 1;
            int standIndex = 0;
            for (int i = 0; i < home.length; i++){
                if (i == standIndex){
                    continue;
                }
                if ((home[i] - home[standIndex]) >= mid){
                    standIndex = i;
                    count++;
                }
            }

            //기준에 도달하지 못하는 경우
            if (count < stand){
                //간격을 줄임.
                high = mid;
            }else{
                //기준에 부합하면 간격을 늘림.
                low = mid + 1;
            }
        }
        //마지막에 기준을 부합한 최소 거리 반환. (+ 1되어 있음.)
        return low;
    }
}