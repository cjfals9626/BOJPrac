import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {

    static boolean[][] visited = new boolean[1001][1001];//[clipboard][screen]

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int s = scan.nextInt();

        bfs(s);
    }

    public static void bfs(int s) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1));
        visited[0][1] = true;

        int second = 0;
        System.out.println(q.size());
        while(!q.isEmpty()) {
            int size = q.size();
            for (int loop = 0; loop < size; loop++) {
                Node current = q.poll();

                if(current.screen == s) {
                    System.out.println(second);
                    return;
                }


                // 1. 화면에 있는 이모티콘 클립보드에 저장
                q.offer(new Node(current.screen, current.screen));

                // 2. 클립보드에 있는 이모티콘 붙여넣기.
                // 클립보드 비어있지 않아야하고, 붙여넣은 후 개수가 총 개수보다 적어야 하며, 이전에 방문한적 없어야함.
                if(current.clipboard != 0 && current.screen + current.clipboard <= s && !visited[current.clipboard][current.screen + current.clipboard]) {
                    q.offer(new Node(current.clipboard, current.screen + current.clipboard));
                    visited[current.clipboard][current.screen + current.clipboard] = true;
                }

                // 3. 화면에 있는 이모티콘 중 하나 삭제.
                // 총 개수 1보다 크거나 같아야하고, 방문한적 없어야함.
                if(current.screen >= 1 && !visited[current.clipboard][current.screen - 1]) {
                    q.offer(new Node(current.clipboard, current.screen - 1));
                    visited[current.clipboard][current.screen - 1] = true;
                }
            }
            second++;
        }
    }

    public static class Node {
        int clipboard;
        int screen;

        public Node(int clipboard, int total) {
            this.clipboard = clipboard;
            this.screen = total;
        }
    }
}
