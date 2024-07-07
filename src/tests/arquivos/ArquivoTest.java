package tests.arquivos;

import dominio.arquivos.Formulario;

import java.io.File;

public class ArquivoTest {
    public static void main(String[] args) {
        File form = new File(Formulario.CAMINHO_FORMULARIO_AUXILIAR);
        Formulario.adicionarPergunta("Qual é o seu hobbie preferido?");
        Formulario.adicionarPergunta("Qual é o seu jogo preferido?");
        System.out.println(Formulario.qtdPerguntasFormulario);
        Formulario.deletaPergunta(6);
        System.out.println(Formulario.qtdPerguntasFormulario);
        Formulario.deletaPergunta(4);
        Formulario.deletaPergunta(6);
        Formulario.deletaPergunta(5);



    }
}
