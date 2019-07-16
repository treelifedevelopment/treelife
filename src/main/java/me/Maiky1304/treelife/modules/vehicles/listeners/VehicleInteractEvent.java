package me.Maiky1304.treelife.modules.vehicles.listeners;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.vehicles.listeners in de class VehicleInteractEvent.
*/

import me.Maiky1304.treelife.modules.vehicles.interfaces.VehicleEntity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.UUID;

public class VehicleInteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e){
        if (e.getRightClicked() instanceof ArmorStand){
            ArmorStand armorStand = (ArmorStand) e.getRightClicked();
            Player player = e.getPlayer();

            VehicleEntity vehicle = new VehicleEntity(armorStand);

            if (vehicle.isCar()){
                e.setCancelled(true);
                if (player.isSneaking()){
                    // TODO: Send player a message and tell him that he tried to interact with a car
                    if (player.hasPermission("treelife.admin.pickupvehicles")){
                        player.getInventory().addItem(armorStand.getHelmet());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                "&6Je hebt &e" + ChatColor.stripColor(armorStand.getHelmet().getItemMeta().getDisplayName())  + " &6opgepakt!"));
                        armorStand.remove();
                    }else{
                        player.sendMessage(ChatColor.RED + "Dit is niet jouw voertuig.");
                    }
                }else{
                    if (player.hasPermission("treelife.admin.entervehicles")) {
                        if (vehicle.getEntity().getPassenger() == null) {
                            vehicle.getEntity().setPassenger(player);
                        }
                    }else{
                        player.sendMessage(ChatColor.RED + "Dit is niet jouw voertuig.");
                    }
                }
            }
        }
    }

}
