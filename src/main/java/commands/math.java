package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class math extends ListenerAdapter {
    String prefix = "#";


    public void onGuildMessageReceived(GuildMessageReceivedEvent event){


        if(!event.getMember().getUser().isBot()){
            String messageRaw = event.getMessage().getContentRaw();
            System.out.println("Raw message= " + messageRaw);
            String[] message = event.getMessage().getContentRaw().split(" ");
            char[] messageW = messageRaw.toCharArray();
            int messageL = message.length;
            for(int i=0; i<messageL; i++){
                System.out.println("MessageArray at " + i + " = " + message[i]);
            }
            int[] arr;
            arr = new int[2];

            String charZero = String.valueOf(messageW[0]);
            System.out.println("First character= " + charZero);

            if (charZero.equalsIgnoreCase(prefix)){
                if(messageL == 1){
                    if(message[0].equalsIgnoreCase(("#calculate"))){
                        event.getChannel().sendMessage("This is the calculate command type (#calculate help) for more.").queue();
                        System.out.println("Bot Response= " + "This is the calculate command type (#calculate help) for more.");
                    }
                }
                if(messageL == 2){
                    if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("help")){
                        event.getChannel().sendMessage("Use (#calculate add x y) to add two numbers. Use (#calculate subtract x y) to subtract x from y.").queue();
                        System.out.println("Bot Response= " + "Use (#calculate add x y) to add two numbers. Use (#calculate subtract x y) to subtract x from y.");
                    }
                    if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("add")){
                        event.getChannel().sendMessage("Use this to add two numbers").queue();
                        System.out.println("Bot Response= " + "Use this to add two numbers");
                    }
                    if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("subtract")){
                        event.getChannel().sendMessage("Use this to subtract one number from another").queue();
                        System.out.println("Bot Response= " + "Use this to subtract one number from another");
                    }
                }
                if(messageL == 3){
                    event.getChannel().sendMessage("I need two numbers").queue();
                    System.out.println("Bot Response= " + "I need two numbers");
                }
                if(messageL == 4){
                    try{
                        arr = new int[]{Integer.parseInt(message[2]), Integer.parseInt(message[3])};
                        int firstNum = arr[0];
                        int secondNum = arr[1];
                        if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("add")){
                            int sum = firstNum + secondNum;
                            event.getChannel().sendMessage(firstNum + "+" + secondNum + "=" + sum +"!").queue();
                            System.out.println("Bot Response= " + firstNum + "+" + secondNum + "=" + sum +"!");
                        }
                        if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("subtract")){
                            int result = secondNum - firstNum;
                            event.getChannel().sendMessage(secondNum + "-" + firstNum + "=" + result).queue();
                            System.out.println("Bot Response= " + secondNum + "-" + firstNum + "=" + result);
                        }
                    }
                    catch (NumberFormatException exception){
                        event.getChannel().sendMessage("One of those is not a number").queue();
                        System.out.println("Bot Response= " + "One of those is not a number");
                    }


                }
                if(messageL>4){
                    if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("add")){
                        event.getChannel().sendMessage("I was expecting only two numbers").queue();
                        System.out.println("Bot Response= " + "I was expecting only two numbers");
                    }
                    if(message[0].equalsIgnoreCase("#calculate") && message[1].equalsIgnoreCase("subtract")){
                        event.getChannel().sendMessage("I was expecting only two numbers").queue();
                        System.out.println("Bot Response= " + "I was expecting only two numbers");
                    }

                }
            }



        }






    }

}
