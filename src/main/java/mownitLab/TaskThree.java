package mownitLab;

public class TaskThree {

    // for float
    public float fpRiemann(float s, int n) {
        float partialSum = 0;
        for (int k = 1; k <= n; k++) {
            partialSum += 1 / (Math.pow(k, s));
        }
        return partialSum;
    }

    public float fpRiemannBd(float s, int n) {
        float partialSum = 0;
        for (int k = n; k >= 1; k--) {
            partialSum += 1 / (Math.pow(k, s));
        }
        return partialSum;
    }

    public float fpDirichlet(float s, int n) {
        float partialSum = 0;
        for (int k = 1; k <= n; k++) {
            partialSum += Math.pow(-1, k - 1) * (1 / (Math.pow(k, s)));
        }
        return partialSum;
    }

    public float fpDirichletBd(float s, int n) {
        float partialSum = 0;
        for (int k = n; k >= 1; k--) {
            partialSum += Math.pow(-1, k - 1) * (1 / (Math.pow(k, s)));
        }
        return partialSum;
    }

    // for double
    public double dbRiemann(double s, int n) {
        double partialSum = 0;
        for (int k = 1; k <= n; k++) {
            partialSum += 1 / (Math.pow(k, s));
        }
        return partialSum;
    }

    public double dbRiemannBd(double s, int n) {
        float partialSum = 0;
        for (int k = n; k >= 1; k--) {
            partialSum += 1 / (Math.pow(k, s));
        }
        return partialSum;
    }

    public double dbDirichlet(double s, int n) {
        float partialSum = 0;
        for (int k = 1; k <= n; k++) {
            partialSum += Math.pow(-1, k - 1) * (1 / (Math.pow(k, s)));
        }
        return partialSum;
    }

    public double dbDirichletBd(double s, int n) {
        float partialSum = 0;
        for (int k = n; k >= 1; k--) {
            partialSum += Math.pow(-1, k - 1) * (1 / (Math.pow(k, s)));
        }
        return partialSum;
    }

    public void calculationsForS(float s, int[] n) {
        float[][] values = new float[5][4];
        System.out.println("S = " + s);
        for (int i = 0; i < 5; i++) {
            values[i][0] = fpRiemann(s, n[i]);
            values[i][1] = fpRiemannBd(s, n[i]);
            values[i][2] = fpDirichlet(s, n[i]);
            values[i][3] = fpDirichletBd(s, n[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(values[i][0] + " " + values[i][1] + " " + values[i][2] + " " + values[i][3]);
            System.out.println("Riemman difference : " + (values[i][0] -  values[i][1]) + " |||| Dirichlet difference : " + (values[i][2] - values[i][3]));
        }
        System.out.println("");
    }

    public void calculationsForDoubleS(double s, int[] n) {
        double[][] values = new double[5][4];
        System.out.println("S = " + s);
        for (int i = 0; i < 5; i++) {
            values[i][0] = dbRiemann(s, n[i]);
            values[i][1] = dbRiemannBd(s, n[i]);
            values[i][2] = dbDirichlet(s, n[i]);
            values[i][3] = dbDirichletBd(s, n[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(values[i][0] + " " + values[i][1] + " " + values[i][2] + " " + values[i][3]);
            System.out.println("Riemman difference : " + (values[i][0] -  values[i][1]) + " |||| Dirichlet difference : " + (values[i][2] - values[i][3]));
        }

        System.out.println("");
    }

    public void calculate() {
        float[] sF = {2, (float) 3.6667, 5, (float) 7.2, 10};
        double[] sD = {2, 3.6667, 5, 7.2, 10};
        int[] topIndex = {50, 100, 200, 500, 1000};
        float[][] floatArray = new float[25][4];
//        for(int n : topIndex){
//            System.out.println("N = " + n);
//            System.out.println("Floating point : ");
//            for(float s : sF){
//                System.out.println(s + " Forwards sum : " + fpRiemann(s, n) + " " + fpDirichlet(s, n) + " Backward sum : " + fpRiemannBd(s, n) + " " + fpDirichletBd(s, n));
//            };
//            System.out.println("Double : ");
//            for(double s : sD){
//                System.out.println(s + " Forwards sum : " + dbRiemann(s, n) + " " + dbDirichlet(s, n) + " Backward sum : " + dbRiemannBd(s, n) + " " + dbDirichletBd(s, n));
//            };
//            System.out.println("");
//        }
        System.out.println("FLOATS : ");

        for (int i = 0; i < 5; i++) {
            calculationsForS(sF[i], topIndex);
        }

        System.out.println("DOUBLES : ");

        for (int i = 0; i < 5; i++) {
            calculationsForDoubleS(sD[i], topIndex);
        }
    }
}
