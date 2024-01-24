import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int max;
    static List<Integer> arrList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        max = 0;

        arrList = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arrList.add(num);
        }

        dfs(0);
        System.out.println(max);
    }
    static void dfs(int sum){
        if (arrList.size() == 2){
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < arrList.size() - 1; i++){
            int firstNum = arrList.get(i - 1);
            int secondNUm = arrList.get(i + 1);
            Integer tmp = arrList.remove(i);
            dfs(sum + (firstNum * secondNUm));
            arrList.add(i, tmp);
        }
    }

}


