package tests.individuos;

import dominio.arquivos.Formulario;
import dominio.individuos.GerenciadorDePessoas;
import dominio.individuos.Pessoa;
import servicos.ColetaDeDados;

import java.io.File;

public class PessoasTest {
    public static void main(String[] args) {
        File form = new File(Formulario.CAMINHO_FORMULARIO_AUXILIAR);
        Formulario.lerFormulario();
        System.out.println();
        GerenciadorDePessoas.cadastrarPessoa(ColetaDeDados.coletarNome(), ColetaDeDados.coletarEmail(),ColetaDeDados.coletarIdade(), ColetaDeDados.coletarAltura());
        System.out.println("---------------------------------------");
        System.out.println();
        GerenciadorDePessoas.cadastrarPessoa(ColetaDeDados.coletarNome(), ColetaDeDados.coletarEmail(),ColetaDeDados.coletarIdade(), ColetaDeDados.coletarAltura());
    }
}
