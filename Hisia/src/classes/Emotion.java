package classes;

import java.util.ArrayList;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class Emotion implements java.io.Serializable{
    
    private String idEmotion;
    private String nameEmotion;
    private ArrayList<Cause> causes;
    private ArrayList<Recommendation> recommendations;

    public Emotion() {
    }

    public Emotion(String idEmotion, String nameEmotion) {
        this.idEmotion = idEmotion;
        this.nameEmotion = nameEmotion;
    }

    public Emotion(String idEmotion, String nameEmotion, ArrayList<Cause> causes, 
            ArrayList<Recommendation> recommendations) {
        this.idEmotion = idEmotion;
        this.nameEmotion = nameEmotion;
        this.causes = causes;
        this.recommendations = recommendations;
    }

    public String getIdEmotion() {
        return idEmotion;
    }

    public void setIdEmotion(String idEmotion) {
        this.idEmotion = idEmotion;
    }

    public String getNameEmotion() {
        return nameEmotion;
    }

    public void setNameEmotion(String nameEmotion) {
        this.nameEmotion = nameEmotion;
    }

    public ArrayList<Cause> getCauses() {
        return causes;
    }

    public void setCauses(ArrayList<Cause> causes) {
        this.causes = causes;
    }

    public ArrayList<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(ArrayList<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public String toString() {
                
        return String.format("idEmotion: %s, nameEmotion: %s, causes: %s, "
                + "recommendations: %s", idEmotion, nameEmotion, causes, recommendations);
    }     
}
