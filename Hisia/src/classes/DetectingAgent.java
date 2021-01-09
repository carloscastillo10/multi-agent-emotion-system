package classes;

import gui.DetectingGUI;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
        DetectingGUI objDetectingGUI = new DetectingGUI();
        
        @Override
        public void action() {
                       
            if (!data.FaceImage.pathName.equals(" ")){
                if (!detectingEmotion().isEmpty()){
                    this.objDetectingGUI.lblAnalyzing.setText("EVALUANDO EMOCIONES......");
                    
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
                    block();
                } else {
                }
            }else{
               this.objDetectingGUI.setVisible(true);
               block(5000);
            }
        }
        
        // Comprueba si el comportamiento se ha cumplido
        @Override
        public boolean done() {
            return false;
        }
        
       /**
        * Detectar rostros a partir de una imágen seleccionada.
        * @param pathImage[String]: Ruta de la imágen seleccionada
        * @return byte[]
        * @throws IOException 
        */
        protected String  detectingEmotion(){
            String[] emotions = {"Feliz", "Triste", "Aburrido", "Enojado"};
            
            return emotions[0];
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