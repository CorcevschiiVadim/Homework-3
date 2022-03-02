package xml_parsing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

class ModifyXmlFileDemo {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element rootElement = document.getRootElement();

            Element supercarElement = rootElement.getChild("supercars");

            Attribute attribute = supercarElement.getAttribute("company");
            attribute.setValue("Lamborigini");

            List<Element> list = supercarElement.getChildren();

            for (int temp = 0; temp < list.size(); temp++) {
                Element carElement = list.get(temp);

                if ("Ferrari 101".equals(carElement.getText())) {
                    carElement.setText("Lamborigini 001");
                }

                if ("Ferrari 202".equals(carElement.getText())) {
                    carElement.setText("Lamborigini 002");
                }
            }

            List<Element> supercarslist = rootElement.getChildren();

            for (int temp = 0; temp < supercarslist.size(); temp++) {
                Element tempElement = supercarslist.get(temp);

                if ("luxurycars".equals(tempElement.getName())) {
                    rootElement.removeContent(tempElement);
                }
            }

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(document, System.out);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
