package cs2030.mystream;
import java.util.List;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;

public class MyIntStreamImpl implements MyIntStream {
    private List<Integer> array;

    public MyIntStreamImpl(List<Integer> list) {
        array = list;
    }

    @Override
    public String toString() {
        return array.toString();
    }

    @Override
    public long count() {
        if (array.size() == 0) {
            return 0;
        } else {
            return array.size();
        }
    }

    @Override
    public int sum() {
        int sum = 0;
        for(int el : array) {
            sum += el;
        } 
        return sum;
    }

    @Override
    public OptionalDouble average() {
        if (array.size() == 0) {
            return OptionalDouble.empty();
        } else {
            return OptionalDouble.of(this.sum() / array.size());
        }
    }

    @Override
    public OptionalInt max() {
        if (array.size() == 0) {
            return OptionalInt.empty();
        } else {
            int max = array.get(0);
            for (Integer el : array) {
                if (el > max) {
                    max = el;
                }
            }
            return OptionalInt.of(max);
        }
    }

    @Override
    public OptionalInt min() {
        if (array.size() == 0) {
            return OptionalInt.empty();
        } else {
            int min = array.get(0);
            for (Integer el : array) {
                if (el < min) {
                    min = el;
                }
            }
            return OptionalInt.of(min);
        }
    }

    @Override
    public void forEach(IntConsumer action) {
        for (Integer el : array) {
            action.accept(el);
        }
    }

    @Override
    public MyIntStream limit(int maxSize) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            arr.add(array.get(i));            
        }
        return new MyIntStreamImpl(arr);
    }

    @Override
    public MyIntStream distinct() {
        Set<Integer> distinctHset = new LinkedHashSet<>();
        for (Integer el : array) {
            distinctHset.add(el);
        }
        List<Integer> distinctList = new ArrayList<>(distinctHset);
        return new MyIntStreamImpl(distinctList);
    }

    @Override
    public MyIntStream filter(IntPredicate predicate) {
        List<Integer> arr = new ArrayList<>();
        for (Integer el : array) {
            if (predicate.test(el)) {
                arr.add(el);
            }
        }
        return new MyIntStreamImpl(arr);
    }
    
    @Override
    public MyIntStream map(IntUnaryOperator mapper) {
        List<Integer> arr = new ArrayList<>();
        for (Integer el : array) {
            int mappedEl = mapper.applyAsInt(el);
            arr.add(mappedEl);
        }
        return new MyIntStreamImpl(arr);
    }
    
    @Override
    public int reduce(int identity, IntBinaryOperator op){
        for (Integer el : array) {
            identity = op.applyAsInt(el, identity);
        }   
        return identity;
    }

    @Override
    public OptionalInt reduce(IntBinaryOperator op){
        if (array.size() == 0) {
            return OptionalInt.empty();
        } else {
            int identity = array.get(0);
            for (int i = 1; i < array.size(); i++) {
                int reduced = op.applyAsInt(identity, array.get(i));
                identity = reduced;
            }  
            return OptionalInt.of(identity);
        }
    }
}
