package ua.goit.vic.databaseUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabasePopulateService {
    public static void main(String[] args) {
        String populateDB_file = "src/main/java/ua/goit/vic/sql/populate_db.sql";
        try {
            BufferedReader br = new BufferedReader(new FileReader(populateDB_file));
            Statement statement = Database.getInstance().getConnection().createStatement();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                if (line.endsWith(";")) {
                    try {
                        int i = statement.executeUpdate(sb.toString());
                        System.out.println(i);
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
