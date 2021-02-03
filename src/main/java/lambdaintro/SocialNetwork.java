package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SocialNetwork {

    private List<Member> network;

    public SocialNetwork(List<Member> network) {
        this.network = network;
    }

    public List<Member> getNetwork() {
        return network;
    }

    public List<Member> findMembersBy(Predicate<Member> predicate) {
        return network.stream().filter(m -> predicate.test(m)).collect(Collectors.toList());
    }

    public void applyToSelectedMembers(Predicate<Member> predicate, Consumer<Member> consumer) {
        for (Member m : network) {
            if (predicate.test(m)) {
                consumer.accept(m);
            }
        }
    }

    public <T> List<T> transformMembers(Function<Member, T> function) {
        List<T> transformed = new ArrayList<>();
        for (Member m : network) {
            transformed.add(function.apply(m));
        }
        return transformed;
    }
}
