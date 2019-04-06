package cs2030.mystream;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;

public interface MyIntStream {
    public static MyIntStream of(int... values) {
        List<Integer> array = new ArrayList<>();
        for (int value : values) {
            array.add(value);
        }
        return new MyIntStreamImpl(array);
    }

    public static MyIntStream range(int start, int end) {
        List<Integer> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(i);
        }
        return new MyIntStreamImpl(arr);
    }

    public static MyIntStream rangeClosed(int start, int end) {
        List<Integer> arr = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            arr.add(i);
        }
        return new MyIntStreamImpl(arr);
    }

    public long count(); 

    public int sum();

    public OptionalDouble average();

    public OptionalInt max();

    public OptionalInt min();

    public void forEach(IntConsumer action);
    
    public MyIntStream limit(int maxSize);

    public MyIntStream distinct();

    public MyIntStream filter(IntPredicate predicate);

    public MyIntStream map(IntUnaryOperator mapper);

    public int reduce(int identity, IntBinaryOperator op);

    public OptionalInt reduce(IntBinaryOperator op);
}
