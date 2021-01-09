package agents;

import classes.Emotion;
import data.EmotionDB;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
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
                    ArrayList<Emotion> emotions = searchEmotions();
                    if (!emotions.isEmpty()) {
                        System.out.println(emotions);
                        // Identificador del agente con el que se va a comunicar (EvaluatingAgent)
                        AID evaluating__agent_id = new AID();

                        // Nombre del agente con el que se va a comunicar (EvaluatingAgent)
                        evaluating__agent_id.setLocalName("Avalie");

                        ACLMessage search_message = new ACLMessage(ACLMessage.REQUEST);
                        search_message.setSender(evaluating__agent_id);
                        search_message.setLanguage("Español");
                        search_message.addReceiver(evaluating__agent_id); // Agregar receptor (EvaluatingAgent)
                        search_message.setContent("Generar evualacion de la emocion dectectada");

                        send(search_message); // Enviar mensaje al agente 'Buscador' (EvaluatingAgent)'
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(SearchAgent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            block();
        }

        protected ArrayList<Emotion> searchEmotions() throws ClassNotFoundException, SQLException {
            ArrayList<Emotion> emotions = new ArrayList<>();
            EmotionDB emotionDB = new EmotionDB();
            ResultSet resultset = emotionDB.getEmotions();

            while (resultset.next()) {
                int idEmotion = resultset.getInt(1);
                String nameEmotion = resultset.getString(2);
                Emotion emotion = new Emotion(idEmotion, nameEmotion);
                emotions.add(emotion);
            }
            return emotions;
        }
    }

    @Override
    protected void setup() {
        System.out.println("Estado " + getAgentState());
        System.out.println("Agente " + getLocalName());
        addBehaviour(new SearchAgentBehaivour()); // Agregar comportamiento
    }
}
