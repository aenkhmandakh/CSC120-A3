// You should **not** update any call signatures in this file
// only modify the body of each function

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


class Conversation implements ConversationRequirements {

  // Attributes 
 private int numberOfRounds;
 private Random random;
 private String[] cannedResponses;
 private ArrayList<String> transcriptNotes;


  /**
   * Constructor 
   */
  Conversation() {
    this.numberOfRounds=0;
    this.random=new Random();
    this.cannedResponses= new String[]{
      "Oh Wow...",
      "Interesting!",
      "That's crazy!",
      "Right, right..."
    };
    this.transcriptNotes= new ArrayList<>();
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner(System.in);

    System.out.println("Hello! I am your chatbot. How many rounds would you like to speak with me?");
    this.numberOfRounds = input.nextInt();
    input.nextLine();
    System.out.println("Great, let's start!");

    for(int i=0; i<this.numberOfRounds; i++){
    String userInput=input.nextLine();
    String response = respond(userInput);
    System.out.println(response);
    transcriptNotes.add("You:"+userInput);
    transcriptNotes.add("Me:"+response);
    }
    input.close();

  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("\n---------Transcript--------");
    for (String string : transcriptNotes) {
      System.out.println(string);
    }
    System.out.println("---------Transcript--------\n");

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    if (inputString.contains("You are")){
      returnString= inputString.replaceAll("You are", "I am");
    }else if(inputString.contains("You're")){
      returnString= inputString.replaceAll("You're", "I'm");
    }else if(inputString.contains("Your")){
      returnString= inputString.replaceAll("Your", "My");
    }else if(inputString.contains("Yours")){
      returnString= inputString.replaceAll("Yours", "Mine");
    }else if(inputString.contains("I am")){
      returnString= inputString.replaceAll("I am", "You are");
    }else if(inputString.contains("I'm")){
      returnString= inputString.replaceAll("I'm", "You're");
    }else if(inputString.contains("I")){
      returnString= inputString.replaceAll("I", "You");
    }else if(inputString.contains("My")){
      returnString= inputString.replaceAll("My", "Your");
    } else if(inputString.contains("Mine")){
      returnString= inputString.replaceAll("Mine", "Yours");
    }else{
      int randomIndex= random.nextInt(cannedResponses.length);

      returnString=cannedResponses[randomIndex];
    }
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
