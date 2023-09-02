package org.example.utils;

import org.example.models.DataStructure;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLFileWriter {

    private static final Logger logger = Logger.getLogger(XMLFileWriter.class.getName());

    private XMLFileWriter(){
        System.out.println("Private constructor.");
        System.out.println("Forbidden to create this class instance.");
    };

    public static void writeToXml(DataStructure dataStructure) {
        String directoryPath = "xmlReqs";
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "req_" + timestamp + ".xml";

        try {
            JAXBContext context = JAXBContext.newInstance(DataStructure.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File directory = new File(directoryPath);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    logger.log(Level.INFO, "Directory has been created: {0}", directory.getAbsolutePath());
                } else {
                    logger.log(Level.SEVERE, "Failed to create directory: {0}", directory.getAbsolutePath());
                    return;
                }
            } else {
                logger.log(Level.INFO, "Directory already exists: {0}", directory.getAbsolutePath());
            }

            File outputFile = new File(directory, fileName);

            marshaller.marshal(dataStructure, outputFile);
            logger.log(Level.INFO, "XML file has been successfully written: {0}", outputFile.getAbsolutePath());
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "An error occurred during XML file writing: {0}", e.getMessage());
        }
    }
}