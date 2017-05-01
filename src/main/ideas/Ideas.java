package main.ideas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebde on 01/05/2017.
 */
public class Ideas {

    List<Idea>ideas;

    public Ideas(){
        ideas=new ArrayList<Idea>();
    }

    public void addIdea(Idea idea){
        ideas.add(idea);
    }

    public List<Idea> getIdeas(){
        return ideas;
    }
}
