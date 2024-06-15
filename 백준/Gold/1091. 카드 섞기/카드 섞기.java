import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] P = new int[n];
        int[] S = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] card = new int[n];
        int[] originCard = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = i;
            originCard[i] = i;
        }

        int cnt = 0;
        while (true) {
            if (isSameArray(card, P)) {
                bw.write(cnt + "\n");
                break;
            }
            card = shuffleCard(card, S);
            cnt++;

            if (cnt != 0 && Arrays.equals(card, originCard)) {
                bw.write("-1\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isSameArray(int[] card, int[] P) {
        for (int i = 0; i < n; i++) {
            int x = card[i];
            if(P[x]!=i%3) return false;
        }
        return true;
    }

    private static int[] shuffleCard(int[] card, int[] S) {
        int[] newCard = new int[n];
        for (int i = 0; i < n; i++) {
            newCard[S[i]] = card[i];
        }
        return newCard;
    }
}
