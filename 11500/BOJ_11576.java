import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        int totalNums = 0;

        st = new StringTokenizer(br.readLine());

        //A진수를 10진수로 만들기
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            int curBase = 1;
            for (int j = n - i - 1; j > 0; j--) {
                curBase *= a;
            }
            totalNums += curBase * num;
        }


        //10진수를 B진수로 만들기
        StringBuilder sb = new StringBuilder();
        while (totalNums / b > 0){
            int edge = totalNums % b;
            totalNums /= b;

            sb.insert(0, edge).insert(0, " ");
        }

        sb.insert(0, totalNums);
        System.out.println(sb);

    }
}
