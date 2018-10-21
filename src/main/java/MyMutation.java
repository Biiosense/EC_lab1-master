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
            if (random.nextDouble() < 0.5)
            {
                for (int i = 0; i < individual.length; i++) {

                    if (random.nextDouble() < 0.01)
                    {
                        double gauss = random.nextGaussian() * rate;

                        if (individual[i] > 5)
                            individual[i] = 5;
                        else if (individual[i] < -5)
                            individual[i] = -5;
                    }
                }
            }
        }
        generations++;
        double mini = 0.2;
        rate = mini + Math.exp(- Math.pow(generations/10000.0, 2));
        System.out.println(rate);

        //result population
        return population;
    }
}
