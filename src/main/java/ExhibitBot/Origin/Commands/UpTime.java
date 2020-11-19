package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static ExhibitBot.Origin.Other.Global_Variables.BotStartTime;
import static ExhibitBot.Origin.Other.Global_Variables.COMMAND_PREFIX;

/**
 * Created by josep on 02/08/2017.
 */
public class UpTime extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContentRaw();

        if (message.equalsIgnoreCase(COMMAND_PREFIX + "UpTime") && !(e.getAuthor().isBot())) {
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