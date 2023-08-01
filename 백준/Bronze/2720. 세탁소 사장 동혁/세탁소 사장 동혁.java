import java.util.*;
import java.io.*;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.valueOf(br.readLine());
        int a = 25;
        int b = 10;
        int c = 5;
        int d = 1;
        for(int i=0; i<T; i++){
            int C = Integer.valueOf(br.readLine());
            int x1=0;
            int x2=0;
            int x3=0;
            int x4=0;
            if(C/a!=0){
                x1=C/a;
                C=C%a;
                x2=C/b;
                C=C%b;
                x3=C/c;
                C=C%c;
                x4=C;
                bw.write(""+x1+" "+x2+" "+x3+" "+x4+" ");
            }else if(C/a==0){
                if(C/b!=0){
                x1=0;   
                x2=C/b;
                C=C%b;
                x3=C/c;
                C=C%c;
                x4=C;
                bw.write(""+x1+" "+x2+" "+x3+" "+x4+" ");
                }else if(C/b==0){
                    if(C/c!=0){
                        x1=0;
                        x2=0;
                        x3=C/c;
                        C=C%c;
                        x4=C;
                        bw.write(""+x1+" "+x2+" "+x3+" "+x4+" ");
                    }else if(C/c==0){
                        x1=0;
                        x2=0;
                        x3=0;
                        x4=C;
                        bw.write(""+x1+" "+x2+" "+x3+" "+x4+" ");
                    }//else if
                }//else if   
            }//if
            
            bw.write("\n");
        }//for
        bw.flush();
        bw.close();
        br.close();
        
    }//main()
}//Main