import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Node>[] list;

    static class Node {
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int data = st.nextToken().charAt(0) - 'A' + 1;
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            list[data].add(new Node(left, right));
        }

        전위순회(1);
        bw.write("\n");
        중위순회(1);
        bw.write("\n");
        후위순회(1);
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();

    }


    private static void 전위순회(int start) throws IOException {
        for(Node node : list[start]){
            char data = (char)(start+'A'-1);
            char lt = node.left;
            char rt = node.right;

            bw.write(data+"");
            if(lt>=65 && lt<97) 전위순회(lt-'A'+1);
            if(rt>=65 && rt<97) 전위순회(rt-'A'+1);
        }
    }

    private static void 중위순회(int start) throws IOException {
        for(Node node : list[start]){
            char data = (char)(start+'A'-1);
            char lt = node.left;
            char rt = node.right;

            if(lt>=65 && lt<97) 중위순회(lt-'A'+1);
            bw.write(data+"");
            if(rt>=65 && rt<97) 중위순회(rt-'A'+1);
        }

    }

    private static void 후위순회(int start) throws IOException {
        for(Node node : list[start]){
            char data = (char)(start+'A'-1);
            char lt = node.left;
            char rt = node.right;


            if(lt>=65 && lt<97) 후위순회(lt-'A'+1);
            if(rt>=65 && rt<97) 후위순회(rt-'A'+1);
            bw.write(data+"");
        }
    }


}//Main Class
