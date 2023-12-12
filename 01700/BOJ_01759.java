
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int l;
    static int c;
    static char[] tmpArr;
    static char[] w;
    static boolean[] visited;
    static List<Character> moem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        moem = new ArrayList<>();
        moem.add('a');
        moem.add('e');
        moem.add('i');
        moem.add('o');
        moem.add('u');

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        w = new char[c];
        tmpArr = new char[l];
        visited = new boolean[c];

        for (int i = 0; i < c; i++) {
            w[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(w);

        dfs(0, 0);

        System.out.println(sb);

    }

    static void dfs(int depth, int preNode) {
        if (depth == l) {
            int count = 0;

            //모음 몇 개인지
            for (int i = 0; i < l; i++){
                if (moem.contains(tmpArr[i])){
                    count++;
                }
            }
            //모음 1개 이상, 자음 2개 이상인지 확인
            if (count >= 1 && tmpArr.length - count >= 2){
                for (int i = 0; i < l; i++) {
                    sb.append(tmpArr[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = preNode; i < c; i++){
            if (!visited[i]){
                visited[i] = true;
                tmpArr[depth] = w[i];
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}