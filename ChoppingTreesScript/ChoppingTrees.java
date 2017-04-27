import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

//Chopping Trees Class which extends the task abstract class with Client Context
public class ChoppingTrees extends Task<ClientContext> {
    //integer array hold tree ID's
    private int[] TreeIDs = {38616, 38627, 58006};

    public ChoppingTrees(ClientContext ctx) {
        super(ctx);

    }

    @Override
    public boolean activate() {
        //Activate Cutting Trees if 1) Inventory isn't full 2) you aren't already cutting trees 3) there is a a tree to chop
       return (ctx.inventory.select().count() < 28) && !ctx.objects.select().id(TreeIDs).isEmpty() && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        //When activate returns true execute the cutting tree command
        GameObject Tree = ctx.objects.nearest().poll();

        //Checking to see if tree is in range of being chopped, if so, then chop tree, if not then move towards tree
        if (Tree.inViewport()){
            Tree.interact("Chop");
        }
        else {
            ctx.movement.step(Tree);
            ctx.camera.turnTo(Tree);
        }
    }
}
