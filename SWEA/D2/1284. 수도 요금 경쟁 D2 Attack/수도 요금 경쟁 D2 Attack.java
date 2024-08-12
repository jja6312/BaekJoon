

import java.io.*;
import java.util.StringTokenizer;

// =============== 문제 접근 ===============
// A사 : 리터당 P원
// B사 : 기본요금 Q원(월간 사용량 R리터 이하), 초과리터당 S원

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            sb.append("#").append(test).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int min = Integer.MAX_VALUE;
            int companyA = p * w;
            int companyB = calCompanyB(w,q,r,s);
            min = Math.min(companyA, companyB);

            sb.append(min).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int calCompanyB(int w, int q, int r, int s) {
        if(w <= r){ // 기준 리터 r보다 적게 사용했다면
            return q;// q 원 지불.
        }else{// 더 많이 사용했다면
            return q + s * (w-r);
        }

    }
}
