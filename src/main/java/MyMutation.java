import org.uncommons.maths.random.GaussianGenerator;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {

    private int generations = 1;
    private double rate = 1.0;

    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!

        // your implementation:

        for (double[] individual : population) {
            for (int i = 0; i < individual.length; i++) {

                if (random.nextDouble() < 0.005) {

                    double mutation_factor = 5 * random.nextDouble() * rate;
                    if (random.nextDouble() < 0.5)
                        individual[i] = mutation_factor;
                    else
                        individual[i] = -mutation_factor;

                    if (individual[i] > 5)
                        individual[i] = 5;
                    else if (individual[i] < -5)
                        individual[i] = -5;
                }
            }
        }
        generations++;
        rate = 0.001 + Math.exp(- (generations/5000.0));

        return population;
    }
}
