package main.enums;

import main.commands.ListIdea;
import main.commands.Parser;
import main.commands.PostIdea;

/**
 * Created by sebde on 01/05/2017.
 */
public enum EnumCommands {

    POSTIDEA(new PostIdea()),
    LISTIDEA(new ListIdea());

    private Parser parser;

    EnumCommands(Parser parser){
        this.parser=parser;
    }

    public Parser toCommand(){
        return parser;
    }
}
