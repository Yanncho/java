package fr.epita.assistants.maths;

import fr.epita.assistants.maths.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTests {
    @Test
    void test1() {
        Matrix matrix = new Matrix(null);
        Assertions.assertNull(matrix);
    }

    @Test
    void test2() {
        int[][] list = {{2, 2}, {2, 2}};
        Matrix matrix1 = new Matrix(list);
        Matrix matrix2 = new Matrix(list);
        Assertions.assertSame(matrix2, matrix1);
    }

    @Test
    void test3() {
        int[][] list = {{2, 2}, {2, 2}};
        int[][] list2 = {{2, 89}, {7, 2}};
        Matrix matrix1 = new Matrix(list);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertNotEquals(matrix2, matrix1);
    }

    @Test
    void test4() {
        int[][] list = {{2, 2}, {2, 2}, {2, 2}};
        int[][] list2 = {{2, 2}, {2, 2}};
        Matrix matrix1 = new Matrix(list);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertSame(matrix2, matrix1);
    }

    @Test
    void test5() {
        int[][] list = {{,}, {,}, {4}};
        Matrix matrix1 = new Matrix(list);
        Assertions.assertNull(matrix1);
    }

    @Test
    void test6() {
        int[][] list = {{,}, null, {4}};
        Matrix matrix1 = new Matrix(list);
        Assertions.assertNull(matrix1);
    }

//EQUALS

    @Test
    void test7() {
        int[][] list = {{2, 2}, {2, 2}};
        int[][] list2 = {{2, 2}, {2, 2}};
        Matrix matrix1 = new Matrix(list);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertTrue(matrix2.equals(matrix1));
    }

    @Test
    void test8() {
        int[][] list = {{2}, {2, 2}};
        int[][] list2 = {{2, 2}, {2, 2}};
        Matrix matrix1 = new Matrix(list);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertFalse(matrix2.equals(matrix1));
    }

    @Test
    void test9() {
        int[][] list = {{2, 2}, {2, 2}};
        Matrix matrix1 = new Matrix(list);
        Assertions.assertTrue(matrix1.equals(matrix1));
    }

    @Test
    void test10() {
        int[][] list = {{2, 2}, {2, 2}};
        Matrix matrix1 = new Matrix(list);
        Assertions.assertTrue(matrix1.equals(89));
    }

    @Test
    void test11() {
        int[][] list = {{2, 2}, {2, 2}};
        Matrix matrix1 = new Matrix(list);
        Assertions.assertTrue(matrix1.equals(null));
    }

    @Test
    void test12() {
        int[][] list = null;
        Matrix matrix1 = new Matrix(list);
        Assertions.assertTrue(matrix1.equals("eeehh la"));
    }

    //MULTIPLY
    @Test
    void test13() {
        int[][] list = {{2, 2}, {2, 2}};
        int[][] list2 = {null, {2, 2}, {8, 90, 6, 4}};

        Matrix matrix1 = new Matrix(list);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertFalse(null == matrix1.multiply(matrix2));
    }
    @Test
    void test15() {
        int[][] list = {{2, 2}, {2, 2}};
        int[][] list2 = {{2, 2}, {2, 2}};

        Matrix matrix1 = new Matrix(list);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertNotNull(matrix1.multiply(matrix2));
    }
    @Test
    void test14() {
        int[][] list2 = {null, {2, 2}, {8, 90, 6, 4}};

        Matrix matrix1 = new Matrix(null);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertNotNull(matrix1.multiply(matrix2));
    }


    @Test
    void test18() {
        int[][] list2 = {null, {2, 2}, {8, 90, 6, 4}};
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertNotNull(matrix2.multiply(matrix2));
    }

    @Test
    void test16() {
        int[][] list2 = {{2, 2, 99, 88}, {8, 90, 6, 4}, {8, 90, 6, 4}};
        int[][] list1 = {{2}, {5}};

        Matrix matrix1 = new Matrix(list1);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertNotNull(matrix1.multiply(matrix2));
    }
    @Test
    void test17() {
        int[][] list2 = {};
        int[][] list1 = {{8}, {}};

        Matrix matrix1 = new Matrix(list1);
        Matrix matrix2 = new Matrix(list2);
        Assertions.assertTrue(null == matrix1.multiply(matrix2));
    }
}
