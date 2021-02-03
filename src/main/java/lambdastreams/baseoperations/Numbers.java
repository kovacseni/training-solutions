package lambdastreams.baseoperations;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Numbers {

    private List<Integer> ints;

    public Numbers(List<Integer> ints){
        this.ints = ints;
    }

    public Optional min() {
        Optional<Integer> result = ints.stream().min(Comparator.naturalOrder());
        return result;
    }

    public Integer sum() {
        BinaryOperator<Integer> bin = (a, b) -> a + b;
        Integer result = ints.stream().reduce(0, bin, bin);
        return result;
    }

    public List<Integer> getDistinctElements() {
        List<Integer> result = ints.stream().distinct().collect(Collectors.toList());
        return result;
    }

    public boolean isAllPositive() {
        boolean result = ints.stream().allMatch(i -> i > 0);
        return result;
    }
}
