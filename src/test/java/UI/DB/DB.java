package UI.DB;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private static Connection connection;
    static int userId;
    static int numNote;
    static int maxNoteId ;
    static int maxUsersId;
    public static void ConnectDB() {
 try {
        String url = "jdbc:postgresql://172.24.120.5:5432/postgres";
        String login = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, login, password);
 } catch (Exception e) {
     e.printStackTrace();
   }
    }

    public static void loginExecuteQuery(String userLogin) {
        try {
            String sqlUserId = "SELECT ID FROM nfaut.users WHERE login = ?";
            PreparedStatement statementOne= connection.prepareStatement(sqlUserId);
            statementOne.setString(1, userLogin);
            ResultSet resultId = statementOne.executeQuery();
            while (resultId.next()){
                userId = resultId.getInt(1);
            }
            statementOne.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lastPriorityExecuteQuery() {
        try {
            String sqlnumNote = "SELECT MAX(priority)+1 FROM nfaut.notes where user_id = ?";
            PreparedStatement statementTwo = connection.prepareStatement(sqlnumNote );
            statementTwo.setInt(1, userId);
            ResultSet resultNum= statementTwo.executeQuery();
            while (resultNum.next()){
                numNote = resultNum.getInt(1);
                //System.out.println("ID: " + numNote);
            }
            statementTwo.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public static void lastIdExecuteQuery() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultNoteId = statement.executeQuery( "select MAX(id)+1 FROM nfaut.notes");
            while (resultNoteId.next()){
                maxNoteId = resultNoteId.getInt(1);
                //System.out.println("ID: " + maxNoteId);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

            public static void CreateNoteExecuteQuery(String titleText,String contentText ) {
                try {
            String updateNote = "insert into nfaut.notes (id,user_id, name , color , content , priority ,archive_flg) values (?,?,'"+titleText+"','#fdcfe8', '"+contentText+"',?, false)";
            PreparedStatement statementThree = connection.prepareStatement(updateNote);
            statementThree.setInt(1, maxNoteId);
            statementThree.setInt(2, userId);
            statementThree.setInt(3, numNote);
            statementThree.executeUpdate();
            statementThree.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void maxUsersIdExecuteQuery() {
           try {
            Statement statement = connection.createStatement();
            ResultSet resultMaxId  = statement.executeQuery( "select MAX(id)+1 from nfaut.users");
            while (resultMaxId.next()){
                maxUsersId = resultMaxId.getInt(1);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void CreateNewUserExecuteQuery(String userName) {
        try {
            String newUser = "insert into nfaut.users (id,login, password)  values (?,'"+userName+"','$2a$10$Lw6xgPc685KAyMMsKM8nyOXmDRF0lB2e9Kb2xjf1x0o.r3RYnDNt.')";
            PreparedStatement statementFour = connection.prepareStatement(newUser);
            statementFour.setInt(1, maxUsersId);
            statementFour.executeUpdate();
            statementFour.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ConnectionCloseExecuteQuery() {
        try {
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    }
