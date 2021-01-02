package classes;

import gui.DetectingGUI;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

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
                try {
                    if (detectFace(data.FaceImage.pathName) != null){
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
                    }
                } catch (IOException ex) {
                    Logger.getLogger(DetectingAgent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
               this.objDetectingGUI.setVisible(true);
               block(5000);
            }
        }
        
        @Override
        public boolean done() {
            return false;
        }
       
        protected Image detectFace(String path) throws IOException {
            
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            CascadeClassifier faceDetector = new CascadeClassifier(System.getProperty("user.dir") + "\\resources\\faceDetection\\"
                    + "haarcascade_frontalface_alt.xml");
            Mat image = Imgcodecs.imread(path);
            MatOfRect detectedFaces = new MatOfRect();
            MatOfByte matOfByte = new MatOfByte();

            faceDetector.detectMultiScale(image, detectedFaces);
            System.out.println(String.format("Rostros detectados: %s", detectedFaces.toArray().length));

            for (Rect rect : detectedFaces.toArray()) {
                Imgproc.rectangle(image, rect.tl(), rect.br(), new Scalar(0, 255, 0), 2);
            }

            Imgcodecs.imencode(".jpg", image, matOfByte);
            byte[] byteArray = matOfByte.toArray();
            try {
                InputStream input = new ByteArrayInputStream(byteArray);
                BufferedImage bufImage = ImageIO.read(input);
                Image outputImage = (Image) bufImage;
                Imgcodecs.imwrite("deteccion.png", image);
                return outputImage;
            } catch (IOException e) {
            }
            return null;
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