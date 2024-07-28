import java.util.*;

public class Main {
    static int N;
    static int[][] classroom;
    static Map<Integer, List<Integer>> studentPreferences = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        classroom = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            int student = sc.nextInt();
            List<Integer> preferences = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                preferences.add(sc.nextInt());
            }
            studentPreferences.put(student, preferences);
            placeStudent(student);
        }

        System.out.println(calculateSatisfaction());
    }

    private static void placeStudent(int student) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxFriends = -1;
        int maxEmpty = -1;
        int finalX = -1;
        int finalY = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (classroom[i][j] != 0) continue;

                int friends = 0;
                int empty = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (classroom[nx][ny] == 0) {
                            empty++;
                        } else if (studentPreferences.get(student).contains(classroom[nx][ny])) {
                            friends++;
                        }
                    }
                }

                if (friends > maxFriends || (friends == maxFriends && empty > maxEmpty) || (friends == maxFriends && empty == maxEmpty && (finalX == -1 || i < finalX || (i == finalX && j < finalY)))) {
                    maxFriends = friends;
                    maxEmpty = empty;
                    finalX = i;
                    finalY = j;
                }
            }
        }

        classroom[finalX][finalY] = student;
    }

    private static int calculateSatisfaction() {
        int[] satisfaction = {0, 1, 10, 100, 1000};
        int totalSatisfaction = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = classroom[i][j];
                int friends = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && studentPreferences.get(student).contains(classroom[nx][ny])) {
                        friends++;
                    }
                }

                totalSatisfaction += satisfaction[friends];
            }
        }

        return totalSatisfaction;
    }
}
