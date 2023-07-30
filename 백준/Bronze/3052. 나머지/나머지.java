import java.util.*;
import java.io.*;
public class Main{
    public static void main(String [] args ) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer a=0;
        Integer []arr = new Integer[10];
        for(int i=0; i<10; i++){
            a = Integer.valueOf(br.readLine());
            arr[i] = a%42;
        }//for
        
        //배열끼리 서로다른 나머지가 몇개인지 세는 로직을 짜야한다.
        //배열을 순회하며 전체를 비교하고, 값이 같다면 다른한녀석을 -1로 바꾸자.
        for(int i=0; i<10; i++){
            if(arr[i]!=-1){
                for(int j=i+1; j<10; j++){
                    if(arr[i]==arr[j]) arr[j]=-1;
                }//for2
            }//if
        }//for1
        int count=0;
        for(int i=0; i<10; i++){
            if(arr[i]!=-1){
                count++;
            }
        }
        bw.write(""+count);
        bw.flush();
        bw.close();
        br.close();
        //-1이아닌녀석을 세면 된다.
        
    }//main()
}//Main class