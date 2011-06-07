package me.hgilman.TestingServer;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TSPlayerListener extends PlayerListener {
	
	public static TestingServer plugin;
	
	public TSPlayerListener(TestingServer instance) { plugin = instance; } // So we can call the plugin.
	
	public void onPlayerJoin (PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		Inventory inventory = player.getInventory();
		
		player.sendMessage("Welcome the AorMinecraft Test Server!");
		player.sendMessage("Data periodically cleared. Don't be alarmed at item loss.");
		
		if (!(inventory.contains(Material.GOLD_HOE)))
		{
			player.getInventory().addItem(new ItemStack(Material.GOLD_HOE, 1));
			player.sendMessage("One scepter (gold hoe) has been added to your inventory.");
		}
		
	}
	
}
