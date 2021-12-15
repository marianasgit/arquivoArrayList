package br.senai.arquivo.arraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	DadosContato objDadosContato = new DadosContato();
	
	// Cria e grava os dados no arquivo
	public boolean escrever(String caminho, String texto) {

		try {

			FileWriter arquivo = new FileWriter(caminho); // criar o arquivo
			
			PrintWriter gravarArquivo = new PrintWriter(arquivo); // permitir que o arquivo seja gravado

			gravarArquivo.append(texto); // usado para inserir a informacao no final do arquivo
			
			gravarArquivo.close();

			return true;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());
			return false;

		}
	}

	// Le os dados do arquivo
	public DadosContato ler(String caminho) {

		// recupera os dados do arquivo e armazena em memoria para a manipulacao

		try {

			FileReader arquivo = new FileReader(caminho); // abre o arquivo
			BufferedReader conteudoArquivo = new BufferedReader(arquivo); // armazena o conteudo do arquivo em memoria

			// Recupera os dados do arquivo
			
				String linha = "";
				
				linha = conteudoArquivo.readLine();
				
				while (linha != null) {
					
					Contato objContato = new Contato();
					
					String[] vetorLinha = linha.split(";");
					
					objContato.setNome(vetorLinha[0]);
					objContato.setEmail(vetorLinha[1]);
					objContato.setTelefone(vetorLinha[2]);
					objContato.setCidade(vetorLinha[3]);
					
					objDadosContato.cadastrarContato(objContato);
					
					linha = conteudoArquivo.readLine();

				}

				conteudoArquivo.close();
				return objDadosContato;

			} catch (IOException e) { // Trata o BufferedReader
				System.out.println("ERRO: " + e.getMessage());
				return null;
			}


	}

}
