package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static ExhibitBot.Origin.Other.Global_Variables.COMMAND_PREFIX;

public class Ban extends ListenerAdapter {


    /**
     * Created by BQ on 22/12/2020.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String message = e.getMessage().getContentRaw();


        if (message.equalsIgnoreCase(COMMAND_PREFIX + "ban form") && !(e.getAuthor().isBot())) {
            String Time = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(ZonedDateTime.now());





            e.getTextChannel().sendMessage( e.getAuthor().getAsMention() + "Please see: https://forms.gle/d8rZMAbXixHMGcBk8").queue();
            try {
                Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
}}}
