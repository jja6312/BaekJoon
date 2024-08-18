

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// ============== 문제 접근 ==============

// 첫 번째 시도
// (틀림)answer = 참외수 * (max동or서쪽 *  max북or남쪽 - min동or서쪽 * min북or남쪽)

// 두 번째 시도
// 아. 북,남쪽은 값이 세개가 주어지는데 세개의 값 중 내가생각했던 빼야할면적의 값이 가장작다는것은 옳은 전제가 아니었다.
// (틀림)그럼 북,남쪽과 서,동쪽을 순서대로 저장하는 ArrayList를 만들고, 가장 긴 값에서 +1, +2 인덱스에 있는 값이 빼야할 면적의 값이겠다.

// 세 번째 시도
// 반례가 존재하는구나. 나는 그림처럼 왼쪽 하단에 빼야할 면적이 존재한다고 생각했었다.
// 빼야할 면적이 어디있는지 모른다는 말은, 가장 긴 변에서 몇 번째 뒤가 빼야할 변인지 파악할 수 있으면 정답으로 처리할 수 있다는 말이다.
// 어떻게 파악할 수 있을까?
// direction의 움직임 패턴으로 파악할 수 있을 듯 하다.
// 423131 에서, 3131은 남동남동으로 이동했다는 말이다. 남동남동으로 이동했다는 말은 이 부분에서 빼야할 위치를 지나고 있음을 의미한다.
// 남동남동 으로 이동할 때, 첫 번째 남동의 '동', 두 번째 남동의 '남'이 빼야할 변이다.
// 만약 424231 이라면, 4242는 북서북서다. 첫 번째 북서의 '서', 두 번째 북서의 '북'이 빼야할 변이다.
// 만약 423231 이라면, 2323은 서남서남이다. 첫 번째 서남의 '남'과 두 번째 서남의 '서'가 빼야할 변이다.

// 이러한케이스의 공통점은, 반복되는 direction이 2개가 있고, 첫 번째 direction의 두 번째 요소와 두 번째 direction의 첫 번째 요소가 빼야할 너비의 변이라는 점이다.
// 따라서 문제에서 입력값을 쭉 받고 반복되는 패턴을 찾고, 이 패턴에서 변을 추릴 수 있다.
// 해보자!


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int k  =Integer.parseInt(br.readLine()); //참외 개수

        // 1: 동
        // 2: 서
        // 3: 남
        // 4: 북
        int maxW = 0; //가장 긴 가로변
        int maxH = 0; //가장 긴 세로변

        int[] directionData = new int[6]; //어디가 반복되는 방향인지 확인하기 위한 배열
        int[] lenArr = new int[6]; // 변을 순서대로 저장하는 리스트


        for(int i=0; i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            //배열들에 데이터를 저장한다.
            directionData[i] = direction;
            lenArr[i] = len;

            if(direction == 1|| direction==2){
                maxW = Math.max(maxW, len);
            }else if(direction == 3|| direction==4){
                maxH = Math.max(maxH,len);
            }
        }//for

        int subW = -1;
        int subH = -1;
        //길이가 2인 반복되는 패턴을 찾는다.
        for(int i=0; i<6+1; i++){// i가 6+1인 이유는, 반복되는 첫 인덱스가 3이라면 3,4와 5,6 이 반복숫자로 나와야할것이기때문. 이 때 6은 0을 가리켜야한다.
            int first = directionData[i%6];
            int second = directionData[(i+1)%6];
            int third = directionData[(i+2)%6];
            int last = directionData[(i+3)%6];

            if (first == third && second == last){//방향이 반복된다면
                subW = lenArr[(i+1)%6]; //첫 번째 반복에서의 두 번째 요소를 변으로 할당
                subH = lenArr[(i+2)%6]; // 두번째 반복에서의 첫 번째 요소를 변으로 할당
            }
        }

        int answer = k*(maxW * maxH - subW * subH);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
