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
                "\r\n!ip - Shows the current server IP " +
                "\r\n!website - Shows our website link" +
                "\r\n!hello - Greets you" +
                "\r\n!vote - Shows our voting links" +
                "\r\n!flipcoin - Flips a coin" +
                "\r\n!playercount - Shows how many players are playing on the server```";

        if (message.startsWith("!commands") && !(e.getAuthor().isBot())) {

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

            Logging.CLog(e.getGuild().getName(), e.getAuthor().getName(), message);
        }

        }
    }