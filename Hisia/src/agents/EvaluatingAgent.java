package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import gui.DetectingGUI;
import jade.lang.acl.UnreadableException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class EvaluatingAgent extends Agent{
    /**
     * Presentar resultados de evaluación
     * Emitir criterio u sugerencia
    */
    
    class EvaluatingAgentBehaivour extends CyclicBehaviour{
        
        @Override
        public void action(){
            
            // Recibir el mensaje del agente buscador (DetectingAgent)
            ACLMessage search_message = blockingReceive();
            //String message = new String(Base64.decodeBase64(search_message.get.getBytes()));
            if (search_message != null){
                try {
                    System.out.println(String.format("Mensaje receptado desde "
                            + "agente buscador: %s\n", search_message.getContentObject()));
                } catch (UnreadableException ex) {
                    Logger.getLogger(EvaluatingAgent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    protected void setup(){
        System.out.println("Estado " + getAgentState());
        System.out.println("Agente " + getLocalName());
        addBehaviour(new EvaluatingAgentBehaivour()); // Agregar comportamiento
    }
}