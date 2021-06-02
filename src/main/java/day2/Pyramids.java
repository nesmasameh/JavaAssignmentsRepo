package day2;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class Pyramid {

    private String pharaoh;
    private String modern_name;
    private String site;
    private double height;

    public Pyramid(String pharaoh, String modern_name, String site, double height) {
        this.pharaoh = pharaoh;
        this.modern_name = modern_name;
        this.site = site;
        this.height = height;
    }

    public String getPharaoh() {
        return pharaoh;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public String getModern_name() {
        return modern_name;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return getPharaoh() + " " + getModern_name() + " " + getSite() + " " + getHeight();
    }
}

class PyramidCSVDAO {

    public Pyramid createpPyramid(String[] metadata) {//metadata = fields array of string
        for (int fieldIndex = 0; fieldIndex < metadata.length; fieldIndex++) {
            metadata[fieldIndex] = metadata[fieldIndex].trim();
        }
        double height;
        if (metadata[7].isEmpty()) { //if (metadata[7].equals(""))
            height = 0;
        } else {
            height = Double.valueOf(metadata[7]);
        }
        Pyramid p = new Pyramid(metadata[0], metadata[2], metadata[4], height);
        return p;
    }

    public List<Pyramid> readPyramidsFromCSV(String fileName) {//fileName = filePath
        List<Pyramid> pyramids = new ArrayList<>();
        File pyramidsInfo = new File(fileName);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(pyramidsInfo.toPath());
        } catch (Exception e) {
            System.out.println("issue happened during reading pyramidsInfo : " + e);
        }
        for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex);
            String[] fields = line.split(",");
            pyramids.add(createpPyramid(fields));
        }
        return pyramids;
    }
}

public class Pyramids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("G:\\pyramids.csv");
        int i = 0;
        for (Pyramid p : pyramids) {
            System.out.println("#" + (i++) + p);
        }

    }

}
