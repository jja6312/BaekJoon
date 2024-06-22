import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] arr = new char[C];
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);  // 알파벳 순으로 정렬
        combination(arr, new char[L], 0, 0, L);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void combination(char[] arr, char[] chosen, int start, int depth, int L) throws IOException {
        if (depth == L) {
            if (isValid(chosen)) {
                bw.write(chosen);
                bw.write("\n");
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            chosen[depth] = arr[i];
            combination(arr, chosen, i + 1, depth + 1, L);
        }
    }

    private static boolean isValid(char[] chosen) {
        int vowels = 0;
        int consonants = 0;
        for (char c : chosen) {
            if (isVowel(c)) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return vowels >= 1 && consonants >= 2;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
