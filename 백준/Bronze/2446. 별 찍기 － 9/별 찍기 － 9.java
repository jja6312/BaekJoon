import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<String> dq = new ArrayDeque<>();
        for(int i=0; i<2*n-1; i++){
            if(2*n-2*i-1>0){
                String str="";
                for(int j=2*n-i-1; j<2*n-1; j++){
                    str += " ";
                }
                for(int j=0; j<2*n-2*i-1; j++){
                    str += "*";
                }

                bw.write(str+"\n");
                dq.push(str);

            }else if(2*n-2*i-1<0){
                if(2*n-2*i-1==-1) dq.pop();
                String popStr = dq.pop();

                bw.write(popStr+"\n");
            }//else if
        }//for

        bw.flush();
        bw.close();
        br.close();


    }//main

}//Main Class
