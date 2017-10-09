package ExhibitBot.Origin;

import ExhibitBot.Origin.Commands.*;

import ExhibitBot.Origin.GuildMembers.*;
import ExhibitBot.Origin.GuildVoice.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;


import javax.security.auth.login.LoginException;

import java.util.Date;

import static ExhibitBot.Origin.Other.Constants.BOT_TOKEN;
import static ExhibitBot.Origin.Other.Constants.BotStartTime;

/**
 * Created by josep on 10/06/2017.
 */
public class Main {
    public static JDABuilder discord;
    public static JDA jda;


    public static void main(String[] args){


        //Establishes connection with jda
        discord = new JDABuilder(AccountType.BOT);
        discord.setToken(BOT_TOKEN);
        discord.setAudioEnabled(true);
        discord.setAutoReconnect(true);
        discord.setGame(Game.of("eM"));



        try {
            jda = discord.buildBlocking();
        } catch (LoginException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
        }


        registerCommands();
        registerGuildVoiceEvents();
        registerGuildMemberEvents();
        BotStartTimeRecord();

    }
    private static void registerCommands(){
        jda.addEventListener(new Commands());
        jda.addEventListener(new Ip());
        jda.addEventListener(new Hello());
        jda.addEventListener(new Website());
        jda.addEventListener(new Vote());
        jda.addEventListener(new Flipcoin());
        jda.addEventListener(new Diceroll());
        jda.addEventListener(new Serverplayercount());
        jda.addEventListener(new TotalMembers());
        jda.addEventListener(new Author());
        jda.addEventListener(new UpTime());
        jda.addEventListener(new McStats());
    }
    private static void registerGuildVoiceEvents(){
        jda.addEventListener(new VoiceJoin());
        jda.addEventListener(new VoiceLeave());
        jda.addEventListener(new VoiceMove());
    }
    private static void registerGuildMemberEvents(){
        jda.addEventListener(new NickChange());
        jda.addEventListener(new GuildJoin());
        jda.addEventListener(new GuildLeave());
    }
    private static void BotStartTimeRecord(){
        BotStartTime = new Date();
    }
}