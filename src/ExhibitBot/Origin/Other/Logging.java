package ExhibitBot.Origin.Other;

import net.dv8tion.jda.core.entities.Guild;



/**
 * Created by josep on 10/06/2017.
 */
public class Logging {

    public static void DataLog(String guildN, String aName, String message){
        /*
        Logs to console
         */
        String log = guildN + ": " + aName + ": " + message;
        System.out.println(log);

    }

    public static void DataLog(String guildN, String aName, String message, Boolean logchat, Guild guild) {
        /*
        Logs to logging channel within the server
         */

        String log = aName + ": " + message;
        if (logchat) {
            if (!(guild.getTextChannelsByName("Logging", true).isEmpty())) {
                guild.getTextChannelsByName("Logging", true).get(0).sendMessage("```"+log+"```").queue();
            }
        }
        System.out.println(log);
    }

    public static void DataLog(String guildN, String aName, String message, Boolean logchat, Guild guild, Boolean staffchat) {
        /*
        Can log to discord staff chat &  Logging channel
         */
        String log = aName + ": " + message;

        if (staffchat) {
            if (!(guild.getTextChannelsByName("discord_staff_chat", true).isEmpty())) {
                guild.getTextChannelsByName("discord_staff_chat", true).get(0).sendMessage("```" + log + "```").queue();
            }
        }
            if (logchat) {
                if (!(guild.getTextChannelsByName("Logging", true).isEmpty())) {
                    guild.getTextChannelsByName("Logging", true).get(0).sendMessage("```" + log + "```").queue();
                }
            }
        System.out.println(log);
    }
}