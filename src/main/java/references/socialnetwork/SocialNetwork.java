package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> socialNetwork = new ArrayList<>();

    public void addMember(String name) {
        Member member = new Member(name);
        socialNetwork.add(member);
    }

    public void connect(String name, String anotherName) {
        Member m = findByName(name);
        m.connectMember(findByName(anotherName));
    }

    public List<String> bidirectionalConnections() {
        List<String> membersConnections = new ArrayList<>();
        for (Member m : socialNetwork) {
            for (Member m2: m.getConnections()) {
                if (m.getConnections().contains(m2)) {
                    membersConnections.add((m2.getName() + "-" + m.getName()));
                }
            }
        }
        return membersConnections;
    }

    private Member findByName(String name) {
        for (Member m : socialNetwork) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return socialNetwork.toString();
    }

}
