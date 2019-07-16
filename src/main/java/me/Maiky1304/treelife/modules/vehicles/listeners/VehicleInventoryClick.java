package me.Maiky1304.treelife.modules.vehicles.listeners;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.vehicles.listeners in de class VehicleInventoryClick.
*/

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.UUID;

public class VehicleInventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getInventory().getName().equalsIgnoreCase("§6Kies een §evoertuig§6.")){
            // Setup item and data
            ItemStack item = e.getCurrentItem();
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(meta.getDisplayName());
            meta.setLore(Arrays.asList(" ", "§6Voertuig ID: §e" + UUID.randomUUID().toString()));
            item.setItemMeta(meta);

            // Finish event and give item to the player.
            e.getWhoClicked().getInventory().addItem(item);
            e.getWhoClicked().closeInventory();

            // Cancel the click
            e.setCancelled(true);
        }
    }


}


