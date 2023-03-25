package ua.goit.vic.databaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    private static final Database dataBase = new Database();
    private Connection connection;

    private Database(){
        try{
            String connectionUrl = "jdbc:h2:./test-jdbc";
            connection = DriverManager.getConnection(connectionUrl);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static Database getInstance(){
        return dataBase;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}