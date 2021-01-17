package agents;

import gui.DetectingGUI;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try {
                String emotionDetected = detectingEmotion();
                updateInterface(emotionDetected);
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
            } catch (InterruptedException ex) {
                Logger.getLogger(DetectingAgent.class.getName()).log(Level.SEVERE, null, ex);
            }

            block(20500);

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

    protected void updateInterface(String emotionDetected) throws InterruptedException {
        
        DetectingGUI detectingInterface = new DetectingGUI();
        detectingInterface.setVisible(true);
        Thread.sleep(5780);
        detectingInterface.txtEmotionDetected.setText(emotionDetected);
        Thread.sleep(1500);
        detectingInterface.setVisible(false);
        detectingInterface.txtEmotionDetected.setText("");                
    }
}
