import java.util.InputMismatchException;
import java.util.Scanner;

public class Act1 {
  private static Pessoa[] people = new Pessoa[3];
  private static Scanner input = new Scanner(System.in);

  private static void takeName(int i, Pessoa[] pessoas) throws InputMismatchException {
    System.out.println("Digite o Nome da Pesssoa " + (i + 1));
    pessoas[i].setNome(input.nextLine());
  }

  private static void takeAge(int i, Pessoa[] pessoas) throws InputMismatchException {
    System.out.println("Digite a Idade Da Pessoa " + (i + 1));
    pessoas[i].setIdade(input.nextInt());
  }

  private static void takeCpf(int i, Pessoa[] pessoas) throws InputMismatchException {
    System.out.println("DIGITE O CPF DA PESSOA " + (i + 1));
    pessoas[i].setCpf(input.nextInt());
  }

  private static void lerPessoa(int i, Pessoa[] pessoas) {
    takeName(i, pessoas);
    takeAge(i, pessoas);
    takeCpf(i, pessoas);
  }

  private static void showP(int i) {
    System.out.println("Nome da Pessoa" + (i + 1) + ": " + people[i].getNome());
    System.out.println("Idade da Pessoa" + (i + 1) + ": " + people[i].getIdade());
    System.out.println("CPF da Pessoa" + (i + 1) + ": " + people[i].getCpf());
  }

  public static void main(String args[]) {
    for (int i = 0; i < 3; i++) {
      people[i] = new Pessoa();
      try {
        lerPessoa(i, people);
      } catch (InputMismatchException e) {
        System.out.println("Insira os dados corretamente!");
        i -= 1;
      }
      input.nextLine();
    }
    for (int i = 0; i < 3; i++) {
      showP(i);
    }
  }
}
