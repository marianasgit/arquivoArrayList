package br.senai.arquivo.arraylist;

public class Main {

	public static void main(String[] args) {
		
		//Declaração das variáveis/objetos
		Arquivo objArquivo = new Arquivo();
		String caminho = "C:\\Users\\21276380\\Desktop\\contato\\contatos.txt";
		
		//Teste de gravação do arquivo
		DadosContato objtDadosContato = new DadosContato(); 

		Contato objContato1 = new Contato("Ana", "ana@gmail.com", "1111-1111", "Jandira");
		Contato objContato2 = new Contato("Maria", "maria@gmail.com", "2222-2222", "Barueri");
		Contato objContato3 = new Contato("João", "joão@gmail.com", "3333-3333", "Osasco");
		Contato objContato4 = new Contato("José", "jose@gmail.com", "4444-4444", "Itapevi");
		
		objtDadosContato.cadastrarContato(objContato1);
		objtDadosContato.cadastrarContato(objContato2);
		objtDadosContato.cadastrarContato(objContato3);
		objtDadosContato.cadastrarContato(objContato4);
		
		//Adicionando separador de ;
		String texto = "";
		
		for (Contato c : objtDadosContato.listarContatos()) {
			
//			System.out.println("Nome:  " + c.getNome() + " E-mail: " + c.getEmail() + 
//								" Telefone: " + c.getTelefone() + " Cidade: " + c.getCidade());
			
			texto += c.getNome() + ";" + c.getEmail() + ";" + c.getTelefone() + ";" + c.getCidade() + "\n";	
			
		}
		
		//System.out.println(texto);
		objArquivo.escrever(caminho, texto);
		
	}

}
