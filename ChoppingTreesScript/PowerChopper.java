import org.powerbot.script.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;

import java.util.LinkedList;


//Main Script handler for the chopping trees script
@Script.Manifest(name = "Cutting Trees", description = "Script for cutting trees and dropping logs")
public abstract class PowerChopper extends PollingScript<ClientContext>{

    //Declaring a list to hold the to-do activities
    private LinkedList<Task> toDoList = new LinkedList<>();

    //When the Script launches I want the chopping trees and dropping logs activities to be added to the toDolist
    public void start(){
        //Adding chopping trees activity to the list
        toDoList.add(new ChoppingTrees((org.powerbot.script.rt4.ClientContext) ctx));
        //Adding Dropping logs activity to the list
        toDoList.add(new DroppingLogs((org.powerbot.script.rt4.ClientContext) ctx));
    }

    @Override
    public void poll(){
        //Create a for each loop that will iterate through all the activities that extend class and polymorphically call the activate and execute method
        for (Task task: toDoList){
            if (task.activate()){
                task.execute();
            }
        }

    }
}
