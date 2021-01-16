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
public class CauseDB {
    
    ConnectionDB conecction = new ConnectionDB();
    
    public ResultSet getCauses(String idEmotion) throws ClassNotFoundException, SQLException{
        
        Statement statement = conecction.openConnection().createStatement();
        String query = String.format("SELECT idCause, descriptionCause FROM Cause \n" +
                "WHERE idEmotion = '%s'", idEmotion);
        
        return statement.executeQuery(query);
    }
}
