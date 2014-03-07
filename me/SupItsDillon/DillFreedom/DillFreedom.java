package me.SupItsDillon.DillFreedom;

import net.pravian.bukkitlib.BukkitLib;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DillFreedom extends JavaPlugin {

    public PlayerListener playerListener;
    public DillFreedom plugin;

    @Override
    public void onLoad() {
        plugin = this;
        playerListener = new PlayerListener(plugin);
    }

    @Override
    public void onEnable() {
        BukkitLib.init(plugin);
        getLogger().info("DillFreedom has been enabled!");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(plugin.playerListener, plugin);
    }

    @Override
    public void onDisable() {
        getLogger().info("DillFreedom has been disabled!");
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
                    return true;
                }
                user.setHealth(20.0);
                player.sendMessage(ChatColor.RED + "You are now full!");
            } else {
                player.sendMessage(ChatColor.DARK_RED + "/df-heal <player>");
            }
        } else if (cmd.getName().equalsIgnoreCase("df-feed")) {
            if (args.length == 1) {
                Player user = player.getServer().getPlayer(args[0]);
                if (user == null) {
                    player.sendMessage("Invalid Player");
                    return true;
                }
                user.setFoodLevel(20);
                player.sendMessage(ChatColor.DARK_RED + "Your food levels have suddenly gone up!");
            } else {
                player.sendMessage(ChatColor.DARK_RED + "/df-feed <player>");
            }
        } else if (cmd.getName().equalsIgnoreCase("df-lol")) {
            if (args.length == 1) {
                Player user = player.getServer().getPlayer(args[0]);
                if (user == null) {
                    player.sendMessage("Invalid Player");
                    return true;
                }
                user.setHealth(0.0);
                player.sendMessage(ChatColor.DARK_RED + "Lol.");
            }
        }
        return true;
    }

}
