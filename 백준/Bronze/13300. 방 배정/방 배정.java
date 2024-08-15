import java.io.*;
import java.util.StringTokenizer;

// ======================= 문제 접근 =======================
// 성별에 따른 학년별 숫자를 카운팅한다.

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] manCntByLevels = new int[7]; // 1~6학년 남학생이 몇명인지?
    static int[] womanCntByLevels = new int[7]; // 1~6학년 여학생이 몇명인지?

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            if(sex == 0){//여학생이라면
                womanCntByLevels[level]++;
            }else if(sex == 1){//남학생이라면
                manCntByLevels[level]++;
            }
        }
        // 한 방의 최대값 k이므로, 반별 학생수를 k로 나눈값+1이 방 개수. 만약 나누어떨어진다면 나눈값이 방개수.
        int room = 0;
        //여자방
        for(int studentCnt : womanCntByLevels){
            if(studentCnt%k == 0){ //나누어떨어진다면
                room += studentCnt/k;
            }else{//나누어떨어지지 않는다면
                room += studentCnt/k + 1;
            }
        }
        // 남자방
        for(int studentCnt : manCntByLevels){
            if(studentCnt%k == 0){ //나누어떨어진다면
                room += studentCnt/k;
            }else{//나누어떨어지지 않는다면
                room += studentCnt/k + 1;
            }
        }

        sb.append(room);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
