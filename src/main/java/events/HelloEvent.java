package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

public class HelloEvent extends ListenerAdapter {
    public Random rnd = new Random();
    //List of hi-s just to store responses
    String[] listOfGreetings = {"Hey","Hi","What's up","Hello there","Hola","Hiya"};

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        int length = message.length;
        if(!event.getMember().getUser().isBot()) {
            int rando = rnd.nextInt(5);
            String name = event.getMember().getUser().getName();
            for (int i = 0; i < length; i++) {
                if (message[i].equalsIgnoreCase("hello") || message[i].equalsIgnoreCase("hi")) {
                    String response = listOfGreetings[rando];
                    event.getChannel().sendMessage(response + " "+ name + "!").queue();
                }
            }
        }

    }
}