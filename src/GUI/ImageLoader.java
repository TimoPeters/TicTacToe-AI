package GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Timo Peters on 21.11.2019.
 */
public class ImageLoader {

    public static Image imgX;
    public static Image imgO;

    public ImageLoader() {
        try {
            imgX = ImageIO.read(new File("res/x.png"));
            imgO = ImageIO.read(new File("res/o.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
