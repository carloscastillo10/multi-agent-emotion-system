package classes;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class Emotion {
    
    private int idEmotion;
    private String nameEmotion;

    public Emotion() {
    }

    public Emotion(int idEmotion, String nameEmotion) {
        this.idEmotion = idEmotion;
        this.nameEmotion = nameEmotion;
    }


    public int getIdEmotion() {
        return idEmotion;
    }

    public void setIdEmotion(int idEmotion) {
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
        return String.format("idEmotion: %d, emotion: %s", getIdEmotion(),
                getNameEmotion());
    }
        
}
