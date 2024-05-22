import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt;

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;

        }

        @Override
        public int compareTo(Meeting o) {
            return end!=o.end ? end-o.end : start-o.start;
        }
    }


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(start,end));
        }
        //그순간에 가장 짧은애들을 선택해주자.
        Meeting firstMeeting = pq.poll();
        int compareEnd = firstMeeting.end;
        cnt++;

        while(!pq.isEmpty()){
            Meeting currentMeeting = pq.poll();
            int currentStart = currentMeeting.start;
            int currentEnd = currentMeeting.end;
            if(currentStart>=compareEnd){//이전에 추가한 시간표에서 회의끝시간보다 현재회의시작시간이 뒤에있다면
                cnt++;
                compareEnd = currentEnd;//다음 비교대상은 현재끝나는시간.
            }
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
