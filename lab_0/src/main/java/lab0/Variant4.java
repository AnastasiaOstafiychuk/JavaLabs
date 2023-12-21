package lab0;

public class Variant4 {

    /**
     * @param num is a two-digit number
     * @return an array of the sum and product of the digits
     * @throws IllegalArgumentException if the number is not a two-digit positive number
     */

    public static int integerTask(int A, int B) {
        if (B <= 0 || A <= B) {
            throw new IllegalArgumentException("Arguments must be equals or more 0!");
        }

        return A / B;
    }


    /**
     * @param a is integer number
     * @param b is integer number
     * @param c is integer number
     * @return true, if number b is between numbers a and c
     */

    public static boolean booleanTask(int A, int B) {
        return (A > 2) && (B != 3);
    }


    /**
     * @param a is float number
     * @param b is float number
     * @return ordinal number of the smaller number
     */

    public static int ifTask(int A, int B, int C) {
        int[] numbers = {A, B, C};
        int counterPositiveNumbers = 0;

        for (int number : numbers) {
            if (number > 0) {
                counterPositiveNumbers++;
            }
        }

        return counterPositiveNumbers;
    }

    /**
     * @param n    is number between 1 and 5
     * @param mass is weight in certain units
     * @return weight in specified units
     * @throws IllegalArgumentException if N is not a number between 1 and 5
     * @throws IllegalArgumentException if Mass number is not a a non-negative float number
     */

    public static int caseTask(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }

        return switch (month) {
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }


    /**
     * @param a is integer number
     * @param b is integer number
     * @return sum of integers from a to b inclusive
     */

    public static double[] forTask(double priceCandles) {
        double[] pricesCandles = new double[10];

        for (int i = 0; i < 10; i++) {
            pricesCandles[i] = priceCandles * (i + 1);
        }

        return pricesCandles;
    }


    /**
     * @param n is integer number
     * @return the smallest integer which square is greater than n
     * throws IllegalArgumentException if argument is not an integer positive number
     */

    public static boolean whileTask(int N) {
        if (N <= 0) throw new IllegalArgumentException("Invalid N!");

        while (N > 1) {
            if (N % 3 != 0) {
                return false;
            }
            N /= 3;
        }

        return true;

    }


    /**
     * @param n   is integer number
     * @param arr is an array of n elements
     * @return numbers of the first maximum and last minimum element from a given set
     * @throws IllegalArgumentException if the array length is less than 2
     */

    public static int minMaxTask(int N, int[] array) {
        if (N <= 0 || array.length != N) throw new IllegalArgumentException("Invalid N!");

        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * @param n   is an integer number
     * @param arr is array of n elements
     * @throws IllegalArgumentException if n is incorrect
     */

    // print the array in reverse order
    public static double[] arrayTask(int N, double A, double D) {
        if (N < 1 || A == 0 || D == 0)
            throw new IllegalArgumentException("Invalid N or A or D!");

        double[] progressionArray = new double[N];

        for (int i = 0; i < N; i++) {
            progressionArray[i] = A * Math.pow(D, i);
        }

        return progressionArray;
    }

    /**
     * @param matrix is a matrix of integers
     * @param n      is an integer number
     * @param m      is an integer number
     * @param k      is an integer number
     * @throws IllegalArgumentException if matrix dimensions are invalid or k is out of bounds
     */

    // print the elements of the k-th row of the matrix.
    public static double[][] matrixTask(int M, int N, double[] numbers) {
        if (M <= 0 || N <= 0 || numbers.length != N) {
            throw new IllegalArgumentException("Invalid arguments!!");
        }

        double[][] matrix = new double[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = numbers[j];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        System.out.println("Start of zero lab.");
        System.out.println("Done!");
    }
}
