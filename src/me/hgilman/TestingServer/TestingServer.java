package me.hgilman.TestingServer;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.ChatColor;

public class TestingServer extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft"); // Allow us to send output to the console.

	private final TSPlayerListener playerListener = new TSPlayerListener(this); // Declare the player listener.


	public void onEnable()
	{
		log.info("TestingServer enabling...");

		PluginManager pm = this.getServer().getPluginManager();

		// Event registrations.
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);


		log.info("TestingServer plugin enabled!");
		this.getServer().broadcastMessage(ChatColor.GREEN + "All plugins have been reloaded.");
	}

	public void onDisable()
	{
		log.info("TestingServer disabled");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

		if(cmd.getName().equalsIgnoreCase("signalstop")){ // If the command was "signalstop"
			if (sender.isOp())
			{
				int b = 0;
				for (int i = 10; i >= 0; i--)
				{
					sender.getServer().getScheduler().scheduleSyncDelayedTask(this, new RunnableNotify(sender.getServer(), i), b*20);
					b++;
				}
			}

			return true;
		} //If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
		
		return false; }

}
