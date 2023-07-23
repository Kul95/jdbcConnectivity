import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCconnectivety {
    public static void main(String[] args) {
        System.out.println("Hello JDBC");
//        getConnection();
//        insertData();
//        getData();
//        deleteRecord();
//        updateInfo();

        getRecordWithInput();
    }
    public static Connection getConnection(){
        try{
            String driver="com.mysql.cj.jdbc.Driver";
            String databaseUrl="jdbc:mysql://localhost:3306/School";
            String userName="root";
            String password="";
            Class.forName(driver);
            Connection con= DriverManager.getConnection(databaseUrl,userName,password);
            System.out.println("Database connected .");
            return con;
        }catch (Exception e){
            System.out.println("Some error: "+e);
        }
        return null;
    }
    //getFunction.......
    public static void getData(){
try{
 Statement statement=getConnection().createStatement();
 ResultSet resultSet=statement.executeQuery("select * from StudentInfo");
    while (resultSet.next()){
        System.out.println(resultSet.getString("Student_Name"));
        System.out.println(resultSet.getString("Student_Age"));
        System.out.println(resultSet.getString("Student_Mobile"));
    }
}catch (Exception e){
    System.out.println("Error generarte in get data: "+e);
    e.printStackTrace();
}
    }

    //Insert data....
    public static void insertData(){
        try{
            Statement statement=getConnection().createStatement();
            int result=statement.executeUpdate("insert into StudentInfo(Student_id,Student_Name,Student_Age,Student_City,Student_Mobile)values(5,'Komal',15,'Bangalore',00009900)");
            System.out.println(result);
            if(result==1){
               System.out.println("Data is printed successfully");
           }else{
               System.out.println("Data giving some error..");
           }
        }catch(Exception e){
            System.out.println("Insert data failed : "+e);
            e.printStackTrace();
        }
    }
    //Delete data....
    public static void deleteRecord(){
        try{
            Statement statement=getConnection().createStatement();
            int result=statement.executeUpdate("delete from StudentInfo where Student_id=2");

                if(result==1){
                    System.out.println("Record deleted sucessfully...");
                }else{
                    System.out.println("I am feeling dome error...");
                }
        }catch (Exception e){
            System.out.println("Some error in delete data : "+e);
            e.printStackTrace();
        }
    }
    public static void updateInfo(){
        try{
          Statement statement=getConnection().createStatement();
          int result=statement.executeUpdate("update StudentInfo set Student_Name='Pritam' where Student_id=3");
        if(result==1){
            System.out.println("Update successfully..");
        }else{
            System.out.println("Update is not successfully.");
        }
        }catch(Exception e){
            System.out.println("Some update error found in our update table..");
            e.printStackTrace();
        }
    }
    //

    public static  void getRecordWithInput(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number: ");
            int id=sc.nextInt();
            System.out.println(id);
            Statement statement=getConnection().createStatement();

            ResultSet resultSet=statement.executeQuery("select * from StudentInfo");
            while(resultSet.next()){
                System.out.println(resultSet.getString("Student_Name"));
                System.out.println(resultSet.getString("Student_Age"));
                System.out.println(resultSet.getString("Student_City"));
            }
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
