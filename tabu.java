import java.util.*;

public class tabu {

    static int[][] distance = { { 0, 1, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 3, 4, 5, 6, 7 },
            { 1, 0, 1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 3, 4, 5, 4, 3, 4, 5, 6 },
            { 2, 1, 0, 1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 3, 4, 5, 4, 3, 4, 5 },
            { 3, 2, 1, 0, 1, 4, 3, 2, 1, 2, 5, 4, 3, 2, 3, 6, 5, 4, 3, 4 },
            { 4, 3, 2, 1, 0, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3 },
            { 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6 },
            { 2, 1, 2, 3, 4, 1, 0, 1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 3, 4, 5 },
            { 3, 2, 1, 2, 3, 2, 1, 0, 1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 3, 4 },
            { 4, 3, 2, 1, 2, 3, 2, 1, 0, 1, 4, 3, 2, 1, 2, 5, 4, 3, 2, 3 },
            { 5, 4, 3, 2, 1, 4, 3, 2, 1, 0, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2 },
            { 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 1, 2, 3, 4, 5 },
            { 3, 2, 3, 4, 5, 2, 1, 2, 3, 4, 1, 0, 1, 2, 3, 2, 1, 2, 3, 4 },
            { 4, 3, 2, 3, 4, 3, 2, 1, 2, 3, 2, 1, 0, 1, 2, 3, 2, 1, 2, 3 },
            { 5, 4, 3, 2, 3, 4, 3, 2, 1, 2, 3, 2, 1, 0, 1, 4, 3, 2, 1, 2 },
            { 6, 5, 4, 3, 2, 5, 4, 3, 2, 1, 4, 3, 2, 1, 0, 5, 4, 3, 2, 1 },
            { 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4 },
            { 4, 3, 4, 5, 6, 3, 2, 3, 4, 5, 2, 1, 2, 3, 4, 1, 0, 1, 2, 3 },
            { 5, 4, 3, 4, 5, 4, 3, 2, 3, 4, 3, 2, 1, 2, 3, 2, 1, 0, 1, 2 },
            { 6, 5, 4, 3, 4, 5, 4, 3, 2, 3, 4, 3, 2, 1, 2, 3, 2, 1, 0, 1 },
            { 7, 6, 5, 4, 3, 6, 5, 4, 3, 2, 5, 4, 3, 2, 1, 4, 3, 2, 1, 0 } };

    static int[][] flow = { { 0, 0, 5, 0, 5, 2, 10, 3, 1, 5, 5, 5, 0, 0, 5, 4, 4, 0, 0, 1 },
            { 0, 0, 3, 10, 5, 1, 5, 1, 2, 4, 2, 5, 0, 10, 10, 3, 0, 5, 10, 5 },
            { 5, 3, 0, 2, 0, 5, 2, 4, 4, 5, 0, 0, 0, 5, 1, 0, 0, 5, 0, 0 },
            { 0, 10, 2, 0, 1, 0, 5, 2, 1, 0, 10, 2, 2, 0, 2, 1, 5, 2, 5, 5 },
            { 5, 5, 0, 1, 0, 5, 6, 5, 2, 5, 2, 0, 5, 1, 1, 1, 5, 2, 5, 1 },
            { 2, 1, 5, 0, 5, 0, 5, 2, 1, 6, 0, 0, 10, 0, 2, 0, 1, 0, 1, 5 },
            { 10, 5, 2, 5, 6, 5, 0, 0, 0, 0, 5, 10, 2, 2, 5, 1, 2, 1, 0, 10 },
            { 3, 1, 4, 2, 5, 2, 0, 0, 1, 1, 10, 10, 2, 0, 10, 2, 5, 2, 2, 10 },
            { 1, 2, 4, 1, 2, 1, 0, 1, 0, 2, 0, 3, 5, 5, 0, 5, 0, 0, 0, 2 },
            { 5, 4, 5, 0, 5, 6, 0, 1, 2, 0, 5, 5, 0, 5, 1, 0, 0, 5, 5, 2 },
            { 5, 2, 0, 10, 2, 0, 5, 10, 0, 5, 0, 5, 2, 5, 1, 10, 0, 2, 2, 5 },
            { 5, 5, 0, 2, 0, 0, 10, 10, 3, 5, 5, 0, 2, 10, 5, 0, 1, 1, 2, 5 },
            { 0, 0, 0, 2, 5, 10, 2, 2, 5, 0, 2, 2, 0, 2, 2, 1, 0, 0, 0, 5 },
            { 0, 10, 5, 0, 1, 0, 2, 0, 5, 5, 5, 10, 2, 0, 5, 5, 1, 5, 5, 0 },
            { 5, 10, 1, 2, 1, 2, 5, 10, 0, 1, 1, 5, 2, 5, 0, 3, 0, 5, 10, 10 },
            { 4, 3, 0, 1, 1, 0, 1, 2, 5, 0, 10, 0, 1, 5, 3, 0, 0, 0, 2, 0 },
            { 4, 0, 0, 5, 5, 1, 2, 5, 0, 0, 0, 1, 0, 1, 0, 0, 0, 5, 2, 0 },
            { 0, 5, 5, 2, 2, 0, 1, 2, 0, 5, 2, 1, 0, 5, 5, 0, 5, 0, 1, 1 },
            { 0, 10, 0, 5, 5, 1, 0, 2, 0, 5, 2, 2, 0, 5, 10, 2, 2, 1, 0, 6 },
            { 1, 5, 0, 5, 1, 5, 10, 10, 2, 2, 5, 5, 5, 0, 10, 0, 0, 1, 6, 0 } };

