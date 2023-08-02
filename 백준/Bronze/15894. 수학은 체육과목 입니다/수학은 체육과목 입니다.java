import java.util.*;
import java.io.*;

public class Main{
	
	
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //-----필드
        long a = Long.valueOf(br.readLine());
        long sumValue=(long) 4+(16+(a-2)*4)*(a-1)/2; //+연산에서의 등차수열의 합(초기값 4포함)
        long subValue=(long) 0+(8+(a-2)*4)*(a-1)/2;	 //-연산에서의 등차수열의 합(초기값 0)
      
        //--입력 값이 1일때와 아닐때를 구분
        if(a==1) bw.write(""+4);
        else{
        	long result= sumValue-subValue;
            bw.write(""+result);
        }
        bw.flush();
        bw.close();
        br.close();
    }//main()
}//Main


/*
		                ㅁ
	                   ㅁㅁ
                      ㅁㅁㅁ
                     ㅁㅁㅁㅁ

각각을 따로 보면 된다.

1. 총 추가되는 길이는, y=x 와 같은 선형이다.
		n2=2, n1(==4)+4*(2) ==12 (+8)
		n3=3, n2(==12)+4*(3) ==24 (+12)
		n4=4, n3(==24)+4*(4) == 40 (+16)


2. 뺴줘야할 길이를 분류해야한다.
아래 분류를 다 합하니까, 전부 다른식이아니라 일정한 식이네?
그렇다면 통으로 묶을 수 잇겟네?
빼야할 식은
n2=2,    4(1) (+4)
n3=3,    12(3) (+8)
n4=4,    24(6) (+12)
네?
뺄셈 공식은 아래와같다.
        (8+(a-2)*4)*(a-1)/2
        
        

	2-1.  빼줘야할 윗변
        <공식>
        
        <공식유도를 위한 식>
		n2=2, n1(==0) + (0.5)*2 == 1
		n3=3, n2(==1) + (0.5)*4 == 3
		n4=4, n3(==3) + (0.5)*6 == 6
	2-2.  빼줘야할 옆변
        <공식>
        <공식유도를 위한 식>
		n2=2,  n1(==0) + 1 *2 == 2
		n3=3,  n2(==2) + 1 *4  == 6
		n4=4,  n3(==6) + 1* 6 == 12
	2-3. 빼줘야할 아랫변
        <공식>
        <공식유도를 위한 식>
		n2=2, n1(==0) + 1  == 1
		n3=3, n2(==1) + 2 == 3
		n4=4, n3(==3) + 3 == 6
        
        엥?
        
*/