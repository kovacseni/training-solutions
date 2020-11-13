package references.socialnetwork;

public class SocialNetworkMain {

    public static void main(String[] args) {

        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.addMember("Kiss József");
        socialNetwork.addMember("Nagy Béla");
        socialNetwork.addMember("Szép Szilvia");
        socialNetwork.addMember("Rút Rezső");
        socialNetwork.addMember("Jóska Pista");

        System.out.println(socialNetwork);

        socialNetwork.connect("Kiss József", "Nagy Béla");
        socialNetwork.connect("Rút Rezső", "Szép Szilvia");
        socialNetwork.connect("Jóska Pista", "Kiss József");
        socialNetwork.connect("Nagy Béla", "Kiss József");
        socialNetwork.connect("Szép Szilvia", "Rút Rezső");
        socialNetwork.connect("Szép Szilvia", "Jóska Pista");
        socialNetwork.connect("Jóska Pista", "Szép Szilvia");
        socialNetwork.connect("Jóska Pista", "Rút Rezső");
        socialNetwork.connect("Kiss József", "Szép Szilvia");

        System.out.println(socialNetwork);
        System.out.println(socialNetwork.bidirectionalConnections());
    }
}
