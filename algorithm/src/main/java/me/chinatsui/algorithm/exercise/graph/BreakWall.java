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

    public List<Position> shortestPath(Position src, Position dst) {
        BFSResult srcDstRes = bfs(src, dst);
        BFSResult dstSrcRes = bfs(dst, src);

        List<Position> wallsToCheck = dstSrcRes.walls;
        wallsToCheck.retainAll(srcDstRes.walls);

        int shortestPathLen = Integer.MAX_VALUE;
        List<Position> shortestPath = null;
        for (Position wall : wallsToCheck) {
            Position adj1 = findNearestPositionAdjacentToWall(wall, srcDstRes.predecessors);
            Position adj2 = findNearestPositionAdjacentToWall(wall, dstSrcRes.predecessors);

            // which means a new potential shortest path could concat by part of forward and backward paths.
            if (adj1 != null && adj2 != null) {
                // path.get(position) refers to the position's predecessor, so actual path length should plus one.
                int forwardPartLen = srcDstRes.predecessors.get(adj1).dist + 1;
                int backwardPartLen = dstSrcRes.predecessors.get(adj2).dist + 1;

                // break the wall calculate path length
                int temp = forwardPartLen + backwardPartLen + 1;

                // try to find the shortest path
                if (temp < shortestPathLen) {
                    shortestPathLen = temp;
                    List<Position> forwardPartPath = buildPath(srcDstRes.predecessors, src, adj1);
                    List<Position> backwardPartPath = buildPath(dstSrcRes.predecessors, dst, adj2);
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

    private BFSResult bfs(Position src, Position dst) {
        Map<Position, PathNode> path = new HashMap<>();
        List<Position> walls = new ArrayList<>();

        // mark start position as visited
        boolean[][] visited = new boolean[n][m];
        visited[src.x][src.y] = true;

        // enqueue start position to prepare bfs
        Queue<PathNode> queue = new LinkedList<>();
        queue.offer(new PathNode(src, 0));

        // bfs
        while (!queue.isEmpty()) {
            PathNode node = queue.poll();
            Position cur = node.position;

            if (cur.equals(dst)) {
                return new BFSResult(path, walls);
            }

            for (Position adj : getAdjacentPositions(cur)) {
                int row = adj.x;
                int col = adj.y;

                if (!visited[row][col]) {
                    Position next = new Position(row, col);
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

    private Position findNearestPositionAdjacentToWall(Position wall, Map<Position, PathNode> path) {
        List<Position> adjacentPositions = getAdjacentPositions(wall);

        Position res = null;
        PathNode pathNode = null;
        for (Position adj : adjacentPositions) {
            // don't consider the adjacent position which is also a wall, because we only can break a wall once.
            if (matrix[adj.x][adj.y] == 1) {
                continue;
            }

            if (path.containsKey(adj)) {
                if (pathNode == null) {
                    res = adj;
                    pathNode = path.get(adj);
                } else {
                    // find nearest adjacent position
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

    private List<Position> getAdjacentPositions(Position cur) {
        List<Position> adjacentPositions = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int row = cur.x + rows[i];
            int col = cur.y + cols[i];

            if (isValidPoint(row, col) ) {
                adjacentPositions.add(new Position(row, col));
            }
        }

        return adjacentPositions;
    }

    private List<Position> buildPath(Map<Position, PathNode> path, Position src, Position dst) {
        LinkedList<Position> res = new LinkedList<>();
        Position cur = dst;
        while (!cur.equals(src)) {
            res.push(cur);
            cur = path.get(cur).position;
        }
        res.push(cur);
        return res;
    }

    private boolean isValidPoint(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    static class BFSResult {
        Map<Position, PathNode> predecessors;
        List<Position> walls;

        public BFSResult(Map<Position, PathNode> predecessors, List<Position> walls) {
            this.predecessors = predecessors;
            this.walls = walls;
        }
    }

    static class PathNode {
        Position position;
        int dist;

        PathNode(Position position, int dist) {
            this.position = position;
            this.dist = dist;
        }
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
