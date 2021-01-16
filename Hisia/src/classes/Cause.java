/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class Cause {
    
    private String idCause;
    private String descriptionCause;
    private Emotion emotion;

    public Cause() {
    }

    public Cause(String idCause, String descriptionCause, Emotion emotion) {
        this.idCause = idCause;
        this.descriptionCause = descriptionCause;
        this.emotion = emotion;
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

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
    
    @Override
    public String toString(){
        return String.format("idCause: %s, descriptionCause: %s", getIdCause(),
                getDescriptionCause());
    }
}
