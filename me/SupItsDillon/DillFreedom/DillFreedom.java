package me.SupItsDillon.DillFreedom;
 
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
 
public class DillFreedom extends JavaPlugin{
        private PlayerListener PlayerListener = new PlayerListener(this);
       
 
        public void onEnable(){
                System.out.println("DillFreedom Enabled");
                PluginManager pm = getServer().getPluginManager();
                pm.registerEvents(this.PlayerListener, this);
        }
        public void onDisable(){
                System.out.println("DillFreedom Disabled");
        }
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
                Player player = (Player)sender;
                if(cmd.getName().equalsIgnoreCase("df-help")){
                        player.sendMessage("Welcome to DillFreedom! There are many commands in the plugin. To see them all, do /help DillFreedom");
                }
                 else if(cmd.getName().equalsIgnoreCase("Healme")){
                        if(args.length==1){
                        Player user = player.getServer().getPlayer(args[0]);
                        if(user==null){
                                player.sendMessage("Invalid Player");
                                return true;}
                        user.setHealth(20);}
                        else{
                                player.sendMessage(ChatColor.DARK_RED+"/HealMe <player>");
                        }
                }
 
                else if(cmd.getName().equalsIgnoreCase("FeedMe")){
                        if(args.length==1){
                        Player user = player.getServer().getPlayer(args[0]);
                        if(user==null){
                                player.sendMessage("Invalid Player");
                                return true;}
                        user.setFoodLevel(20);}
                        else{
                                player.sendMessage(ChatColor.DARK_RED+"/FeedMe <player>");
                        }       
                }                
                 else if(cmd.getName().equalsIgnoreCase("df-lol")){
                        player.sendMessage("Welp. You've done goof'd.");
                        user.setHealth(0);}
                        }
                }
                return true;
        }
       
}
