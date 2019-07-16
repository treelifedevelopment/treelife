package me.Maiky1304.treelife.modules.vehicles.commands;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.vehicles.commands in de class VehicleAdminCommand.
*/

import me.Maiky1304.treelife.modules.interfaces.CommandModule;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VehicleAdminCommand extends CommandModule {

    public VehicleAdminCommand(){
        super("vehicleadmin", "treelife.moderation.vehicle");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            if (args.length == 0){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6&m-----------[&r&eVehicles&6&m]-----------"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6/&evehicleadmin create &6- &eOpent een menu en dan kun je een &6vehicle &espawnen."));
                player.sendMessage(" ");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6/&evehicleadmin remove &6- &eVerwijderd het voertuig waar je naartoe kijkt permanent."));
                player.sendMessage(" ");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6/&evehicleadmin reload &6- &eHerlaad de modellen van de voertuigen."));
            }else if (args.length == 1){
                switch (args[0]){
                    case "create" :
                        Inventory inventory = Bukkit.createInventory(null, 6*9, "§6Kies een §evoertuig§6.");

                        ItemStack item = new ItemStack(Material.DIAMOND_HOE, 1, (short)1002);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("Blauwe Auto");
                        meta.setUnbreakable(true);
                        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                        item.setItemMeta(meta);

                        inventory.addItem(item);

                        //Rode auto

                        ItemStack item2 = new ItemStack(Material.DIAMOND_HOE, 1, (short)1017);
                        ItemMeta meta2 = item2.getItemMeta();
                        meta2.setDisplayName("Rode Auto");
                        meta2.setUnbreakable(true);
                        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                        item2.setItemMeta(meta2);

                        inventory.addItem(item2);
                        player.openInventory(inventory);
                        break;
                }
                return true;
            }
        }
        return false;
    }
}
