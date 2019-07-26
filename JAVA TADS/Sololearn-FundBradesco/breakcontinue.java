class ifelse{
    public static void main(String[] args){
        for(int x = 10; x > 0; x--) {
           if(x == 8){
               continue;
           }
           else if(x == 5){
               break;
           }
           System.out.println(x);
          
        }
    }
}