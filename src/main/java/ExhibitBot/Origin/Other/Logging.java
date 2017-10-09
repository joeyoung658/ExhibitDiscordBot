package ExhibitBot.Origin.Other;


import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;
import sun.rmi.runtime.Log;

import java.util.List;


/**
 * Created by josep on 10/06/2017.
 */
public class Logging {

//    public static void DataLog(String guildN, String aName, String message){
//        /*
//        Logs to console
//         */
//        String log = guildN + ": " + aName + ": " + message;
//        System.out.println(log);
//
//    }

    public static void DataLog(String guildN, String aName, String message, Boolean logchat, Guild guild) throws PermissionException{
        /*
        Logs to logging channel within the server
         */

        String log = aName + ": " + message;
        List<TextChannel> guildchannels = guild.getTextChannels();


        for (TextChannel channel: guildchannels){
            if (channel.getName().equalsIgnoreCase("general")){
                channel.sendMessage("```" + log + "```").queue();
            }
        }




//        if (logchat) {
//
//            if (!(guild.getTextChannelsByName("Logging", true).isEmpty())) {
//
//                Logging.sendMessage("```" + log + "```").queue();
//
//                }
//        }
    }


}