package servicos;

import dominio.individuos.GerenciadorDePessoas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ColetaDeDados {
    private int qtdDePessoasCadastradas = GerenciadorDePessoas.getNumeroPessoasCadastradas();
    private static Scanner entrada = new Scanner(System.in);

    public static void coletarDados() {
        String nome = coletarNome();
        String email = coletarEmail();
        int idade = coletarIdade();
        String altura = coletarAltura();
    }

    public static String coletarNome() {
        System.out.println();
        String nome = entrada.nextLine();
        if (nome.length() > 10) {
            return nome;
        } else {
            System.out.println("Nome do usuario precisa ter no mínimo 10 caracteres");
            throw new IllegalArgumentException();
        }
    }

    public static int coletarIdade() {
        System.out.println();
        int idade = entrada.nextInt();
        if (idade > 18) {
            entrada.nextLine();
            return idade;
        } else {
            System.out.println("O usuario precisa ter mais de 18 anos");
            throw new IllegalArgumentException();
        }
    }

    public static String coletarEmail() {
        System.out.println();
        String email = entrada.nextLine();
        File file = new File("C:\\Users\\rafsf\\Desktop\\'\\Programaçao\\Projetos\\SistemaCadastros\\assets\\dados\\usuarios_emails\\emails_usuarios.txt");
        if (email.contains("@")) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String emailArquivo;
                while ((emailArquivo = br.readLine()) != null){
                    if(email.equals(emailArquivo)){
                        throw new IOException("Email ja existente na base de dados");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        return email;

        } else {
            System.out.println("Email invalido");
            throw new IllegalArgumentException();
        }
    }

    public static String coletarAltura() {
        System.out.println();
        String altura = entrada.nextLine();
        if (altura.contains(",")) {
            return altura;
        } else {
            System.out.println("Formato da Altura invalido");
            throw new IllegalArgumentException();
        }
    }
}
