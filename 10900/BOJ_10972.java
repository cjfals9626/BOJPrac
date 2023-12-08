import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //가장 마지막 인덱스부터 증가하는 부분 탐색
        int index = n-1;



        //증가하는 부분이 있는지 없는지 확인하기 위함.
        //내림차순일 경우 index = n-1상태여서 증가하는 부분이 없더라도 index = 0이 되지 않기 때문에
        //-1을 출력하지 않음
        boolean noneIncrease = true;
        //마지막 인덱스부터 앞으로 탐색하며
        //앞자리 > 뒷자리이면 인덱스를 1씩 줄임
        //뒷자리가 앞자리보다 더 크다면 멈춤.
        //즉, 뒷자리가 인덱스가 됨.
        for (int i = n-1; i > 0; i--){
            if (arr[i] > arr[i-1]){
                index = i;
                noneIncrease = false;
                break;
            }
        }


        //만약 인덱스가 0이라면, 혹은 마지막 인덱스이면서 증가한 부분이 없다면
        //증가하는 부분이 없다면 마지막 순열
        if (index == 0 || (index == n-1 && noneIncrease)){
            System.out.println(-1);
        }else{


            //해당 인덱스를 기준으로 좌,우 나눔
            //좌측에서 가장 오른쪽 숫자 (i-1 인덱스)와
            //우측 영역에서 i-1 값보다 큰 숫자를 가장 오른쪽에서부터 찾음.
            //찾았다면 swap
            for (int i = n-1; i >= index; i--){
                if (arr[i] > arr[index - 1]){
                    int tmp = arr[i];
                    arr[i] = arr[index - 1];
                    arr[index - 1] = tmp;
                    break;
                }
            }

            //우측 영역 오름차순 정렬
            Arrays.sort(arr, index, n);


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++){
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
        }

    }
}