package com.company;

public class RatMaze {

    int M = 7, N = 7;
    void printPath(int[][] maze) {
        if(!printPath(maze, new int[M][N], 0,0))
            System.out.println("no path exists");
    }

    private boolean printPath(int[][] maze, int[][] path, int i, int j) {
        if(i < 0 || j < 0 || i >= M || j >= N) return false;
        else if(i == M -1 && j == M -1) {
            path[i][j] = 1;
            for(int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++)
                    System.out.print(path[a][b] + " ");
                System.out.println();
            }
            return true;
        }
        else {
            if(i < M && j < N && maze[i][j] == 1 && path[i][j] != 1) {
                path[i][j] = 1;

                if(printPath(maze, path, i +1, j)) return true;
                if(printPath(maze, path, i , j +1)) return true;
                if(printPath(maze, path, i -1, j)) return true;
                if(printPath(maze, path, i, j -1)) return true;

                path[i][j] = 0;
                return false;
            }
        }

        return false;
    }
    public static void main(String args[]) {
        int maze[][] = new int[][]{
                {1,1,1,1,1,0,0},
                {1,0,1,0,1,1,1},
                {1,0,1,1,0,0,1},
                {1,0,1,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,1,1,1,1,0,1},
                {0,1,0,1,0,0,1}};

        new RatMaze().printPath(maze);
    }
}
