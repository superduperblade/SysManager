package NMFY.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
public class LocalIP extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (!(event.getName().equals("local_ip"))) return;
        String localIp= "";
        try {
            DatagramSocket socket = new DatagramSocket();
            Throwable var1 = null;


            try {
                socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
               localIp = socket.getLocalAddress().getHostAddress();

            } catch (Throwable var13) {
                var1 = var13;
                throw var13;
            } finally {
                if (socket != null) {
                    if (var1 != null) {
                        try {
                            socket.close();
                        } catch (Throwable var12) {
                            var1.addSuppressed(var12);
                        }
                    } else {
                        socket.close();
                    }
                }

            }


        } catch (SocketException | UnknownHostException var15) {

        }
        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Local IP",null);
        eb.addField("Local IP",localIp,false);
        eb.setColor(Color.GREEN);
        event.replyEmbeds(eb.build()).queue();



    }




}
