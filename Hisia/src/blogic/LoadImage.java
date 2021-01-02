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

    public String uploadImage() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Imágenes", ImageIO.getReaderFileSuffixes());
        fileChooser.setFileFilter(imageFilter);

        int response = fileChooser.showOpenDialog(fileChooser);

        if (response == JFileChooser.APPROVE_OPTION) {
            File image = fileChooser.getSelectedFile();
            return image.getAbsolutePath();
        }
        return " ";
    }
}
