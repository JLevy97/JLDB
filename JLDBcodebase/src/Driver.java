/**
 * Created by User on 4/9/2018.
 */
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private static final String UserDataPath = "E:\\JLDB\\userInfo\\userLOGIN";
    private static final String activityLOGpath = "E:\\JLDB\\userInfo\\activityLOG";
    private static final String schemaListpath = "E:\\JLDB\\userInfo\\schemaList";
    private static final String schemaDataPath ="E:\\JLDB\\schemas\\";

    private static final String ADMIN = "ADMIN";
    private static final String ADMINPASS = "ADMINPASS";

    private static Map<String,String> users;
    private static ArrayList<String> activityLOG;
    private static ArrayList<String> schemaList;
    private static ArrayList<Relations> schemas;

    private static String currentUser;

    public static void main(String[] args){

        /////////////////////////////////////////////////////////////////////////LOAD UP Process
        users = new HashMap<String,String>();
        activityLOG = new ArrayList<String>();
        schemaList = new ArrayList<String>();
        schemas = new ArrayList<Relations>();

        currentUser = "JLDB~STARTUP";
                                                                               //load up users and log data
        File userF = new File(UserDataPath);
        File logF = new File(activityLOGpath);
        File lListF = new File(schemaListpath);
        BufferedReader userR;
        BufferedReader logR;
        BufferedReader lListR;

        try{

            if (!userF.exists()){                                               //checks for and loads all Users
                userF.createNewFile();
            }
            userR = new BufferedReader(new FileReader(userF));
            String[] userRecord;
            while ((userRecord = userR.readLine().split(","))!=null){
                users.put(userRecord[0],userRecord[1]);
            }
            if(!users.containsKey(ADMIN)){
                users.put(ADMIN,ADMINPASS);
            }

            if (!logF.exists()){                                               //checks for and loads Activity LOG
                logF.createNewFile();
            }
            logR = new BufferedReader(new FileReader(logF));
            String line;
            while ((line = logR.readLine())!=null){
                activityLOG.add(line);
            }

            if (!lListF.exists()){                                               //checks for and loads Schema List
                lListF.createNewFile();
            }
            lListR = new BufferedReader(new FileReader(lListF));
            while ((line = lListR.readLine())!=null){
                schemaList.add(line);
            }
                                                                                    //checks for and loads the schemas from the Schema List
            File schemaF;
            ObjectInputStream schemaR = null;                                    //need to close???
            for(String n: schemaList){
                schemaF = new File(schemaDataPath+n);
                if (!schemaF.exists()){
                    System.out.println("error in schema list, file not found");
                    continue;
                }
                schemaR = new ObjectInputStream(new FileInputStream(schemaF));
                schemas.add((Relations) schemaR.readObject());
            }

            userR.close();
            logR.close();
            lListR.close();


        }catch (Exception e){
            System.out.println("problem with initial loading");
            e.printStackTrace();
        }

        /////////////////////////////////////////////////////////////////////////GUI SETUP





        /////////////////////////////////////////////////////////////////////////USER SELECTION PROCESS

        System.out.println(currentUser);

    }


}
