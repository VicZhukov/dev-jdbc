package ua.goit.vic.databaseUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabasePopulateService {
    public static void main(String[] args) {
        String populateDB_file = "C:\\Users\\Victor\\Desktop\\GitHub\\dev-jdbc\\sql\\populate_db.sql";
        try {
            BufferedReader br = new BufferedReader(new FileReader(populateDB_file));
            Connection connection = Database.getInstance().getConnection();
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                if (line.endsWith(";")) {
                    try {
                        int i = connection.createStatement().executeUpdate(sb.toString());
                        System.out.println(i);
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
