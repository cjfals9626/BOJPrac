import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static List<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op){
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop" :
                    sb.append(pop()).append('\n');
                    break;
                case "size" :
                    sb.append(size()).append('\n');
                    break;
                case "empty" :
                    sb.append(empty()).append('\n');
                    break;
                case "front" :
                    sb.append(front()).append('\n');
                    break;
                case "back" :
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);

    }
    static void push(int num){
        q.add(num);
    }
    static int pop(){
        if (q.size() > 0){
            return q.remove(0);
        }else{
            return -1;
        }
    }
    static int size(){
        return q.size();
    }
    static int empty(){
        if (q.size() > 0){
            return 0;
        }else{
            return 1;
        }
    }
    static int front(){
        if (q.size() > 0){
            return q.get(0);
        }else{
            return -1;
        }
    }
    static int back(){
        if (q.size() > 0){
            return q.get(q.size()-1);
        }else{
            return -1;
        }
    }
}