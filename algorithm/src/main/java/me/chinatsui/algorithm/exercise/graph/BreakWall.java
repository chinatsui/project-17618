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
 * Google Interview Question
 *
 * Given an 2D matrix, each cell is either a wall 1 or empty 0, the cell with "0" can be passed,
 * however the cell with "1" can't.
 * <p>
 * Now, there is a robot placed in a cell A, and it is going to find the shortest forwardPath to the cell B.
 * In the meanwhile, the robot is given a hammer which can help break a wall only once.
 * <p>
 * So, please help the robot come up with a solution.
 */
public class BreakWall {

    private final int[][] matrix;
    private final int n, m;

    // aux array used for calculate adjacent points
    private final int[] rows = new int[]{1, 0, 0, -1};
    private final int[] cols = new int[]{0, 1, -1, 0};

    public BreakWall(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            throw new IllegalArgumentException();
        }

        this.matrix = matrix;
        this.n = matrix.length;
        this.m = matrix[0].length;
    }

    public List<Coord> shortestPath(Coord src, Coord dst) {
        BFSResult srcDstRes = bfs(src, dst);
        BFSResult dstSrcRes = bfs(dst, src);

        List<Coord> wallsToCheck = dstSrcRes.walls;
        wallsToCheck.retainAll(srcDstRes.walls);

        int shortestPathLen = Integer.MAX_VALUE;
        List<Coord> shortestPath = null;
        for (Coord wall : wallsToCheck) {
            Coord adj1 = findNearestWallAdjacentCoord(wall, srcDstRes.predecessors);
            Coord adj2 = findNearestWallAdjacentCoord(wall, dstSrcRes.predecessors);

            // which means a new potential shortest path could concat by part of forward and backward paths.
            if (adj1 != null && adj2 != null) {
                // path.get(coord) refers to the coord's predecessor, so actual path length should plus one.
                int forwardPartLen = srcDstRes.predecessors.get(adj1).dist + 1;
                int backwardPartLen = dstSrcRes.predecessors.get(adj2).dist + 1;

                // break the wall calculate path length
                int temp = forwardPartLen + backwardPartLen + 1;

                // try to find the shortest path
                if (temp < shortestPathLen) {
                    shortestPathLen = temp;
                    List<Coord> forwardPartPath = buildPath(srcDstRes.predecessors, src, adj1);
                    List<Coord> backwardPartPath = buildPath(dstSrcRes.predecessors, dst, adj2);
                    Collections.reverse(backwardPartPath);
                    shortestPath = new ArrayList<>(forwardPartPath);
                    // break the wall
                    shortestPath.add(wall);
                    shortestPath.addAll(backwardPartPath);
                }
            }
        }

        return shortestPath == null ? new ArrayList<>() : shortestPath;
    }

    private BFSResult bfs(Coord src, Coord dst) {
        Map<Coord, PathNode> path = new HashMap<>();
        List<Coord> walls = new ArrayList<>();

        // mark start coord as visited
        boolean[][] visited = new boolean[n][m];
        visited[src.x][src.y] = true;

        // enqueue start coord to prepare bfs
        Queue<PathNode> queue = new LinkedList<>();
        queue.offer(new PathNode(src, 0));

        // bfs
        while (!queue.isEmpty()) {
            PathNode node = queue.poll();
            Coord cur = node.coord;

            if (cur.equals(dst)) {
                return new BFSResult(path, walls);
            }

            for (Coord adj : getAdjacentCoords(cur)) {
                int row = adj.x;
                int col = adj.y;

                if (!visited[row][col]) {
                    Coord next = new Coord(row, col);
                    if (matrix[row][col] == 0) {
                        visited[row][col] = true;
                        queue.offer(new PathNode(next, node.dist + 1));
                        path.put(next, node);
                    } else {
                        walls.add(next);
                    }
                }
            }
        }

        return new BFSResult(path, walls);
    }

    private Coord findNearestWallAdjacentCoord(Coord wall, Map<Coord, PathNode> path) {
        List<Coord> adjacentCoords = getAdjacentCoords(wall);

        Coord res = null;
        PathNode pathNode = null;
        for (Coord adj : adjacentCoords) {
            // don't consider the adjacent coord which is also a wall, because we only can break a wall once.
            if (matrix[adj.x][adj.y] == 1) {
                continue;
            }

            if (path.containsKey(adj)) {
                if (pathNode == null) {
                    res = adj;
                    pathNode = path.get(adj);
                } else {
                    // find nearest adjacent coord
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

    private List<Coord> getAdjacentCoords(Coord cur) {
        List<Coord> adjacentCoords = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int row = cur.x + rows[i];
            int col = cur.y + cols[i];

            if (isValidPoint(row, col) ) {
                adjacentCoords.add(new Coord(row, col));
            }
        }

        return adjacentCoords;
    }

    private List<Coord> buildPath(Map<Coord, PathNode> path, Coord src, Coord dst) {
        LinkedList<Coord> res = new LinkedList<>();
        Coord cur = dst;
        while (!cur.equals(src)) {
            res.push(cur);
            cur = path.get(cur).coord;
        }
        res.push(cur);
        return res;
    }

    private boolean isValidPoint(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    static class BFSResult {
        Map<Coord, PathNode> predecessors;
        List<Coord> walls;

        public BFSResult(Map<Coord, PathNode> predecessors,  List<Coord> walls) {
            this.predecessors = predecessors;
            this.walls = walls;
        }
    }

    static class PathNode {
        Coord coord;
        int dist;

        PathNode(Coord coord, int dist) {
            this.coord = coord;
            this.dist = dist;
        }
    }

    static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return x == coord.x &&
                    y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
