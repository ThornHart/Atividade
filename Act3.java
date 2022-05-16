import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Act3 {
    private static Scanner input = new Scanner(System.in);
    private static int numPessoas;
    private static LinkedHashSet<Pessoa> people = new LinkedHashSet<Pessoa>();

    private static void recebeNPessoas() throws InputMismatchException, NullPointerException {

        for (int x = 0; x < 1; x++) {
            try {
                System.out.println("DIGITE A QUANTIDADE DE PESSOAS A SEREM REGISTRADAS: ");
                numPessoas = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este valor deve ser um inteiro!");
                x -= 1;
            }
            input.nextLine();
        }
    }

    private static void takePeople(int i, Pessoa pessoa) {
        takeCpf(i, takeAge(i, takeName(i, pessoa)));
    }

    private static Pessoa takeName(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println("Digite o nome da pessoa " + (i + 1));
        pessoa.setNome(input.nextLine());
        return pessoa;
    }

    private static Pessoa takeAge(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println("Digite a idade da pessoa " + (i + 1));
        pessoa.setIdade(input.nextInt());
        return pessoa;
    }

    private static Pessoa takeCpf(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println("Digite o CPF da pessoa " + (i + 1));
        pessoa.setCpf(input.nextInt());
        return pessoa;
    }

    private static boolean verifyCpf(Pessoa pessoa) {
        boolean cpfContain = true;

        Iterator<Pessoa> pessoasAsIterator = people.iterator();
        if (people.size() == 0) {
            cpfContain = false;
        } else {
            while (pessoasAsIterator.hasNext()) {
                Pessoa p = pessoasAsIterator.next();
                if (p.getCpf() == pessoa.getCpf()) {
                    cpfContain = true;
                } else {
                    cpfContain = false;
                }
            }
        }
        return cpfContain;
    }

    private static void showP(LinkedHashSet<Pessoa> pessoas) {
        Iterator<Pessoa> pessoasAsIterator = pessoas.iterator();
        while (pessoasAsIterator.hasNext()) {
            Pessoa p = pessoasAsIterator.next();
            System.out.println("Nome: " + p.getNome());
            System.out.println("Idade: " + p.getIdade());
            System.out.println("Cpf: " + p.getCpf());
        }
    }

    public static void main(String args[]) {
        recebeNPessoas();
        for (int i = 0; i < numPessoas; i++) {
            Pessoa pessoa = new Pessoa();
            try {
                takePeople(i, pessoa);
                if (verifyCpf(pessoa)) {
                    System.out.println("Este CPF já está cadastrado");
                    System.out.println("Tente novamente");
                    i -= 1;
                } else {
                    people.add(pessoa);
                }
            } catch (InputMismatchException e) {
                System.out.println("Os campos em questão têm tipos específicos, por favor preencha de acordo!");
                i -= 1;
            }
            input.nextLine();
        }
        showP(people);
    }
}
