package com.epam.aleksandr_generalov.java.lesson8.utils;

import com.epam.aleksandr_generalov.java.lesson8.models.Car;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLUtils {

    public static void writeObjectToXml(String fileName, Car car) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(car, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Car readObjectFromXml(String fileName) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Car) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
