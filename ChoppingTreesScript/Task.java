import org.powerbot.script.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;
//This abstract class ensures that any script components made have an activate and an execute method and also allow for polymorphic iteration in the main Script Class
//C is basically a new class that must extend client context and the task class must extend entirely from Client Accessor
public abstract class Task <C extends ClientContext> extends ClientAccessor<C>{

//  Passing the client context into the superclass constructor
    public Task(C ctx){
        super(ctx);

    }

    public abstract boolean activate();
    public abstract void execute();
}
