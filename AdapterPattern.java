
interface ImageViewer {
    void displayImage(String filename);
}


class JPEGImage {
    public void loadJPEG(String filename) {
        System.out.println("Displaying JPEG image: " + filename);
    }
}

class PNGImage {
    public void loadPNG(String filename) {
        System.out.println("Displaying PNG image: " + filename);
    }
}
class JPEGImageAdapter implements ImageViewer {
    private JPEGImage jpegImage;

    public JPEGImageAdapter(JPEGImage jpegImage) {
        this.jpegImage = jpegImage;
    }

    @Override
    public void displayImage(String filename) {
        jpegImage.loadJPEG(filename);
    }
}

class PNGImageAdapter implements ImageViewer {
    private PNGImage pngImage;

    public PNGImageAdapter(PNGImage pngImage) {
        this.pngImage = pngImage;
    }

    @Override
    public void displayImage(String filename) {
        pngImage.loadPNG(filename);
    }
}


public class AdapterPattern {
    public static void main(String[] args) {
        ImageViewer jpegViewer = new JPEGImageAdapter(new JPEGImage());
        ImageViewer pngViewer = new PNGImageAdapter(new PNGImage());

        jpegViewer.displayImage("photo.jpeg");
        pngViewer.displayImage("photo.png");
    }
}
