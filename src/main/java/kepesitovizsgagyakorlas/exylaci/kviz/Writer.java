package kepesitovizsgagyakorlas.exylaci.kviz;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Writer {

    private JdbcTemplate jdbcTemplate;

    public Writer(DataSource source) {
        jdbcTemplate = new JdbcTemplate(source);
        loadQuestions(source);
    }

    private void loadQuestions(DataSource source) {
        Flyway flyway = Flyway.configure().locations("/db/migration/exylaci/kviz").dataSource(source).load();
        flyway.clean();
        flyway.migrate();
    }

    public int getPieces() {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(id) AS pieces FROM questions",
                (rs, rowNum) -> rs.getInt("pieces"));
    }

    public Question getQuestion(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT question, answer1, answer2, answer3, answer4 FROM questions WHERE id=?",
                (rs, index) -> new Question(
                        id,
                        rs.getString("question"),
                        rs.getString("answer1"),
                        rs.getString("answer2"),
                        rs.getString("answer3"),
                        rs.getString("answer4")),
                id);
    }

    public static void main(String[] args) {

        MariaDbDataSource source = new MariaDbDataSource();
        try {
            source.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            source.setUser("employees");
            source.setPassword("employees");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database!");
        }

        Writer w = new Writer(source);

        for (int i = 1; i <= 142; i++) {
            System.out.println(w.getQuestion(i));
            System.out.println();
        }
    }
}
