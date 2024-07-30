import java.io.*;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        // 풍선 1부터 터뜨린다.
        // 풍선이 모두터질때까지 반복 (visited배열이 모두 true가 아니라면)
        // 풍선이 터지면 나온 값에 대해 visited를 true로 한다.
        // 나온 값에 대해 왼쪽,오른쪽으로 이동한다.
        // 이동했을때 만약 visited가 true인 것은 체크하지 않고 넘어간다.
        // visited가 false인 순서를 만나면, true로 바꾸고 값을 출력한다.

        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        visited[0] = true; // 1~n까지 쓸거니까 0은 미리 true로 변경
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boom(1);

        bw.flush();
        bw.close();
        br.close();

    }

    private static void boom(int idx) throws IOException {
        visited[idx] = true;//현재 방문한 풍선을 터뜨린다.
        bw.write(idx+" ");

        if (isAllVisit()) return;//모두 방문했다면 메서드 종료

        int nextStep = arr[idx];//풍선에서 꺼낸 값

        int step;
        if (nextStep > 0) step = 1;
        else step = -1;

        int nextIdx = findNextIdx(idx,nextStep, step);

        boom(nextIdx);//다음 풍선을 터뜨린다.
    }

    private static int findNextIdx(int idx, int nextStep, int step) {
        nextStep = Math.abs(nextStep);//nextStep은 음수일수도있는데, 여기서 중요한건 몇 번 가야하는지임.
        int nextIdx = idx;//초기값은 현재 idx

        while(nextStep>0){//풍선에서 꺼낸 값이 0이될때까지 뺀다.
            nextIdx = (nextIdx+step)%arr.length; // step을 통해 우측 혹은 좌측으로 1씩 이동
            if(nextIdx<0){//음수인경우 배열의끝으로돌아가게함.
                nextIdx += arr.length;
            }
            if(!visited[nextIdx]){//방문하지 않은 곳만
                nextStep--;
            }
        }//while

        return nextIdx;
    }

    private static boolean isAllVisit() {

        for (boolean visit : visited) {
            if (!visit) return false;//방문하지 않은 곳이 있다면, 모든 배열을 방문하지 않았다고 처리
        }

        return true;
    }
}