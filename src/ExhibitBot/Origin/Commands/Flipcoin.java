package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ExhibitBot.Origin.Other.Constants.SERVER_IP;

/**
 * Created by josep on 11/06/2017.
 */
public class Flipcoin extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String message = e.getMessage().getContent();
        List<String> coin = new ArrayList();
        coin.add("Heads");
        coin.add("Tails");

        if (message.startsWith("!flipcoin") && !(e.getAuthor().isBot())) {
            Random rand = new Random();
            int random = rand.nextInt(2) + 0;
            e.getTextChannel().sendMessage( e.getAuthor().getAsMention() + " flipped " + coin.get(random)).queue();
            Logging.CLog(e.getGuild().getName(), e.getAuthor().getName(), message);
        }
    }
}