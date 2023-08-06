import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static ArrayList<Integer> arrList;
    static Integer[] distance;
    static Integer[] neededTree;
    
    public static void main(String[]args) throws IOException{

    	read();
        arrListAdd();
        int minDistance = minDistance();
    	neededTree = new Integer[N-1];
        
    	int result=0;
    	int realMinDistance;
    	ArrayList <Integer>arrList2 = new ArrayList <Integer>();
    	for(int i=0; i<N-1; i++) {
    		
    			realMinDistance= gcd(distance[i],minDistance);
    			arrList2.add(realMinDistance);
    		
    	}
    	Collections.sort(arrList2);
    	int realRealMinDistance = arrList2.get(1);
        
        	for(int i=0; i<N-1; i++){
        	neededTree[i] =distance[i]/realRealMinDistance-1;
        	result+=neededTree[i];
        	}
        
        

        bw.write(""+result);
        bw.flush();
        bw.close();
        br.close();
        
        
        
    }//main()
    
    public static void read() throws IOException{
    	
        N = Integer.parseInt(br.readLine());
    }//read()
    
    public static void arrListAdd()throws IOException{
        arrList = new ArrayList<Integer>();
        for(int i=0; i<N; i++){
            int treeIndex = Integer.parseInt(br.readLine());
            arrList.add(treeIndex);
        }
    }//arrListAdd
    
    public static int minDistance(){
        distance = new Integer[N-1];
        for(int i = 0; i < N-1; i++) {
            distance[i] = arrList.get(i+1) - arrList.get(i);
        }
        Arrays.sort(distance);
        return distance[0];
    }//minDistance
    
    public static int gcd(int a, int b) {
    	while(b!=0) {
    		int remainder = a%b;
    		a = b;
    		b = remainder;
    	}
    	return a;
    }
    
}//Main