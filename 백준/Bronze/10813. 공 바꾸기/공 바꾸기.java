import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer N = Integer.valueOf(st.nextToken());
        Integer M = Integer.valueOf(st.nextToken());
        Integer [] arr = new Integer[N];
        //배열초기화
        for(int l=0; l<N; l++){
            arr[l]=l+1;
        }//for
        
        //M번 바꾸는작업을 실행한다.
        for(int l=0; l<M; l++){
            //한 번 바꿀때마다 일어나는 일
            st = new StringTokenizer(br.readLine(), " ");
            Integer i = Integer.valueOf(st.nextToken())-1;
            Integer j = Integer.valueOf(st.nextToken())-1;
            int buffer = arr[i];
            arr[i]= arr[j];
            arr[j] = buffer;
        }//for
        for(int l=0; l<N;l++){
            bw.write(""+arr[l]+" ");
        }//for
        bw.flush();
        bw.close();
        br.close();
    }//main()
}//Main
/*
도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다.
바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.

도현이는 앞으로 M번 공을 바꾸려고 한다. 도현이는 공을 바꿀 바구니 2개를 선택하고,
두 바구니에 들어있는 공을 서로 교환한다.

공을 어떻게 바꿀지가 주어졌을 때,
M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.
*/