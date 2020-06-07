package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class music extends ListenerAdapter {
    String prefix = "#";
    String url;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(!event.getMember().getUser().isBot()) {
            String messageRaw = event.getMessage().getContentRaw();
            String[] message = event.getMessage().getContentRaw().split(" ");
            char[] messageW = messageRaw.toCharArray();
            int messageL = message.length;

            String charZero = String.valueOf(messageW[0]);
            if (charZero.equalsIgnoreCase(prefix)) {

                if (messageL == 1) {
                    if (message[0].equalsIgnoreCase("#music")) {
                        event.getChannel().sendMessage("This is the music command type (#music help) for more.").queue();
                        System.out.println("Bot Response= " + "This is the music command type (#music help) for more.");
                    }
                }
                if (messageL == 2) {
                    if (message[0].equalsIgnoreCase("#music") && message[1].equalsIgnoreCase("help")) {
                        event.getChannel().sendMessage("This is the play command it allows you to play youtube videos(usually music) in the in the music room voice channel.").queue();
                        System.out.println("Bot Response= " + "This is the music command it allows you to play youtube videos(usually music) in the in the music room voice channel.");
                        event.getChannel().sendMessage("Typing (#music play link) will play that link in the music channel. (#music stop) will stop whatever song is playing.").queue();
                        System.out.println("Bot Response= " + "Typing (#music play link) will play that link in the music channel. (#music stop) will stop whatever song is playing.");
                    }
                    if (message[0].equalsIgnoreCase("#music") && message[1].equalsIgnoreCase("play")) {
                        event.getChannel().sendMessage("This is the music play command type(#music play link) with a functional youtube link and the bot will play the song in the Music Room channel.").queue();
                        System.out.println("Bot Response= " + "This is the music play command type(#music play link) with a functional youtube link and the bot will play the song in the Music Room channel.");
                    }
                    if (message[0].equalsIgnoreCase("#music") && message[1].equalsIgnoreCase("stop")) {

                        event.getChannel().sendMessage("The music has been stopped").queue();
                        System.out.println("Bot Response= " + "The music has been stopped");
                    }

                }
                if (messageL == 3) {
                    if (message[0].equalsIgnoreCase("#music") && message[1].equalsIgnoreCase("play")) {
                        url = message[2];
                        System.out.println("Url: " + url);
                    }
                }
            }
        }
    }


}