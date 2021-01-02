package blogic;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
 */
public class LoadImage {
    
    /**
     * Mostrar una ventana para seleccionar un archivo
     * Filtrar archivos en formato de imagen
     * @return pathImage[String]: Ruta de la imágen seleccionada
     * @throws IOException 
     */
    public String uploadImage() throws IOException {
                
        // Objeto que permite mostrar una ventana para seleccionar un archivo.
        JFileChooser fileChooser = new JFileChooser();
        
        String pathImage = "";
        
        // Filtrar archivos en formato de imágen
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Imágenes", 
                ImageIO.getReaderFileSuffixes());
        
        fileChooser.setFileFilter(imageFilter);
        
        int response = fileChooser.showOpenDialog(fileChooser);
        
        // Validar si se ha seleccionado un archivo
        if (response == JFileChooser.APPROVE_OPTION) {
            File image = fileChooser.getSelectedFile();
            pathImage = image.getAbsolutePath();
        }
        
        return pathImage;
    }
}