package com.appdynamics.demo.persistence;

import com.appdynamics.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by shiv.loka on 8/26/15.
 */
public class UserPersistence {

    private static Map<String, User> userMap = new HashMap<String, User>();
    private int mapLength = 0;
    private User user = null;
    private static Logger logger = LoggerFactory.getLogger(UserPersistence.class);


    public String addUser(User userInfo){
        mapLength = userMap.size();

        String mapContents = null;
        userMap.put("user"+ " " + (mapLength+1), userInfo);
        mapContents = printMapValues();
        return "User has been added" + mapContents;
    }

    private String printMapValues() {
        Iterator iter = userMap.entrySet().iterator();
        String usernames = null;

        while(iter.hasNext()){
            Map.Entry entryVal = (Map.Entry) iter.next();

            user = (User)entryVal.getValue();
            usernames = usernames + user.getUsername();

            logger.info(" "+user.getUsername());
        }
        return usernames;
    }


    public List getAllUsers(){

        List<User> userList = new ArrayList<User>();
        Iterator iterator = userMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry userEntry = (Map.Entry)iterator.next();
            userList.add((User)userEntry.getValue());
        }
        return userList;
    }
}
