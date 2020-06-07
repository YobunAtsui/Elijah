package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SwearEvent extends ListenerAdapter {
    //Ignore the next line not school friendly needs to be here to prevent people from saying it in chat
    String[] swearWords = {"fuck", "shit", "bullshit", "damn", "asshole", "ass", "bitch", "cunt", "fucker", "motherfucker"};

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        int mLength = message.length;
        int curseLength = swearWords.length;
        if(!event.getMember().getUser().isBot()) {
            String name = event.getMember().getUser().getName();
            for (int i = 0; i < mLength; i++) {
                System.out.println("index:  "+i);
                for(int e=0; e < curseLength; e++)
                {
                    String curse = swearWords[e];
                    if(message[i].equalsIgnoreCase(curse))
                    {
                        event.getChannel().sendMessage( "You can't say that here "+ name + "!").queue();
                        System.out.println("Bot Response= " + "You can't say that here "+ name + "!");
                        String messageId = event.getChannel().getLatestMessageId();
                        event.getChannel().deleteMessageById(messageId).queue();
                    }
                }

            }
        }

    }
}
