import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int length = str.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch == 'c' && i < length - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (ch == 'd' && i < length - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                } else if (i < length - 2 && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                    i += 2;
                }
            } else if ((ch == 'l' || ch == 'n') && i < length - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if ((ch == 's' || ch == 'z') && i < length - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            count++;
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
}