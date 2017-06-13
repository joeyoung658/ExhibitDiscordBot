package ExhibitBot.Origin;

import ExhibitBot.Origin.Commands.*;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

import static ExhibitBot.Origin.Other.Constants.BOT_TOKEN;

/**
 * Created by josep on 10/06/2017.
 */
public class Main {

    public static JDA discord;

    public static void main(String[] args){


        //Establishes connection with discord
        try {
            discord = new JDABuilder(AccountType.BOT).setToken(BOT_TOKEN).buildBlocking();
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e){
            e.printStackTrace();
        }


        registerCommands();
    }

    public static void registerCommands(){
        discord.addEventListener(new Commands());
        discord.addEventListener(new Ip());
        discord.addEventListener(new Hello());
        discord.addEventListener(new Website());
        discord.addEventListener(new Vote());
        discord.addEventListener(new Flipcoin());
        discord.addEventListener(new Diceroll());
        discord.addEventListener(new Serverplayercount());
    }
}
