package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageTypes) {
     ImageReader ir = null;
        if (imageTypes == null) {
            throw new IllegalArgumentException();
        } else if (imageTypes.equals(ImageTypes.JPG)) {
            ir = new JpgReader();
        } else if (imageTypes.equals(ImageTypes.PNG)) {
            ir = new PngReader();
        } else if (imageTypes.equals(ImageTypes.BMP)){ ir=  new BmpReader();}
        return ir;

    }
}
