

	package scripts;
	import org.powerbot.script.AbstractScript;
	import org.powerbot.script.Condition;
	import org.powerbot.script.rt4.GeItem;
import org.powerbot.script.rt4.GroundItem;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.MessageEvent;
	import org.powerbot.script.MessageListener;
	import org.powerbot.script.PaintListener;
	import org.powerbot.script.PollingScript;
	import org.powerbot.script.Script;
	import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Npc;

import ScriptRepo.Task;
import ScriptRepo.smeltingAIO;
import ScriptRepo.smeltingBankAIO;
import ScriptRepo.smeltingUseAIO;

import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Timer;

	import javax.swing.JOptionPane;
	@Script.Manifest(name = "HaxFletchAIO", description = "Fletches stuff -V1.0")//V1.0




	public class HaxFletchAIO extends PollingScript<ClientContext> implements MessageListener, PaintListener {

	public static final Font TAHOMA = new Font("Tahoma", Font.PLAIN, 12);
	private static int LogsGeCost = 0;
	private static int TotalProfit = 0;
	int bankId = 4483;		
	int logCost = 0;
	int logsGeCost = 0;
	public static int LogsId;
	int bowsFletched=0;
	int xp=0;
	int xpHr=0;
	static int bowId;
	int knifeId = 946;
	GameObject bank = ctx.objects.select().id(bankId).nearest().poll();		
	private List<Task> taskList = new ArrayList<Task>();
	int featherPrice,shaftPrice,headlessPrice;
	int normalLog;
	int oakLog;
	int willowLog;
	int mapleLog;
	int yewLog;
	int magicLog;		
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
	int bowGePrice;
    public static String userChoice;








	public void repaint(Graphics graphics) {
	    	long milliseconds = getTotalRuntime();
	        long seconds = (milliseconds / 1000) % 60;
	        long minutes = (milliseconds / (1000*60) % 60);
	        long hours = (milliseconds / (1000*60*60)) % 24; 		
	    	final Graphics2D g = (Graphics2D) graphics;
	    	g.setFont(TAHOMA);
	        g.setColor(Color.WHITE);   
			g.drawString(String.format("HaxFletchAIO  Time running: "+ String.format("%02d:%02d:%02d", hours, minutes, seconds)), 10, 35);   
			TotalProfit = bowsFletched*bowGePrice;
			int profit = TotalProfit-(LogsGeCost*bowsFletched);
			final int profitHr = (int) ((profit * 3600000D) / getRuntime());
			final int bowsHr = (int) ((bowsFletched * 3600000D) / getRuntime());
			g.drawString(String.format("Items: %,d (%,d)", bowsFletched, bowsHr), 10, 55);
		    g.drawString(String.format("Profit: %,d (%,d)", profit, profitHr), 10, 75); 
		    g.drawString(String.format("Xp: %,d (%,d)", xp, xpHr), 10, 95);
	    }


		@Override
		public void messaged(MessageEvent e) {
			final String msg = e.text();
			if (e.source().isEmpty() && msg.contains("You carefully")) {
				bowsFletched = bowsFletched+1;
			}
			if (e.source().isEmpty() && msg.contains("You carefully")) {
				xp=xp+75;
			}
	        }
	    
			
		
	public void start() {
		taskList.addAll(Arrays.asList(new HaxFletcherBank(ctx),new HaxFletcherUse(ctx)));
		featherPrice = new GeItem(314).price;
		shaftPrice = new GeItem(52).price;
		headlessPrice = new GeItem(53).price;
	   
	   
		
		String userOptions[] = {"Shaft Normal Log", "Cut Normal ShortBow","Cut Normal LongBow","String Normal ShortBow", "String Normal LongBow","Shaft Oak Log", "Cut Oak ShortBow","Cut Oak LongBow","String Oak ShortBow", "String Oak LongBow","Shaft Willow Log", "Cut Willow ShortBow","Cut Willow LongBow","String Willow ShortBow", "String Willow LongBow","Shaft Maple Log", "Cut Maple ShortBow","Cut Maple LongBow","String Maple ShortBow", "String Maple LongBow","Shaft Yew Log", "Cut Yew ShortBow","Cut Yew LongBow","String Yew ShortBow", "String Yew LongBow","Shaft Magic Log", "Cut Magic ShortBow","Cut Magic LongBow","String Magic ShortBow", "String Magic LongBow"};
         userChoice = ""+(String)JOptionPane.showInputDialog(null, "Select what you wanna do", "Fletching", JOptionPane.PLAIN_MESSAGE, null, userOptions, userOptions[0]);
       // System.out.println(userChoice);
        if(HaxFletchAIO.userChoice.equals("Shaft Normal Log")||HaxFletchAIO.userChoice.equals("Cut Normal ShortBow")||HaxFletchAIO.userChoice.equals("Cut Normal LongBow")||HaxFletchAIO.userChoice.equals("String Normal ShortBow")||HaxFletchAIO.userChoice.equals("String Normal LongBow")) {
    		LogsId = 1523;
    		logsGeCost = new GeItem(LogsId).price;
    		
    		
    	}
        if(HaxFletchAIO.userChoice.equals("Shaft Oak Log")||HaxFletchAIO.userChoice.equals("Cut Oak ShortBow")||HaxFletchAIO.userChoice.equals("Cut Oak LongBow")||HaxFletchAIO.userChoice.equals("String Oak ShortBow")||HaxFletchAIO.userChoice.equals("String Oak LongBow")) {
    		LogsId = 1521;
    		logsGeCost = new GeItem(LogsId).price;
    		
    		
    	}
        
        if(HaxFletchAIO.userChoice.equals("Shaft Willow Log")||HaxFletchAIO.userChoice.equals("Cut Willow ShortBow")||HaxFletchAIO.userChoice.equals("Cut Willow LongBow")||HaxFletchAIO.userChoice.equals("String Willow ShortBow")||HaxFletchAIO.userChoice.equals("String Willow LongBow")) {
    		LogsId = 1519;
    		logsGeCost = new GeItem(LogsId).price;
    		
    		
    	}
        
        
        if(HaxFletchAIO.userChoice.equals("Shaft Maple Log")||HaxFletchAIO.userChoice.equals("Cut Maple ShortBow")||HaxFletchAIO.userChoice.equals("Cut Maple LongBow")||HaxFletchAIO.userChoice.equals("String Maple ShortBow")||HaxFletchAIO.userChoice.equals("String Maple LongBow")) {
    		LogsId = 1517;
    		LogsGeCost = new GeItem(1517).price;
    		 if(HaxFletchAIO.userChoice.equals("Cut Maple ShortBow")){
    			 bowGePrice = new GeItem(64).price;//maples short
    			 bowId = 64;
    		 }
    		 if(HaxFletchAIO.userChoice.equals("Cut Maple LongBow")){
    			 bowGePrice = new GeItem(62).price;//maples long
    			 bowId = 62;
    		 }
    		
    	}
    	if(HaxFletchAIO.userChoice.equals("Shaft Yew Log")||HaxFletchAIO.userChoice.equals("Cut Yew ShortBow")||HaxFletchAIO.userChoice.equals("Cut Yew LongBow")||HaxFletchAIO.userChoice.equals("String Yew ShortBow")||HaxFletchAIO.userChoice.equals("String Yew LongBow")) {
    		LogsId = 1515;
    		LogsGeCost = new GeItem(1515).price;
    		 if(HaxFletchAIO.userChoice.equals("Cut Yew ShortBow")){
    			 bowGePrice = new GeItem(68).price;//yew short
    			 bowId = 68;
    		 }
    		 if(HaxFletchAIO.userChoice.equals("Cut Yew LongBow")){
    			 bowGePrice = new GeItem(66).price;//yew long
    			 bowId = 66;
    	//		 System.out.println("In Start bowGePrice:"+bowGePrice+"LogsGeCost:"+LogsGeCost);
    		 }
    	}
    	if(HaxFletchAIO.userChoice.equals("Shaft Magic Log")||HaxFletchAIO.userChoice.equals("Cut Magic ShortBow")||HaxFletchAIO.userChoice.equals("Cut Magic LongBow")||HaxFletchAIO.userChoice.equals("String Magic ShortBow")||HaxFletchAIO.userChoice.equals("String Magic LongBow")) {
    		LogsId = 1513;
    		
    		
    	}
		
	}

		@Override
		public void poll() {
			
			for (Task task : taskList) {
				if (task.activate()) {
					task.execute();
					 
				}
			}
			
			
		}
	 	


		}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


