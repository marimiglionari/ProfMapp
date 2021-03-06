package br.com.processador;


import java.io.File;
import java.util.*;  

public class Navegador{

	/* Atributos
	------------------------------------------------------------------------------------------------------------------*/	
	private ArrayList<String> listaDeDiretorios = new ArrayList<String>();
	private ArrayList<String> listaDeArquivos = new ArrayList<String>();
	private	int a = 20;
	int b = 20;


	/* Navega entre os diretórios
	/  repositório: é o diretório raiz
	------------------------------------------------------------------------------------------------------------------*/	
	public ArrayList<String> navegaPorDiretorios(String repositorio)
	{
		File folder = new File(repositorio);
		File[] listOfFiles = folder.listFiles();
		

		for (int i = 0; i < listOfFiles.length; i++) 
		{
	    	if (listOfFiles[i].isDirectory()) 
	    	{
	      		listaDeDiretorios.add(folder + "/" + listOfFiles[i].getName());
	      		navegaPorDiretorios(folder + "/" + listOfFiles[i].getName());
	    	}
		}
		return listaDeDiretorios;
	}
		

	/* Navega entre os arquivos
	/  caminhoDir: é o caminho completo do diretório
	------------------------------------------------------------------------------------------------------------------*/	
	public ArrayList<String> navegaPorArquivos(String caminhoDiretorio)
	{

		File folder = new File(caminhoDiretorio);
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
	    	if (listOfFiles[i].isFile()) {
	    		
	    		listaDeArquivos.add(folder + "/" + listOfFiles[i].getName());
	    	
	    	} else if (listOfFiles[i].isDirectory()) {

	      		navegaPorArquivos(folder + "/" + listOfFiles[i].getName());
	    	}
		}
		return listaDeArquivos;
	}


	/* Busca palavras-chave em String
	------------------------------------------------------------------------------------------------------------------*/
	public String buscaPalavra(String frase, String palavraChave) {
		
		if(frase.toLowerCase().contains(palavraChave.toLowerCase())) {
			System.out.println(frase);
			return frase;
		}

		return "0";
	}
	
	/* Busca palavras-chave em String
	------------------------------------------------------------------------------------------------------------------*/
	public void buscaConjuntoDePalavra(ArrayList<String> conjuntoDeFrases, ArrayList<String> conjuntoDePalavrasChave) {
		
		for(String frase : conjuntoDeFrases) {
			for(String palavraChave : conjuntoDePalavrasChave){
				if(frase.toLowerCase().contains(palavraChave.toLowerCase())) {

					System.out.println("Frase: " + frase + " , Palavra: " + palavraChave);
				}
			}
		}

		//return "0";
	}

}
