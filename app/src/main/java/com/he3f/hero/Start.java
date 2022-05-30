package com.he3f.hero;

import com.he3f.hero.domain.Config;
import com.he3f.rest.RestServer;

public class Start {

    public static void main(String[] args) throws Exception {
        System.out.println("http://localhost:" + Config.getInstance().getProperty("port") + "/rest/api/heroes");
        new RestServer();
    }
    

}
