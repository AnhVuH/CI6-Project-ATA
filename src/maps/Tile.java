package maps;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Tile {
    // các tên thuộc tính phải trùng với các trường trong trường tilesets của file json
    public Integer firstgid; // id của tile trong mảng data (integer object)
    public String image;
    public String name;
    public int tileheight, tilewidth;

    public String findPath(){
//        System.out.println(this.image);
        return "assets/maps/ATA-MAPS/"+ this.image;
    }










//    public String source;
//
//    public String findPath(){
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder db = dbFactory.newDocumentBuilder();
//            try {
//                Document document = db.parse( "assets/maps/ATA-MAPS/"+this.source);
//                document.getDocumentElement().normalize();
//                NodeList dataList =  document.getElementsByTagName("image");
//                Node node = dataList.item(0);
//                Element e = (Element) node;
//                String sourceImage = e.getAttribute("source");
//                return sourceImage;
//            } catch (SAXException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
