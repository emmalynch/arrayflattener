import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {

    /**
     * Flattens an array of arbitrarily nested arrays of integers into a flat array of integers.
     * e.g. [[1,2,[3]],4] → [1,2,3,4]
     *
     * @param unflattenedArray array of objects to accommodate ints or int arrays
     * @return flattened array of ints
     */
    public static List<Integer> flatten(Object[] unflattenedArray) {
        if(unflattenedArray == null){
            return null;
        }

        List<Integer> flattenedArray = new ArrayList<>();

        for (Object element : unflattenedArray) {
            if (element instanceof Integer) {
                flattenedArray.add((Integer)element);
            } else {
                flattenedArray.addAll(flatten((Object[]) element));
            }
        }
        return flattenedArray;
    }

}
