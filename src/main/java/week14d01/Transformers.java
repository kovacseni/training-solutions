package week14d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Transformers {

    public <T, R> List<R> map(List<T> list, Function<T, R> transformer) {
        List<R> listR = new ArrayList<>();
        for (T t : list) {
            R r = transformer.apply(t);
            listR.add(r);
        }
        return listR;
    }

    public <T> T reduce(List<T> list, T identity, BiFunction<T, T, T> combiner) {
        T result = identity;
        for (T t : list) {
            result = combiner.apply(result, t);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Transformers().map(Arrays.asList(1, 2, 3), (value) -> value + 1));
        System.out.println(new Transformers().reduce(Arrays.asList(1, 2, 3), 0, Integer::sum));
    }
}
