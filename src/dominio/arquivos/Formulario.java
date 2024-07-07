package dominio.arquivos;

import java.io.*;

public class Formulario {
    public static final String CAMINHO_FORMULARIO_ORIGINAL = "C:\\Users\\rafsf\\Desktop\\'\\Programaçao\\Projetos\\SistemaCadastros\\assets\\forms\\formulario_original.txt";
    public static final String CAMINHO_FORMULARIO_AUXILIAR = "C:\\Users\\rafsf\\Desktop\\'\\Programaçao\\Projetos\\SistemaCadastros\\assets\\forms\\formulario_auxiliar.txt";
    public static String[] novasPerguntas = new String[50];
    public static int qtdPerguntasFormulario = 4;

    public static void lerFormulario() {
        File arquivo = new File(CAMINHO_FORMULARIO_AUXILIAR);
        try (FileReader fr = new FileReader(arquivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reescreveFormulario(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_FORMULARIO_AUXILIAR));
             BufferedReader br = new BufferedReader((new FileReader(CAMINHO_FORMULARIO_ORIGINAL)))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                bw.write(linha);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void adicionarPergunta(String pergunta) {
        qtdPerguntasFormulario += 1;
        novasPerguntas[qtdPerguntasFormulario - 5] = pergunta;
        File formOriginal = new File(CAMINHO_FORMULARIO_ORIGINAL);
        File formAuxiliar = new File(CAMINHO_FORMULARIO_AUXILIAR);
        reescreveFormulario();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(formAuxiliar, true))) {

            int indice = 5;
            for (String perg : novasPerguntas) {
                if (perg != null){
                    bw.write(indice+" - "+perg);
                    bw.newLine();
                    indice++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deletaPergunta(int index){
        if (index < 5){
            System.out.println("Não é possivel apagar nenhuma das 4 primeiras perguntas");
            return;
        } else if (index > qtdPerguntasFormulario) {
            System.out.println("Não existe essa pergunta no formulário");
        }
        novasPerguntas[index - 5] = null;
        reescreveFormulario();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_FORMULARIO_AUXILIAR, true))){

            int indice = 5;
            for(String novaPergunta : novasPerguntas){
                if (novaPergunta != null){
                    bw.write(indice+" - "+novaPergunta);
                    bw.newLine();
                    indice++;
                }
            }
            qtdPerguntasFormulario--;

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
