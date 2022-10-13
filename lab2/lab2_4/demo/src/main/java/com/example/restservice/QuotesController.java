package com.example.restservice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

	private HashMap<String,ArrayList<String>> quotesList = new HashMap<>();
    private ArrayList<String> shows = new ArrayList<String>();
    private Random random;
    
    public QuotesController(){

        random = new Random();
        
        ArrayList<String> quotesHIMYM = new ArrayList<String>();
        ArrayList<String> quotesFriends = new ArrayList<String>();
		ArrayList<String> quotesB99 = new ArrayList<String>();
		ArrayList<String> quotesTMZ = new ArrayList<String>();
        ArrayList<String> quotesBP = new ArrayList<String>();
        
        quotesHIMYM.add("Whenever I'm sad, I stop being sad and be awesome instead.");
        quotesHIMYM.add("A lie is just a great story that someone ruined with the truth.");
        quotesFriends.add("We were on a break!");
        quotesFriends.add("Hi, I'm Chandler. I make jokes when I'm uncomfortable.");
        quotesB99.add("I'm gonna go cry in the bathroom, peace out homies");
        quotesB99.add("Anyone over the age of six celebrating a birthday should go to hell.");
        quotesTMZ.add("If you ain't scared… you ain't human.");
        quotesTMZ.add("It's kind of hard to ask a dead guy what he did wrong.");
        quotesBP.add("You are a good man, with a good heart. And it's hard for a good man to be a king.");
        quotesBP.add("Evacuate the city, engage all defenses…and get this man a shield!");


        quotesList.put("How I met your mother", quotesHIMYM);
        shows.add("How I met your mother");

        quotesList.put("Friends", quotesFriends);
        shows.add("Friends");

		quotesList.put("Brooklyn 99", quotesB99);
        shows.add("Brooklyn 99");

		quotesList.put("The Maze Runner", quotesTMZ);
        shows.add("The Maze Runner");

        quotesList.put("Black Panther", quotesBP);
        shows.add("Black Panther");
    }

    @GetMapping("/api/quotes")
    public Quotes quote(@RequestParam(value = "show", defaultValue = "-1" ) String show_id){

        int id = -1;
        
        try{
            id = Integer.parseInt(show_id);
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
        
        if( id == -1){
            id = random.nextInt( shows.size());
        }

        String show = shows.get(id);

        ArrayList<String> show_quotes = quotesList.get(show);
        int random_quote_id = random.nextInt( show_quotes.size());

        String quote = quotesList.get(show).get(random_quote_id);
        
        return new Quotes(id, show, quote);
    }

    @GetMapping("api/shows")
    public ArrayList<String> shows(){
        return shows;
    }

}