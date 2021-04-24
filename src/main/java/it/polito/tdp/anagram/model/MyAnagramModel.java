package it.polito.tdp.anagram.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyAnagramModel
{
	public enum Mode 
	{
		NoRepetitions,
		WithRepetitions;
	}
	
	public Collection<String> computeAnagramsOf(String word)
	{
		return computeAnagramsOf(word, Mode.NoRepetitions);
	}
	
	public Collection<String> computeAnagramsOf(String word, Mode computationMode)
	{
		Collection<String> anagrams;
		if(computationMode == Mode.NoRepetitions)
			anagrams = new HashSet<>();
		else
			anagrams = new LinkedList<>();
		
		StringBuilder partialAnagram = new StringBuilder();
		StringBuilder remainedChars = new StringBuilder(word);
		
		this.recursiveAnagramsOf(partialAnagram, remainedChars, anagrams, computationMode);
		return anagrams;
	}
	
	private void recursiveAnagramsOf(
			StringBuilder partialAnagram, StringBuilder remainedChars, Collection<String> anagrams, Mode computationMode)
	{
		if(remainedChars.length() == 0)
		{	
			String newAnagram = partialAnagram.toString();
			anagrams.add(newAnagram);
			return;
		}
		
		int loops = remainedChars.length();
		
		Set<Character> insertedChars = null;
		if(computationMode == Mode.NoRepetitions)
			insertedChars = new HashSet<>();
		
		for(int i=0; i<loops; i++)
		{		
			char c = remainedChars.charAt(i);
			
			if(computationMode == Mode.NoRepetitions)
			{
				if(insertedChars.contains(c))
					continue;
				else
					insertedChars.add(c);
			}
			
			partialAnagram.append(c);
			remainedChars.deleteCharAt(i);
			
			recursiveAnagramsOf(partialAnagram, remainedChars, anagrams, computationMode);
			
			//backtracking
			int lastIndex = partialAnagram.length() - 1;
			partialAnagram.deleteCharAt(lastIndex);
			remainedChars.insert(i,c);
		}
		return;
	}
}
