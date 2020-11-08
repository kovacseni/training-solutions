package attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        Person person = new Person("Kiss Béla", "123456");
        Address address = new Address("Magyarország", "Budapest", "Arany János utca 3.", "1056");

        System.out.println(person.personToString());
        System.out.println(address.addressToString());

        address.correctData("Magyarország", "Veszprém", "Petőfi Sándor utca 4", "8200");
        person.moveTo(address);
        System.out.println(person.getAddress().addressToString());

        String newCountry = "Magyarország";
        String newCity = "Kiskunhalas";
        String newStreetAndNumber = "Kossuth Lajos utca 2.";
        String newZipCode = "6400";

        address.correctData(newCountry, newCity, newStreetAndNumber, newZipCode);
        person.moveTo(address);

        System.out.println(person.getAddress().addressToString());

    }
}
