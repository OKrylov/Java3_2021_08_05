package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseJdbcExample {

    private static final String DB_URL = "jdbc:sqlite:D:/Google Drive/GeekBrains/Java3_2021_08_05/test.db";

    public static void main(String[] args) {
        System.setProperty( "oracle.jdbc.Trace", Boolean.TRUE.toString() );

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            testJdbc(connection);

            connection.createStatement().executeUpdate("DELETE FROM students WHERE group_name = 'TestGroup'");

            long startTime = System.nanoTime();
            psBatchEx(connection);
            long duration = System.nanoTime() - startTime;
            System.out.println("'psBatchEx' took: " + TimeUnit.NANOSECONDS.toMillis(duration));





        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void psBatchEx(Connection connection) throws SQLException {
        try (PreparedStatement prepInsert = connection.prepareStatement("INSERT INTO students (name, group_name, score) VALUES (?, ?, ?)")) {
            connection.setAutoCommit(false);
            for (int i = 1; i <= 10000; i++) {
                prepInsert.setString(1, "Bob" + i);
                prepInsert.setString(2, "TestGroup");
                prepInsert.setInt(3, i * 10 % 100);
                prepInsert.addBatch();
//                prepInsert.execute();
            }
            int[] result = prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        connection.commit();
//          connection.rollback();
        connection.setAutoCommit(true);
    }


    private static void testJdbc(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        int updatedRowsCount = statement.executeUpdate("DELETE FROM students WHERE name = 'name3'");
//            int updatedRowsCount = statement.executeUpdate("INSERT INTO students (name, group_name, score) VALUES ('name3', 'group3', 3)");
        System.out.println("Updated rows: " + updatedRowsCount);

        statement.execute("CREATE TABLE IF NOT EXISTS students_temp (\n" +
                "    id         INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name       TEXT    NOT NULL,\n" +
                "    group_name TEXT    NOT NULL,\n" +
                "    score      INTEGER NOT NULL\n" +
                ");\n");

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE score = ?");

        List<Student> students = getStudentsByScore(4, preparedStatement);
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("-----------");


        List<Student> groupStudents = getStudentsByGroupName("group1'; SELECT * FROM students", statement);
        for (Student student : groupStudents) {
            System.out.println(student);
        }
    }

    private static List<Student> getStudentsByScore(int scoreArg, PreparedStatement statement) throws SQLException {
        List<Student> result = new ArrayList<>();

        statement.setInt(1, scoreArg);


        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString("name");
            String groupName = resultSet.getString(3);
            int score = resultSet.getInt("score");
            result.add(new Student(id, name, groupName, score));
        }

        return result;
    }


    private static List<Student> getStudentsByGroupName(String groupNameArg, Statement statement) throws SQLException {
        List<Student> result = new ArrayList<>();

        String sql = String.format("SELECT * FROM students WHERE group_name = '%s'", groupNameArg);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString("name");
            String groupName = resultSet.getString(3);
            int score = resultSet.getInt("score");
            result.add(new Student(id, name, groupName, score));
        }

        return result;
    }
}
