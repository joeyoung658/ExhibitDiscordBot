package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import jdk.nashorn.internal.runtime.ListAdapter;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.math.BigDecimal;
import java.util.Date;

import static ExhibitBot.Origin.Other.Constants.BotStartTime;
import static ExhibitBot.Origin.Other.Constants.SERVER_IP;

/**
 * Created by josep on 02/08/2017.
 */
public class UpTime extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();

        if (message.equalsIgnoreCase("!UpTime") && !(e.getAuthor().isBot())) {
            Date CurrentDate = new Date();
            long difference = (CurrentDate.getTime() - BotStartTime.getTime());
            Long seconds = difference/1000;
            int[] time = splitToComponentTimes(seconds);

            e.getTextChannel().sendMessage("```Uptime - " +time[1] + " Days, " +  time[1] + " Hours, " + time[2] + " Minutes and " + time[3] + " Seconds.```").queue();


            Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());
        }
    }

    private int[] splitToComponentTimes(Long biggy)
    {
        int longVal = (int) biggy.longValue();
        int days = longVal / 86400;
        int hours = (longVal % 86400 ) / 3600 ;
        int mins = ((longVal % 86400 ) % 3600 ) / 60;
        int secs = ((longVal % 86400 ) % 3600 ) % 60;

        int[] ints = {days, hours , mins , secs};
        return ints;
    }
}