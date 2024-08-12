

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++){
            sb.append(changeDash(i)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String changeDash(int num) {
        String str = num+"";
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '3'
                || str.charAt(i) == '6'
                || str.charAt(i) == '9'){
                cnt++;
            }
        }
        if(cnt!=0){// 3,6,9가 있는 경우
            for(int i=0; i<cnt; i++){
                sb.append("-"); //그 개수만큼 - 작성
            }
        }else{
            sb.append(num);//그게아니라면 그냥 숫자.
        }
        return sb.toString();
    }
}
