import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

public class DroppingLogs extends Task<ClientContext>{
    private int LogID = 1511;

    public DroppingLogs(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        //Check to see if inventory is full
        return ctx.inventory.select().count() >= 28;
    }

    @Override
    public void execute() {
        //In order to drop the item we need to :
        //1) Iterate through the inventory
        //2) Check to see if item is a log
        //3) Drop Item if it is

        for (Item item: ctx.inventory.id(LogID)){ //ctx.inventory.id(args) is a list containing all the items in clients inventory with the matching argument id number
            item.interact("Drop");
        }
    }
}
