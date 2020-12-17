package ExhibitBot.Origin;

import ExhibitBot.Origin.Commands.*;
import ExhibitBot.Origin.GuildMembers.*;
import ExhibitBot.Origin.GuildVoice.VoiceJoin;
import ExhibitBot.Origin.GuildVoice.VoiceLeave;
import ExhibitBot.Origin.GuildVoice.VoiceMove;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;


import javax.security.auth.login.LoginException;
import java.util.Date;

import static ExhibitBot.Origin.Other.Global_Variables.BOT_TOKEN;
import static ExhibitBot.Origin.Other.Global_Variables.BotStartTime;

/**
 * Created by josep on 10/06/2017.
 */
public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(BOT_TOKEN);

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("brad"));

        builder = registerCommands(builder);
        builder = registerGuildVoiceEvents(builder);
        builder = registerGuildMemberEvents(builder);

        builder.build();

        BotStartTimeRecord();
    }
    private static JDABuilder registerCommands(JDABuilder builder){
        builder.addEventListeners(new Commands());
        builder.addEventListeners(new Ip());
        builder.addEventListeners(new Hello());
        builder.addEventListeners(new Website());
        builder.addEventListeners(new Vote());
        builder.addEventListeners(new Flipcoin());
        builder.addEventListeners(new Diceroll());
        builder.addEventListeners(new Serverplayercount());
        builder.addEventListeners(new TotalMembers());
        builder.addEventListeners(new Author());
        builder.addEventListeners(new UpTime());
        builder.addEventListeners(new McStats());
        builder.addEventListeners(new GMT());
        return builder;
    }
    
    private static JDABuilder registerGuildVoiceEvents(JDABuilder builder){
        builder.addEventListeners(new VoiceJoin());
        builder.addEventListeners(new VoiceLeave());
        builder.addEventListeners(new VoiceMove());
        return builder;
    }
    private static JDABuilder registerGuildMemberEvents(JDABuilder builder){
        builder.addEventListeners(new GuildJoin());
        builder.addEventListeners(new GuildLeave());
        builder.addEventListeners(new GuildBan());
        builder.addEventListeners(new GuildUnban());
        return builder;
    }
    private static void BotStartTimeRecord(){
        BotStartTime = new Date();
    }
}