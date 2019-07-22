package scripts;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import ScriptRepo.Task;
import ScriptRepo.smeltingAIO;

public class HaxFletcherBank extends Task<ClientContext> {
	
	
	
	int bowId ;
	int LogsId;
	int normalLog;
	int oakLog;
	int willowLog;
	int mapleLog;
	int yewLog;
	int magicLog;
	int knifeId = 946;
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
    Item knife = ctx.inventory.select().id(knifeId).poll();
	

	
	public HaxFletcherBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}


@Override
public String status() {
	
	return null;
}

@Override
public boolean activate() {
	
	return 0 >= ctx.inventory.select().id(knifeId).size()
            || 0 >= ctx.inventory.select().id(LogsId).size();
            
            
			
}

@Override
public void execute() {
	
	

	LogsId = HaxFletchAIO.LogsId;
	bowId = HaxFletchAIO.bowId;
	if(HaxFletchAIO.userChoice.contains("Cut")) {//generic cut so either short or long
		
			

				//Bank code		
					System.out.println("entering code for banking, logs id:"+LogsId+"bowID:"+bowId);
					
					while(ctx.bank.opened()==false) {
					Condition.sleep(1000);
					ctx.bank.open();
							
					}
					Condition.sleep(1000);
					ctx.bank.deposit(bowId, 27);
					Condition.sleep(1000);
					ctx.bank.withdraw(LogsId, 27);
					Condition.sleep(1000);	
					ctx.bank.close();
					Condition.sleep(1000);
					if (ctx.inventory.select().count()<28){//didn't withdraw right amount
						ctx.bank.open();
						Condition.sleep(1000);
						ctx.bank.withdraw(LogsId, 27);
						Condition.sleep(1000);	
						ctx.bank.close();
						Condition.sleep(1000);
						if (ctx.inventory.select().count()<28){
						ctx.controller.stop();
						System.out.println("out");
						}
						
						}
						
						
					
					}//closes  shortbow & long
	if(HaxFletchAIO.userChoice.contains("Shaft")) {


	//Bank code		
//		System.out.println("entering code for banking");
		
		while(ctx.bank.opened()==false) {
		Condition.sleep(1000);
		ctx.bank.open();
				
		}
		Condition.sleep(1000);

		ctx.bank.withdraw(LogsId, 27);
		Condition.sleep(1000);	
		ctx.bank.close();
		Condition.sleep(1000);
		if (ctx.bank.opened()){//didn't withdraw right amount
			ctx.bank.close();
			System.out.println("Missclicked close on bank");
			
		}
		if (ctx.inventory.select().count()<28){//didn't withdraw right amount
			ctx.controller.stop();
			System.out.println("ran out of stuff");
			
		}
		
		}//closes shafts
		
		}//closes execute
		
	
	
	
	}

	

	
	
	
	
	
