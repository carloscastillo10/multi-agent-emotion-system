package agents;

import classes.Cause;
import classes.Emotion;
import classes.Recommendation;
import data.CauseDB;
import data.EmotionDB;
import data.RecommendationDB;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
 */
public class SearchAgent extends Agent {

    /**
     * Buscar y asociar los datos receptados por el agente detector
     * (DetectingAgent) Enviar resultador al agente evaluador (EvaluatingAgent)
     */
    class SearchAgentBehaivour extends CyclicBehaviour {

        @Override
        public void action() {

            // Recibir el mensaje del agente detector (DetectingAgent)
            ACLMessage detecting_message = blockingReceive();
            if (detecting_message != null) {
                System.out.println(String.format("Mensaje receptado desde "
                        + "agente detector: %s\n", detecting_message.getContent()));
                try {
                    Emotion emotion = searchEmotion(detecting_message.getContent());
                    if (emotion != null) {
                        // Identificador del agente con el que se va a comunicar (EvaluatingAgent)
                        AID evaluating__agent_id = new AID();

                        // Nombre del agente con el que se va a comunicar (EvaluatingAgent)
                        evaluating__agent_id.setLocalName("Avalie");

                        ACLMessage search_message = new ACLMessage(ACLMessage.REQUEST);
                        search_message.setSender(evaluating__agent_id);
                        search_message.setLanguage("Español");
                        search_message.addReceiver(evaluating__agent_id); // Agregar receptor (EvaluatingAgent)

                        search_message.setContentObject(emotion);

                        send(search_message); // Enviar mensaje al agente 'Buscador' (EvaluatingAgent)'
                    }
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    Logger.getLogger(SearchAgent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            block();
        }
    }

    @Override
    protected void setup() {
        System.out.println("Estado " + getAgentState());
        System.out.println("Agente " + getLocalName());
        addBehaviour(new SearchAgentBehaivour()); // Agregar comportamiento
    }

    protected Emotion searchEmotion(String emotionDetected)
            throws ClassNotFoundException, SQLException {

        EmotionDB emotionDB = new EmotionDB();
        Emotion emotion = new Emotion();
        ResultSet resultset = emotionDB.getEmotion(emotionDetected);
        while (resultset.next()) {
            String idEmotion = resultset.getString(1);
            String nameEmotion = resultset.getString(2);
            ArrayList<Cause> causes = searchCauses(idEmotion);
            ArrayList<Recommendation> recommendations = searchRecommendations(idEmotion);

            emotion = new Emotion(idEmotion, nameEmotion, causes, recommendations);
        }

        return emotion;
    }

    protected ArrayList<Cause> searchCauses(String idEmotion) throws ClassNotFoundException, SQLException {

        ArrayList<Cause> causes = new ArrayList<>();
        CauseDB causeDB = new CauseDB();
        ResultSet resultset = causeDB.getCauses(idEmotion);

        while (resultset.next()) {
            String idCause = resultset.getString(1);
            String descriptionCause = resultset.getString(2);
            Cause cause = new Cause(idCause, descriptionCause);
            causes.add(cause);
        }

        return causes;
    }

    protected ArrayList<Recommendation> searchRecommendations(String idEmotion)
            throws ClassNotFoundException, SQLException {

        ArrayList<Recommendation> recommendations = new ArrayList<>();
        RecommendationDB recommendationDB = new RecommendationDB();
        ResultSet resultset = recommendationDB.getRecommendations(idEmotion);

        while (resultset.next()) {
            String idRecommendation = resultset.getString(1);
            String descriptionRecommendation = resultset.getString(2);
            Recommendation recommendation = new Recommendation(idRecommendation, descriptionRecommendation);
            recommendations.add(recommendation);
        }

        return recommendations;
    }
}
