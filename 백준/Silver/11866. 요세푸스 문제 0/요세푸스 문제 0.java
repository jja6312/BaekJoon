import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Integer> linkedList = new LinkedList<Integer>();
    static int N;
    static int M;
    public static void main(String[]args) throws IOException{
    	read();
        loop();
        
        bw.flush();
        bw.close();
        br.close();

        
    }//main()
    
    public static void read() throws IOException{
        String A = br.readLine();
        String arrA[] = A.split(" ");
        
        N = Integer.parseInt(arrA[0]);
        M = Integer.parseInt(arrA[1]);
        for(int i=1; i<=N; i++){    //링크드리스트 초기화 
            linkedList.add(i);
        }
       
        
    }//read()
    
    public static void loop() throws IOException{
        bw.write("<");
        /*
        */
        int index=0;
        while(linkedList.size()>1){
        	index = (index+M-1)%linkedList.size();
            bw.write(linkedList.get(index)+", ");
            linkedList.remove(index);            
        }//while
             //1234567
        //124567
        
            if(linkedList.size()==1){
                bw.write(linkedList.get(0)+">");
                linkedList.remove(0);
                
            }
            
        }
    }
    
