package domain;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Rotator {

    public static void Rotate(AffineTransform at, int w , int h, double rads, BufferedImage image){
        at.translate(w / 2, h / 2);
        at.rotate(rads,0, 0);
        at.translate(-image.getWidth() / 2, -image.getHeight() / 2);

    }
}
