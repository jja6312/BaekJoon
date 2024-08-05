import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        String A = br.readLine();
        st = new StringTokenizer(A, " ");

        int n = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        String B = br.readLine();

        int[] conditionArr = new int[4];
        String C = br.readLine();
        st = new StringTokenizer(C, " ");
        for(int i=0; i<4; i++){
            conditionArr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = range - 1;
        int cnt = 0;
        int[] checkArr = new int[4];
        for(int i=lt; i<=rt; i++){
            if(B.charAt(i)=='A') checkArr[0]++;
            else if(B.charAt(i)=='C') checkArr[1]++;
            else if(B.charAt(i)=='G') checkArr[2]++;
            else if(B.charAt(i)=='T') checkArr[3]++;
        }

        while(rt < n){ // 수정된 부분: 종료 조건을 `rt < n`으로 변경
            boolean isTrue = true;
            for(int i=0; i<4; i++){
                if(conditionArr[i] > checkArr[i]){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue) cnt++;

            if(rt + 1 < n){ // 마지막 윈도우 처리를 위한 조건 추가
                if(B.charAt(lt) == 'A') checkArr[0]--;
                else if(B.charAt(lt) == 'C') checkArr[1]--;
                else if(B.charAt(lt) == 'G') checkArr[2]--;
                else if(B.charAt(lt) == 'T') checkArr[3]--;
                lt++;

                rt++;
                if(B.charAt(rt) == 'A') checkArr[0]++;
                else if(B.charAt(rt) == 'C') checkArr[1]++;
                else if(B.charAt(rt) == 'G') checkArr[2]++;
                else if(B.charAt(rt) == 'T') checkArr[3]++;
            } else {
                // 마지막 문자까지 처리가 끝났으므로 루프를 빠져나옵니다.
                break;
            }
        }

        bw.write(""+cnt);
        bw.flush();
        bw.close();
        br.close();
    }
}
