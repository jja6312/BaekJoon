import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //몇 번 반복할지 읽어들이기
        int n = Integer.valueOf(br.readLine());
        int count=0;
        for(int i=0; i<n; i++){
            //문제 줄 읽기
            String A = br.readLine();
            //캐릭터배열선언
            char[] a = new char[A.length()];
            //캐릭터배열 초기화(A문자열을 쪼갠것임.)
            for(int j=0;j<A.length();j++){
                a[j]= A.charAt(j);    
            }//for2
            
            //그룹문자 판독을 위해 어레이리스트를 만듦. 
            ArrayList <Character>arrList = new ArrayList<Character>();
            for(int j=0;j<A.length()-1;j++){
                if(a[j]==a[j+1]) continue;
                else if(a[j]!=a[j+1]) arrList.add(a[j]);
            }//for2
            // 마지막 문자 추가
            arrList.add(a[A.length()-1]);

            //trueSwitch의 기본값을true로 설정하고, 만약 배열을 순회하며 일치하는 값이 나온다면 false로 변경.
            boolean trueSwitch = true;
            for(int j=0; j<arrList.size()-1; j++){
            	for(int z=j+1; z<arrList.size(); z++) {
            		if(arrList.get(j).equals(arrList.get(z))) {
            			trueSwitch=false;
            			break;
            		}
            	}
            	if(!trueSwitch){
            		break;
            	}
            }
            //즉 trueSwitch가 true일 때만 값 반환.
            if (trueSwitch){
                count++;  
            }
            
        }//for1
        bw.write(""+count);
        bw.flush();
        bw.close();
        br.close();
        
    }//main()
}//Main class
