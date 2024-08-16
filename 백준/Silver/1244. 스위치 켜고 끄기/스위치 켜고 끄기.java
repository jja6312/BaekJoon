

import java.io.*;
import java.util.StringTokenizer;

// ============= 문제 접근 =============
// 1. 남학생이 받은 스위치, 배수에 해당하는 스위치번호 토글하기.
// 2. 여학생이 받은 스위치, 좌우대칭으로 최장 길이를 찾아서 해당 범위 전부 토글하기.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringBuilder sb =new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine()); // 학생 수
        for(int i=0; i<m; i++){
            st=  new StringTokenizer(br.readLine());
            //1은 남자, 2는 여자
            int gender = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            if(gender == 1){
                manSwitch(switchNum);
            }else if(gender == 2){
                womanSwitch(switchNum);
            }
        }

        //출력
        int tmp = 0;
        for(int i=1; i<=n; i++){
            sb.append(arr[i]);
            if(i!=n) sb.append(" ");

            if(i/20 != tmp) sb.append("\n");// 출력형식을 맞추자.
            tmp = i/20;
            
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }//main()

    private static void womanSwitch(int num) {
        int lt = num-1;
        int rt = num+1;

        if(arr[num] == 1) arr[num] = 0;
        else arr[num] = 1;

        while(isBoundary(lt,rt) && arr[lt] == arr[rt]){
            if(arr[lt] == 1){
                arr[lt] = 0;
                arr[rt] = 0;
            }else{
                arr[lt] = 1;
                arr[rt] = 1;
            }
            lt--;
            rt++;
        }
    }

    private static void manSwitch(int num) {
        for(int i=num; i<=n; i+=num){
            if(arr[i]==1) arr[i] = 0;
            else arr[i] = 1;
        }
    }

    public static boolean isBoundary(int lt, int rt){
        return lt>=1 && lt<=n && rt>=1 && rt<=n;
    }
}
