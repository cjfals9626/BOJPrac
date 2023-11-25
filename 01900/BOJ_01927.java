import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if (num == 0){
                Integer poll = priorityQueue.poll();
                if (poll == null){
                    sb.append(0).append('\n');
                }else{
                    sb.append(poll).append('\n');
                }
            }else {
                priorityQueue.add(num);
            }
        }

        System.out.println(sb);
    }
}