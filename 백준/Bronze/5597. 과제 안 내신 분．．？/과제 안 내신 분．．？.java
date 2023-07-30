import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer []arr = new Integer[30];
        for(int i=0; i<30; i++){
            arr[i]=i+1;
        }
        Integer check=0;
        for(int l=0;l<28;l++){
            check = Integer.valueOf(br.readLine());
            
            for(int m=0;m<30;m++){
                if(arr[m]==check){
                    arr[m]=0;
                }
            }//for2
        }//for1
        //이제, 만약 0이아니라면 출력하자.
        for(int x=0; x<30; x++){
            if(arr[x]!=0){
                bw.write(""+arr[x]+"\n");
            }//if
        }//for
        bw.flush();
        bw.close();
        br.close();
        
    }//main()
}//Main class