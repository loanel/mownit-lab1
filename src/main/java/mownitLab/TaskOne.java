package mownitLab;


import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;


public class TaskOne {
    final static int numbersAmount = 10000000;
    final static float arrayNumberValue = (float) 0.53125;
    final static int step = 25000;

    public float iterativeSum(float[] numbers) {
        float sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
        return sum;
    }

    public void plotIterativeSum(float[] numbers) {
        XYSeries dataset = new XYSeries("Relative Error");
        float sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (i % step == 0 & i != 0) {
                float error = relativeError(arrayNumberValue * i, sum);
                dataset.add((double) i / step, (double) error);
//                System.out.println(sum + " " + i * arrayNumberValue);
            }
        }
        XYSeriesCollection gatheredData = new XYSeriesCollection();
        gatheredData.addSeries(dataset);
        XYChartGenerator chart = new XYChartGenerator("Relative Error for iterative sum", gatheredData);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

    public float relativeError(float expectedValue, float sum) {
        float error = ((expectedValue - sum) / expectedValue * 100);
//        System.out.println(expectedValue + " " + sum + " " + error);
        return error;
    }

    public float recurrentSum(float[] numbers, int left, int right) {
        if (left >= right) return numbers[right];
        int pivot = (left + right) / 2;
        return recurrentSum(numbers, left, pivot) + recurrentSum(numbers, pivot + 1, right);
    }

    public void calculate() {
        //setup
        float[] numbersArray = new float[numbersAmount];
        float expectedValue = numbersAmount * arrayNumberValue;
        for (int i = 0; i < numbersAmount; i++) {
            numbersArray[i] = arrayNumberValue;
        }

        //1
        float iterativeSum = iterativeSum(numbersArray);
        System.out.println("The expected value was " + expectedValue + ", iterative sum returned " + iterativeSum);
        //2
        System.out.println("Absolute error = " + (expectedValue - iterativeSum));
        System.out.println("Relative error = " + relativeError(expectedValue, iterativeSum) + "%");
        //3
        plotIterativeSum(numbersArray);
        //4
        float recurrentSum = recurrentSum(numbersArray, 0, numbersAmount - 1);
        System.out.println("The expected value was " + expectedValue + ", recurrent sum returned " + recurrentSum);
        //5
        System.out.println("Absolute error = " + (expectedValue - recurrentSum));
        System.out.println("Relative error = " + relativeError(expectedValue, recurrentSum) + "%");
        //6
        double currentTime = System.currentTimeMillis();
        iterativeSum = iterativeSum(numbersArray);
        System.out.println("Iterative sum took " + (System.currentTimeMillis() - currentTime) + " miliseconds to complete");
        currentTime = System.currentTimeMillis();
        recurrentSum = recurrentSum(numbersArray, 0, numbersAmount - 1);
        System.out.println("Recurrent sum took " + (System.currentTimeMillis() - currentTime) + " miliseconds to complete");
        //7
        float[] reccurentFailureArray = new float[numbersAmount];
        for (int i = 0; i < numbersAmount; i++) {
            reccurentFailureArray[i] = (float) 0.125;
        }
        reccurentFailureArray[0] = 5000000;
        recurrentSum = recurrentSum(reccurentFailureArray, 0, numbersAmount - 1);
        System.out.println(String.format("The recurrent sum returned %f", recurrentSum));
    }
}
