

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t ++) {
            sb.append("#").append(t).append(" ");
            //입력값받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] timeClient = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                timeClient[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(timeClient); //시간은 순서대로 정렬.
            int maxTime = timeClient[n-1]; //손님이 오는 최대시간
            // m초의 시간마다 k개의 붕어빵 만들기.
            // 붕어빵 재고 초기화
            int[] stockFishBread = new int[maxTime+1];

            int clientIdx = 0; // 클라이언트 방문 시간을 순회하는 idx
            boolean isFine = true; // 결과에 대한 boolean

            for(int time=1; time<=maxTime; time++){
                stockFishBread[time] += stockFishBread[time-1]; //재고는 이전 시간을 함께 고려한다.

                //붕어빵은 m초마다 k개만들어진다.
                if(time%m == 0){// 현재 시간이 m초의 배수라면
                    stockFishBread[time]+=k; //k개의 붕어빵을 추가.
                }

                //만약 현재 시간이 손님이 방문한 시간이라면
                if(time == timeClient[clientIdx]){
                    stockFishBread[time]--; // 재고를 하나 뺀다.

                    //이 때, 만약 재고가 0보다 작아진다면 실패.
                    if(stockFishBread[time]<0) {
                        isFine = false;
                        break;
                    }
                    clientIdx++; //다음 손님!
                }
            }
            if(timeClient[0] == 0){
                sb.append("Impossible").append("\n");
            }else{
                if(isFine){//모든손님이 다 괜찮으면
                    sb.append("Possible").append("\n");
                }else{
                    sb.append("Impossible").append("\n");
                }
            }

            
        }//for - test
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }//main()
}
