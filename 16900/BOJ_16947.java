import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] map;
    static boolean[] cycle;
    static int[] distance;
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new boolean[n + 1][n + 1];
        cycle = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstStation = Integer.parseInt(st.nextToken());
            int secondStation = Integer.parseInt(st.nextToken());

            map[firstStation][secondStation] = map[secondStation][firstStation] = true;
        }

        Arrays.fill(distance, -1);

        checkCycle(0, 1);
        measureBFS();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++){
            sb.append(distance[i] + " ");
        }
        System.out.println(sb);

    }

    //DFS 탐색
    //단지 노드 두 개가 서로 이어져있을 뿐이라면 사이클이 아님
    //그래서 prev 필요함
    static boolean checkCycle(int prev, int cur){
        //일단 현재 노드가 사이클에 포함되었다고 가정
        cycle[cur] = true;

        //다음 노드 탐색
        for (int i = 1; i <= n; i++) {
            //다음 노드 탐색. 다음 노드 = i
            //visited 필요없음.cycle이 visited 역할 함
            if (map[cur][i]) {

                //다음 노드가 이미 순환에 포함된(방문한) 노드이고, 이전 노드와 다음 탐색할 노드가 같지 않다면
                //이는 사이클. true 반환
                //사이클 시작 부분부터
                if (cycle[i] && prev != i){
                    distance[i] = 0;
                    q.add(i);
                    return true;

                }else if(!cycle[i]){
                    //아직 방문하지 않았다면

                    //다음 탐색
                    //결국 사이클이 형성된다면
                    if (checkCycle(cur, i)){

                        //이미 다음 노드가 사이클이어서 거리가 0이라고 적혀있다면
                        //(다음 노드가 사이클의 시작 부분이라면)
                        if (distance[i] == 0){
                            //현재 노드는 사이클 시작 노드의 이전 노드
                            //사이클이 포함되지 않음
                            //1 2 3 4로 구성된 그래프에서 1-2 연결되고 234는 사이클로
                            //구성된 것을 예로 들면 됨
                            cycle[cur] = false;
                            return false;
                        }else{
                            //사이클을 돌면서 사이클에 해당하는 노드의 거리는 0
                            distance[i] = 0;
                            q.add(i);
                            return true;
                        }
                    }
                }
            }
        }

        //현재 노드로부터 시작하여 끝까지 돌았을 때 결국 자기 자신을 못 만난다면
        //이는 사이클이 아님. false 반환
        cycle[cur] = false;
        return false;
    }

    static void measureBFS(){
        int count = 1;
        //사이클에 포함된 노드들이 큐에 저장됨
        while (!q.isEmpty()){
            int len = q.size();

            //큐의 사이즈만큼 반복.
            //왜 while 아래에서 바로 q.poll하지 않고
            //for을 하나 생성해서 큐 사이즈만큼 반복하냐면
            //사이클로부터 노드들의 거리를 재야하기 때문
            //큐 한 번 다 비우는 것이 거리 1 증가하는 것임
            for (int i = 0; i < len; i++){
                int poll = q.poll();

                for (int j = 1; j <= n; j++){
                    if(map[poll][j]){
                        //사이클에 포함되지 않은 노드일 경우에만
                        if (distance[j] == -1){
                            //거리 계산
                            distance[j] = count;
                            q.add(j);
                        }
                    }
                }
            }
            count++;
        }
    }
}
