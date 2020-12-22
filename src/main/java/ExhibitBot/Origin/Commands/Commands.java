package ExhibitBot.Origin.Commands;


import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static ExhibitBot.Origin.Other.Global_Variables.COMMAND_PREFIX;


/**
 * Created by josep on 10/06/2017.
 */
public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContentRaw();
        String sendMessage = "```" +COMMAND_PREFIX + "commands - Shows a list of all commands " +
                "\n" + COMMAND_PREFIX + "ip - Shows the current server IP " +
                "\n" + COMMAND_PREFIX + "website - Shows our website link" +
                "\n" + COMMAND_PREFIX + "hello - Greets you" +
                "\n" + COMMAND_PREFIX + "vote - Shows our voting links" +
                "\n" + COMMAND_PREFIX + "flipcoin - Flips a coin" +
                "\n" + COMMAND_PREFIX + "playercount - Shows how many players are playing on the server" +
                "\n" + COMMAND_PREFIX + "diceroll - Enables you to roll a dice" +
                 "\n" + COMMAND_PREFIX + "membercount - Shows the total amount of members on the discord server" +
                "\n" + COMMAND_PREFIX + "UpTime - Shows how long the bot has been online" +
                "\n" + COMMAND_PREFIX + "McStats - Shows the Minecraft Service Status" +
                "\n" + COMMAND_PREFIX + "GMT - Show time" +
                "\n" + COMMAND_PREFIX + "ban form - Get the ban appeal form for AA" +
                "\n" + COMMAND_PREFIX + "Author - Shows information about the bot ```";


        if (message.equalsIgnoreCase(COMMAND_PREFIX + "commands") && !(e.getAuthor().isBot())) {



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

            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}

        }

        }
    }