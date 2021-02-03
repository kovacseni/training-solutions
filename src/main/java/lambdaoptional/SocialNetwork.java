package lambdaoptional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> network;

    public SocialNetwork(List<Member> network) {
      this.network = network;
    }

    public Optional<Member> findFirst(Predicate<Member> predicate) {
        return network.stream().filter(m -> predicate.test(m)).min(Comparator.comparing(Member::getName));
    }

    public Optional<Double> averageNumberOfSkills() {
        if (network.isEmpty()) {
            return Optional.empty();
        }
        int sumOfSkills = 0;
        for (Member m : network) {
            sumOfSkills += m.getSkills().size();
        }
        return Optional.of(Double.valueOf((double)sumOfSkills / network.size()));
    }
}
