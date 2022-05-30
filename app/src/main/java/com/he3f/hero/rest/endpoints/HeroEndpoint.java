package com.he3f.hero.rest.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.he3f.hero.domain.Hero;

@Path("rest")
public class HeroEndpoint {

    private static List<Hero> heroes;
    private static int size;

    public HeroEndpoint() {
    // if we had a database, we would remove beload code. The get Hero would always pull the latest list of heroes
        if (heroes == null) {
            heroes = new ArrayList<Hero>();
            heroes.add(new Hero("1. hero", 1));
            heroes.add(new Hero("2. hero", 2));
            heroes.add(new Hero("3. hero", 3));
            size = heroes.size();
        }
    }

    @GET
    @Path("{path: (?i)(api/heroes)}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Hero> getSearchHeroes(@QueryParam("name")
    String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("name not sat: " + name);
            return heroes;
        } else {
            System.out.println("name sat: " + name);
            List<Hero> list = new ArrayList<Hero>();
            for (Hero hero : heroes) {
                if (hero.getName().contains(name)) {
                    list.add(hero);
                }
            }
            return list;
        }
    }

    @PUT
    @Path("{path: (?i)(api/heroes)}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Hero> updateHero(Hero hero) {
        for (int i = 0; i < heroes.size(); i++) {
            Hero hereFromList = heroes.get(i);
            if (hereFromList.getId() == hero.getId()) {
                heroes.get(i).setName(hero.getName());
            }
        }
        return heroes;
    }

    @DELETE
    @Path("{path: (?i)(api/heroes)}" + "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Hero> deleteHero(@PathParam("id")
    String id) {
        int index = -1;
        for (int i = 0; i < heroes.size(); i++) {
            Hero hereFromList = heroes.get(i);
            if (hereFromList.getId() == Integer.parseInt(id)) {
                index = i;
            }
        }
        if (index != -1) {
            heroes.remove(index);
        }
        return heroes;
    }

    @POST
    @Path("{path: (?i)(api/heroes)}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Hero createHero(Hero hero) {
        size += 1;
        hero.setId(size);
        heroes.add(hero);
        return hero;
    }

    @GET
    @Path("{path: (?i)(api/heroes)}" + "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Hero getHero(@PathParam("id")
    String id) {
        for (int i = 0; i < heroes.size(); i++) {
            Hero heroFromList = heroes.get(i);
            if (heroFromList.getId() == Integer.parseInt(id)) {
                return heroFromList;
            }
        }
        return null;
    }


}
