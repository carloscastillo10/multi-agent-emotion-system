package classes;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class Recommendation {
    
    private int idRecommendation;
    private String nameRecommendation;
    private String descriptionRecommendation;
    private Emotion emotion;

    public Recommendation() {
    }

    public Recommendation(int idRecommendation, String nameRecommendation, 
            String descriptionRecommendation, Emotion emotion) {
        
        this.idRecommendation = idRecommendation;
        this.nameRecommendation = nameRecommendation;
        this.descriptionRecommendation = descriptionRecommendation;
        this.emotion = emotion;
    }

    public int getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(int idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public String getNameRecommendation() {
        return nameRecommendation;
    }

    public void setNameRecommendation(String nameRecommendation) {
        this.nameRecommendation = nameRecommendation;
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
    
}
