import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //[O]1줄씩 읽어들인다.
        //[O](끝이나올때까지 읽어야함.)
        //[O]2차원 배열로 15개짜리의 배열 5개를 만든다.
        //[O]-1로 초기화한다.
        //[O]채워넣는다.
        //[]세로로 읽는 for문을 짠다. 이때, 조건문으로 만약 -1이라면 출력하지않고 넘어가야한다.(continue)
        
        //
        
        //5줄을 읽는다.
        
        
        char[][] arr = new char[5][15];
        for(int i=0; i<5; i++){
            for(int j=0; j<15; j++){
                arr[i][j]='*';
            }
        }
        String a="";
        for(int i=0; i<5; i++){
            a = br.readLine();
            for(int j=0; j<a.length(); j++){
                if(a!=null){
            	    
                    arr[i][j] = a.charAt(j);
                }else{
                    arr[i][j] = '*';
                }
                
                }
        	}
        
        
        for(int i=0; i<15; i++){
            for(int j=0; j<5; j++){
                if(arr[j][i]!='*'){
                    bw.write(""+arr[j][i]);
                }//if
            }//for2
        }//for1
        bw.flush();
        bw.close();
        br.close();
        
        
    }
}