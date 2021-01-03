package jorn.letnes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class ImageReader {
    public BufferedImage read(String BMPFileName) throws IOException {
        return ImageIO.read(new File(BMPFileName));
    }
}
