import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Stream;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("log.txt");
        List<String> fileStr = new ArrayList<>();
        String str;
        LogFormat logFormat = null;
        for (String s : Files.readAllLines(path)) {
            if (s.startsWith("LogFormat")) {
                logFormat = new LogFormat(s);
            } else {
                fileStr.add(s);
            }
        }

        List<Log> logs = new ArrayList<>();
        for (String s : fileStr) {
            logs.add(new Log(logFormat, s));
        }
     //   List l = new ArrayList<>();
System.out.println(logs.get(7).getIp());
        try{
            String url = "jdbc:mysql://localhost/Logs?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "password";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                System.out.println("Connection to Logs DB succesfull!");
                PreparedStatement preparedStatement = conn.prepareStatement("insert into Logs(Id,Ip,Actions) values(?,?,?)");
                for (Log log: logs) {
                    preparedStatement.setString(1,log.getId());
                    preparedStatement.setString(2,log.getIp());
                    preparedStatement.setString(3,log.getActions());
                   // preparedStatement.setString(4,log.getLink());
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed");

            System.out.println(ex);
        }
    }
}
