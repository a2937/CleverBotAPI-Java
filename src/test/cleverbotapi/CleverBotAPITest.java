import cleverbotapi.CleverBotQuery;

import java.io.IOException;
import java.util.Scanner;

public class CleverBotAPITest
{
    public static void main(String[] args)
    {
        Scanner keyboard;
        CleverBotQuery botQuery;
        String input;
        boolean done;

        keyboard = keyboard = new Scanner(System.in);

        do
        {
            System.out.print("Enter your message: ");
            input = keyboard.nextLine();
            done = input.equals("done");

            if (!done)
            {
                botQuery = new CleverBotQuery("APIKEY", input);
                try
                {
                    botQuery.sendRequest();
                    System.out.println("BOT: " + botQuery.getResponse());
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        } while(!done);

    }
}
