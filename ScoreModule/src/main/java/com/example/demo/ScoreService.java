package com.example.demo;
import org.springframework.http.MediaType;

import javax.print.attribute.standard.Media;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreService {
	
	private int wins,losses,ties;
	
	//{"wins":"0","losses":"0","ties":"0"}
	//GetScore is to get inital score of game
@RequestMapping(value="/score",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public String getScore() {
  String pattern ="{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\", \"event\":\"Yes\"}";
  System.out.println("GetScore Method Triggered");
  return String.format(pattern,  Score.WINS, Score.LOSSES, Score.TIES);
}
	
	
	//Update score Uses displays value given in query param
	
	@RequestMapping (value="/score" ,method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public String updateScore(int wins,int losses,int ties)
	{
		Score.WINS=wins;
		Score.LOSSES=losses;
		Score.TIES=ties;
		String pattern ="{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\":\"%s\"}";
		System.out.println("Update score is Triggered");
		
		return String.format(pattern,Score.WINS,Score.LOSSES,Score.TIES);
		
	}
	
	//Post The value of win,losses,ties in Incremental from
	
	@RequestMapping(value="/score/wins",method=RequestMethod.POST)
	public int increaseWins() {return ++Score.WINS;}
	@RequestMapping(value="/score/ties" ,method=RequestMethod.POST)
	public int increaseTies() {return ++Score.TIES;}
	@RequestMapping(value="/score/losses",method=RequestMethod.POST)
	public int increaseLosses() {return ++Score.LOSSES;}
	
	
	@RequestMapping(value="/score/wins",method=RequestMethod.GET)
	public int getWins() {return Score.WINS;}
	@RequestMapping(value="/score/ties" ,method=RequestMethod.GET)
	public int getTies() {return Score.TIES ;}
	@RequestMapping(value="/score/losses" ,method=RequestMethod.GET)
	public int getLosses() {return Score.LOSSES; }

}
