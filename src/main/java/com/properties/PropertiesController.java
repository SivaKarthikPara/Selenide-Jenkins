package com.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesController {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);
    final InputStream inputStream = PropertiesController.class.getClassLoader().getResourceAsStream("common.properties");

    private static PropertiesController instance = null;
    private final Properties properties = new Properties();

    private PropertiesController() {
        try {
            loadProperties(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (instance == null) {
            instance = new PropertiesController();
        }
        LOG.info("Loading {} from properties", key);
        return instance.properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        String valueFromProperty = getProperty(key);
        return valueFromProperty == null ? defaultValue : valueFromProperty;
    }

    private void loadProperties(InputStream inputStream) throws IOException {
        LOG.info("Loading properties");
        if (inputStream == null) {
            throw new IOException("Unable to open stream for resource ");
        }
        final Properties props = new Properties();
        props.load(inputStream);
        inputStream.close();
        properties.putAll(props);
    }

}
