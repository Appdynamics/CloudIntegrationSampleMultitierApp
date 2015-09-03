package com.appdynamics.demo.service;


import com.appdynamics.demo.model.User;
import com.appdynamics.demo.persistence.UserPersistence;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shiv.loka on 8/26/15.
 */
@Path("/user")
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    UserPersistence userPersistence = new UserPersistence();
    User user = new User();


    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List getAllUsers(){

        List users = userPersistence.getAllUsers();
        JSONObject userObj = userListToJSON(users);
        logger.info("Users returned are: " +userObj);
        return users;

    }

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public String addUser(@Context HttpServletRequest req){
        User user = new User();
        user.setEmail(req.getParameter("email"));
        user.setUsername(req.getParameter("username"));

        String responseString = userPersistence.addUser(user);
        return responseString;
    }

    public JSONObject userListToJSON(List userList){
        Iterator iter = userList.listIterator();
        JSONObject jsonObj = new JSONObject();
        JSONArray objArray = new JSONArray();
        int i = 1;
        while(iter.hasNext()){
            user = (User)iter.next();
            jsonObj.put("user"+ " "+ i, user.getEmail() + " " +user.getUsername());
            i++;
        }

        return jsonObj;
    }

}
