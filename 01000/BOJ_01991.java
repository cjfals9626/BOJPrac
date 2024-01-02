import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        Node[] tree = new Node[n];

        tree[0] = new Node('A');

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parentVal = st.nextToken().charAt(0);
            char leftVal = st.nextToken().charAt(0);
            char rightVal = st.nextToken().charAt(0);

            if (leftVal != '.') {
                tree[leftVal - 'A'] = new Node(leftVal);
                tree[parentVal - 'A'].setLeft(tree[leftVal - 'A']);
            }

            if (rightVal != '.') {
                tree[rightVal - 'A'] = new Node(rightVal);
                tree[parentVal - 'A'].setRight(tree[rightVal - 'A']);
            }
        }
        preOrder(tree[0]);
        sb.append('\n');
        inOrder(tree[0]);
        sb.append('\n');
        postOrder(tree[0]);
        System.out.println(sb);

    }

    static void preOrder(Node cur) {
        if (cur != null) {
            sb.append(cur.getVal());
            preOrder(cur.getLeft());
            preOrder(cur.getRight());
        }
    }

    static void inOrder(Node cur) {
        if (cur != null) {
            inOrder(cur.getLeft());
            sb.append(cur.getVal());
            inOrder(cur.getRight());
        }
    }

    static void postOrder(Node cur) {
        if (cur != null) {
            postOrder(cur.getLeft());
            postOrder(cur.getRight());
            sb.append(cur.getVal());
        }
    }

    static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
            left = null;
            right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public char getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
