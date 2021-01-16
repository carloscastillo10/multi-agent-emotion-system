package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
            String emotionDetected = detectingEmotion();
            if (!emotionDetected.isEmpty()) {
      
                // Identificador del agente con el que se va a comunicar (SearchAgent)
                AID search_agent_id = new AID();

                // Nombre del agente con el que se va a comunicar (SearchAgent)
                search_agent_id.setLocalName("Raadso");

                ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
                message.setSender(search_agent_id);
                message.setLanguage("Español");
                message.addReceiver(search_agent_id); // Agregar receptor (SearchAgent)

                // Contenido del mensaje
                message.setContent(emotionDetected);

                send(message); // Enviar mensaje al agente 'Buscador' (SearchAgente)'
            }

            block(10000);

        }

        // Comprueba si el comportamiento se ha cumplido
        @Override
        public boolean done() {
            return false;
        }
    }

    @Override
    protected void setup() {
        System.out.println("Estado" + getAgentState());
        System.out.println("Agente" + getLocalName());
        DetectingAgentBehaviour detectingBehaviour = new DetectingAgentBehaviour();
        addBehaviour(detectingBehaviour); // Agregar comportamiento
    }
    
    protected String detectingEmotion() {
            ArrayList<String> emotions = new ArrayList<>();
            File file = new File("resources/emotions_file.csv");
            Random random = new Random();
            
            Scanner input = null;
            String emotion;
            
            try {
                input = new Scanner(file);
                while (input.hasNext()) {
                    emotion = input.nextLine();
                    emotions.add(emotion);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                input.close();
            }
            
            String emotionDectected = emotions.get(random.nextInt(emotions.size()));

            return emotionDectected;
        }
}
