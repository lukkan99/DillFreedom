package me.SupItsDillon.DillFreedom;
 
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

//Plugin imports etc..
import me.SupItsDillon.DillFreedom.DillFreedom;
 
public class PlayerListener implements Listener{
 
        public DillFreedom plugin;
       
        public PlayerListener(DillFreedom instance){
                plugin = instance;
        }
       
        @EventHandler(priority = EventPriority.HIGHEST)
        public void onPlayerJoin(PlayerJoinEvent e){
                e.getPlayer().sendMessage(ChatColor.RED+"This server is using DillFreedom!");
                e.getPlayer().sendMessage(ChatColor.RED+ "To get the source go to github.com/SupItsDillon/DillFreedom");
        }
       
       
}
