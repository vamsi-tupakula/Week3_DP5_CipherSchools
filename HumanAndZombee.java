import java.util.LinkedList;
import java.util.Queue;

public class HumanAndZombee {
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int makingZombees(int[][] matrix) {
        Queue<Position> queue = new LinkedList<>();
        int totalCreatures = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 || matrix[i][j] == 2) {
                    totalCreatures++;
                }

                if (matrix[i][j] == 2) {
                    queue.add(new Position(i, j));
                }
            }
        }

        int zombies = 0;
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            zombies += size;
            if (zombies == totalCreatures) {
                return time;
            }

            time++;

            for (int i = 0; i < size; i++) {
                Position p = queue.poll();
                if (p.x + 1 < matrix.length && matrix[p.x + 1][p.y] == 1) {
                    matrix[p.x + 1][p.y] = 2;
                    queue.add(new Position(p.x + 1, p.y));
                }

                if (p.x - 1 >= 0 && matrix[p.x - 1][p.y] == 1) {
                    matrix[p.x - 1][p.y] = 2;
                    queue.add(new Position(p.x - 1, p.y));
                }

                if (p.y - 1 >= 0 && matrix[p.x][p.y - 1] == 1) {
                    matrix[p.x][p.y - 1] = 2;
                    queue.add(new Position(p.x, p.y - 1));
                }

                if (p.y + 1 < matrix.length && matrix[p.x][p.y + 1] == 1) {
                    matrix[p.x][p.y + 1] = 2;
                    queue.add(new Position(p.x, p.y + 1));
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        // code goes here
    }
}