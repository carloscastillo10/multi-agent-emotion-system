package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class EmotionDB {
    
    ConnectionDB conecction = new ConnectionDB();
    
    public ResultSet getEmotions() throws ClassNotFoundException, SQLException{
        
        Statement statement = conecction.openConnection().createStatement();
        String query = "SELECT * FROM Emotion";
        return statement.executeQuery(query);
    }
}
