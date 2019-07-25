class incremento{
    public static void main(String[] args){
        int x = 5, y;
        System.out.println(x);
        y = ++x; //incrementa e atribui a y
        System.out.println(y);
        y = x++; //atribui a y e depois incrementa
        System.out.println(y);
        y = --x;
        System.out.println(y);
        y = x--;
        y = --x;
        System.out.println(y);
    }
}