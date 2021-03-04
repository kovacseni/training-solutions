package covid.service;

import covid.CovidVaccineMain;
import covid.database.RegistrationDao;
import covid.userinterface.Registration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class RegistrationService {

    private Check check = new Check();
    private RegistrationDao dao = new RegistrationDao();

    public boolean checkName(String name) {
        return check.checkName(name);
    }

    public boolean checkPostalCode(String postalCode) {
        return check.checkPostalCode(postalCode);
    }

    public String getTown(String postalCode) throws SQLException {
        return dao.getTown(postalCode);
    }

    public boolean checkAge(int age) {
        return check.checkAge(age);
    }

    public boolean checkEmail(String email) {
        return check.checkEmail(email);
    }

    public boolean checkEmail2(String email, String email2) {
        return check.checkEmail2(email, email2);
    }

    public boolean checkSsn(String ssn) {
        return check.checkSsn(ssn);
    }

    public boolean checkIfThisPersonIsRegistratedBefore(String ssn) throws SQLException {
        return dao.checkIfThisPersonIsRegistratedBefore(ssn);
    }

    public boolean postalCodeIsOKAndValid(String postalCode) throws SQLException {
        boolean postalCodeIsOK = checkPostalCode(postalCode);
        boolean postalCodeIsValid = !dao.getTown(postalCode).isEmpty();

        return (postalCodeIsOK && postalCodeIsValid);
    }

    public boolean ageIsNumberAndIsOK(String ageString) {
        boolean ageIsNumber = check.checkAgeIsNumber(ageString);
        int age = 0;
        if (ageIsNumber) {
            age = Integer.parseInt(ageString);
        }
        boolean ageIsOK = checkAge(age);

        return (ageIsNumber && ageIsOK);
    }

    public boolean ssnIsOKAndNotRegistratedBefore(String ssn) throws SQLException {
        boolean ssnIsOk = checkSsn(ssn);
        boolean ssnIsNotRegistratedBefore = !dao.checkIfThisPersonIsRegistratedBefore(ssn);

        return (ssnIsOk && ssnIsNotRegistratedBefore);
    }

    public List<String> registrateMass(String filename, String splitter) throws IOException, SQLException {
        List<String> wrongLines = new ArrayList<>();

        InputStreamReader isr = new InputStreamReader(CovidVaccineMain.class.getResourceAsStream("/covid/" + filename));
        try (BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(splitter);
                boolean nameIsOK = checkName(temp[0]);
                boolean postalCodeIsOK = postalCodeIsOKAndValid(temp[1]);
                boolean ageIsOK = ageIsNumberAndIsOK(temp[2]);
                boolean emailIsOK = checkEmail(temp[3]);
                boolean ssnIsOK = ssnIsOKAndNotRegistratedBefore(temp[4]);

                if (nameIsOK && postalCodeIsOK && ageIsOK && emailIsOK && ssnIsOK) {
                    writeIntoDatabase(new Person(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], temp[4]));
                } else {
                    wrongLines.add(line);
                }
            }
        }
        return wrongLines;
    }

    public void writeIntoDatabase(Person person) throws SQLException {
        dao.writeIntoDatabase(person);
    }

    public void writeWrongLinesToFile(List<String> wrongLines) throws IOException {
        String timeString = LocalDateTime.now().toString().replace(":", "-").replace(".", "-");
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/resources/covid/wrongdata" + timeString + ".csv"))) {
            for (String s : wrongLines) {
                bw.write(s);
                bw.write("\n");
            }
        }
    }

    public void updateName(String ssn, String name) throws SQLException {
        dao.updateName(ssn, name);
    }

    public void updatePostalCode(String ssn, String postalCode) throws SQLException {
        dao.updatePostalCode(ssn, postalCode);
    }

    public void updateAge(String ssn, int age) throws SQLException {
        dao.updateAge(ssn, age);
    }

    public void updateEmail(String ssn, String email) throws SQLException {
        dao.updateEmail(ssn, email);
    }

    public void deleteRegistration(String ssn) throws SQLException {
        dao.deleteRegistration(ssn);
    }

    public void newRegistration() throws SQLException {
        new Registration().registrate();
    }

    public void generateVaccinationListByPostalCode(LocalDate date, String postalCode) throws SQLException, IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/resources/covid/vaccinationlist_" + date.toString() + "_" + postalCode + ".csv"))) {
            PriorityQueue<Person> vaccinationList = dao.getVaccinationList(postalCode);
            String town = dao.getTown(postalCode);
            LocalDate dateBefore = date.minusDays(15);
            bw.write("Oltási lista " + postalCode + ", " + town + " településre" + "\n");
            bw.write(date.toString() + "\n");
            bw.write("\n");
            bw.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám;Legutóbbi vakcina típusa(ha már kapott)" + "\n");

            writeList(bw, vaccinationList, dateBefore);
        }
    }

    private void writeList(BufferedWriter bw, PriorityQueue<Person> vaccinationList, LocalDate dateBefore) throws IOException {
        int count = 0;
        LocalTime time = LocalTime.of(8, 0);
        for (Person p : vaccinationList) {
            if (count < 16) {
                if (p.getLastVaccination() == null || p.getLastVaccination().isBefore(dateBefore)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(time.toString()).append(";").append(p.getName()).append(";").append(p.getPostalCode()).append(";")
                            .append(p.getAge()).append(";").append(p.getEmail()).append(";").append(p.getSsn());
                    if (p.getVaccineType() != null) {
                        sb.append(";").append(p.getVaccineType().toString());
                    }
                    bw.write(sb.toString() + "\n");
                    count++;
                    time = time.plusMinutes(30);
                }
            }
        }
    }

    public Person getPersonWithThisSsn(String ssn) throws SQLException {
        return dao.getPersonWithThisSsn(ssn);
    }

    public boolean checkDate(Person person, LocalDate date2) {
        LocalDate date1 = person.getLastVaccination();
        return check.checkDate(date1, date2);
    }

    public void registrateVaccinationIntoDatabase(String ssn, VaccinationState numberOfVaccinesGot, LocalDate date, VaccineType vaccineType) throws SQLException {
        VaccinationState newVaccinateState = VaccinationState.getState(numberOfVaccinesGot.getValue() + 1);
        dao.registrateVaccinationIntoDatabase(ssn, newVaccinateState, date, vaccineType);
    }

    public void registrateFail(String ssn, String reason, LocalDate date) throws SQLException {
        String commentsBefore = getCommentsBefore(ssn);
        StringBuilder sb = new StringBuilder();
        if (commentsBefore != null) {
            sb.append(commentsBefore).append("; ");
        }
        sb.append("Az oltás meghiúsult: ").append(date.toString())
                .append(" Indok: ").append(reason);
        reason = "Az oltás meghiúsult. Indok: " + reason;
        dao.registrateFail(ssn, sb.toString(), reason, date);
    }

    private String getCommentsBefore(String ssn) throws SQLException {
        return dao.getCommentsBefore(ssn);
    }

    public Map<String, Integer> getTownStatistics(String postalCode) throws SQLException {
        Map<String, Integer> townStatistics = new TreeMap<>();
        List<Integer> townData = dao.getTownData(postalCode);

        townStatistics.put("0_beoltatlan", 0);
        townStatistics.put("1 alkalommal beoltott", 0);
        townStatistics.put("2 alkalommal beoltott", 0);

        for (int i : townData) {
            if (i == 0) {
                townStatistics.put("0_beoltatlan", (townStatistics.get("0_beoltatlan") + 1));
            } else if (i == 1) {
                townStatistics.put("1 alkalommal beoltott", (townStatistics.get("1 alkalommal beoltott") + 1));
            } else {
                townStatistics.put("2 alkalommal beoltott", (townStatistics.get("2 alkalommal beoltott") + 1));
            }
        }
        return townStatistics;
    }

    public void writeTownStatisticsToFile(String postalCode) throws SQLException, IOException {
        Map<String, Integer> townStatistics = getTownStatistics(postalCode);
        String town = getTown(postalCode);
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/resources/covid/townstatistics_" + LocalDate.now().toString() + "_" + postalCode + ".txt"))) {
            bw.write("Oltási statisztika " + postalCode + ", " + town + " településre:" + "\n");
            for (String s : townStatistics.keySet()) {
                bw.write(s + "=" + townStatistics.get(s) + " fő\n");
            }
        }
    }

    public Map<String, Map<String, Integer>> getHungaryStatistics() throws SQLException {
        Map<String, Map<String, Integer>> hungaryStatistics = new TreeMap<>();
        List<String> postalCodes = dao.getPostalCodes();

        for (String s : postalCodes) {
            Map<String, Integer> townStatistics = getTownStatistics(s);
            hungaryStatistics.put(s, townStatistics);
        }
        return hungaryStatistics;
    }

    public void writeHungaryStatisticsToFile() throws SQLException, IOException {
        Map<String, Map<String, Integer>> hungaryStatistics = getHungaryStatistics();

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/resources/covid/Hungarystatistics_" + LocalDate.now().toString() + ".txt"))) {
            bw.write(LocalDate.now().toString() + "\n");
            bw.write("Országos oltási statisztika:" + "\n");
            bw.write("\n");

            for (String s : hungaryStatistics.keySet()) {
                bw.write(s + " " + hungaryStatistics.get(s).toString() + "\n");
            }
        }
    }
}
