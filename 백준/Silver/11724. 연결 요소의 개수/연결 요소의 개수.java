import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;
    static boolean visited[];
    static int N;
    static int M;
    static ArrayList<Integer>[] A1;

    public static void main(String args[]) throws IOException {
        read();
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void read() throws IOException {
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        A1 = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A1[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A1[s].add(e);
            A1[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // DFS를 시작하기 전에 방문 여부를 확인
                count++;
                DFS(i);
            }
        }
    }

    static void DFS(int v) {
        visited[v] = true;
        for (int i : A1[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
