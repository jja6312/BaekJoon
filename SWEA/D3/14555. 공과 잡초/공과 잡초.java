

import java.io.*;

// ================== 문제 접근 ==================
// '(' 가 나오면 +1
// ')' 가 나오면, 그 전에 '('가 아니었다면 +1
// 따라서 최근 값 정도는 저장하는 변수가 있으면 되겠다.
public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");
            String A = br.readLine();
            char last = '0';
            int cnt = 0;
            for (int i = 0; i < A.length(); i++) {
                char current = A.charAt(i);
                if (current == '(') {
                    cnt++;
                } else if (current == ')' && last != '(') {
                    cnt++;
                }
                last = current;
            }
            sb.append(cnt).append("\n");
        }//for - test
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }//main()
}//Class
