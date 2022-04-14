package solutions;

import java.util.Random;

public class PiEstimator {
    double estimate (int numberOfIterations){
        Random r = new Random();
        int inCircle = 0 , outCircle = 0;
        double x,y,dist;
        for(int i=0; i < 100000000; i++){
            x = r.nextDouble();
            y = r.nextDouble();
            dist = distWithOrigin(x,y);
            if(dist > 1.0)
                outCircle++;
            else
                inCircle++;
        }
        System.out.println("in = "+inCircle+", out = "+outCircle);
        double ration = ((double)inCircle/(double)(outCircle+inCircle));
        return  ration*4;
    }
    static double distWithOrigin (double x , double y){
        return Math.sqrt(x*x+y*y);
    }
    public static void main(String[] args) {
        PiEstimator estimator = new PiEstimator();
        double pi = estimator.estimate(1999999);
        System.out.println(pi);
    }

}
