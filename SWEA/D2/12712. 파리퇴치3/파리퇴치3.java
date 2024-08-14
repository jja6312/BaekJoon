
// ============= 문제 접근 =============
// 1. 배열을 순회하며
// 2. 합을 계산한다.
// 2-1. sum = 가로+세로
// 2-2. sum2 = 대각
// 3. 합의 최대값을 저장한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test<= t ; test++) {
			sb.append("#").append(test).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];

			//배열초기화
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//1. 배열 순회
			int max = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					//2-1. sum1 구하기
					int sum1 = 가로세로의합(i,j);
					//2-2. sum2 구하기
					int sum2 = 대각선의합(i,j);
					//3. 최대값 초기화
					max = Math.max(max, sum1);
					max = Math.max(max, sum2);
				}
			}//for - 배열순회
			sb.append(max).append("\n");
		}//for - test
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}

	private static int 대각선의합(int y, int x) {
		int sum = 0;
		
		//좌상
		int tmpY = y;
		int tmpX = x;
		int cnt = 0;
		while(isBoundary(tmpY,tmpX) && cnt<m) {//좌표가 경계값 내에 존재한다면
			sum += arr[tmpY][tmpX];//더한다.
		
			//좌상에 맞게 움직인다.
			tmpY--;
			tmpX--;
			cnt++;//m이 되면 멈추는 카운팅개수. 첫 시작은 현좌표부터니까 0부터.
		}
		//우상
		tmpY = y;
		tmpX = x;
		cnt = 0;
		while(isBoundary(tmpY,tmpX) && cnt<m) {//좌표가 경계값 내에 존재한다면
			sum += arr[tmpY][tmpX];//더한다.
			
			//우상에 맞게 움직인다.
			tmpY--;
			tmpX++;
			cnt++;//m이 되면 멈추는 카운팅개수. 첫 시작은 현좌표부터니까 0부터.
		}
		//좌하
		tmpY = y;
		tmpX = x;
		cnt = 0;
		while(isBoundary(tmpY,tmpX) && cnt<m) {//좌표가 경계값 내에 존재한다면
			sum += arr[tmpY][tmpX];//더한다.
			
			//좌하에 맞게 움직인다.
			tmpY++;
			tmpX--;
			cnt++;//m이 되면 멈추는 카운팅개수. 첫 시작은 현좌표부터니까 0부터.
		}
		//우하
		tmpY = y;
		tmpX = x;
		cnt = 0;
		while(isBoundary(tmpY,tmpX) && cnt<m) {//좌표가 경계값 내에 존재한다면
			sum += arr[tmpY][tmpX];//더한다.
			
			//좌상에 맞게 움직인다.
			tmpY++;
			tmpX++;
			cnt++;//m이 되면 멈추는 카운팅개수. 첫 시작은 현좌표부터니까 0부터.
		}
		
		//현재 좌표값이 총 4번 더해졌으므로, 3번은 빼주자.
		sum -= arr[y][x] * 3;
		
		
		return sum;
	}

	// 좌표를 벗어나지 않는지 체크
	private static boolean isBoundary(int y, int x) {
		return x>=0 && x<n && y>=0 && y<n;
	}

	private static int 가로세로의합(int y, int x) {
		int sum = 0;
		//좌합
		int moveY = y;
		int moveX = x;
		int cnt = 0;
		while(isBoundary(moveY,moveX) && cnt<m) {
			sum += arr[moveY][moveX];
			
			moveX--;
			cnt++;
		}
		
		//우합
		moveY = y;
		moveX = x;
		cnt = 0;
		while(isBoundary(moveY,moveX) && cnt<m) {
			sum += arr[moveY][moveX];
			
			moveX++;
			cnt++;
		}
		
		//상합
		moveY = y;
		moveX = x;
		cnt = 0;
		while(isBoundary(moveY,moveX) && cnt<m) {
			sum += arr[moveY][moveX];
			
			moveY--;
			cnt++;
		}
		
		//하합
		moveY = y;
		moveX = x;
		cnt = 0;
		while(isBoundary(moveY,moveX) && cnt<m) {
			sum += arr[moveY][moveX];
			
			moveY++;
			cnt++;
		}
		
		sum -= arr[y][x]*3;
		
		
		return sum;
	}

	

}
