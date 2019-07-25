import java.util.Scanner;
class userInput{
    public static void main(String[] args){
        Scanner name = new Scanner(System.in);
        System.out.println("Digite o seu nome: ");
        System.out.println(name.nextLine());
    }
}