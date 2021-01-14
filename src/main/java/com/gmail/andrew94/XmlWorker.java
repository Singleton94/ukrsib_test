package com.gmail.andrew94;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gmail.andrew94.entity.Transaction;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew Samoilov
 */
public class XmlWorker {

    public static <T> List<T> readXml(String filepath, String targetElement, Class<T> tClass) throws IOException, XMLStreamException {

        List<T> tList = new ArrayList<>();

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        XMLInputFactory f = XMLInputFactory.newFactory();
        XMLStreamReader sr = f.createXMLStreamReader(new FileReader(filepath));

        while (sr.hasNext()) {
            int type = sr.next();

            if (type == XMLStreamReader.START_ELEMENT && targetElement.equals(sr.getLocalName())) {
                T tObject = xmlMapper.readValue(sr, tClass);
                tList.add(tObject);
            }
        }
        return tList;
    }
}
