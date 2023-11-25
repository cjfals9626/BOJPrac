import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            if (o1.val == o2.val){
                return o1.sign - o2.sign;
            }else{
                return o1.val - o2.val;
            }
        }));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if (num == 0){
                Node poll = priorityQueue.poll();
                if (poll == null){
                    sb.append(0).append('\n');
                }else{
                    int valWithSig = poll.getValWithSig();
                    sb.append(valWithSig).append('\n');
                }
            }else {
                priorityQueue.add(new Node(Math.abs(num), num / Math.abs(num)));
            }
        }

        System.out.println(sb);
    }
    static class Node{
        int val;
        int sign;

        public Node(int val, int sign){
            this.val = val;
            this.sign = sign;
        }

        public int getValWithSig(){
            return val * sign;
        }
    }
}