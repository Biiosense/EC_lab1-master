import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.*;

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

        double crossoverFactor = 0.5;
        int crossoverNumber = random.nextInt(p1.length/10);
        Set<Integer> genesCrossover = new HashSet<Integer>();
        while (genesCrossover.size() < crossoverNumber)
            genesCrossover.add(random.nextInt(p1.length));

        for (int j = 0; j < p1.length; j++)
        {
            if (genesCrossover.contains(j))
            {
                child1[j] = (crossoverFactor * p1[j]) + ( (1 - crossoverFactor) * p2[j]) ;
                child2[j] = (crossoverFactor * p2[j]) + ( (1 - crossoverFactor) * p1[j]) ;
            }
            else
            {
                child1[j] = p1[j];
                child2[j] = p2[j];
            }
        }

        children.add(child1);
        children.add(child2);


     //   children.add(p1);
      //  children.add(p2);
        return children;
    }
}
