package blogic;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
 */
public class DetectingAgent extends Agent{
    /**
     * Detectar rostro desde la webcam del computador
     * Emitir keypoints hacia el agente buscador
     */
    
    class DetectingAgentBehaviour extends Behaviour{
        
        @Override
        public void action(){
            
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
            block(10000);
        }

        @Override
        public boolean done(){
            return false;
        }
    }
    
    @Override
    protected void setup(){
        System.out.println("Estado" + getAgentState());
        System.out.println("Agente" + getLocalName());
        addBehaviour(new DetectingAgentBehaviour()); // Agregar comportamiento
    }
}
