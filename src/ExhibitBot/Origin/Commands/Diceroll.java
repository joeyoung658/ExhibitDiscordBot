package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

import static ExhibitBot.Origin.Other.Constants.SERVER_IP;

/**
 * Created by josep on 11/06/2017.
 */
public class Diceroll extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();

        if (message.startsWith("!roll") && !(e.getAuthor().isBot())) {


                Random rand = new Random();
                int random = rand.nextInt(6) + 1;

                e.getTextChannel().sendMessage( e.getAuthor().getAsMention() + " rolled " +  random + "/6 on the dice" ).queue();

                Logging.CLog(e.getGuild().getName(), e.getAuthor().getName(), message);
        }
    }
}