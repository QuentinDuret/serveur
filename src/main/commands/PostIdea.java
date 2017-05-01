package main.commands;

import main.ideas.Idea;
import main.ideas.Ideas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebde on 01/05/2017.
 */
public class PostIdea extends Parser {

    @Override
    public String toString(){
        return "postidea";
    }

    @Override
    public String read(String request,Ideas ideas){
        String[] tab=request.split("\\$");
        List<String> technologies=new ArrayList<String>();

        for(int i=0;i<tab[5].split("/").length;i++)technologies.add(tab[5].split("/")[i]);
        ideas.addIdea(new Idea(tab[1],tab[2],tab[3],tab[4],technologies));

        return "POSTIDEARESPONSE$OK";
    }
}
