package me.chinatsui.algorithm.exercise.graph;

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
 * In the meanwhile, the robot is given a hammer which can help break a wall only once.
 * <p>
 * So, please help the robot come up with a solution.
 */
public class BreakWall {

    private int[][] matrix;
    private int n, m;

    // aux array used for calculate adjacent points
    private int[] rows = new int[]{1, 0, 0, -1};
    private int[] cols = new int[]{0, 1, -1, 0};

    public BreakWall(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            throw new IllegalArgumentException();
        }

        this.matrix = matrix;
        this.n = matrix.length;
        this.m = matrix[0].length;
    }

    public List<Point> shortestPath(Point src, Point dst) {
        Map<Point, PathNode> forwardPath = bfs(src, dst);
        Map<Point, PathNode> backwardPath = bfs(dst, src);
        List<Point> walls = getWalls();

        int shortestPathLen = Integer.MAX_VALUE;
        List<Point> shortestPath = null;
        for (Point wall : walls) {
            Point adj1 = findNearestWallAdjacentPointInPath(wall, forwardPath);
            Point adj2 = findNearestWallAdjacentPointInPath(wall, backwardPath);

            // which means a new potential shortest path could concat by part of forward and backward paths.
            if (adj1 != null && adj2 != null) {
                // path.get(point) refers to the PathNode to this point, so actual path length should plus one.
                int forwardPartLen = forwardPath.get(adj1).dist + 1;
                int backwardPartLen = backwardPath.get(adj2).dist + 1;

                // break the wall
                int temp = forwardPartLen + backwardPartLen + 1;
                if (temp < shortestPathLen) {
                    shortestPathLen = temp;
                    List<Point> forwardPartPath = flattenPath(forwardPath, src, adj1);
                    List<Point> backwardPartPath = flattenPath(backwardPath, dst, adj2);
                    Collections.reverse(backwardPartPath);
                    shortestPath = new ArrayList<>(forwardPartPath);
                    shortestPath.add(wall);
                    shortestPath.addAll(backwardPartPath);
                }
            }
        }

        return shortestPath == null ? new ArrayList<>() : shortestPath;
    }

    private Point findNearestWallAdjacentPointInPath(Point wall, Map<Point, PathNode> path) {
        List<Point> adjacentPoints = getAdjacentPoints(wall);

        Point res = null;
        PathNode pathNode = null;
        for (Point adj : adjacentPoints) {
            // don't consider the adjacent point which is also a wall, because we only can break a wall once.
            if (matrix[adj.x][adj.y] == 1) {
                continue;
            }

            if (path.containsKey(adj)) {
                if (pathNode == null) {
                    res = adj;
                    pathNode = path.get(adj);
                } else {
                    // find nearest adjacent point
                    PathNode temp = path.get(adj);
                    if (temp.dist < pathNode.dist) {
                        res = adj;
                        pathNode = temp;
                    }
                }
            }
        }

        return res;
    }

    private List<Point> flattenPath(Map<Point, PathNode> path, Point src, Point dst) {
        LinkedList<Point> res = new LinkedList<>();
        Point cur = dst;
        while (!cur.equals(src)) {
            res.push(cur);
            cur = path.get(cur).point;
        }
        res.push(cur);
        return res;
    }

    private Map<Point, PathNode> bfs(Point src, Point dst) {
        Map<Point, PathNode> path = new HashMap<>();

        // mark start point as visited
        boolean[][] visited = new boolean[n][m];
        visited[src.x][src.y] = true;

        // enqueue start point to prepare bfs
        Queue<PathNode> queue = new LinkedList<>();
        queue.offer(new PathNode(src, 0));

        // bfs
        while (!queue.isEmpty()) {
            PathNode node = queue.poll();
            Point cur = node.point;

            if (cur.equals(dst)) {
                return path;
            }

            for (Point adj : getAdjacentPoints(cur)) {
                int row = adj.x;
                int col = adj.y;

                if (!visited[row][col] && matrix[row][col] == 0) {
                    visited[row][col] = true;
                    Point next = new Point(row, col);
                    queue.offer(new PathNode(next, node.dist + 1));
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

    private List<Point> getAdjacentPoints(Point cur) {
        List<Point> adjacentPoints = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int row = cur.x + rows[i];
            int col = cur.y + cols[i];

            if (isValidPoint(row, col) ) {
                adjacentPoints.add(new Point(row, col));
            }
        }

        return adjacentPoints;
    }

    private boolean isValidPoint(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    static class PathNode {
        Point point;
        int dist;

        PathNode(Point point, int dist) {
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
