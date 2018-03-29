package me.jasonhaxstuff.candymania.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jasonhaxstuff.candymania.Main;
import net.md_5.bungee.api.ChatColor;

public class Tylenol implements CommandType {

	@Override
	public boolean use(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length != 1) {
				player.sendMessage(ChatColor.RED + "Usage: /tylenol <amount>");
				return false;
			}
			int amount = Integer.parseInt(args[0]);
			if (amount >= 1) {
				player.getInventory().addItem(Main.candies.get(3).giveItem(amount));
				return true;
			} else if (amount <= 0) {
				player.getInventory().addItem(Main.candies.get(3).giveItem(1));
				return true;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Only players can use Tylenol!");
			return true;
		}
		return false;
	}

	@Override
	public String getCmd() {
		
		return "tylenol";
	}

}
