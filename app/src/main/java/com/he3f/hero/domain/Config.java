package com.he3f.hero.domain;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class Config {
    public static final String CONFIG_PATH = "configPath";
    private static Properties properties;
    private static Config instance;

    private Config() {
        // private as we are doing a singelton pattern here
    }

    private static ThreadLocal<Config> _threadLocal = new ThreadLocal<Config>() {
        @Override
        protected Config initialValue() {
            if (instance != null) {
                return instance;
            } else {

                String path = System.getProperty(CONFIG_PATH);
                Properties properties;
                if (StringUtils.isEmpty(path)) {
                    properties = getLocalConfig();
                } else {
                    File rootPath = new File(".");
                    File file = new File(rootPath.getAbsolutePath() + "" + path);
                    properties = getConfigFile(file);

                }
                Config config = new Config();

                instance = config;
                Config.setProperties(properties);
                return config;
            }
        }
    };

    /**
     * Returns the thread local singleton instance
     * 
     * @return
     */
    public static Config getInstance() {
        return _threadLocal.get();
    }

    private static Properties getLocalConfig() {
        File file = new File("./config.properties");
        return getConfigFile(file);
    }

    private static Properties getConfigFile(File file) {
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException("Cound not find or load config file: " + file.getAbsolutePath());
        }
        return properties;
    }

    public String getProperty(String key) {
        return getProperties().getProperty(key);
    }

    public void setProperty(String key, String value) {
        getProperties().setProperty(key, value);
    }

    public void setProperty(String key, int value) {
        getProperties().setProperty(key, value + "");
    }

    public int getPropertyAsInt(String key) {
        String value = getProperty(key);
        int parsedInt;
        try {
            parsedInt = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 4040;
        }
        return parsedInt;
    }

    public static Properties getProperties() {
        return properties;
    }

    private static void setProperties(Properties properties) {
        Config.properties = properties;
    }

}
