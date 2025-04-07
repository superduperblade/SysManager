package NMFY.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class PublicIp extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("public_ip"))) return;


        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle("Public IP",null);
            eb.addField("Public IP",br.readLine(),false);
            eb.setColor(Color.GREEN);
            event.replyEmbeds(eb.build()).queue();
        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }


    }




}
