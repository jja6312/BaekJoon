

import java.io.*;
import java.util.StringTokenizer;

// ====================== 문제 접근 ======================
// 현재 p 4에서, 한계값 6이라고했을 떄, 10이 늘어난다면?
// 6까지 2늘어나고, 다시 0까지 6 줄어들고, 남은 2가 다시 0에서 늘어날 것이다.

// (p+t)/w 가 0이라면, 그대로출력.
// (p+t)/w 가 홀수라면, (p+t)%w만큼 p값에서 빼준다.
// (p+t)/w 가 짝수라면, (p+t)%w만큼 0값에서 더해준다.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken()); //6,4
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int gongSic = (p+t)/w;
        if( gongSic == 0) {
            bw.write((p+t)+" ");
        }else if(gongSic % 2 == 1){
            bw.write((w - (p+t)%w)+" ");
        }else if(gongSic % 2 == 0){
            bw.write((p+t)%w+" ");
        }

        int gongSic2 = (q+t)/h;
        if( gongSic2 == 0) {
            bw.write((q+t)+"\n");
        }else if(gongSic2 % 2 == 1){
            bw.write((h - (q+t)%h)+"\n");
        }else if(gongSic2 % 2 == 0){
            bw.write((q+t)%h+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
