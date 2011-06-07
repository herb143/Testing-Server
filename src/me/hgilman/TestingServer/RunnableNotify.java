package me.hgilman.TestingServer;

import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;

public class RunnableNotify implements Runnable {

	Server server;
	int countdown;

	public RunnableNotify(Server instance, int instancecountdown) { server = instance; countdown = instancecountdown; }

	public void run()
	{
		if (countdown > 0)
		{
			server.broadcastMessage("Stopping the server in " + countdown + " seconds.");
		}
		else
		{
			server.broadcastMessage("HALTING SERVER");
			server.dispatchCommand(new ConsoleCommandSender(server), "stop");
		}
	}

}
