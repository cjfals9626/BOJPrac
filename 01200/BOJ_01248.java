import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int n;

    static char[][] sign;
    static int[] tmpArr;

    static Integer[] correctArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sign = new char[n][n];
        tmpArr = new int[n];
        correctArr = new Integer[n];

        String s = br.readLine();
        int curPosition = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                sign[i][j] = s.charAt(curPosition++);
            }
        }
        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(correctArr[i] + " ");
        }
        System.out.println(sb);
    }
    static void dfs(int depth){
        if (correctArr[0] != null){
            return;
        }

        if (depth == n){

            for (int i = 0; i < n; i++){
                correctArr[i] = tmpArr[i];
            }

            return;
        }

        for (int i = 0; i < 21; i++){
            tmpArr[depth] = i - 10;
            if (check(depth)){
                dfs(depth + 1);
            }
        }
    }
    static boolean check(int depth){

        for (int l = 0; l <= depth; l++){
            for (int j = l; j <= depth; j++){
                int sum = 0;
                for (int k = l; k <= j; k++){
                    sum += tmpArr[k];
                }

                if (sign[l][j] == '+'){
                    if (!(sum > 0)){
                        return false;
                    }
                }
                if (sign[l][j] == '-') {
                    if (!(sum < 0)){
                        return false;
                    }
                }
                if (sign[l][j] == '0') {
                    if (sum != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}