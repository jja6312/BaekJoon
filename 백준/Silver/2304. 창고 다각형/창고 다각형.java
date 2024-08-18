

import java.io.*;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// =================== 문제 접근 ===================
// 물이 고이지 않게 구성해야한다.
// 따라서, 기둥이 가장 높은 위치를 기준으로 왼쪽과 오른쪽은 지붕이 점차 낮아져야 한다.
// 중요한 것은 '점차'낮아져야 한다. 따라서 '가장 높은 기둥에서 그 다음으로 높은 기둥까지' 지붕이 씌워진다.

// 결과 = 왼쪽 + 중간 + 오른쪽 너비의 합이 될 것이다.
// 왼쪽은 재귀적으로 왼쪽을 계속해서 호출해야 한다.(자기보다 낮은 값을 만날때까지 반복.)
// 오른쪽은 재귀적으로 오른쪽을 계속해서 호출해야 한다. (자기보다 낮은 값을 만날때까지 반복.)


// 시간복잡도는 O(n^2)으로 풀어야 한다.
// 구현해보자.

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr = new int[1001];//위치 최대값 1000
    static PriorityQueue<KiDoong> leftKiDoong = new PriorityQueue<>();//왼쪽 기둥의 높이순 내림차순 큐
    static PriorityQueue<KiDoong> rightKiDoong = new PriorityQueue<>();//오른쪽 기둥의 높이순 내림차순 큐

    static class KiDoong implements Comparable<KiDoong>{
        int h;
        int idx;

        public KiDoong(int h, int idx){
            this.h=h;
            this.idx=idx;
        }
        @Override
        public int compareTo(KiDoong o){
            return o.h-h;  //높이가 높은것부터 내림차순
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        int max = -1;
        int maxIdx = -1;

        // 0. 변수 입력 받기
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(max<h){ //최대값 저장.(최대값 기준으로 좌 우를 살필 예정.)
                max = h;
                maxIdx = idx;
            }

            arr[idx] = h;//배열에 높이 할당
        }

        // 왼쪽 기둥을 높이 내림차순 순으로 정렬.
        for(int i=0; i<maxIdx; i++){
            if(arr[i]!=0){ //기둥은 높이가 0이 아님.
                leftKiDoong.offer(new KiDoong(arr[i],i));//높이와 순서를 저장.
            }
        }
        //오른쪽 기둥 높이 내림차순 순으로 정렬.
        for(int i=maxIdx+1; i<1001; i++){
            if(arr[i]!=0){ //기둥은 높이가 0이 아님.
                rightKiDoong.offer(new KiDoong(arr[i],i));//높이와 순서를 저장.
            }
        }

        // 1. 결과는 단순하게 아래처럼 표현될 수 있다.
        int sum = 0;
        sum += leftSum(maxIdx);// 최대 기둥의 왼쪽 면적을 재귀적으로 더해나간다.
        sum += max; // 최대 기둥 높이만큼의 면적
        sum += rightSum(maxIdx); // 최대 기둥의 오른쪽 면적을 재귀적으로 더해나간다.

        sb.append(sum).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 최대높이 기둥의 오른쪽 지붕 면접의 합
    private static int rightSum(int defaultIdx) {
        int sum = 0;
        while(!rightKiDoong.isEmpty()){

            KiDoong currentKiDoong = rightKiDoong.poll();
            int h = currentKiDoong.h; //가야할 최대높이 h
            int idx = currentKiDoong.idx; // 가야할 최대높이h의 idx

            if(idx < defaultIdx) continue; //현재 인덱스가 기준인덱스보다 왼쪽에있으면 안된다. 무조건 오른쪽으로만 체크.

            //오른쪽으로 정상적으로 있다면,
            int w = idx - defaultIdx;//가로길이는 현재 인덱스에서 기준 인덱스를 뺀 값.

            sum += h*w;//합계에 더한다.
            defaultIdx = idx; //기준 인덱스를 현재 인덱스로 업데이트
        }
        return sum;
    }

    // 최대높이 기둥의 왼쪽 지붕 면접의 합
    private static int leftSum(int defaultIdx) {

        // 현재 지붕이 가야할 최대높이의 기둥
        int sum = 0;
        while(!leftKiDoong.isEmpty()){

            KiDoong currentKiDoong = leftKiDoong.poll();
            int h = currentKiDoong.h; //가야할 최대높이 h
            int idx = currentKiDoong.idx; // 가야할 최대높이h의 idx

            if(idx > defaultIdx) continue; //현재 인덱스가 기준인덱스보다 오른쪽에있으면 안된다. 무조건 왼쪽으로만 체크.

            //왼쪽으로 정상적으로 있다면,
            int w = defaultIdx - idx;//가로길이는 기준 인덱스에서 현재의 인덱스를 뺀 값.

            sum += h*w;//합계에 더한다.
            defaultIdx = idx; //기준 인덱스를 현재 인덱스로 업데이트
        }

        return sum;
    }
}
