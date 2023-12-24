import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0,-1,1,1,-1};
    static int[] dy = {0,0,-1,1,1,1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        while (n != 0 && m != 0){
            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //계산
            int count = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (!visited[i][j] && map[i][j] != 0){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }
    static void dfs(int x, int y){
        //반환 조건
        //없음

        for (int i = 0; i < 8; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || visited[nextX][nextY] || map[nextX][nextY] == 0){
                continue;
            }

            visited[nextX][nextY] = true;
            dfs(nextX, nextY);

        }
    }
}
