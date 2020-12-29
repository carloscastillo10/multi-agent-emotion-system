package blogic;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
 */
public class SearchAgent extends Agent{
  /**
   * Buscar y asociar los datos receptados por el agente detector (DetectingAgent)
   * Enviar resultador al agente evaluador (EvaluatingAgent)
   */
    
    class SearchAgentBehaivour extends CyclicBehaviour{
        
        @Override
        public void action(){
           
            // Recibir el mensaje del agente detector (DetectingAgent)
            ACLMessage detecting_message = blockingReceive();
            if (detecting_message != null){
                System.out.println(String.format("Mensaje receptado desde "
                        + "agente detector: %s\n", detecting_message.getContent()));
                
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
            block();
            
        }
    }
    
    @Override
    protected void setup(){
       System.out.println("Estado " + getAgentState());
       System.out.println("Agente " + getLocalName());
       addBehaviour(new SearchAgentBehaivour()); // Agregar comportamiento
    }
    
   
}
