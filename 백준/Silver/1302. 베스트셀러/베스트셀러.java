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
        //arrayList로 받고, sort.
        //sort해서 순서대로, 그다음과 지금의단어가 같은지 체크.
        //같다면, sum을 ++시키고 그게 max값보다 크다면 max에 sum값을 할당.
        //이작업과 동시에 글자를 result에 저장시킴.
        
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        if(N==1) {
        	bw.write(arr[0]);
        	return;
        }
        Arrays.sort(arr);
        
        int max=0;
        int sum=0;
        String result = null;
        
        for(int i=0; i<N-1; i++){
            
            if(arr[i].equals(arr[i+1])){
                sum++;
                if(max<sum){
                    max = sum;
                    result = arr[i+1];
                    
                }
            }else{
                sum = 0;
            }//else
            
        }//for
        if(result==null){
            result=arr[0];
        }
        
        bw.write(result);
        
    }//read()
}//Main