package xml_parsing;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
public class StAX {
    public static void main(String[] args) {

        try {
            StringWriter stringWriter = new StringWriter();

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);

            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeStartElement("cars");

            xMLStreamWriter.writeStartElement("supercars");
            xMLStreamWriter.writeAttribute("company", "Ferrari");

            xMLStreamWriter.writeStartElement("carname");
            xMLStreamWriter.writeAttribute("type", "formula one");
            xMLStreamWriter.writeCharacters("Ferrari 101");
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("carname");
            xMLStreamWriter.writeAttribute("type", "formula one");
            xMLStreamWriter.writeCharacters("Ferrari 202");
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();

            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();

            stringWriter.close();

            System.out.println(xmlString);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
