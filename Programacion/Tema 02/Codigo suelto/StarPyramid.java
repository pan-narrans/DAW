import java.util.Scanner;

class StarPyramid{

  Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args){
    StarPyramid program = new StarPyramid();    
    program.Start();
  }

  public void Start(){
    String star = " *";
    String pyramid = "";
    int num;
    
    System.out.println("Enter the number of levels you want your star pyramid to have:");
    num = keyboard.nextInt();

    for(int i=0; i<num; i++){
      pyramid += star;
      System.out.println(pyramid);
    }

  }
}