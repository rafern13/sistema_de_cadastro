package dominio.individuos;

import java.io.*;

public class GerenciadorDePessoas {
    private static int numeroPessoasCadastradas;
    private static Pessoa[] pessoas = new Pessoa[100];
    private static String[] emails = new String[100];

    static{
        File filequantia = new File("C:\\Users\\rafsf\\Desktop\\'\\Programaçao\\Projetos\\SistemaCadastros\\assets\\dados\\usuarios_respostas");
        File[] lista = filequantia.listFiles();
        GerenciadorDePessoas.numeroPessoasCadastradas = 0;
        for (File file : lista){
            if(file.isFile()){
                GerenciadorDePessoas.numeroPessoasCadastradas++;

            }
        }
    }


    public static void filtrarDadosNome(String substring){
        for (Pessoa pessoa : pessoas){
            if (pessoa != null){
                String nome = pessoa.getNome();
                if (nome.startsWith(substring)){
                    System.out.println(nome);
                }
            }
        }
    }

    public static void filtrarDadosEmail(String substring){
        for (Pessoa pessoa : pessoas){
            if (pessoa != null){
                String email = pessoa.getEmail();
                if (email.startsWith(substring)){
                    System.out.println(email);
                }
            }
        }
    }

    public static void filtrarDadosIdade(int valor){
        for (Pessoa pessoa : pessoas){
            if (pessoa != null){
                int idade = pessoa.getIdade();
                if (idade == valor){
                    System.out.println(idade);
                }
            }
        }
    }


    private static void salvarNomes(){
        String caminhoNomesUsuarios = "C:\\Users\\rafsf\\Desktop\\'\\Programaçao\\Projetos\\SistemaCadastros\\assets\\dados\\usuarios_nomes\\nomes_usuarios.txt";
        File nomesUsuarios = new File(caminhoNomesUsuarios);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomesUsuarios, true))){

            int indice = numeroPessoasCadastradas;
            bw.write((indice)+" - "+pessoas[indice-1].getNome());
            bw.newLine();


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void salvarEmails(){
        String caminhoEmailsUsuarios = "C:\\Users\\rafsf\\Desktop\\'\\Programaçao\\Projetos\\SistemaCadastros\\assets\\dados\\usuarios_emails\\emails_usuarios.txt";
        File emailsUsuarios = new File(caminhoEmailsUsuarios);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(emailsUsuarios, true))){

            int indice = numeroPessoasCadastradas;
            bw.write(pessoas[indice-1].getEmail());
            bw.newLine();


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static int getNumeroPessoasCadastradas() {
        return numeroPessoasCadastradas;
    }

    public static void cadastrarPessoa(String nome, String email, int idade, String altura) {
        Pessoa usuario = new Pessoa(nome, email, idade, altura);
        pessoas[numeroPessoasCadastradas] = usuario;
        String caminhoArquivoUsuario = "C:\\Users\\rafsf\\Desktop\\'\\Programaçao\\Projetos\\SistemaCadastros\\assets\\dados\\usuarios_respostas\\" + ((numeroPessoasCadastradas+1)+"-"+nome.replace(" ", "").toUpperCase()) + ".txt";
        File arquivoUsuario = new File(caminhoArquivoUsuario);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoUsuario))) {
            int indice = 1;
            while (true) {
                bw.write(indice + " - " + usuario.getNome());
                bw.newLine();
                indice++;
                bw.write(indice + " - " + usuario.getEmail());
                bw.newLine();
                indice++;
                bw.write(indice + " - " + usuario.getIdade());
                bw.newLine();
                indice++;
                bw.write(indice + " - " + usuario.getAltura());
                bw.newLine();
                break;
            }
            numeroPessoasCadastradas++;
            salvarNomes();
            salvarEmails();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Pessoa[] getPessoas() {
        return pessoas;
    }
}