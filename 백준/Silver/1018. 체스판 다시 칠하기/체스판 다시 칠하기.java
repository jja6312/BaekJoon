import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.valueOf(st.nextToken()); // 아래 줄
        int M = Integer.valueOf(st.nextToken()); // 오른 쪽
        
        //N M에 따른 입력값 받아오기
        String [][] sysArr = new String[N][M];
        
        //주어진 체스판 초기화
        for(int i=0; i<N; i++){
        	String a = br.readLine();
            for(int j=0; j<M; j++){
                sysArr[i][j] = ""+a.charAt(j);
            }
        }
        //잘만든 체스판 경우의수 2개 초기화
        String [][] arr = new String[8][8];
        for(int i=1; i<=8; i++){
            for(int j=1; j<=8; j++){
                if(j%2==1){
                	if(i%2==1) {
                		arr[i-1][j-1]="B";
                	}else {
                		arr[i-1][j-1]="W";
                	}
                }else{
                	if(i%2==1) {
                		arr[i-1][j-1]="W";
                	}else {
                		arr[i-1][j-1]="B";
                	}
                }    
            }
        }
        String [][] arr2 = new String[8][8];
        for(int i=1; i<=8; i++){
            for(int j=1; j<=8; j++){
            	if(j%2==1){
                	if(i%2==1) {
                		arr2[i-1][j-1]="W";
                	}else {
                		arr2[i-1][j-1]="B";
                	}
                }else{
                	if(i%2==1) {
                		arr2[i-1][j-1]="B";
                	}else {
                		arr2[i-1][j-1]="W";
                	}
                }    
            }
        }
        
        //주어진 체스판을 8*8짜리로 쪼개주는 경우의 수를 만들고, 잘만들어진 체스판과 비교해본다.
        //우측으로 한 칸씩, 아래측으로 한 칸씩 내려가야한다.
        String [][] exampleArr = new String[8][8];
        ArrayList<Integer> arrList = new ArrayList<Integer>(); // 틀린갯수 cnt,cnt2 추가를 위함.
        
        
       
        for(int x=0; x<N-7; x++){
            for(int y=0; y<M-7; y++){
                int cnt=0;
                int cnt2=0;
                for(int i=1; i<=8; i++){
                    for(int j=1; j<=8; j++){
                        exampleArr[i-1][j-1]=sysArr[i-1+x][j-1+y];
                        if(!arr[i-1][j-1].equals(exampleArr[i-1][j-1])){
                            //만약 잘만든체스판과 다르면, cnt를 올려라.
                            cnt+=1;
                        }
                        if(!arr2[i-1][j-1].equals(exampleArr[i-1][j-1])){
                            //만약 잘만든체스판2와 다르면, cnt2를 올려라.
                            cnt2+=1;
                        }
                    }//for4
                } //for3  -- 이 2중for문의 의미는, 8*8짜리 체스판 값을 할당시키고
                          // 경우의수1이 잘만든체스판 1,2와 얼마나 다른지 체크하는 것.
                if(cnt>=cnt2) arrList.add(cnt2);
                else arrList.add(cnt);
            }//for2
        }//for1
        
        Collections.sort(arrList);
        bw.write(""+arrList.get(0));
        bw.flush();
        bw.close();
        br.close();
        
        /*
        <사고의 흐름>
        1. 체스판을 N*M개 짜리를 받아서,
        2. 8*8 짜리로 자른 경우의 수를 모두 구하고,
        3. 각각의 경우의수에서 가장 적은 값이 있다면 변수에 초기화 시켜야겠다.
        ------------------------------------------------------------
        <가설의 구체화>
        N*M 체스판을 8*8로 자르는 모든 경우의수는 어떻게 될까?
        
        N*M이
        8*8이라면 1이다.
        8*9라면 2다.
        8*10라면 3이다.
        
        9*9라면 4다.
        9*10라면 6다.
        즉, N과 M이 8로부터 멀어지는 만큼 서로 곱한 값이 그 식이된다.
        ------------------------------------------------------------
        <진짜로직>
        N과 M이 주어졌을 때, 8*8로 체스판을 자를 수 있는
        경우의 수 범위는 (N-7) * (M-7)
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        각각의 경우의 수에서 최소값을 어떻게 구할 수 있을까?
        기존에 잘 만들어진 체스판에서, 현재의 체스판을 빼준다.
        이 때, 잘 만들어진 체스판의 버전은 두가지가 존재한다.(맨위 왼쪽이 하얀색인 ver, 검은색인 ver)
        [1 0 1 0]    [0 1 0 1]
        [0 1 0 1]    [1 0 1 0]
        [1 0 1 0]    [0 1 0 1]
        [0 1 0 1]    [1 0 1 0]
        
        여기에 아무개 체스판과 값을 비교해준다.
        [1 0 1 1]
        [0 1 1 1]
        [0 1 1 1]
        [0 1 1 1]
        값이 틀린게 몇 개인지 ver 별로 확인하고,
        더 적게 틀린 것을 반환한다.
        그렇다면 그 경우의 수에서 낼 수 있는 최소 값이다.
        
        이를 ArrayList에 추가한다.
        
        그리고 이를 .sort()하고
        .get(0)을 해준다면
        가장 적은 값이 나오리라.
        ------------------------------------------------------------   
        */ 
    }//main()
}//Main