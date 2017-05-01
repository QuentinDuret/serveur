package main.commands;

import main.ideas.Ideas;

/**
 * Created by sebde on 01/05/2017.
 */
public class ListIdea extends Parser {

    @Override
    public String read(String request,Ideas ideas){
        String str="LISTIDEARESPONSE";

        for(int i=0;i<ideas.getIdeas().size();i++){
            str+="$$"+ideas.getIdeas().get(i).getTitre()+"$"+ideas.getIdeas().get(i).getDescription()+"$"+ideas.getIdeas().get(i).getMail()+"$"+ideas.getIdeas().get(i).getNom();
            for(int j=0;j<ideas.getIdeas().get(i).getTechnologies().size();j++){
                if(j==0)str+="$"+ideas.getIdeas().get(i).getTechnologies().get(j);
                else str+="/"+ideas.getIdeas().get(i).getTechnologies().get(j);
            }



        }

        return str;
    }
}
