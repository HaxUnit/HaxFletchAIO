package scripts;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import ScriptRepo.Task;

public class HaxFletcherUse extends Task<ClientContext> {
	int LogsId;
	int knifeId = 946;

	Item knife = ctx.inventory.select().id(knifeId).poll();
	Item Logs = ctx.inventory.select().id(HaxFletchAIO.LogsId).poll();
	int normalShortBow;
	int normalLongBow;
	int oakShortBow;
	int oakLongBow;
	int willowShortBow;
	int willowLongBow;
	int mapleShortBow;
	int mapleLongBow;
	int yewShortBow;
	int yewLongBow;
	int magicShortBow;
	int magicLongBow;
	
	
	
	
	
	
	public HaxFletcherUse(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}



@Override
public String status() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean activate() {
	
	return ctx.inventory.select().id(HaxFletchAIO.LogsId).count()>0;
}

@Override
public void execute() {
	

	 Logs = ctx.inventory.select().id(HaxFletchAIO.LogsId).poll();
	if(HaxFletchAIO.userChoice.contains("Cut")) {//generic use cut
		System.out.println("entering generic method, logs id:"+LogsId);

		knife.interact("Use");
		Condition.sleep(500);
		Logs.interact("Use");
		Condition.sleep(1000);
		if(HaxFletchAIO.userChoice.contains("ShortBow")) {
		ctx.input.send("2");
		}
		else {
		ctx.input.send("3");
		}
		Condition.sleep(1000);
		System.out.println("stuck at 72");
		boolean flag = false;
		while (flag == false) {
			Condition.sleep(1000);
			if (ctx.chat.canContinue()){
				System.out.println("level up- the animation for ctx.players.local().animation() is: "+ctx.players.local().animation());
			    ctx.input.send(" ");
			    Condition.sleep(500);
			    knife.interact("Use");
				Condition.sleep(500);
				Logs.interact("Use");
				Condition.sleep(1000);
				if(HaxFletchAIO.userChoice.contains("ShortBow")) {
					ctx.input.send("2");
					}
					else {
					ctx.input.send("3");
					}
				Condition.sleep(1000);
			    flag = true;
			    System.out.println("stuck at 82");
			}
			if (ctx.inventory.select().id(HaxFletchAIO.LogsId).count()>0&&ctx.players.local().animation()==1248) {
				
				Condition.sleep(1000);
				
				
				
				
				
				
			}
			else {
				flag = true;
			}
			
		
		}
		
		
	
	}//closes generic cut
	
	
	
		
		if(HaxFletchAIO.userChoice.contains("Shaft")) {//generic shaft
		knife.interact("Use");
		Condition.sleep(500);
		System.out.println("logs:"+Logs);

		Logs.interact("Use");
		Condition.sleep(1000);
		ctx.input.send("1");
		Condition.sleep(1000);
		boolean flag = false;
		while (flag == false) {
			Condition.sleep(1000);
			if (ctx.chat.canContinue()){
				System.out.println("level up- the animation for ctx.players.local().animation() is: "+ctx.players.local().animation());
			    ctx.input.send(" ");
			    Condition.sleep(500);
			    knife.interact("Use");
				Condition.sleep(500);
				Logs.interact("Use");
				Condition.sleep(1000);
				ctx.input.send("1");
				Condition.sleep(1000);
			    flag = true;
			    System.out.println("stuck at 82");
			}
			if (ctx.inventory.select().id(HaxFletchAIO.LogsId).count()>0&&ctx.players.local().animation()==1248) {
				
				Condition.sleep(1000);
				
				
				
				
				
				
			}
			else {
				flag = true;
			}
			
		
		}
		
		}//closes generic shaft
	
	
	
	
	
	
	
	
	
	
}
}
