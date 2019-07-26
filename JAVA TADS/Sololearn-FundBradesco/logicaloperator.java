class ifelse{
    public static void main(String[] args){
        int age = 25, money = 300; 
        
        //Condicional And(&&) só é true quando ambos true
        if (age > 18 && money > 500) {
            System.out.println("Welcome!");
         }
        else{
            System.out.println("Not welcome!");
        }
        //Condicional Or(||) só é true se pelo menos 1 das condições for true
        if (age > 18 || money > 500) {
            System.out.println("Welcome!");
         }
        else{
            System.out.println("Not welcome!");
        }

    }
}