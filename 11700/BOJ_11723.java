import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int S = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            int num = 0;
            if (!(op.equals("all") || op.equals("empty"))){
                num = Integer.parseInt(st.nextToken());
            }

            switch (op){
                case "add" :
                    S = S | (1 << num);
                    break;
                case "remove" :
                    S = S & ~(1 << num);
                    break;
                case "check" :
                    if ((S & (1 << num)) != 0){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "toggle" :
                    S = S ^ (1 << num);
                    break;
                case "all" :
                    for (int j = 0; j < 21; j++){
                        S = S | (1 << j);
                    }
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
