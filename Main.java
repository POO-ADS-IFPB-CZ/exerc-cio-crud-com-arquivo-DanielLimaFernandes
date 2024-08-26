import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciarPessoa manager = new GerenciarPessoa();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Salvar uma pessoa");
            System.out.println("2. Listar todas as pessoas");
            System.out.println("3. Deletar uma pessoa pelo e-mail");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o e-mail: ");
                    String email = scanner.nextLine();
                    manager.salvarPessoa(new Pessoa(nome, email));
                    break;
                case 2:
                    manager.listarPessoas();
                    break;
                case 3:
                    System.out.print("Digite o e-mail da pessoa a ser deletada: ");
                    String emailParaDeletar = scanner.nextLine();
                    manager.deletarPessoa(emailParaDeletar);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

