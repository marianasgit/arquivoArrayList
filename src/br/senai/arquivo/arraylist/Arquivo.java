package br.senai.arquivo.arraylist;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	// Cria e grava os dados no arquivo
	public boolean escrever(String caminho, String conteudo) {

		try {

			FileWriter arquivo = new FileWriter(caminho); // criar o arquivo
			PrintWriter gravarArquivo = new PrintWriter(arquivo); // permitir que o arquivo seja gravado

			gravarArquivo.append(conteudo); // usado para inserir a informacao no final do arquivo
			gravarArquivo.close();

			return true;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());
			return false;

		}
	}

	// Le os dados do arquivo
	public String ler(String caminho) {

		String conteudo = "";

		// recupera os dados do arquivo e armazena em memoria para a manipulacao

		try {

			FileReader arquivo = new FileReader(caminho); // abre o arquivo
			BufferedReader conteudoArquivo = new BufferedReader(arquivo); // armazena o conteudo do arquivo em memoria

			// Recupera os dados do arquivo
			try {
				String linha = "";
				linha = conteudoArquivo.readLine();
				while (linha != null) {

					conteudo += linha + "\n";
					linha = conteudoArquivo.readLine();

				}

				conteudoArquivo.close();
				return conteudo;

			} catch (IOException e) { // Trata o BufferedReader
				System.out.println("ERRO: " + e.getMessage());
				return "";
			}

		} catch (FileNotFoundException e) {

			System.out.println("ERRO: " + e.getMessage());
			return "";

		}
	}

}
