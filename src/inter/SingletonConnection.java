package inter;

import java.sql.DriverManager;
import java.sql.Connection;


public class SingletonConnection {
    private static Connection connection;
    
    public static int cmpCnx = 0;

    
    public static Connection getConnection(){
        System.out.println("call init cnx");
        
        if(cmpCnx == 0){
        
            try {
           Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionvisiteurs","root","");
            
            System.out.println("connection intit success");
            } catch (Exception e) {
                e.printStackTrace();

                System.out.println("connection intit problem");
            }
            cmpCnx++;
            return connection;
        }else 
            return connection;
    }
}
