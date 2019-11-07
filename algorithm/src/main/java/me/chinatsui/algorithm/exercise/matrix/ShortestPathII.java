package me.chinatsui.algorithm.exercise.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * Given an 2D matrix, each cell is either a wall 1 or empty 0, the cell with "0" can be passed,
 * however the cell with "1" can't.
 * <p>
 * Now, there is a robot placed in a cell A, and it is going to find the shortest forwardPath to the cell B.
 * In the meanwhile, the robot is given a hammer which can help destroy a wall only once.
 * <p>
 * So, please help the robot come up with a solution.
 */
public class ShortestPathII {

    private int[][] matrix;
    private int n, m;

    // aux array used for calculate neighbour points
    private int[] rows = new int[]{1, 0, 0, -1};
    private int[] cols = new int[]{0, 1, -1, 0};

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                new int[]{1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                new int[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                new int[]{1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                new int[]{1, 0, 1, 0, 1, 1, 0, 1, 0, 0},
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                new int[]{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                new int[]{1, 1, 0, 0, 0, 0, 1, 0, 0, 1},
        };

        ShortestPathII spii = new ShortestPathII(matrix);
        List<Point> shortestPath = spii.resolve(new Point(0, 0), new Point(4, 3));
        for (Point point : shortestPath) {
            System.out.print(String.format("(%s, %s) ", point.x, point.y));
        }
    }

    public ShortestPathII(int[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.m = matrix[0].length;
    }

    public List<Point> resolve(Point src, Point dst) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new ArrayList<>();
        }

        Map<Point, DistNode> forwardPath = bfs(src, dst); // bfs from src to dst
        Map<Point, DistNode> backwardPath = bfs(dst, src); // bfs from dst to src
        List<Point> walls = getWalls();

        int shortestPathLen = Integer.MAX_VALUE;
        List<Point> shortestPath = null;
        for (Point wall : walls) {
            Point nei1 = findWallNeighbourWithShortestDistInPath(wall, forwardPath);
            Point nei2 = findWallNeighbourWithShortestDistInPath(wall, backwardPath);

            // which means a new potential shortest path could concat by part of forward and backward paths.
            if (nei1 != null && nei2 != null) {
                int forwardPartLen = forwardPath.get(nei1).dist + 1;
                int backwardPartLen = backwardPath.get(nei2).dist + 1;
                int temp = forwardPartLen + backwardPartLen + 1;
                if (temp < shortestPathLen) {
                    shortestPathLen = temp;
                    List<Point> forwardPartPath = flattenPath(forwardPath, src, nei1);
                    List<Point> backwardPartPath = flattenPath(backwardPath, dst, nei2);
                    Collections.reverse(backwardPartPath);
                    shortestPath = new ArrayList<>(forwardPartPath);
                    shortestPath.add(wall);
                    shortestPath.addAll(backwardPartPath);
                }
            }
        }

        return shortestPath;
    }

    private Point findWallNeighbourWithShortestDistInPath(Point wall, Map<Point, DistNode> path) {
        List<Point> wallNeighbours = getNeighbours(wall);

        Point res = null;
        DistNode distNode = null;
        for (Point nei : wallNeighbours) {
            if (matrix[nei.x][nei.y] == 1) {
                continue;
            }

            if (path.containsKey(nei)) {
                if (distNode == null) {
                    res = nei;
                    distNode = path.get(nei);
                } else {
                    DistNode temp = path.get(nei);
                    if (temp.dist < distNode.dist) {
                        res = nei;
                        distNode = temp;
                    }
                }
            }
        }

        return res;
    }

    private List<Point> flattenPath(Map<Point, DistNode> path, Point src, Point dst) {
        LinkedList<Point> res = new LinkedList<>();
        Point cur = dst;
        while (!cur.equals(src)) {
            res.push(cur);
            cur = path.get(cur).point;
        }
        res.push(cur);
        return res;
    }

    private Map<Point, DistNode> bfs(Point src, Point dst) {
        Map<Point, DistNode> path = new HashMap<>();

        // mark start point as visited
        boolean[][] visited = new boolean[n][m];
        visited[src.x][src.y] = true;

        // enqueue start point to prepare bfs
        Queue<DistNode> queue = new LinkedList<>();
        queue.offer(new DistNode(src, 0));

        // bfs
        while (!queue.isEmpty()) {
            DistNode node = queue.poll();
            Point cur = node.point;

            if (cur.equals(dst)) {
                return path;
            }

            for (Point nei : getNeighbours(cur)) {
                int row = nei.x;
                int col = nei.y;

                if (!visited[row][col] && matrix[row][col] == 0) {
                    visited[row][col] = true;
                    Point next = new Point(row, col);
                    queue.offer(new DistNode(next, node.dist + 1));
                    path.put(next, node);
                }
            }
        }

        return path;
    }

    private List<Point> getWalls () {
        List<Point> walls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    walls.add(new Point(i, j));
                }
            }
        }

        return walls;
    }

    private List<Point> getNeighbours(Point cur) {
        List<Point> neighbours = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int row = cur.x + rows[i];
            int col = cur.y + cols[i];

            if (isValidPoint(row, col) ) {
                neighbours.add(new Point(row, col));
            }
        }

        return neighbours;
    }

    private boolean isValidPoint(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    static class DistNode {
        Point point;
        int dist;

        DistNode(Point point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
