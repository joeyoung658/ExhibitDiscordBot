package ExhibitBot.Origin.Other;

import java.io.IOException;

/**
 * Created by josep on 10/06/2017.
 */
public class Logging {

    public static void CLog(String guild, String aName, String message){

        String log = guild + " " + aName + ": " + message;

        System.out.println(log);

        //WriteLog.writeToFile(log);

    }


}
