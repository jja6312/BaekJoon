import java.io.*;
import java.util.StringTokenizer;

//행, 열, 대각선 합 중 최대값 구하기.

//================ 문제 접근 ================
// 상하좌우대각을 더해서 최대값을 구하자!
public class Solution {
    static int[][] arr = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for(int test=1; test<=10; test++){//테스트케이스 10번 돌린다.
            StringBuilder sb = new StringBuilder();

            br.readLine(); // 테스트케이스 입력은 무의미한 데이터이므로 없앤다.
            sb.append("#").append(test).append(" ");
            int max = Integer.MIN_VALUE; //int의 최소값으로 할당.(최대값 비교를 위해)

            //배열초기화
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //배열을 순회하며
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    int rowSum = sumRow(i);//열 총합
                    int colSum = sumCol(j);//행 총합
                    int crossSum1 = sumCross1(i,j);//대각1(좌상우하) 총합
                    int crossSum2 = sumCross2(i,j);//대각2(좌하우상) 총합
                    max = Math.max(max,rowSum);
                    max = Math.max(max,colSum);
                    max = Math.max(max,crossSum1);
                    max = Math.max(max,crossSum2);
                }
            }
            sb.append(max).append("\n");

            bw.write(sb.toString());

        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static int sumCross2(int y, int x) {
        int sum = 0;
        for(int i=0; i<100; i++){
            sum+= arr[i][i];//주대각선
        }
        return sum;
    }

    private static int sumCross1(int y, int x) {
        int sum = 0;
        for(int i=0; i<100; i++){
            sum+= arr[i][99-i];//반대각선
        }
        return sum;
    }

    private static int sumCol(int x) {
        int sum = 0;
        for(int i=0; i<100; i++){
            sum += arr[i][x];
        }
        return sum;
    }

    private static int sumRow(int y) {
        int sum = 0;
        for(int i=0; i<100; i++){
            sum += arr[y][i];
        }
        return sum;
    }
}