    static final int numberOfIterations = 2000;
    static final int tabuLength = 5;

    public static void main(String[] args) {

        int[] currSolution = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int[] bestSol = new int[20];
        System.arraycopy(currSolution, 0, bestSol, 0, 20);

        int bestCost = getCost(bestSol);
        ArrayList<tabuMove> tabuList = new ArrayList<tabuMove>();

        for (int i = 0; i < numberOfIterations; i++) {
            int currCost = getBestNeighbour(tabuList, currSolution);

            if (currCost < bestCost) {
                System.arraycopy(currSolution, 0, bestSol, 0, 20);
                bestCost = currCost;
            }
        }

        System.out.println("\n\nSearch done! \nBest Solution cost found = " + bestCost + "\nBest Solution :");
        for (int i = 0; i < 20; i++) {
            System.out.print(bestSol[i] + " ,");
        }
    }

    static int getCost(int[] sol) {
        int cost = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                cost += flow[sol[i] - 1][sol[j] - 1] * distance[i][j];
            }
        }
        return cost;
    }

    static int getBestNeighbour(ArrayList<tabuMove> tabuList, int[] currSol) {
        int currCost = getCost(currSol);
        int[] tempSol = new int[20];
        int alpha = 0, beta = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = i + 1; j < 20; j++) {
                boolean isTabu = false;
                for (int k = 0; k < tabuList.size(); k++) {
                    if ((tabuList.get(k).alpha == i && tabuList.get(k).beta == j)
                            || (tabuList.get(k).alpha == j && tabuList.get(k).beta == i)) {
                        isTabu = true;
                    }
                }
                if (!isTabu) {
                    System.arraycopy(currSol, 0, tempSol, 0, 20);
                    int temp = tempSol[i];
                    tempSol[i] = tempSol[j];
                    tempSol[j] = temp;
                    int cost = getCost(tempSol);
                    if (cost < currCost) {
                        alpha = i;
                        beta = j;
                        currCost = cost;
                    }
                }
            }
        }
        if (alpha != beta) {
            tabuList.add(new tabuMove(alpha, beta));
            int temp = currSol[alpha];
            currSol[alpha] = currSol[beta];
            currSol[beta] = temp;
        } else {
            do {
                alpha = (int) (Math.random() * 20);
                beta = (int) (Math.random() * 20);
            } while (alpha == beta);
            tabuList.add(new tabuMove(alpha, beta));
            int temp = currSol[alpha];
            currSol[alpha] = currSol[beta];
            currSol[beta] = temp;
        }
        while (tabuList.size() > tabuLength) {
            tabuList.remove(0);
        }
        return currCost;
    }
}

class tabuMove {
    int alpha;
    int beta;

    public tabuMove(int alpha, int beta) {
        this.alpha = alpha;
        this.beta = beta;
    }
}