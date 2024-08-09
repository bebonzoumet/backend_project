public class Varaveis{
    public static void main (String[] args){
        short idade = 16;
        int idade2 = 100;
        int totalIdade = idade + idade2;
        System.out.println(totalIdade);

        long idade3 = 1000;
        int idade4 = 50;
        long totalIdade2 = idade3 + idade4;
        System.out.println(totalIdade2);

        float pi = 3.14f;
        double pi2 = 3.141516;

        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.somar(totalIdade, idade2));
    }
}