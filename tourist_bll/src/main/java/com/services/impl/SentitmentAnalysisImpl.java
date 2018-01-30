package com.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Commentaire;
import com.bo.Destination;
import com.bo.WordPolarity;
import com.dao.DestinationDao;
import com.dao.WordPolarityDao;
import com.services.SentimentAnalysis;

@Service
@Transactional
public class SentitmentAnalysisImpl implements SentimentAnalysis {

	@Autowired
	private WordPolarityDao wordPolDao;

	@Autowired
	private DestinationDao destinationDao;

	@Scheduled(fixedRate = 10000)
	public void destinationRating() {

		System.out.println("destinationRating...");

		List<Destination> destinations = destinationDao.getAll();

		double note = 0.0;

		for (Destination it : destinations) {

			System.out.println("dest. " + it);

			note = 0.0;

			// On récupère les commentaires de la destination
			List<Commentaire> comments = it.getCommentaires();

			// On clacule la polarité de chaque commentaire
			for (Commentaire itc : comments) {
				note += getTextPolarity(itc.getText());

			}

			if (comments.size() != 0) {
				it.setNote(note / comments.size());
			}

			destinationDao.update(it);

		}

	}

	public double getTextPolarity(String ptext) {

		// tockenize

		List<String> tokens = segment_suffix(ptext);

		if (tokens.size() == 0) {
			return 0;
		}

		double moy = 0.0;

		for (String it : tokens) {
			moy += getWordPolarity(it);
		}

		return moy / tokens.size();
	}

	private double getWordPolarity(String pWord) {

		List<WordPolarity> words = wordPolDao.getAll();

		for (WordPolarity it : words) {

			if (it.getWord().equals(pWord)) {
				return it.getPolarity();
			}
		}

		return 0;
	}

	public String []segment_espace(String  phrase)
	{
		String [] seg=phrase.split(" ");
		
		
		return seg;
	}
	public List<String> segment_separ(String  phrase)
	{
		String[] seg=this.segment_espace(phrase);
		List<String> s=new ArrayList<String>();
		for(int i=0;i<seg.length;i++)
		{
			s.add(seg[i]);
		}
		for(int i=0;i<s.size();i++)
		{
			if(s.get(i).equals("and")|| s.get(i).equals("or")||s.get(i).equals("this")||s.get(i).equals("that")||s.get(i).equals("these")||s.get(i).equals("those"))
			{
				s.remove(s.get(i));
			}
			else
			{
				
			}
		}
		return s;
		
	}
	public List<String> segment_suffix(String  phrase)
	{
		List<String> s=this.segment_separ(phrase);
		
		
		for(int i=0;i<s.size();i++)
		{
		 if(s.get(i).substring(s.get(i).length()-2, s.get(i).length()).equals("ed")
				 ||s.get(i).substring(s.get(i).length()-2, s.get(i).length()).equals("er")
				 ||s.get(i).substring(s.get(i).length()-2, s.get(i).length()).equals("ee")
				 ||s.get(i).substring(s.get(i).length()-2, s.get(i).length()).equals("al")
				 ||s.get(i).substring(s.get(i).length()-2, s.get(i).length()).equals("en"))
		 {  s.set(i, s.get(i).substring(0, s.get(i).length()-2));
			 
		 }
		
		}

		return s;
	}

}
