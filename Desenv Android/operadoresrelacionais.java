public class HelloWorld
{
    public static void main(String[] args) {
		boolean resultado;
		int num1 = 5, num2 = 1;
		//(==) igual
		System.out.println("igualdade");
		resultado = 1 == 1;
		System.out.println(resultado);
		resultado = 1 == 2;
		System.out.println(resultado);
		//(!=) diferente
		System.out.println("");
		System.out.println("diferente");
		resultado = 1 != 1;
		System.out.println(resultado);
		resultado = 1 != 2;
		System.out.println(resultado);
		//(> ou >=) > ou >=
		System.out.println("");
		System.out.println("Maior");
		resultado = 4 > 1;
		System.out.println(resultado);
		resultado = 1 > 2;
		System.out.println(resultado);
		//(< ou <=) < ou <=
		System.out.println("");
		System.out.println("Menor");
		resultado = 4 < 1;
		System.out.println(resultado);
		resultado = 1 < 2;
		System.out.println(resultado);
		//And &&
		System.out.println("");
		System.out.println("Operadores Logicos - And");
		System.out.println(num1 > 0 && num2 > 0);
		System.out.println(num1 > 0 && num2 < 0);
		//or ||
		System.out.println("");
		System.out.println("Operadores Logicos - Or");
		System.out.println(num1 > 0 || num2 > 0);
		System.out.println(num1 > 0 || num2 < 0);
		System.out.println(num1 < 0 || num2 < 0);
    }
}