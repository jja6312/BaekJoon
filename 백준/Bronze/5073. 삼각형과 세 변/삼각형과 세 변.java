import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line="";
        while(true){
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            
            Integer[] arr = new Integer[3];
            arr[0]=a;
            arr[1]=b;
            arr[2]=c;
            Arrays.sort(arr);
            if(a==0 && b==0 && c==0) break;
            else if((arr[2]-(arr[0]+arr[1]))>=0) {
                bw.write("Invalid\n");
            }
            else{
            if( a==b && b==c && a==c ) bw.write("Equilateral\n");
            if( (a==b && a!=c) || (a!=b && a==c) || (b==c && a!=c) ) bw.write("Isosceles\n");
            if( a!=b && a!=c && b!=c) bw.write("Scalene\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
        
    }//main()
}//Main

/*
Equilateral :  세 변의 길이가 모두 같은 경우
Isosceles : 두 변의 길이만 같은 경우
Scalene : 세 변의 길이가 모두 다른 경우
단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다.
예를 들어 6, 3, 2가 이 경우에 해당한다.
가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
*/