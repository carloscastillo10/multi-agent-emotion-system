package classes;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class Emotion {
    
    private String idEmotion;
    private String nameEmotion;

    public Emotion() {
    }

    public Emotion(String idEmotion, String nameEmotion) {
        this.idEmotion = idEmotion;
        this.nameEmotion = nameEmotion;
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
    
    @Override
    public String toString(){
        return String.format("idEmotion: %s, emotionName: %s", getIdEmotion(),
                getNameEmotion());
    }
        
}
