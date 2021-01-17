package agents;

import classes.Cause;
import classes.Emotion;
import classes.Recommendation;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import gui.EvaluatingGUI;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
 */
public class EvaluatingAgent extends Agent {

    /**
     * Presentar resultados de evaluación Emitir criterio u sugerencia
     */

    class EvaluatingAgentBehaivour extends CyclicBehaviour {

        @Override
        public void action() {

            // Recibir el mensaje del agente buscador (DetectingAgent)
            ACLMessage search_message = blockingReceive();

            if (search_message != null) {
                try {
                    Emotion emotion = (Emotion) search_message.getContentObject();

                    System.out.println(String.format("Mensaje receptado desde "
                            + "agente buscador: %s\n", emotion));
                    
                    updateInterface(emotion);
                    
                } catch (UnreadableException | InterruptedException ex) {
                    Logger.getLogger(EvaluatingAgent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    protected void setup() {
        System.out.println("Estado " + getAgentState());
        System.out.println("Agente " + getLocalName());
        addBehaviour(new EvaluatingAgentBehaivour()); // Agregar comportamiento
    }

    protected void updateInterface(Emotion emotion) throws InterruptedException {
        
        EvaluatingGUI evaluatingInterface = new EvaluatingGUI();
        Random random = new Random();
        
        evaluatingInterface.setVisible(true);

        evaluatingInterface.txtEmotionName.setText(
                emotion.getNameEmotion().toUpperCase());
        
        evaluatingInterface.txtRecomendation.setLineWrap(true);
        
        ArrayList<Cause> causes = emotion.getCauses();
        
        String descriptionCauses = "";
        for (Cause cause : causes) {
            descriptionCauses = String.format("%s* %s\n\n", descriptionCauses,
                    cause.getDescriptionCause());
        }
        
        evaluatingInterface.txtCauses.setLineWrap(true);
        evaluatingInterface.txtCauses.setText(descriptionCauses);
        ArrayList<Recommendation> recommendations = emotion.getRecommendations();
        
        if (!recommendations.isEmpty()) {
            Recommendation recommendation = recommendations.get(
                    random.nextInt(recommendations.size()));
            evaluatingInterface.txtRecomendation.setText(
                    recommendation.getDescriptionRecommendation());
        } else {
            evaluatingInterface.txtRecomendation.setText(""
                    + "Excelente!, muy buen trabajo, siga de la misma manera.");
        }
        
        Thread.sleep(15000);
        evaluatingInterface.setVisible(false);
    }
}
