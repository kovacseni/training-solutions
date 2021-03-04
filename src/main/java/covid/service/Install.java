package covid.service;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Install {

    public void getPostalCodes(DataSource dataSource) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/covid/osszes_iranyitoszam.csv"));
             Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into postal_codes(irsz, telepules, telepulesresz) values (?, ?, ?);")) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                    stmt.setInt(1, Integer.parseInt(temp[0]));
                    stmt.setString(2, temp[1]);
                    if (temp.length == 2) {
                        stmt.setString(3, "");
                    } else {
                        stmt.setString(3, temp[2]);
                    }
                    stmt.executeUpdate();
            }
        } catch (IOException |SQLException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public void getCitizens(DataSource dataSource) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/covid/citizens_tesztfile.csv"));
        Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into citizens(citizen_name, zip, age, email, taj, number_of_vaccination) values (?, ?, ?, ?, ?, ?);")) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                    stmt.setString(1, temp[0]);
                    stmt.setString(2, temp[1]);
                    stmt.setInt(3, Integer.parseInt(temp[2]));
                    stmt.setString(4, temp[3]);
                    stmt.setString(5, temp[4]);
                    stmt.setInt(6, VaccinationState.NO.getValue());
                    stmt.executeUpdate();
            }
        } catch (IOException |SQLException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public void updateCitizens(DataSource dataSource) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/covid/install.csv"));
             Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("update citizens set number_of_vaccination = ?, last_vaccination = ?, vaccine_type = ? where taj = ?;")) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                stmt.setInt(1, Integer.parseInt(temp[1]));
                stmt.setDate(2, Date.valueOf(LocalDate.parse(temp[2])));
                stmt.setString(3, temp[3]);
                stmt.setString(4, temp[0]);
                stmt.executeUpdate();
            }
        } catch (IOException | SQLException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public void updateCitizensComments(DataSource dataSource) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/covid/installcomments.csv"));
             Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("update citizens set comments = ? where taj = ?;")) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                stmt.setString(1, temp[2]);
                stmt.setString(2, temp[0]);
                stmt.executeUpdate();
            }
        } catch (IOException | SQLException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public void insertIntoVaccinations(DataSource dataSource) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/covid/installvaccinations.csv"));
             Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into vaccinations(citizen_id, taj, vaccination_date, number_of_vaccination, vaccine_type) values (?, ?, ?, ?, ?);")) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                stmt.setInt(1, Integer.parseInt(temp[0]));
                stmt.setString(2, temp[1]);
                stmt.setDate(3, Date.valueOf(LocalDate.parse(temp[3])));
                stmt.setString(4, temp[2]);
                stmt.setString(5, temp[4]);
                stmt.executeUpdate();
            }
        } catch (IOException | SQLException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public void insertIntoVaccinationsComments(DataSource dataSource) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/covid/installvaccinationscomments.csv"));
             Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into vaccinations(citizen_id, taj, vaccination_date, comments) values (?, ?, ?, ?);")) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                stmt.setInt(1, Integer.parseInt(temp[0]));
                stmt.setDate(3, Date.valueOf(LocalDate.parse(temp[2])));
                stmt.setString(2, temp[1]);
                stmt.setString(4, temp[3]);
                stmt.executeUpdate();
            }
        } catch (IOException | SQLException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }
}
