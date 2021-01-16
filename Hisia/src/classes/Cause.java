package classes;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class Cause implements java.io.Serializable{
    
    private String idCause;
    private String descriptionCause;

    public Cause() {
    }

    public Cause(String idCause, String descriptionCause) {
        this.idCause = idCause;
        this.descriptionCause = descriptionCause;
    }

    public String getIdCause() {
        return idCause;
    }

    public void setIdCause(String idCause) {
        this.idCause = idCause;
    }

    public String getDescriptionCause() {
        return descriptionCause;
    }

    public void setDescriptionCause(String descriptionCause) {
        this.descriptionCause = descriptionCause;
    }
    
    @Override
    public String toString(){
        return String.format("idCause: %s, descriptionCause: %s", idCause,
                descriptionCause);
    }
}
