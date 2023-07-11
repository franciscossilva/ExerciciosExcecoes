import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int exibir() {
        System.out.println("----- Menu -----");
        System.out.println("1. Incluir Verdura");
        System.out.println("2. Incluir Legume");
        System.out.println("3. Incluir Grão");
        System.out.println("4. Incluir Outro");
        System.out.println("5. Encerrar");

        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public double lerQuantidade(String tipo) {
        System.out.print("Informe a quantidade em " + getUnidadeMedida(tipo) + ": ");
        return scanner.nextDouble();
    }

    public String lerNomeAlimento() {
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.print("Informe o nome do alimento: ");
        return scanner.nextLine();
    }

    private String getUnidadeMedida(String tipo) {
        switch (tipo) {
            case "VERDURA":
            case "GRÃO":
                return "gramas";
            case "LEGUME":
            case "OUTRO":
                return "unidades";
            default:
                throw new IllegalArgumentException("Tipo de alimento inválido");
        }
    }
}