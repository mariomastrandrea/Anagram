package it.polito.tdp.anagram.model;

import java.util.Collection;
import java.util.List;

import it.polito.tdp.anagram.model.MyAnagramModel.Mode;

public class TestAnagramma
{

	public static void main(String[] args)
	{
		String word = "mama";
		
		AnagramModel model = new AnagramModel();
		List<String> anagrammi = model.anagrammi(word);
		
		
		System.out.println("Anagram Model - in aula\n");
		System.out.println(printCollection(anagrammi));
		System.out.println();
		
		MyAnagramModel myModel = new MyAnagramModel();
		Collection<String> myAnagrams = myModel.computeAnagramsOf(word, Mode.NoRepetitions);
		
		System.out.println("------------------\nMy anagram Model\n");
		System.out.println(printAndCheckCollection(myAnagrams, anagrammi));
		System.out.println();
	}
	
	
	public static String printCollection(Collection<? extends Object> collection)
	{
		StringBuilder sb = new StringBuilder();
		
		for(Object o : collection)
		{
			if(sb.length()>0)
				sb.append("\n");
			
			sb.append(o.toString());
		}
		sb.append("\n\n").append("count: ").append(collection.size());
		sb.insert(0, "Anagrams:\n\n");
		
		return sb.toString();
	}
	
	public static String printAndCheckCollection(Collection<? extends Object> collection, Collection<? extends Object> other)
	{
		StringBuilder sb = new StringBuilder();
		
		for(Object o : collection)
		{
			if(sb.length()>0)
				sb.append("\n");
			
			sb.append(o.toString());
			
			String existence = other.contains(o) ? "exist" : "doesn't exist";
			sb.append("  -->  ").append(existence);
		}
		String correctness = collection.size() == other.size() ? "same size" : "different size";
		sb.append("\n\n").append("count: ").append(collection.size()).append("  -->  ").append(correctness);
		sb.insert(0, "Anagrams:\n\n");
		
		return sb.toString();
	}

}
