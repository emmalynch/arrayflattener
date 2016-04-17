import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;

public class ArrayFlattenerTest {

    @Test
    public void testEmptyArray() {
        List<Integer> result = ArrayFlattener.flatten(new Integer[0]);
        Assert.assertEquals(result, EMPTY_LIST);
    }

    @Test
    public void testNullArray() {
        List<Integer> result = ArrayFlattener.flatten(null);
        Assert.assertNull(result);
    }

    @Test
    public void testSimpleArray() {
        Integer[] testArray = {1, 2, 3, 4, 5};
        List<Integer> result = ArrayFlattener.flatten(testArray);
        Assert.assertEquals(result.toArray(), testArray);
    }

    @Test
    public void test2DArray() {
        Object[] testArray = {1, 2, 3, 4, new Object[]{ 5, 6, 7}};
        List<Integer> result = ArrayFlattener.flatten(testArray);
        Integer[] expectedResult = {1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(result.toArray(), expectedResult);
    }

    @Test
    public void testComplexArray() {
        Object[] testArray =  {1, new Object[]{2, 3}, 4, new Object[]{ 5, new Object[]{ new Object[]{ 6,new Object[]{7, 8}}}, 9}};
        List<Integer> result = ArrayFlattener.flatten(testArray);
        Integer[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertEquals(result.toArray(), expectedResult);
    }
}
