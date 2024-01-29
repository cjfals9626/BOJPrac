import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int n;
    static int m;
    static List<int[]> coin;
    static int[] dx;
    static int[] dy;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        coin = new ArrayList<>();

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};


        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++){
                char c = s.charAt(j);

                map[i][j] = c;

                if (c == 'o'){
                    coin.add(new int[]{i, j});
                }
            }
        }

        dfs(coin.get(0)[0], coin.get(0)[1], coin.get(1)[0], coin.get(1)[1], 0);

        if (result != Integer.MAX_VALUE){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }

    static void dfs(int x1, int y1, int x2, int y2, int count){
        if (count >= 10){
            return;
        }

        for (int i = 0; i < 4; i++){
            int nextX1 = x1 + dx[i];
            int nextY1 = y1 + dy[i];
            int nextX2 = x2 + dx[i];
            int nextY2 = y2 + dy[i];

            if ((((nextX1 < 0 || nextX1 >=n) || (nextY1 < 0 || nextY1 >= m)) && ((0 <= nextX2 && nextX2 < n) && (0 <= nextY2 && nextY2 < m))) ||
                    (((nextX2 < 0 || nextX2 >=n) || (nextY2 < 0 || nextY2 >= m)) && ((0 <= nextX1 && nextX1 < n) && (0 <= nextY1 && nextY1 < m)))) {
                result = Math.min(result, count + 1);
                continue;
            }

            if (!((0 <= nextX1 && nextX1 < n) && (0 <= nextY1 && nextY1 < m)) && !((0 <= nextX2 && nextX2 < n) && (0 <= nextY2 && nextY2 < m))){
                continue;
            }

            if (map[nextX1][nextY1] == '#'){
                nextX1 = x1;
                nextY1 = y1;
            }
            if (map[nextX2][nextY2] == '#'){
                nextX2 = x2;
                nextY2 = y2;
            }

            dfs(nextX1,nextY1,nextX2,nextY2,count + 1);

        }

    }

}


