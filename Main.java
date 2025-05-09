import java.util.Scanner;

class Funcionario {
    private int id;
    private String nome;
    private String idade;
    private String cargo;
    private String turno;

    public Funcionario(int id, String nome, String idade, String cargo, String turno) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.turno = turno;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getIdade() { return idade; }
    public String getCargo() { return cargo; }
    public String getTurno() { return turno; }

    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(String idade) { this.idade = idade; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setTurno(String turno) { this.turno = turno; }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nIdade: " + idade + "\nCargo: " + cargo + "\nTurno: " + turno + "\n";
    }
}

class Vetor {
    private Funcionario[] funcionarios;
    private int contador;

    public Vetor(int tamanho) {
        funcionarios = new Funcionario[tamanho];
        contador = 0;
    }

    public void adicionarFuncionario(String nome, String idade, String cargo, String turno) {
        if (contador < funcionarios.length) {
            funcionarios[contador] = new Funcionario(contador, nome, idade, cargo, turno);
            System.out.println("Registro feito com sucesso!");
            contador++;
        } else {
            System.out.println("Erro: Limite atingido!");
        }
    }

    public void listarFuncionarios() {
        for (int i = 0; i < contador; i++) {
            if (funcionarios[i] != null) {
                System.out.println(funcionarios[i]);
            }
        }
    }

    public void atualizarFuncionario(int id, String nome, String idade, String cargo, String turno) {
        if (id >= 0 && id < contador && funcionarios[id] != null) {
            funcionarios[id].setNome(nome);
            funcionarios[id].setIdade(idade);
            funcionarios[id].setCargo(cargo);
            funcionarios[id].setTurno(turno);
            System.out.println("Informações Atualizadas!");
        } else {
            System.out.println("ID não existe");
        }
    }

    public void deletarFuncionario(int id) {
        if (id >= 0 && id < contador && funcionarios[id] != null) {
            funcionarios[id] = null;
            System.out.println("Informações Deletadas com Sucesso!");
        } else {
            System.out.println("ID não existe");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vetor vetor = new Vetor(100);
        int opcao;

        do {
            System.out.println("\n-------------------------------------------------");
            System.out.println("*        DIGITE O NUMERO DA OPERACAO REALIZADA    *");
            System.out.println("---------------------------------------------------");
            System.out.println("*        1- Registrar                             *");
            System.out.println("*        2- Listar                                *");
            System.out.println("*        3- Atualizar                             *");
            System.out.println("*        4- Deletar                               *");
            System.out.println("*        5- Sair                                  *");
            System.out.println("---------------------------------------------------");
            System.out.print("--> ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("*       Registro       *");
                    System.out.print("\n Nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Idade: ");
                    String idade = scan.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scan.nextLine();
                    System.out.print("Turno: ");
                    String turno = scan.nextLine();
                    vetor.adicionarFuncionario(nome, idade, cargo, turno);
                    break;
                case 2:
                    System.out.println("\n*       Lista          *\n");
                    vetor.listarFuncionarios();
                    System.out.println("-------------------------------------------");
                    break;
                case 3:
                    System.out.print("Informe o ID a ser atualizado: ");
                    int idAtualizar = scan.nextInt();
                    scan.nextLine();
                    System.out.print("\n Nome: ");
                    String novoNome = scan.nextLine();
                    System.out.print("Idade: ");
                    String novaIdade = scan.nextLine();
                    System.out.print("Cargo: ");
                    String novoCargo = scan.nextLine();
                    System.out.print("Turno: ");
                    String novoTurno = scan.nextLine();
                    vetor.atualizarFuncionario(idAtualizar, novoNome, novaIdade, novoCargo, novoTurno);
                    break;
                case 4:
                    System.out.print("Tem certeza que deseja deletar um registro? [s - n]: ");
                    char certeza = scan.next().charAt(0);
                    if (certeza == 's' || certeza == 'S') {
                        System.out.print("Informe o ID a ser deletado: ");
                        int idDeletar = scan.nextInt();
                        scan.nextLine();
                        vetor.deletarFuncionario(idDeletar);
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite um número de 1-5");
            }
        } while (opcao < 5);

        scan.close();
    }
}
