import java.util.Scanner;
public class Exerciciodonpad {
    public static void main(String[] args) {
        Integer[] numeros = new Integer[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite um número: ");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Os números digitados foram: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(numeros[i]);
        }

        System.out.println("A soma dos números digitados é: " + soma_array(numeros));
        System.out.println("O maior número digitado é: " + maior_numero(numeros));
        System.out.println("O menor número digitado é: " + menor_numero(numeros));
        System.out.println("Os números digitados invertidos são: ");
        Integer[] invertido = invert_array(numeros);
        for (int i = 0; i < 5; i++) {
            System.out.println(invertido[i]);
        }
        System.out.println("A média dos números digitados é: " + media_array(numeros));
        System.out.println("A quantidade de números pares digitados é: " + contar_pares(numeros));
        System.out.println("A quantidade de números ímpares digitados é: " + contar_impares(numeros));
        System.out.println("Digite um número para verificar se está no array: ");
        int numero = sc.nextInt();
        if (esta_no_array(numeros, numero) == 1) {
            System.out.println("O número " + numero + " está no array.");
        } else {
            System.out.println("O número " + numero + " não está no array.");
        }
        System.out.println("Os números digitados ordenados são: ");
        Integer[] ordenado = bubble_sort(numeros);
        for (int i = 0; i < 5; i++) {
            System.out.println(ordenado[i]);
        }
        Integer[] numeros2 = new Integer[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite um número para o segundo array: ");
            numeros2[i] = sc.nextInt();
        }
        System.out.println("Os números do segundo array são: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(numeros2[i]);
        }
        System.out.println("Os dois arrays concatenados são: ");
        Integer[] concatenado = concatena_arrays(numeros, numeros2);
        for (int i = 0; i < 10; i++) {
            System.out.println(concatenado[i]);
        }
        System.out.println("Digite um número para remover do array: ");
        int valor = sc.nextInt();
        Integer[] novo = remove_valor_array(numeros, valor);
        System.out.println("O array sem o valor " + valor + " é: ");
        for (int i = 0; i < 4; i++) {
            System.out.println(novo[i]);
        }
        sc.close();
    }
    public static int soma_array(Integer[] numeros) {
        int soma = 0;
        for (int i = 0; i < 5; i++) {
            soma += numeros[i];
        }
        return soma;
    }
    public static int maior_numero(Integer[] numeros) {
        int maior = -2147483648;
        for (int i = 0; i < 5; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }
        return maior;
    }
    public static int menor_numero(Integer[] numeros) {
        int menor = +2147483647;
        for (int i = 0; i < 5; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        return menor;
    }
    public static Integer[] invert_array(Integer[] numeros) {
        Integer[] invertido = new Integer[5];
        for (int i = 0; i < 5; i++) {
            invertido[i] = numeros[4 - i];
        }
        return invertido;
    }
    public static int media_array(Integer[] numeros) {
        int media = 0;
        for (int i = 0; i < 5; i++) {
            media += numeros[i];
        }
        return media / 5;
    }
    public static int contar_pares(Integer[] numeros) {
        int pares = 0;
        for (int i = 0; i < 5; i++) {
            if (numeros[i] % 2 == 0) {
                pares++;
            }
        }
        return pares;
    }
    public static int contar_impares(Integer[] numeros) {
        int impares = 0;
        for (int i = 0; i < 5; i++) {
            if (numeros[i] % 2 != 0) {
                impares++;
            }
        }
        return impares;
    }
    public static int esta_no_array(Integer[] numeros, int numero) {
        for (int i = 0; i < 5; i++) {
            if (numeros[i] == numero) {
                return 1;
            }
        }
        return 0;
    }
    public static Integer[] bubble_sort(Integer[] numeros) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
        return numeros;
    }
    public static Integer[] concatena_arrays(Integer[] numeros1, Integer[] numeros2) {
        Integer[] concatenado = new Integer[10];
        for (int i = 0; i < 5; i++) {
            concatenado[i] = numeros1[i];
        }
        for (int i = 0; i < 5; i++) {
            concatenado[i + 5] = numeros2[i];
        }
        return concatenado;
    }
    public static Integer[] remove_valor_array(Integer[] numeros, int valor) {
        Integer[] novo = new Integer[4];
        for (int i = 0; i < 4; i++) {
            if (numeros[i] == valor) {
                System.out.println("");
            }
            else {
                novo[i] = numeros[i];
            }
        }
        return novo;
    }
}
