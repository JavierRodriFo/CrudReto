
package crudreto;
import java.sql.*;


public class Connexion {
    
    private String urlBase;
    private String portBase;
    protected String dbNameBase;
    protected String Url;
    protected String userBase;
    protected String passwordBase;
    private Connection conn;
    private Statement statement;
    private ResultSet resultset;
    
    public Connexion(String nameBD,String userBD,String PasswordBD){
        urlBase = "jdbc:mysql://localhost:";
        portBase ="3306/";
        dbNameBase="" +nameBD; 
        Url = urlBase + portBase + dbNameBase;
        userBase=userBD;
        passwordBase=PasswordBD;
    }
    
    public void ConnectionMyDB(){
        try {
            conn=DriverManager.getConnection(Url,userBase,passwordBase);
            statement=conn.createStatement();
            if(conn !=null){
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean CREATE(String myQuery){
        boolean salida = true;
        try {
            statement.executeUpdate(myQuery);
        } catch (Exception e) {
            e.printStackTrace();
            salida = false;
        }
        return salida;
    }
    
    public void DELETE (String myQuery){
        try {
            statement.executeUpdate(myQuery);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    public boolean UPDATE(String myQuery){
        return CREATE(myQuery);
    }
    
    public void READ (String myQuery){
        try {
            resultset=statement.executeQuery(myQuery);
            while(resultset.next()){
                System.out.println("\n" + resultset.getString("Nombre")+"\t");
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void READ1 (String myQuery){
        try {
            resultset=statement.executeQuery(myQuery);
            while(resultset.next()){
                
                System.out.println("\n"+resultset.getString("Nombre")+" "+resultset.getString("Precio_Unitario")+" "+resultset.getString("Año")+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
     public void READ2 (String myQuery){
        try {
            resultset=statement.executeQuery(myQuery);
            while(resultset.next()){
                
                System.out.println("\n"+resultset.getString("Nombre")+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     public void READ3 (String myQuery){
        try {
            resultset=statement.executeQuery(myQuery);
            while(resultset.next()){
                
                System.out.println("\n"+resultset.getString("fabricante")+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
     }
      public void READ4 (String myQuery){
        try {
            resultset=statement.executeQuery(myQuery);
            while(resultset.next()){
                
                System.out.println("\n"+resultset.getString("alias")+" "+resultset.getString("Nombre_c")+" "+resultset.getString("Apellido")+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
      public void READ5 (String myQuery){
        try {
            resultset=statement.executeQuery(myQuery);
            while(resultset.next()){
                
                System.out.println("\n"+resultset.getString("fabricadas")+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
}

