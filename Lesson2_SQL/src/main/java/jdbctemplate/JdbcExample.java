package jdbctemplate;

import jdbc.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class JdbcExample {

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:sqlite:D:/Google Drive/GeekBrains/Java3_2021_08_05/test.db");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Student> students = jdbcTemplate.query("select * from students", new StudentMapper());
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("-----");

        NamedParameterJdbcTemplate jdbcTemplate1 = new NamedParameterJdbcTemplate(jdbcTemplate);
        Student john = jdbcTemplate1.queryForObject("SELECT * from students WHERE name = :name", Map.of("name", "John"), new StudentMapper());
        System.out.println(john);
    }

}
