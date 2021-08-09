package jdbctemplate;

import jdbc.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong(1);
        String name = resultSet.getString("name");
        String groupName = resultSet.getString(3);
        int score = resultSet.getInt("score");
        return new Student(id, name, groupName, score);
    }
}
