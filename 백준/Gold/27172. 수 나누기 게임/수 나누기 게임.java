import org.w3c.dom.Node;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int NOT_CARD=777777777;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        int max=0;
        for(int i=0; i<n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }

        int[] point = new int[max+1];
        Arrays.fill(point,NOT_CARD);

        for(int i=0; i<n; i++){
            int card = arr[i];//카드는
            point[card] = 0;// 카드가 있는 배열에 순번을 매긴다.
        }
        //즉 point배열의 card번째에, 카드의 점수가 있다.
        //나머지는 NOT_CARD로 되어있다.

        for(int i=1; i<=max; i++){
            //만약 NOT_CARD라면 넘어가기
            if(point[i]==NOT_CARD) continue;

            int cnt=0;
            //카드라면, 그 배수들에 - 해준다.
            for(int cardMul=2*i; cardMul<=max; cardMul+=i){
                if(point[cardMul]==NOT_CARD) continue;
                point[cardMul]--;
                cnt++;
            }
            //연산을 끝내고, 카운팅을 본인에게 +해준다.
            point[i] += cnt;
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = point[arr[i]];
            bw.write(result[i]+" ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }//main()

}//Main Class
