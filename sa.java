import java.util.*;

public class sa {

    public static double T = 10;

    // Simulated Annealing parameters

    // Temperature at which iteration terminates
    static final double Tmin = .0001;

    // Decrease in temperature
    static final double alpha = 0.99;

    // Number of iterations of annealing
    // before decreasing temperature
    static final int numIterations = 100;

    public static void main(String[] args) {

        double currx1 = 0;
        double currx2 = 0;
        double bestx1 = currx1;
        double bestx2 = currx2;

        double bestCost = getCost(currx1, currx2);
        while (T > Tmin) {
            for (int i = 0; i < numIterations; i++) {

                double currCost = getCost(currx1, currx2);
                double[] newSol = neighbor(currx1, currx2);
                double newx1 = newSol[0];
                double newx2 = newSol[1];
                double newCost = getCost(newx1, newx1);
                double ap = Math.exp((currCost - newCost) / T);

                if (ap > Math.random()) {
                    currx1 = newx1;
                    currx2 = newx2;
                    currCost = newCost;
                }

                if (currCost < bestCost) {
                    bestCost = currCost;
                    bestx1 = currx1;
                    bestx2 = currx2;
                }
            }
            T *= alpha; // Decreases T, cooling phase
        }

        System.out.println("\ndone! \nBest Solution cost found = " + bestCost + "\nBest Solution :");
        System.out.print(bestx1 + " ," + bestx2);
    }

    static double getCost(double x, double y) {
        return -Math.cos(x) * Math.cos(y)
                * Math.exp(-(((x - Math.PI) * (x - Math.PI)) + ((y - Math.PI) * (y - Math.PI))));
    }

    static double[] neighbor(double x, double y) {
        double[] newSol = new double[2];
        double delta1 = Math.random();
        double delta2 = Math.random();
        newSol[0] = x + delta1 - delta2;
        newSol[1] = y + delta2 - delta1;
        if (newSol[0] > 100)
            newSol[0] -= 200;
        if (newSol[1] > 100)
            newSol[1] -= 200;
        if (newSol[0] < -100)
            newSol[0] += 200;
        if (newSol[1] < -100)
            newSol[1] += 200;
        return newSol;
    }
}