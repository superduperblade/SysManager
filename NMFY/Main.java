package NMFY;

import NMFY.Commands.LocalIP;
import NMFY.Commands.PublicIp;
import NMFY.Commands.Reboot;
import NMFY.Commands.Uptime;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.EnumSet;




public class Main {
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("ERROR: YOU NEED TO PROVIDE THE BOT TOKEN IN THE ARGUMENTS");
        }

       JDA jda = JDABuilder.createLight(args[0], EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT))
               .addEventListeners(new LocalIP())
               .addEventListeners(new PublicIp())
               .addEventListeners(new Reboot())
               .addEventListeners(new Uptime())
                .build();

        CommandListUpdateAction commands = jda.updateCommands();
        commands.addCommands(
                Commands.slash("reboot","Reboots the system"),
                Commands.slash( "public_ip","Gets the public ip"),
                Commands.slash("local_ip","Gets the local ip"),
                Commands.slash("uptime","Gets how long the bot has been running")
        );

        commands.queue();
    }
}