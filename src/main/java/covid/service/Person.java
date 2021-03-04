package covid.service;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private long id;
    private String name;
    private String postalCode;
    private int age;
    private String email;
    private String ssn;
    private VaccinationState numberOfVaccinesGot;
    private LocalDate lastVaccination;
    private VaccineType vaccineType;

    public Person(String name, String postalCode, int age, String email, String ssn) {
        this.name = name;
        this.postalCode = postalCode;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
    }

    public Person(long id, String name, String postalCode, int age, String email, String ssn) {
        this(name, postalCode, age, email, ssn);
        this.id = id;
        this.numberOfVaccinesGot = VaccinationState.NO;
    }

    public Person(long id, String name, String postalCode, int age, String email, String ssn, VaccinationState numberOfVaccinesGot) {
        this(id, name, postalCode, age, email, ssn);
        this.numberOfVaccinesGot = numberOfVaccinesGot;
    }

    public Person(long id, String name, String postalCode, int age, String email, String ssn, VaccinationState numberOfVaccinesGot, LocalDate lastVaccination, VaccineType vaccineType) {
        this(id, name, postalCode, age, email, ssn);
        this.numberOfVaccinesGot = numberOfVaccinesGot;
        this.lastVaccination = lastVaccination;
        this.vaccineType = vaccineType;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSsn() {
        return ssn;
    }

    public VaccinationState getNumberOfVaccinesGot() {
        return numberOfVaccinesGot;
    }

    public LocalDate getLastVaccination() {
        return lastVaccination;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumberOfVaccinesGot(VaccinationState numberOfVaccinesGot) {
        this.numberOfVaccinesGot = numberOfVaccinesGot;
    }

    public void setLastVaccination(LocalDate lastVaccination) {
        this.lastVaccination = lastVaccination;
    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", ").append(postalCode).append(", ").append(age).append(", ").append(email).append(", ").append(ssn);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(ssn, person.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn);
    }

    @Override
    public int compareTo(Person other) {
        if (this.age == other.age) {
            return this.name.compareTo(other.name);
        }
        return Integer.valueOf(other.age).compareTo(Integer.valueOf(this.age));
    }
}