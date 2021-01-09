package agents;

import gui.DetectingGUI;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.Random;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
 */
public class DetectingAgent extends Agent {

    /**
     * Detectar rostro desde la webcam del computador Emitir keypoints hacia el
     * agente buscador
     */
    class DetectingAgentBehaviour extends Behaviour {

        @Override
        public void action() {
            String emotion = detectingEmotion();
            if (!emotion.isEmpty()) {
                System.out.println("Emocion: " + emotion);
                // Identificador del agente con el que se va a comunicar (SearchAgent)
                AID search_agent_id = new AID();

                // Nombre del agente con el que se va a comunicar (SearchAgent)
                search_agent_id.setLocalName("Raadso");

                ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
                message.setSender(search_agent_id);
                message.setLanguage("Español");
                message.addReceiver(search_agent_id); // Agregar receptor (SearchAgent)

                // Contenido del mensaje
                message.setContent("Aqui enviar keyPoints detectados");

                send(message); // Enviar mensaje al agente 'Buscador' (SearchAgente)'
            }

            block(10000);

        }

        // Comprueba si el comportamiento se ha cumplido
        @Override
        public boolean done() {
            return false;
        }

        
        protected String detectingEmotion() {
            String[] emotions = {"Feliz", "Triste", "Aburrido", "Enojado"};
            Random random = new Random();
            String emotion = emotions[random.nextInt(emotions.length)];
            
            return emotion;
        }

    }

    @Override
    protected void setup() {
        System.out.println("Estado" + getAgentState());
        System.out.println("Agente" + getLocalName());
        DetectingAgentBehaviour detectingBehaviour = new DetectingAgentBehaviour();
        addBehaviour(detectingBehaviour); // Agregar comportamiento
    }
}
