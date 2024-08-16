

import java.io.*;
import java.util.StringTokenizer;

// =============== 문제 접근 ===============
// 주사위를 위 아래를 붙여놓고, 나머지 수 중 가장 큰 수를 더해나가면 될 듯?
// 주사위 개수는 10,000 개.

// A가 위로 가는 경우의 수
// 1. 첫 번째 줄의 A의 반대편은 F (0,5)
// 2. 두 번째 줄의 C의 반대편은 E (2,4)

// F가 위로 가는 경우의 수
// 1. 첫 번째 줄의 A의 반대편은 F (0,5)
// 2. 두 번째 줄의 D의 반대편은 B (1,3)

// 가장 아래줄의 A가 위로가는경우와 아래로가는 경우 두개로 시작해서,
// 각 층별로 위아래를 지우고 가장높은 숫자를 더해나간다.

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static int n;
    static int top;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][6];
        // 0. arr 초기화
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 0번주사위의 0(A)번째가 맨아래층의 윗면으로 시작한 경우
        top = arr[0][0];
        int[] exceptNum = new int[2];
        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<6; j++){//현재 주사위를 살펴보며, 직전 주사위의 위와 현주사위의 아래를 매칭시킨다.
                if(setTopAndExceptNum(i,j,exceptNum)) break; // 직전주사위의 위 숫자를 현주사위에서 찾으면, top과 exceptNum을 초기화하고 break;
            }
            //exceptNum 을 제외한 숫자 중 가장 큰 수는?
            int max = 0;
            for(int j=0; j<6; j++){
                if(j==exceptNum[0] || j==exceptNum[1]) continue;// 위아래 숫자는 넘어간다.
                if(max<arr[i][j]) max = arr[i][j];
            }
            sum+=max;
        }//for

        // 2. 0번주사위의 5(F)번째가 맨아래층의 윗면으로 시작한 경우
        top = arr[0][5];
        exceptNum = new int[2];
        int sum2 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<6; j++){//현재 주사위를 살펴보며, 직전 주사위의 위와 현주사위의 아래를 매칭시킨다.
                if(setTopAndExceptNum(i,j,exceptNum)) break; // 직전주사위의 위 숫자를 현주사위에서 찾으면, top과 exceptNum을 초기화하고 break;
            }
            //exceptNum 을 제외한 숫자 중 가장 큰 수는?
            int max = 0;
            for(int j=0; j<6; j++){
                if(j==exceptNum[0] || j==exceptNum[1]) continue;// 위아래 숫자는 넘어간다.
                if(max<arr[i][j]) max = arr[i][j];
            }
            
            sum2+=max;
        }//for
        // 3. 0번주사위의 2(B)번째가 맨아래층의 윗면으로 시작한 경우
        top = arr[0][1];
        exceptNum = new int[2];
        int sum3 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<6; j++){//현재 주사위를 살펴보며, 직전 주사위의 위와 현주사위의 아래를 매칭시킨다.
                if(setTopAndExceptNum(i,j,exceptNum)) break; // 직전주사위의 위 숫자를 현주사위에서 찾으면, top과 exceptNum을 초기화하고 break;
            }
            //exceptNum 을 제외한 숫자 중 가장 큰 수는?
            int max = 0;
            for(int j=0; j<6; j++){
                if(j==exceptNum[0] || j==exceptNum[1]) continue;// 위아래 숫자는 넘어간다.
                if(max<arr[i][j]) max = arr[i][j];
            }

            sum3+=max;
        }//for
        // 4. 0번주사위의 3(C)번째가 맨아래층의 윗면으로 시작한 경우
        top = arr[0][2];
        exceptNum = new int[2];
        int sum4 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<6; j++){//현재 주사위를 살펴보며, 직전 주사위의 위와 현주사위의 아래를 매칭시킨다.
                if(setTopAndExceptNum(i,j,exceptNum)) break; // 직전주사위의 위 숫자를 현주사위에서 찾으면, top과 exceptNum을 초기화하고 break;
            }
            //exceptNum 을 제외한 숫자 중 가장 큰 수는?
            int max = 0;
            for(int j=0; j<6; j++){
                if(j==exceptNum[0] || j==exceptNum[1]) continue;// 위아래 숫자는 넘어간다.
                if(max<arr[i][j]) max = arr[i][j];
            }

            sum4+=max;
        }//for
        // 5. 0번주사위의 4(D)번째가 맨아래층의 윗면으로 시작한 경우
        top = arr[0][3];
        exceptNum = new int[2];
        int sum5 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<6; j++){//현재 주사위를 살펴보며, 직전 주사위의 위와 현주사위의 아래를 매칭시킨다.
                if(setTopAndExceptNum(i,j,exceptNum)) break; // 직전주사위의 위 숫자를 현주사위에서 찾으면, top과 exceptNum을 초기화하고 break;
            }
            //exceptNum 을 제외한 숫자 중 가장 큰 수는?
            int max = 0;
            for(int j=0; j<6; j++){
                if(j==exceptNum[0] || j==exceptNum[1]) continue;// 위아래 숫자는 넘어간다.
                if(max<arr[i][j]) max = arr[i][j];
            }

            sum5+=max;
        }//for
        // 5. 0번주사위의 5(E)번째가 맨아래층의 윗면으로 시작한 경우
        top = arr[0][4];
        exceptNum = new int[2];
        int sum6 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<6; j++){//현재 주사위를 살펴보며, 직전 주사위의 위와 현주사위의 아래를 매칭시킨다.
                if(setTopAndExceptNum(i,j,exceptNum)) break; // 직전주사위의 위 숫자를 현주사위에서 찾으면, top과 exceptNum을 초기화하고 break;
            }
            //exceptNum 을 제외한 숫자 중 가장 큰 수는?
            int max = 0;
            for(int j=0; j<6; j++){
                if(j==exceptNum[0] || j==exceptNum[1]) continue;// 위아래 숫자는 넘어간다.
                if(max<arr[i][j]) max = arr[i][j];
            }

            sum6+=max;
        }//for
        int answer = Math.max(sum, Math.max(sum2,Math.max(sum3,Math.max(sum4,Math.max(sum5,sum6)))));
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();




    }

    private static boolean setTopAndExceptNum(int i,int j, int[] exceptNum) {
        if(arr[i][j] == top){ // 현재 주사위 숫자가 직전 주사위 윗면과 같다면

            if(j==0){// 0(A) 이라면 5(F)번째와 함께 나가리.
                exceptNum[0] = 0;
                exceptNum[1] = 5;
                top = arr[i][5];//현재 주사위 숫자의 반대편을 top으로 초기화한다.
            }else if(j==5){
                exceptNum[0] = 0;
                exceptNum[1] = 5;
                top = arr[i][0];//현재 주사위 숫자의 반대편을 top으로 초기화한다.
            }else if(j==1){// 1(B) 이라면 3(D)번째와 함께 나가리.
                exceptNum[0] = 1;
                exceptNum[1] = 3;
                top = arr[i][3];
            }else if(j==3){// 1(B) 이라면 3(D)번째와 함께 나가리.
                exceptNum[0] = 1;
                exceptNum[1] = 3;
                top = arr[i][1];
            }else if(j==2){// 2(C) 이라면 4(E)번째와 함께 나가리.
                exceptNum[0] = 2;
                exceptNum[1] = 4;
                top = arr[i][4];
            }else if(j==4){// 2(C) 이라면 4(E)번째와 함께 나가리.
                exceptNum[0] = 2;
                exceptNum[1] = 4;
                top = arr[i][2];
            }


            return true;//찾았다~ 이제 break
        }
        return false;//못찾았다.. 다음으로계속
    }
}
