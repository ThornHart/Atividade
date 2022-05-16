public class Act2 {

    private static Scanner input = new Scanner(System.in);
    private static int numPessoas;
    

    private static void takeNPeople() throws InputMismatchException, NullPointerException {

        for (int x = 0; x < 1; x++) {
            try {
                System.out.println("Digite a quantidade de pessoas que serão registradas: ");
                numPessoas = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este valor deve ser um número inteiro.");
                x -= 1;
            }
            input.nextLine();
        }
    }

    private static void takeName(int i, Pessoa[] pessoas) throws InputMismatchException {
        System.out.println("Digite o nome da Pessoa " + (i + 1));
        pessoas[i].setNome(input.nextLine());
    }

    private static void takeAge(int i, Pessoa[] pessoas) throws InputMismatchException {
        System.out.println("Digite a idade da pessoa " + (i + 1));
        pessoas[i].setIdade(input.nextInt());
    }

    private static void takeCpf(int i, Pessoa[] pessoas) throws InputMismatchException {
        System.out.println("Digite o Cpf da pessoa " + (i + 1));
        pessoas[i].setCpf(input.nextInt());
    }

    private static void readP(int i, Pessoa[] pessoas) {
        takeName(i, pessoas);
        takeAge(i, pessoas);
        takeCpf(i, pessoas);
    }

    private static void showP(int i, Pessoa[] pessoas) {
        System.out.println("Nome da pessoa " + (i + 1) + " : " + pessoas[i].getNome());
        System.out.println("Idade da pessoa " + (i + 1) + " : " + pessoas[i].getIdade());
        System.out.println("CPF da pessoa " + (i + 1) + " : " + pessoas[i].getCpf());

    }

    public static void main(String args[]) {
        takeNPeople();
        Pessoa[] people = new Pessoa[numPessoas];

        for (int i = 0; i < numPessoas; i++) {
            people[i] = new Pessoa();
            try {
                readP(i, people);

            } catch (InputMismatchException e) {
                System.out.println("Insira os dados corretamente!");
                i -= 1;
            }
            input.nextLine();
        }
        for (int i = 0; i < numPessoas; i++) {
            showP(i, people);
        }
    }
}
