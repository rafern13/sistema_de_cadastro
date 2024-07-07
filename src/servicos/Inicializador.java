package servicos;

import dominio.arquivos.Formulario;
import dominio.individuos.GerenciadorDePessoas;

import java.io.*;
import java.util.Scanner;

public class Inicializador {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int in;
        while (true) {
            System.out.println("1 - Cadastrar o Usuario" +
                    "\n2 - Listar todos usuários cadastrados" +
                    "\n3 - Cadastrar nova pergunta no formulário" +
                    "\n4 - Deletar pergunta do formulário" +
                    "\n5 - Pesquisar usuário por nome ou idade ou email");

            in = entrada.nextInt();
            entrada.nextLine();
            switch (in) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarTodosUsuariosCadastrados();
                    break;
                case 3:
                    String pergunta = entrada.nextLine();
                    cadastrarNovaPerguntaFormulario(pergunta);
                    break;
                case 4:
                    Formulario.lerFormulario();
                    System.out.println();
                    int indice = entrada.nextInt();
                    deletarPerguntaFormulario(indice);
                    entrada.nextLine();
                    break;
                case 5:
                    filtrarUsuario();
                    break;
            }
        }
    }

    public static void cadastrarUsuario() {
        Formulario.lerFormulario();
        GerenciadorDePessoas.cadastrarPessoa(ColetaDeDados.coletarNome(), ColetaDeDados.coletarEmail(), ColetaDeDados.coletarIdade(), ColetaDeDados.coletarAltura());
        pularMtsLinhas();
    }

    public static void listarTodosUsuariosCadastrados() {
        File usuarios = new File("C:\\Users\\rafsf\\Desktop\\'\\Programaçao\\Projetos\\SistemaCadastros\\assets\\dados\\usuarios_nomes\\nomes_usuarios.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(usuarios))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Não foi possivel listar os usuarios"+e.getMessage());
        }
        System.out.println();
    }

    public static void cadastrarNovaPerguntaFormulario(String pergunta) {
        Formulario.adicionarPergunta(pergunta);
        System.out.println("Pergunta adicionada com sucesso\n");

    }

    public static void deletarPerguntaFormulario(int indice) {
        Formulario.deletaPergunta(indice);
        System.out.println("\n");
    }

    public static void filtrarUsuario() {

    }

    public static void pularMtsLinhas() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}


