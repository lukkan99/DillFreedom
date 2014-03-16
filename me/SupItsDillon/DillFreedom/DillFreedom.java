package me.SupItsDillon.DillFreedom;

import net.pravian.bukkitlib.BukkitLib;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//Command imports
import me.SupItsDillon.DillFreedom.Commands.Command_dffeed;
import me.SupItsDillon.DillFreedom.Commands.Command_dfhelp;
import me.SupItsDillon.DillFreedom.Commands.Command_dflol;
import me.SupItsDillon.DillFreedom.Commands.Command_dfheal;

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
        getCommand("df-help").setExecutor((org.bukkit.command.CommandExecutor) new Command_dfhelp(this));
        getCommand("df-heal").setExecutor((org.bukkit.command.CommandExecutor) new Command_dfheal(this));
        getCommand("df-feed").setExecutor((org.bukkit.command.CommandExecutor) new Command_dffeed(this));
        getCommand("df-lol").setExecutor((org.bukkit.command.CommandExecutor) new Command_dflol(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("DillFreedom has been disabled!");
        //Commands moved to me.SupItsDillon.DillFreedom.Commands
    }

}