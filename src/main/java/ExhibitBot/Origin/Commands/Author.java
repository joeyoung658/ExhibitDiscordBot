package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static ExhibitBot.Origin.Other.Global_Variables.COMMAND_PREFIX;


/**
 * Created by josep on 29/07/2017.
 */
public class Author extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContentRaw();

        if (message.equalsIgnoreCase(COMMAND_PREFIX + "author") && !(e.getAuthor().isBot())) {
            e.getTextChannel().sendMessage("```" +
                    "Developed by Origin#9142 and XploderB#9238" +
                    "\nSource Code - https://github.com/Origin658/ExhibitDiscordBot" +
                    "```").queue();
            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
        }

    }
}
