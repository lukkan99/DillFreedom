package me.SupItsDillon.DillFreedom.Commands;

import me.SupItsDillon.DillFreedom.DillFreedom;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_dfhelp implements CommandExecutor {

    public DillFreedom plugin; // points to the main class

    public Command_dfhelp(DillFreedom plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("df-help")) {
            player.sendMessage("Welcome to DillFreedom! The plugin is still in the making, but will soon be done!");
        } else if (cmd.getName().equalsIgnoreCase("df-heal")) {
            if (args.length == 1) {
                Player user = player.getServer().getPlayer(args[0]);
                if (user == null) {
                    player.sendMessage("Invalid Player");
                }
            }
        }
        return true;
    }
}
