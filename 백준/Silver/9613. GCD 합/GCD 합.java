import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[]args) throws IOException{
        read();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        StringTokenizer st;
        int moreSmaller;
        int N = Integer.parseInt(br.readLine());
        
        for(int n=0; n<N; n++){
            String A = br.readLine();
           
            st = new StringTokenizer(A, " ");
            int testCase = Integer.parseInt(st.nextToken());
            int [] arrayList = new int[testCase];
            int[] intArr = new int[1000001];
            for(int i=0; i<testCase; i++) {
            	arrayList[i]=Integer.parseInt(st.nextToken());
            }
            long sum=0;
            for(int i=0; i<arrayList.length-1; i++){
            	for(int j=i+1; j<arrayList.length;j++) {
            		sum+=gcd(arrayList[i], arrayList[j]);
            	}
            }//for2
            
            bw.write(sum+"\n");
            //최대공약수
            //소인수분해 했을 때 겹치는 가장 큰 수
            //최대공약수 구하는 법
            //1~본인의 값까지 %가 0인 수를 양쪽에서 확인.
            //따라서 배열을 둘 중 큰 수로 잡고, 1 씩 value를 ++ 하는방식으로 한다.
            //2인 녀석은 공통된 약수.
            //뒤에서부터 셌을 때 2인녀석에서 break하면 최대공약수.
            
            
        }
    }//read()

	private static int gcd(int a, int b) {
		while(b>0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
}//Main