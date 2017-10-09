package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import ExhibitBot.Origin.Other.URLReader;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static ExhibitBot.Origin.Other.Constants.COMMAND_PREFIX;


/**
 * Created by josep on 02/08/2017.
 */
public class McStats extends ListenerAdapter {
    public String Stats;

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();


        if (message.equalsIgnoreCase(COMMAND_PREFIX + "McStats") && !(e.getAuthor().isBot())) {

            try {
                Stats = URLReader.URLRead("https://status.mojang.com/check");
            } catch (Exception ev){}


            Stats = Stats.replaceAll("[{},:\\[\\]]","");


            e.getTextChannel().sendMessage(Stats).queue();

//            Login
//            Session
//            Website
//            Textures
//            Realms

//            [
//            {
//                "minecraft.net": "yellow"
//            },
//            {
//                "session.minecraft.net": "green"
//            },
//            {
//                "account.mojang.com": "green"
//            },
//            {
//                "auth.mojang.com": "green"
//            },
//            {
//                "skins.minecraft.net": "green"
//            },
//            {
//                "authserver.mojang.com": "green"
//            },
//            {
//                "sessionserver.mojang.com": "yellow"
//            },
//            {
//                "api.mojang.com": "green"
//            },
//            {
//                "textures.minecraft.net": "red"
//            },
//            {
//                "mojang.com": "green"
//            }
//]





            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
        }

    }
}


