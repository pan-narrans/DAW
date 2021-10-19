import java.util.Scanner;

public class kids {
  Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args){
    kids program = new kids();
    program.Start();
  }
  
  public void Start(){
    int numberOfKids;

    System.out.println("How many kids?");      
    numberOfKids = keyboard.nextInt();

    String[][] kids = new String[3][numberOfKids + 1];
    kids[0][0] = "Dni";
    kids[1][0] = "Date of Birth [dd/mm/yyyy]";
    kids[2][0] = "Gender";

    for(int i=1; i<kids[0].length; i++){
      System.out.println("Enter the information of the kid nº" + i + ":");     
      for(int c=0; c<kids.length; c++){
        System.out.println("Enter the kid's " + kids[c][0] + ":");
        kids[c][i] = keyboard.next();
      }
      System.out.println("");   
    }

    PrintKids(kids);

  }

  public void PrintKids(String[][] kids){
    for(int i=1; i<kids[0].length; i++){
      System.out.println("Kid nº" + i + ":");     
      for(int c=0; c<kids.length; c++){
        System.out.println("- " + kids[c][0] + ": " + kids[c][i]);
      }
      System.out.println("");   
    }
  }
  
}
