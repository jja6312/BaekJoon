import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        
        Integer N = Integer.valueOf(st.nextToken());
        Integer M = Integer.valueOf(st.nextToken());
        Integer [] arr = new Integer[N];
        Integer []arrBuffer = new Integer[N];

        for(int i=0; i<N; i++){
            arr[i]=i+1;
            arrBuffer[i]=i+1;
        }
        
        for(int x=0; x<M; x++){
            st = new StringTokenizer(br.readLine(), " ");
            int i= Integer.valueOf(st.nextToken())-1;
            int j= Integer.valueOf(st.nextToken())-1;
            
            for(int y=i; y<=j; y++){
                //첫번째 범위와 마지막범위가 서로 바뀌게된다.
                arr[y] = arr[j];
                arr[j] = arrBuffer[y];
                //arr와 똑같이생긴 배열을 초기화시킨다.
                arrBuffer[y] = arr[y];
                arrBuffer[j] = arr[j];
                //마지막범위(j)를 줄여서, (i+j)/2 만큼 연산이 일어나게 만든다.
                j--;
            }//for2 
        }//for1
        
        for(int z=0; z<N; z++){
            bw.write(arr[z]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }//main()
}//Main class