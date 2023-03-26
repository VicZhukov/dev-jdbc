package ua.goit.vic.databaseUtils;

import ua.goit.vic.requestsClasses.*;
import ua.goit.vic.util.SQLReader;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    List<FindMaxSalaryWorker> findMaxSalaryWorkers(){
        List<FindMaxSalaryWorker> workers = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/ua/goit/vic/sql/find_max_salary_worker.sql");

        try(Statement statement = Database.getInstance().getConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                workers.add(FindMaxSalaryWorker.builder()
                        .name(rs.getString("NAME"))
                        .salary(rs.getInt("SALARY"))
                        .build());
                statement.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return workers;
    }

    List<FindLongestProject> findLongestProjects(){
        List<FindLongestProject> longest_project = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/ua/goit/vic/sql/find_longest_project.sql");

        try(Statement statement = Database.getInstance().getConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                longest_project.add(FindLongestProject.builder()
                        .name(rs.getString("NAME"))
                        .month_count(rs.getInt("MONTH_COUNT"))
                        .build());
                statement.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return longest_project;
    }

    List<FindMaxProjectsClient> findMaxProjectsClients(){
        List<FindMaxProjectsClient> client_project = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/ua/goit/vic/sql/find_max_projects_client.sql");
        try(Statement statement = Database.getInstance().getConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                client_project.add(FindMaxProjectsClient.builder()
                        .name(rs.getString("NAME"))
                        .count(rs.getInt("PROJECT_COUNT"))
                        .build());
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return client_project;
    }

    List<FindYoungestEldestWorker> findYoungestEldestWorkers(){
        List<FindYoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/ua/goit/vic/sql/find_youngest_eldest_workers.sql");
        try(Statement statement = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                youngestEldestWorkers.add(FindYoungestEldestWorker.builder()
                        .type(rs.getString("TYPE"))
                        .name(rs.getString("NAME"))
                        .birthday(LocalDate.parse(rs.getString("BIRTHDAY")))
                        .build());
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return youngestEldestWorkers;
    }

    List<PrintProjectPrices> printProjectPrices(){
        List<PrintProjectPrices> project_price = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/ua/goit/vic/sql/print_project_prices.sql");
        try(Statement statement = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                project_price.add(PrintProjectPrices.builder()
                        .id(rs.getString("NAME"))
                        .price(rs.getInt("PRICE"))
                        .build());
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  project_price;
    }
}
