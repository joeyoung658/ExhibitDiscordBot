package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import jdk.nashorn.internal.runtime.ListAdapter;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
            long seconds = difference/1000;

            long[] time = splitToComponentTimes(seconds);
            e.getTextChannel().sendMessage("```Uptime - " +time[1] + " Days, " +  time[1] + " Hours, " + time[2] + " Minutes and " + time[3] + " Seconds.```").queue();
            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
        }
    }

    private long[] splitToComponentTimes(Long longVal)
    {
        long days = TimeUnit.SECONDS.toDays(longVal);
        long hours = TimeUnit.SECONDS.toHours(longVal) - (days *24);
        long minutes = TimeUnit.SECONDS.toMinutes(longVal) - (TimeUnit.SECONDS.toHours(longVal)* 60);
        long seconds = TimeUnit.SECONDS.toSeconds(longVal) - (TimeUnit.SECONDS.toMinutes(longVal) *60);

        long[] ints = {days, hours , minutes , seconds};
        return ints;
    }
}