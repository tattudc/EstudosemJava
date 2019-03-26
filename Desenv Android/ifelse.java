public class HelloWorld
{
    public static void main(String[] args) {
		int idade = 15;
		if(idade >= 18){
			System.out.println("Adulto");			
		}
		else if(idade < 18 && idade >= 10){
		    System.out.println("Adolescente");
		}
		else{
			System.out.println("Crianca");
    }
}
}