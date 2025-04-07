package NMFY.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;

public class Reboot extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!(event.getName().equals("reboot"))) return;

        try {
            // Reboot the system
            Process process = Runtime.getRuntime().exec("sudo reboot");
            process.waitFor();
            event.reply("Rebooting");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }




}
