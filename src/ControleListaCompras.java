import Exercicio01.Alimento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControleListaCompras {
    private static List<Alimento> listaCompras = new ArrayList<>();
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        boolean encerrar = false;

        while (!encerrar) {
            int opcao = menu.exibir();

            switch (opcao) {
                case 1:
                    incluirAlimento("VERDURA");
                    break;
                case 2:
                    incluirAlimento("LEGUME");
                    break;
                case 3:
                    incluirAlimento("GRÃO");
                    break;
                case 4:
                    incluirAlimento("OUTRO");
                    break;
                case 5:
                    encerrar = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        }

        exibirListaCompras();
        exibirQuantidadeTiposAlimentos();
    }

    private static void incluirAlimento(String tipo) {
        double quantidade = menu.lerQuantidade(tipo);

        String nome = menu.lerNomeAlimento();

        listaCompras.add(new Alimento(nome, quantidade, tipo));
    }

    private static void exibirListaCompras() {
        System.out.println("Lista de Compras:");

        for (Alimento alimento : listaCompras) {
            System.out.println(alimento.getNome() + " - " + alimento.getQuantidade() + " " + getUnidadeMedida(alimento.getTipo()));
        }

        System.out.println();
    }

    private static void exibirQuantidadeTiposAlimentos() {
        Map<String, Integer> quantidadePorTipo = contarQuantidadePorTipo();

        System.out.println("Quantidade de cada tipo de alimento a ser comprada:");

        for (String tipo : quantidadePorTipo.keySet()) {
            int quantidade = quantidadePorTipo.get(tipo);
            System.out.println(tipo + ": " + quantidade);
        }
    }

    private static Map<String, Integer> contarQuantidadePorTipo() {
        Map<String, Integer> quantidadePorTipo = new HashMap<>();

        for (Alimento alimento : listaCompras) {
            String tipo = alimento.getTipo();
            quantidadePorTipo.put(tipo, quantidadePorTipo.getOrDefault(tipo, 0) + 1);
        }

        return quantidadePorTipo;
    }

    private static String getUnidadeMedida(String tipo) {
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