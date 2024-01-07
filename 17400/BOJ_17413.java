import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        boolean isTag = false;

        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (cur == '<'){
                isTag = true;
                int size = stack.size();
                for (int j = 0; j < size; j++){
                    sb.append(stack.pop());
                }
            }
            if (isTag){
                sb.append(cur);
            }else if (cur == ' '){
                int size = stack.size();
                for (int j = 0; j < size; j++){
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else{
                stack.push(cur);
            }
            if (cur == '>'){
                isTag = false;
            }

        }

        int size = stack.size();
        for (int j = 0; j < size; j++){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
