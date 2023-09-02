package org.example.utils;

import org.example.models.DataStructure;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JsonFileWriter {

    private static final Logger logger = Logger.getLogger(JsonFileWriter.class.getName());

    public static void writeToJson(DataStructure dataStructure) {
        String directoryPath = "jsonReqs";
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(dataStructure.getExecutionDate());
        String fileName = "req_" + timestamp + ".json";
        String json = JsonUtils.toJson(dataStructure);

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                logger.log(Level.INFO, "Directory has been created: {0}", directory.getAbsolutePath());
            } else {
                logger.log(Level.SEVERE, "Failed to create directory: {0}", directory.getAbsolutePath());
                return; // Прекращаем запись, так как нет директории
            }
        } else {
            logger.log(Level.INFO, "Directory already exists: {0}", directory.getAbsolutePath());
        }

        File outputFile = new File(directory, fileName);
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.log(Level.INFO, "JSON file has been written successfully: {0}", outputFile.getAbsolutePath());
    }
}