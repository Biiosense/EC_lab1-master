import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList children = new ArrayList();

        // your implementation:
        if(p1.length != p2.length)
            return children;

        double[] child1 = new double[p1.length];
        double[] child2 = new double[p1.length];


        double mutationFactor = 0.5;
        int mutationNumber = random.nextInt(p1.length);
        for (int j = 0; j < p1.length; j++)
        {
            if (j < mutationNumber)
            {
                child1[j] = p1[j];
                child2[j] = p2[j];
            }
            else
            {
                child1[j] = (mutationFactor * p1[j]) + ( (1 - mutationFactor) * p2[j]) ;
                child2[j] = (mutationFactor * p2[j]) + ( (1 - mutationFactor) * p1[j]) ;
            }

        }

        children.add(child1);
        children.add(child2);


     //   children.add(p1);
      //  children.add(p2);
        return children;
    }
}
