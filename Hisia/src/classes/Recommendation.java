package classes;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class Recommendation {
    
    private String idRecommendation;
    private String descriptionRecommendation;
    private Emotion emotion;

    public Recommendation() {
    }

    public Recommendation(String idRecommendation, String descriptionRecommendation, 
            Emotion emotion) {
        
        this.idRecommendation = idRecommendation;
        this.descriptionRecommendation = descriptionRecommendation;
        this.emotion = emotion;
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

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
    
    @Override
    public String toString(){
        return String.format("idCause: %s, descriptionCause: %s", 
                getIdRecommendation(),getDescriptionRecommendation());
    }
}
