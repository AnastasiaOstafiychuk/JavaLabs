import lab0.Variant4;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// matrix and array !!


public class Variant4Test {

    @Test
    public void testIntegerTask() {
        int result = Variant4.integerTask(30, 3);
        assertEquals(result, 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIntegerTaskException() {
        Variant4.integerTask(3, 30);
    }

    @Test
    public void testBooleanTask() {
        boolean result = Variant4.booleanTask(3, 4);
        Assert.assertTrue(result);
    }

    @Test
    public void testIfTask() {
        int result = Variant4.ifTask(-3, 2, 1);
        assertEquals(result, 2);
    }

    @Test
    public void testCaseTask() {
        float result = Variant4.caseTask(3);
        assertEquals(result, 31);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCaseTaskException() {
        Variant4.caseTask(-1);
    }

    @Test
    public void testForTask() {
        double[] result = Variant4.forTask(2);
        assertEquals(result, new double[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
    }

    @Test
    public void testWhileTask() {
        boolean result = Variant4.whileTask(27);
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWhileTaskException() {
        Variant4.whileTask(-5);
    }

    @Test
    public void testMinMaxTask() {
        int result = Variant4.minMaxTask(4, new int[]{5, 8, 2, 10});
        assertEquals(result, 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMinMaxTaskException() {
        Variant4.minMaxTask(-5, new int[]{5});
    }

    @Test
    public void testArrayTask() {
        double[] result = Variant4.arrayTask(3, 1, 2);
        assertEquals(result, new double[]{1, 2, 4});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testArrayTaskException() {
        Variant4.arrayTask(0, 1, 2);
    }

    @Test
    public void testMatrixTask() {
        double[][] result = Variant4.matrixTask(3, 2, new double[]{2, 1});
        assertEquals(result, new double[][] {{2, 1}, {2, 1}, {2, 1}});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMatrixTaskException() {
        Variant4.matrixTask(0, 2, new double[]{2, 1});
    }

}

