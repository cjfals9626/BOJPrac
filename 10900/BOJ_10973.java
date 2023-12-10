import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //가장 마지막 인덱스부터 감소하는 부분 탐색
        int index = n-1;



        //마지막 인덱스부터 앞으로 탐색하며
        //앞자리가 뒷자리보다 더 크다면 멈춤.
        //즉, 앞자리가 인덱스가 됨.
        for (int i = n-1; i > 0; i--){
            if (arr[i] < arr[i-1]){
                index = i-1;
                break;
            }
        }


        //만약 인덱스가 n-1이라면
        //감소하는 부분이 없어 -1을 출력
        if (index == n-1){
            System.out.println(-1);
        }else{


            //해당 인덱스를 기준으로 좌,우 나눔
            //좌측에서 가장 오른쪽 숫자 (index)와
            //우측 영역에서 index 값보다 작은 숫자를 가장 오른쪽에서부터 찾음.
            //찾았다면 swap하고 break
            for (int i = n-1; i > index; i--){
                if (arr[i] < arr[index]){
                    int tmp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = tmp;
                    break;
                }
            }

            //우측 영역 내림차순 정렬
            Arrays.sort(arr, index + 1, n, Collections.reverseOrder());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++){
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
        }

    }
}