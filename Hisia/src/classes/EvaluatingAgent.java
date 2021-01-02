package classes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

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
            if (search_message != null){
                System.out.println(String.format("Mensaje receptado desde "
                        + "agente buscador: %s\n", search_message.getContent()));
                data.FaceImage.pathName = " ";
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