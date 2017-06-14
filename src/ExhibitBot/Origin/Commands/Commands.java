package ExhibitBot.Origin.Commands;


import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


/**
 * Created by josep on 10/06/2017.
 */
public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();
        String sendMessage = "```!commands - Shows a list of all commands " +
                "\n!ip - Shows the current server IP " +
                "\n!website - Shows our website link" +
                "\n!hello - Greets you" +
                "\n!vote - Shows our voting links" +
                "\n!flipcoin - Flips a coin" +
                "\n!playercount - Shows how many players are playing on the server" +
                "\n!diceroll - Enables you to roll a dice" +
                 "\n!membercount - Shows the total amount of members on the discord server ```";

        if (message.equalsIgnoreCase("!commands") && !(e.getAuthor().isBot())) {

            Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());

            if (e.isFromType(ChannelType.TEXT)) {
                e.getAuthor().openPrivateChannel().complete().sendMessage(sendMessage).queue();
                e.getTextChannel().sendMessage("All commands have been sent via a DM to " + e.getAuthor().getAsMention()).queue();
                return;
            }

            if (e.isFromType(ChannelType.PRIVATE)) {
                e.getAuthor().openPrivateChannel().complete().sendMessage(sendMessage).queue();
                return;
            }

            if (e.isFromType(ChannelType.GROUP)) {
                return;
            }

            if (e.isFromType(ChannelType.UNKNOWN)) {
                return;
            }


        }

        }
    }