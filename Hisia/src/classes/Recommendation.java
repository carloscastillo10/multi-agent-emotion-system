package classes;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class Recommendation implements java.io.Serializable{
    
    private String idRecommendation;
    private String descriptionRecommendation;

    public Recommendation() {
    }

    public Recommendation(String idRecommendation, String descriptionRecommendation) {
        
        this.idRecommendation = idRecommendation;
        this.descriptionRecommendation = descriptionRecommendation;
    }

    public String getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(String idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public String getDescriptionRecommendation() {
        return descriptionRecommendation;
    }

    public void setDescriptionRecommendation(String descriptionRecommendation) {
        this.descriptionRecommendation = descriptionRecommendation;
    }

    @Override
    public String toString(){
        return String.format("idRecommendation: %s, descriptionRecommendation: %s", 
                idRecommendation, descriptionRecommendation);
    }
}