//package ExhibitBot.Origin.GuildMembers;
//
//import ExhibitBot.Origin.Other.Logging;
//import net.dv8tion.jda.api.exceptions.PermissionException;
//import net.dv8tion.jda.api.hooks.ListenerAdapter;
//
///**
// * Created by josep on 14/06/2017.
// */
//public class NickChange extends ListenerAdapter {
//    @Override
//    public void onGuildMemberNickChange(GuildMemberNickChangeEvent e){
//        String newnick = e.getNewNick();
//        String oldnick = e.getPrevNick();
//
//        if (oldnick == null) {
//            oldnick = e.getMember().getUser().getName();
//        }
//
//        if (newnick == null) {
//            try{Logging.DataLog(e.getGuild().getName(),  e.getMember().getUser().getName()   , " has removed their nickname of \""+ oldnick + "\"", true, e.getGuild() );}catch (PermissionException er){}
//        } else {
//            try{Logging.DataLog(e.getGuild().getName(),  e.getMember().getUser().getName()   , " has changed their nickname to \"" + newnick
//                    + "\" from \""  + oldnick + "\"", true, e.getGuild());}catch (PermissionException er){}
//        }
//
//    }
//}
