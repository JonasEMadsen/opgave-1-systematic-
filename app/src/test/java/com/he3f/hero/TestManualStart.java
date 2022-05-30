package com.he3f.hero;

import com.he3f.hero.domain.Config;
import com.he3f.rest.RestServer;

public class TestManualStart {

    public static void main(String[] args) throws Exception {
        System.setProperty(Config.CONFIG_PATH, "/src/test/resources/config.properties");
        Config.getInstance().setProperty("port", 1337);
        System.out.println("http://localhost:" + Config.getInstance().getProperty("port") + "/rest/api/heroes");
        new RestServer();
    }

}
