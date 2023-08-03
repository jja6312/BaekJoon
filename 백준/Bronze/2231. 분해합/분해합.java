import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
        //  1. 자연수를 ArrayList로 구성된 배열(범위는 N*2까지)로 만들고, 초기화.
        int N = Integer.valueOf(br.readLine());        
        ArrayList[] nList = new ArrayList[N];

        for(int i=0; i<N; i++){
            nList[i] = new ArrayList<Integer>();
        }
        
         // 2. 자연수 차례대로 분해합을 계산해준다.
         // 3. 분해합이 나오는 것을, 분해합에 해당하는 자연수로 이동해서 생성자를 ArrayList에 추가해준다.
        for(int i=1; i<=N; i++){
            String iString = ""+i;
            int iStringSum = i;
            for(int j=0; j<iString.length(); j++){//자연수의 자릿수만큼 더해주는, 분해합과정
                iStringSum += iString.charAt(j)-'0';
            }
            if(iStringSum-1<N) { // iStringSum-1(만들어진 분해합이 N보다 작아야함.) 
            	nList[iStringSum-1].add(i);
            }
        }
        //4. 이제 자연수의 배열로 가서 어레이리스트를 정렬하고 가장 낮은 값을 출력하면 된다
        ArrayList <Integer> result = new ArrayList<Integer>();
        result = nList[N-1];
        Collections.sort(result);
        if(!result.isEmpty()) {// 아... 어레이리스트는 비어있을 때 출력하려하면 오류가 나는구나.
        	bw.write(""+result.get(0));
        }else {
        	bw.write(""+0);
        }
        bw.flush();
        bw.close();
        br.close();
        
        
        
        /*
        <생각의 과정>
        abc 가 있을 때, abc+a+b+c는 분해합.
        abc는 abc+a+b+c(분해합)의 생성자.
        생성자를 역추적하려면?
        자연수로 분해합을 모두 만들어봐야 할 것이다.
        
        <구체적인 로직>
        근데, 자연수 배열을 어디까지 만드는게 효율적일까?
        N을 받았을 때 분해합은 N보다 조금 더 크겠지.
        정확한 수치 계산은 귀찮으니까, 그냥 두배까지 늘려서 리스트를 만들어주면 낭낭하겠네.
        
        1. 자연수를 ArrayList로 구성된 배열(범위는 N*2까지)로 만들고, 초기화.
        2. 자연수 차례대로 분해합을 계산해준다.
        3. 분해합이 나오는 것을, 분해합에 해당하는 자연수로 이동해서 생성자를 ArrayList에 추가해준다.
        4. 이제 자연수의 배열로 가서 어레이리스트를 정렬하고 가장 낮은 값을 출력하면 된다.
        
        
        분해합은 생성자보다 항상 크다.
        분해합>생성자
        생성자를 순회하며 분해합을 계산하고, 계산한 분해합과 동일한 생성자에 가서 분해합을 추가하는과정.
        만약 생성자까지 분해합을 계산한다면, 원하는값을 정상적으로 얻을수있는가?
        된다! 어차피 분해합은 생성자보다 크기때문에,
        N(생성자) 내부에 추가된, 계산된 분해합의 생성자들은 다 이전 생성자들이 만들어낸 값들이다.
        
        
        */
        
        
    }//main()
}//Main