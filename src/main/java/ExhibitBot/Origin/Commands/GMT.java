package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ExhibitBot.Origin.Other.Global_Variables.COMMAND_PREFIX;

public class GMT extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String message = e.getMessage().getContentRaw();

        if (message.equalsIgnoreCase(COMMAND_PREFIX + "cum") && !(e.getAuthor().isBot())) {
            e.getTextChannel().sendMessage( e.getAuthor().getAsMention() + "twat" ).queue();
            try {
                Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}

        }
    }
}