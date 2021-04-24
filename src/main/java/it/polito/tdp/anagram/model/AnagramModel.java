package it.polito.tdp.anagram.model;

import java.util.ArrayList;
import java.util.List;

public class AnagramModel
{
	public List<String> anagrammi(String parola)
	{
		List<String> risultato = new ArrayList<>();
		permuta("", parola, 0, risultato);
		return risultato;
	}
	
	// livello -> lunghezza della soluzione parziale (livello iniziale = 0)
	// soluzioneParziale -> stringa che contiene l'anagramma incompleto in fase di costruzione
	// lettereRimanenti -> lettere della parola iniziale che non sono state ancora utilizzate (=sottoproblema da risolvere)
	private void permuta(String soluzioneParziale, String lettereRimanenti, int livello, List<String> risultato)
	{
		if(lettereRimanenti.isEmpty()) // caso terminale
		{
			//la soluzione parziale e' anche una soluzione completa!
			//System.out.println(soluzioneParziale);
			risultato.add(soluzioneParziale);
		}
		else	//fai ricorsione
		{
			// sottoproblema == una lettera (un singolo carattere) di 'lettereRimanenti'
			for(int pos=0; pos<lettereRimanenti.length(); pos++)
			{
				char tentativo = lettereRimanenti.charAt(pos);
				
				//sporco i parametri:
				//soluzioneParziale += tentativo;
				//togli il carattere 'pos' da lettereRimanenti
				
				// oppure creo altre variabili:
				String nuovaParziale = soluzioneParziale + tentativo;
				String nuoveLettere = new StringBuilder(lettereRimanenti).deleteCharAt(pos).toString();
				
				
				permuta(nuovaParziale, nuoveLettere, livello+1, risultato);
				
				// backtracking:
				//rimetti a posto 'soluzioneParziale' e 'lettereRimanenti' (se le ho "sporcate")
			}
			
		}
		
	}
	
}
