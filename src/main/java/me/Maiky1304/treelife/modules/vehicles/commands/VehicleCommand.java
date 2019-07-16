package me.Maiky1304.treelife.modules.vehicles.commands;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.vehicles.commands in de class VehicleCommand.
*/

import me.Maiky1304.treelife.modules.interfaces.CommandModule;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VehicleCommand extends CommandModule {

    public VehicleCommand(){
        super("vehicle", "treelife.command.vehicle");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;

            if (args.length == 0){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6&m-----------[&r&eVehicles&6&m]-----------"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6/&evehicle info &6- &eGeeft informatie over het voertuig waar je staat."));
                player.sendMessage(" ");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6/&evehicle addmember &6- &eVoegt een speler toe aan je voertuig."));
                player.sendMessage(" ");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6/&evehicle removemember &6- &eVerwijderd een speler van je voertuig."));
                return true;
            }
        }
        return false;
    }

}
