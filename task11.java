import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x, y, distance;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.distance = dist;
    }
}

class Wave {
    static int M = 5;
    static int N = 5;

    static boolean isValid(int[][] board, boolean[][] visited, int row, int column) {
        return ((row >= 0) && (row < M))
                && ((column >= 0) && (column < N) && (board[row][column] == 1) && (!visited[row][column]));
    }

    private static void bfs(int[][] bd, int sourceX, int sourceY, int targetX, int targetY) {
        int[] row = new int[] { -1, 0, 0, 1 };
        int[] col = new int[] { 0, -1, 1, 0 };

        int minDistance = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[M][N];
        visited[sourceX][sourceY] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sourceX, sourceY, 0));
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if (curNode.x == targetX && curNode.y == targetY) {
                minDistance = curNode.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curNode.x + row[i];
                int newY = curNode.y + col[i];
                if (isValid(bd, visited, newX, newY)) {
                    visited[newX][newY] = true;
                    Node n = new Node(newX, newY, curNode.distance + 1);
                    q.add(n);
                }
            }
        }
        if (minDistance == Integer.MAX_VALUE) {
            System.out.print("Can't reach the distanation");
        } else {
            System.out.print("The shortest path is " + minDistance);
        }
    }


    public static void main(String[] args) {
        int[][] board = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 1, 1, 0, 0, 0 } };
    
        bfs(board, 0, 0, 3, 4);
    }
}
