class arrays{
    public static void main(String[] args){
        int[] numeros = new int[5];
        numeros[0] = 11;
        numeros[1] = 1321;
        numeros[2] = 121;
        numeros[3] = 111;
        numeros[4] = 1;
        for(int x = 0; x < 5; x++){
            System.out.print(numeros[x]+ ", ");
        }
        //Tamanho do array
        System.out.println("\n Comprimento: "+numeros.length);
    }
}