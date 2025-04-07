package NMFY.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DecimalFormat;

public class Uptime extends ListenerAdapter {

    public static long startTime = System.currentTimeMillis();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("uptime"))) return;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        EmbedBuilder embedBuilder = new EmbedBuilder();


        long milliseconds  = System.currentTimeMillis()-startTime;
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);
        int hours   = (int) ((milliseconds / (1000*60*60)) % 24);

        embedBuilder.setTitle("Stats");
        embedBuilder.setFooter("Running for "+hours+" hours "+minutes+" min "+seconds+" seconds");
        embedBuilder.setColor(Color.GREEN);
        event.replyEmbeds(embedBuilder.build()).queue();
    }




}
