import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long X = Long.valueOf(br.readLine());
        
        long countSum=0;
        long i=0;
        while(X>countSum){
            i++;
            countSum += i;
        }
        
        if(i%2==0){
            bw.write(""+(i-(countSum-X))+"/"+(1+(countSum-X)));
        }else{
            bw.write(""+(1+(countSum-X))+"/"+(i-(countSum-X)));
        }
        bw.flush();
        bw.close();
        br.close();
        /*
        
        
        <풀었는데 위에서 아래로 이동하는 로직으로 짰다..ㅠ 왓다갓다구나>
        X=1, i=1, countSum =1
        X=3, i=1, cS=1
             i=2, cS=3
             
             이게 i=1에서는 분자분모 합이 2고, i=2에서는 합이 3이고, ... 반복한다.
             X가 8이라면, 8은 i의 몇번째인지 체크하자.
             그럼 i값이 나올것이다.
             그리고 그 i값에서 countSum값 - X값으로, 순서를 구하자.
             만약 X=5라고 했을 때, countSum은 123의 합 6이다.
             이 때, countSum - X = 1이다.
             즉, 6번째 값은 가장 왼쪽 끝에 있는 값이고, 거기서 한 칸 당긴 값을 구하면 된다.
             123은 i가 3이다.
             즉, 분자+분모 = 4인 값이다.
             가장 왼쪽의 숫자는 i-(countSum-X)/1+(countSum-X)
             
             
        */
    }
}