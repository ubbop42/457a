import java.util.*;
import java.lang.Math;

class NodeComparator implements Comparator<Node> {

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(Node s1, Node s2) {
        if (s1.cost > s2.cost)
            return 1;
        else if (s1.cost < s2.cost)
            return -1;
        return 0;
    }
}

class Node {
    public int x;
    public int y;
    public int cost;

    // A parameterized student constructor
    public Node(int x, int y, int cost) {

        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class maze {
    public static final int N = 25;
    public static int visited = 0;

    public static void main(String[] args) {
        int[][] map = { { 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 },
                { 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        int[] startxs = { 24, 13, 13 }; // the map is rotated so the x values are opposite.
        int[] startys = { 0, 2, 2 };
        int[] endxs = { 0, 5, 3 }; // the map is rotated so the x values are opposite.
        int[] endys = { 24, 23, 2 };

        for (int counter = 0; counter < 3; counter++) {
            int startx = startxs[counter];
            int starty = startys[counter];
            int endx = endxs[counter];
            int endy = endys[counter];

            for (int counter2 = 1; counter2 <= 3; counter2++) {

                int cost = 0;
                // astar
                System.out.println("astar");
                visited = 0;
                int[][] sol = new int[25][25];
                if (astar(map, startx, starty, endx, endy, sol)) {
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (sol[i][j] != 0) {
                                cost++;
                                System.out.print(" " + sol[i][j] + " ");
                            } else {
                                if (map[i][j] == 0) {
                                    System.out.print(" " + map[i][j] + " ");
                                } else {
                                    System.out.print("   ");
                                }
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("visited: " + visited);
                    System.out.println("cost: " + cost);
                } else {
                    System.out.println("no solution found");
                }

                // dfs
                System.out.println("dfs");
                cost = 0;
                visited = 0;
                int[][] sol0 = new int[25][25];
                if (dfs(map, startx, starty, endx, endy, sol0)) {
                    sol0[startx][starty] = 5;
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (sol0[i][j] != 0) {
                                cost++;
                                System.out.print(" " + sol0[i][j] + " ");
                            } else {
                                if (map[i][j] == 0) {
                                    System.out.print(" " + map[i][j] + " ");
                                } else {
                                    System.out.print("   ");
                                }
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("visited: " + visited);
                    System.out.println("cost: " + cost);
                } else {
                    System.out.println("no solution found");
                }

                // bfs
                System.out.println("bfs");
                cost = 0;
                visited = 0;
                int[][] sol1 = new int[25][25];
                if (bfs(map, startx, starty, endx, endy, sol1)) {
                    sol1[startx][starty] = 5;
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (sol1[i][j] != 0) {
                                cost++;
                                System.out.print(" " + sol1[i][j] + " ");
                            } else {
                                if (map[i][j] == 0) {
                                    System.out.print(" " + map[i][j] + " ");
                                } else {
                                    System.out.print("   ");
                                }
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("visited: " + visited);
                    System.out.println("cost: " + cost);
                } else {
                    System.out.println("no solution found");
                }
            }
        }

    }

    public static int getH(int x, int y, int endx, int endy) {
        double h = Math.sqrt(Math.pow((double) endx - x, 2.0) + Math.pow((double) endy - y, 2.0));
        return (int) h;
    }

    public static boolean astar(int map[][], int x, int y, int endx, int endy, int sol[][]) {
        int[][] visitedNodes = new int[25][25];
        int[][] closed = new int[25][25];
        int[][] parents = new int[25][25];
        int[][] h = new int[25][25];
        PriorityQueue<Node> pq = new PriorityQueue<Node>(625, new NodeComparator());
        Node node = new Node(x, y, getH(x, y, endx, endy));
        h[x][y] = 0;
        int startx = x;
        int starty = y;
        pq.add(node);
        while (!pq.isEmpty()) {
            visited++;
            Node currNode = pq.poll();
            x = currNode.x;
            y = currNode.y;
            if (closed[x][y] == 1) {
                continue;
            }
            closed[x][y] = 1;
            if (x == endx && y == endy) {
                sol[x][y] = 8;
                // backtrack to source
                while (!(x == startx && y == starty)) {
                    if (parents[x][y] == 0) {
                        x = x - 1;
                    } else if (parents[x][y] == 1) {
                        x = x + 1;
                    } else if (parents[x][y] == 2) {
                        y = y - 1;
                    } else if (parents[x][y] == 3) {
                        y = y + 1;
                    }
                    sol[x][y] = 1;
                }
                sol[x][y] = 5;
                return true;
            }
            int closedCost = h[x][y];
            if (x >= 0 && x < N && (y - 1) >= 0 && (y - 1) < N && map[x][y - 1] == 1 && closed[x][y - 1] != 1) {
                if (visitedNodes[x][y - 1] == 0) {
                    int hh = closedCost + 1 + getH(x, (y - 1), endx, endy);
                    Node nodeWest = new Node(x, (y - 1), hh);
                    h[x][y - 1] = closedCost + 1;
                    pq.add(nodeWest);
                    visitedNodes[x][y - 1] = 1;
                    parents[x][y - 1] = 3;
                } else {
                    int newh = closedCost + 1 + getH(x, (y - 1), endx, endy);
                    if ((closedCost + 1) < h[x][y - 1]) {
                        Node nodeWest = new Node(x, (y - 1), newh);
                        h[x][y - 1] = closedCost + 1;
                        pq.add(nodeWest);
                        visitedNodes[x][y - 1] = 1;
                        parents[x][y - 1] = 3;
                    }
                }
            }
            if (x >= 0 && x < N && (y + 1) >= 0 && (y + 1) < N && map[x][y + 1] == 1 && closed[x][y + 1] != 1) {
                if (visitedNodes[x][y + 1] == 0) {
                    int hh = closedCost + 1 + getH(x, (y + 1), endx, endy);
                    Node nodeWest = new Node(x, (y + 1), hh);
                    h[x][y + 1] = closedCost + 1;
                    pq.add(nodeWest);
                    visitedNodes[x][y + 1] = 1;
                    parents[x][y + 1] = 2;
                } else {
                    int newh = closedCost + 1 + getH(x, (y + 1), endx, endy);
                    if (closedCost + 1 < h[x][y + 1]) {
                        Node nodeWest = new Node(x, (y + 1), newh);
                        h[x][y + 1] = closedCost + 1;
                        pq.add(nodeWest);
                        visitedNodes[x][y + 1] = 1;
                        parents[x][y + 1] = 2;
                    }
                }
            }
            if ((x - 1) >= 0 && (x - 1) < N && y >= 0 && y < N && map[x - 1][y] == 1 && closed[x - 1][y] != 1) {
                if (visitedNodes[x - 1][y] == 0) {
                    int hh = closedCost + 1 + getH(x - 1, y, endx, endy);
                    Node nodeWest = new Node(x - 1, y, hh);
                    h[x - 1][y] = closedCost + 1;
                    pq.add(nodeWest);
                    visitedNodes[x - 1][y] = 1;
                    parents[x - 1][y] = 1;
                } else {
                    int newh = closedCost + 1 + getH(x - 1, y, endx, endy);
                    if (closedCost + 1 < h[x - 1][y]) {
                        Node nodeWest = new Node(x - 1, y, newh);
                        h[x - 1][y] = closedCost + 1;
                        pq.add(nodeWest);
                        visitedNodes[x - 1][y] = 1;
                        parents[x - 1][y] = 1;
                    }
                }
            }
            if ((x + 1) >= 0 && (x + 1) < N && y >= 0 && y < N && map[x + 1][y] == 1 && closed[x + 1][y] != 1) {
                if (visitedNodes[x + 1][y] == 0) {
                    int hh = closedCost + 1 + getH(x + 1, y, endx, endy);
                    Node nodeWest = new Node(x + 1, y, hh);
                    h[x + 1][y] = closedCost + 1;
                    pq.add(nodeWest);
                    visitedNodes[x + 1][y] = 1;
                    parents[x + 1][y] = 0;
                } else {
                    int newh = closedCost + 1 + getH(x + 1, y, endx, endy);
                    if (closedCost + 1 < h[x + 1][y]) {
                        Node nodeWest = new Node(x + 1, y, newh);
                        h[x + 1][y] = closedCost + 1;
                        pq.add(nodeWest);
                        visitedNodes[x + 1][y] = 1;
                        parents[x + 1][y] = 0;
                    }
                }
            }
        }

        return false;

    }

    public static boolean dfs(int map[][], int x, int y, int endx, int endy, int sol[][]) {
        // if (x, y is goal) return true
        if (x == endx && y == endy) {
            sol[x][y] = 8;
            return true;
        }

        // Check if map[x][y] is valid
        if (x >= 0 && x < N && y >= 0 && y < N && map[x][y] == 1 && sol[x][y] == 0) {
            visited++;
            sol[x][y] = 1;

            if (dfs(map, x + 1, y, endx, endy, sol))
                return true;

            if (dfs(map, x - 1, y, endx, endy, sol))
                return true;

            if (dfs(map, x, y + 1, endx, endy, sol))
                return true;

            if (dfs(map, x, y - 1, endx, endy, sol))
                return true;

            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static boolean bfs(int map[][], int x, int y, int endx, int endy, int sol[][]) {
        int[][] visitedNodes = new int[25][25];
        int[][] closed = new int[25][25];
        int[][] parents = new int[25][25];
        LinkedList<Node> openList = new LinkedList<Node>();
        Node node = new Node(x, y, 0);
        int startx = x;
        int starty = y;
        openList.add(node);
        while (!openList.isEmpty()) {
            visited++;
            Node currNode = openList.removeFirst();
            x = currNode.x;
            y = currNode.y;
            if (closed[x][y] == 1) {
                continue;
            }
            closed[x][y] = 1;
            if (x == endx && y == endy) {
                sol[x][y] = 8;
                // backtrack to source
                while (!(x == startx && y == starty)) {
                    if (parents[x][y] == 0) {
                        x = x - 1;
                    } else if (parents[x][y] == 1) {
                        x = x + 1;
                    } else if (parents[x][y] == 2) {
                        y = y - 1;
                    } else if (parents[x][y] == 3) {
                        y = y + 1;
                    }
                    sol[x][y] = 1;
                }
                sol[x][y] = 5;
                return true;
            }
            if (x >= 0 && x < N && (y - 1) >= 0 && (y - 1) < N && map[x][y - 1] == 1 && closed[x][y - 1] != 1) {
                Node nodeWest = new Node(x, (y - 1), 0);
                openList.add(nodeWest);
                visitedNodes[x][y - 1] = 1;
                parents[x][y - 1] = 3;
            }
            if (x >= 0 && x < N && (y + 1) >= 0 && (y + 1) < N && map[x][y + 1] == 1 && closed[x][y + 1] != 1) {
                Node nodeWest = new Node(x, (y + 1), 0);
                openList.add(nodeWest);
                visitedNodes[x][y + 1] = 1;
                parents[x][y + 1] = 2;
            }
            if ((x - 1) >= 0 && (x - 1) < N && y >= 0 && y < N && map[x - 1][y] == 1 && closed[x - 1][y] != 1) {
                Node nodeWest = new Node(x - 1, y, 0);
                openList.add(nodeWest);
                visitedNodes[x - 1][y] = 1;
                parents[x - 1][y] = 1;
            }
            if ((x + 1) >= 0 && (x + 1) < N && y >= 0 && y < N && map[x + 1][y] == 1 && closed[x + 1][y] != 1) {
                Node nodeWest = new Node(x + 1, y, 0);
                openList.add(nodeWest);
                visitedNodes[x + 1][y] = 1;
                parents[x + 1][y] = 0;
            }
        }

        return false;
    }

}