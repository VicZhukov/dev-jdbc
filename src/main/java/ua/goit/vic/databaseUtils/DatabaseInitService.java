package ua.goit.vic.databaseUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        String initDB_file = "src/main/java/ua/goit/vic/sql/init_db.sql";
        try {
            BufferedReader br = new BufferedReader(new FileReader(initDB_file));
            Statement statement = Database.getInstance().getConnection().createStatement();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                if (line.endsWith(";")) {
                    try {
                        statement.executeUpdate(sb.toString());
                        statement.close();
                    } catch (SQLException e) {
                        System.err.println("Error executing SQL statement: ");
                        e.printStackTrace();
                    }
                    sb.setLength(0);
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading SQL file or connecting to database.");
            e.printStackTrace();
        }

    }
}

