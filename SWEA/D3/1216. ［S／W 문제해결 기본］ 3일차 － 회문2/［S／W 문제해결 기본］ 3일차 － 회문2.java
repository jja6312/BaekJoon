import java.io.*;
// ============ 문제 사고 과정 ============
// char[][] arr를 만들어서, 문자를 저장한다.
// arr를 순회하며, 오른쪽과 아래방향으로 회문의 최대길이를 확인한다.
// 최대 길이를 비교하고 저장한다.
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int test = 1; test<=10; test++){
            int tc = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append(" ");
            char[][] arr = new char[100][100]; // char 배열 선언

            //배열 초기화
            for(int i=0; i<100; i++){
                String A = br.readLine();
                for(int j=0; j<100; j++){
                    arr[i][j] = A.charAt(j);
                }
            }

            //오른쪽과 아래방향으로 회문 탐색
            int max = Integer.MIN_VALUE;
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    int down = checkPalinDown(i,j,arr);
                    int right = checkPalinRight(i,j,arr);
                    max = Math.max(max,down);
                    max = Math.max(max,right);
                }
            }

            sb.append(max).append("\n");
        }//testCase
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }

    private static int checkPalinRight(int y, int x, char[][] arr) {
        int start = x;
        int end = 99;
        while(start<=end){ // end를 1씩 줄여나가서, 가장 긴 값을 찾으면 빠져나와야하는 while
            if(arr[start][x] != arr[end][x]){
                end--;
                continue;
            }//시작과 끝 문자열이 서로 다르다면 검사조차 하지마라!시간아깝다.

            int inspectorStart = start;//검사하는 역할(start부터 1씩 늘어나며 찾는 역할.)
            int inspectorEnd = end; //검사하는 역할(end부터 1씩 줄어들며 찾는 역할.)
            boolean isFind = false;
            while(inspectorStart<=inspectorEnd){
                if(arr[y][inspectorStart] != arr[y][inspectorEnd]) {
                    end--; // 가장 길게 검사한 문자열이 팰린드롬이 아니면, 조금더 짧게 검사해본다.
                    break;
                }
                if((inspectorEnd - inspectorStart)<=1){ // 끝idx와 시작idx가 1이하(마지막 검사 순서)라면
                    isFind = true;//찾았다!
                }

                inspectorStart++;
                inspectorEnd--;

            }
            if(isFind){//찾았다면?
                return end-start+1;//최대길이 반환
            }
        }


        return 0;
    }

    private static int checkPalinDown(int y, int x, char[][] arr) {

        int start = y;
        int end = 99;

        while(start<=end){ // end를 1씩 줄여나가서, 가장 긴 값을 찾으면 빠져나와야하는 while
            if(arr[start][x] != arr[end][x]){
                end--;
                continue;
            }//시작과 끝 문자열이 서로 다르다면 검사조차 하지마라!시간아깝다.

            int inspectorStart = start;//검사하는 역할(start부터 1씩 늘어나며 찾는 역할.)
            int inspectorEnd = end; //검사하는 역할(end부터 1씩 줄어들며 찾는 역할.)
            boolean isFind = false;
            while(inspectorStart<=inspectorEnd){
                if(arr[inspectorStart][x] != arr[inspectorEnd][x]) {
                    end--; // 가장 길게 검사한 문자열이 팰린드롬이 아니면, 조금더 짧게 검사해본다.
                    break;
                }
                if((inspectorEnd - inspectorStart)<=1){ // 끝idx와 시작idx가 1이하(마지막 검사 순서)라면
                    isFind = true;//찾았다!
                }

                inspectorStart++;
                inspectorEnd--;

            }
            if(isFind){//찾았다면?
                return end-start+1;//최대길이 반환
            }
        }


        return 0;//못찾으면 0
    }
}
