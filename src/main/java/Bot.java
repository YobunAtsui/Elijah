import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import commands.math;
import commands.music;
import domain.WordConfig;
import events.HelloEvent;
import events.SwearEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.*;

public class Bot {
    public static void main(String args[])throws Exception{
        JDA jda = new JDABuilder( "NzE4OTIwODM3NTc4NjIxMTc3.Xtv5Qw.a243thqwhseblVGlg9hJE9J9WWU").build();
        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new SwearEvent());
        jda.addEventListener(new math());
        jda.addEventListener(new music());
        Gson g = new Gson();
        AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(playerManager);


        String filePath = "/Users/Omega Cock Computer/IdeaProjects/bot/src/main/resources/words.json";

        String json = new String ( Files.readAllBytes( Paths.get(filePath)));

        WordConfig config = g.fromJson(json,WordConfig.class);

        //out.println(config);


    }

}
