import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GerenciarPessoa {
    private Set<Pessoa> pessoas;
    private final String fileName = "pessoas.dat";

    public GerenciarPessoa() {
        pessoas = loadPessoas();
    }

    public void salvarPessoa(Pessoa pessoa) {
        if (pessoas.add(pessoa)) {
            savePessoas();
            System.out.println("Pessoa salva com sucesso.");
        } else {
            System.out.println("Uma pessoa com esse e-mail já existe.");
        }
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa p : pessoas) {
                System.out.println(p);
            }
        }
    }

    public void deletarPessoa(String email) {
        Pessoa pessoaParaDeletar = null;
        for (Pessoa p : pessoas) {
            if (p.getEmail().equals(email)) {
                pessoaParaDeletar = p;
                break;
            }
        }

        if (pessoaParaDeletar != null) {
            pessoas.remove(pessoaParaDeletar);
            savePessoas();
            System.out.println("Pessoa deletada com sucesso.");
        } else {
            System.out.println("Pessoa com e-mail " + email + " não encontrada.");
        }
    }

    private void savePessoas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(pessoas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Set<Pessoa> loadPessoas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Set<Pessoa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashSet<>();
        }
    }
}
    