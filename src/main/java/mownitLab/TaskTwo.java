package mownitLab;

public class TaskTwo {
    final static int numbersAmount = 10000000;
    final static float arrayNumberValue = (float) 0.53125;

    public float kahanSum(float[] numbers){
        float sum = 0.0f;
        float err = 0.0f;
        for (int i = 0; i < numbers.length; ++i) {
            float y = numbers[i] - err;
            float temp = sum + y;
            err = (temp - sum) - y;
            sum = temp;
        }
        return sum;
    }

    public void calculate(){
        TaskOne taskOneOperations = new TaskOne();
        float[] numbersArray = new float[numbersAmount];
        float expectedValue = numbersAmount * arrayNumberValue;
        for (int i = 0; i < numbersAmount; i++) {
            numbersArray[i] = arrayNumberValue;
        }

        float kahanSum = kahanSum(numbersArray);
        System.out.println("The expected value was " + expectedValue + ", kahan sum returned " + kahanSum);
        //2
        System.out.println("Absolute error = " + (expectedValue - kahanSum));
        System.out.println("Relative error = " + taskOneOperations.relativeError(expectedValue, kahanSum) + "%");

        //6
        double currentTime = System.currentTimeMillis();
        kahanSum = kahanSum(numbersArray);
        System.out.println("Kahan sum took " + (System.currentTimeMillis() - currentTime) + " miliseconds to complete");
        currentTime = System.currentTimeMillis();
        float recurrentSum = taskOneOperations.recurrentSum(numbersArray, 0, numbersAmount - 1);
        System.out.println("Recurrent sum took " + (System.currentTimeMillis() - currentTime) + " miliseconds to complete");
    }
}
