import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n;i++) {
			String A = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = A.charAt(j)-'0';
			}
		}
		
		
		int min = bfs();
		StringBuilder sb = new StringBuilder();
		sb.append(min);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
		
	}


	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0,0,1}); // y, x, cnt
		visited[0][0] = true;
		
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		while(!queue.isEmpty()) {
			int[]current = queue.poll();
			int y = current[0];
			int x = current[1];
			int cnt = current[2];
			
			if(y ==n-1 && x == m-1) {
				return cnt;
			}
			
			for(int i=0; i<4; i++) {
				int moveY = dy[i] + y;
				int moveX = dx[i] + x;
				
				
				if(isBoundary(moveY,moveX) && !visited[moveY][moveX] && arr[moveY][moveX]==1) {
					
					visited[moveY][moveX] = true;
					queue.offer(new int[] {moveY,moveX,cnt+1});
				}
				
			}
			
			
		}
		
		
		return -1;
	}


	private static boolean isBoundary(int y, int x) {

		return y>=0 && y<n && x>=0 && x<m;
	}
}
