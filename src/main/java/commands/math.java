package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class math extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] message = event.getMessage().getContentRaw().split(" ");
        int messageL = message.length;
        int[] arr;
        arr = new int[2];

        if(!event.getMember().getUser().isBot()){
            if(messageL == 1){
                if(message[0].equalsIgnoreCase(("#calculate"))){
                    event.getChannel().sendMessage("What would you like to calculate?").queue();
                }
            }
            if(messageL == 2){
                if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("help")){
                    event.getChannel().sendMessage("Use (#calculate add x y) to add two numbers. Use (#calculate subtract x y) to subtract x from y.").queue();
                }
                if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("add")){
                    event.getChannel().sendMessage("Use this to add two numbers").queue();
                }
                if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("subtract")){
                    event.getChannel().sendMessage("Use this to subtract one number from another").queue();
                }
            }
            if(messageL == 3){
                event.getChannel().sendMessage("I need two numbers").queue();
            }
            if(messageL == 4){
                try{
                    arr = new int[]{Integer.parseInt(message[2]), Integer.parseInt(message[3])};
                    int firstNum = arr[0];
                    int secondNum = arr[1];
                    if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("add")){
                        int sum = firstNum + secondNum;
                        event.getChannel().sendMessage(firstNum + "+" + secondNum + "=" + sum +"!").queue();
                    }
                    if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("subtract")){
                        int result = secondNum - firstNum;
                        event.getChannel().sendMessage(secondNum + "-" + firstNum + "=" + result).queue();
                    }
                }
                catch (NumberFormatException exception){
                    event.getChannel().sendMessage("One of those is not a number").queue();
                }


            }
            if(messageL>4){
                if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("add")){
                    event.getChannel().sendMessage("I was expecting only two numbers").queue();
                }
                if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("subtract")){
                    event.getChannel().sendMessage("I was expecting only two numbers").queue();
                }

            }
        }






    }

}
