package me.Maiky1304.treelife.modules.vehicles.listeners;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.vehicles.listeners in de class VehiclePlaceEvent.
*/

import me.Maiky1304.treelife.main.Main;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

public class VehiclePlaceEvent implements Listener {

    Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onVehiclePlace(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getHand() == EquipmentSlot.HAND){
            if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_HOE){
                if (e.getPlayer().getItemInHand()
                        .getItemMeta().getLore() != null){
                    if (e.getPlayer().getItemInHand()
                            .getItemMeta().getLore().get(1).startsWith("§6Voertuig ID:")){

                        // Setup Vehicle

                        // Variables
                        String vehicleID = e.getPlayer().getItemInHand()
                                .getItemMeta().getLore().get(1)
                                .replace("§6Voertuig ID: §e", "");

                        // Create Vehicle
                        ArmorStand as = e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getRelative(BlockFace.UP).getLocation(),
                                ArmorStand.class);

                        //Setup data
                        as.setVisible(false);
                        as.setCustomName(vehicleID);
                        as.setCustomNameVisible(false);
                        as.setCanPickupItems(false);
                        as.setHelmet(e.getPlayer().getItemInHand());

                        e.getPlayer().sendMessage(vehicleID);
                    }
                }
            }
        }
    }

}
