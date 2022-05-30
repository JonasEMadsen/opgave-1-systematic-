package com.he3f.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import com.he3f.hero.domain.Config;

public class RestServer {

    private Server jettyServer;

    public RestServer() {
        
        final ResourceConfig application = new ResourceConfig()
                .packages("com.he3f.hero.rest.endpoints")
                .register(JacksonFeature.class);

        ServletContextHandler context 
                 = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        Server jettyServer = new Server(Config.getInstance().getPropertyAsInt("port"));
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = new ServletHolder(new
                org.glassfish.jersey.servlet.ServletContainer(application));
        jerseyServlet.setInitOrder(0);

        context.addServlet(jerseyServlet, "/*");
  
        try {
            jettyServer.start();

            new Thread() {
                @Override
                public void run() {

                    try {

                        jettyServer.join();
                        while (true) {
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // server.destroy();
        }
    }

    public void stop() throws Exception {

        jettyServer.stop();
        jettyServer.join();
    }

}
