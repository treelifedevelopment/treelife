package me.Maiky1304.treelife.modules.vehicles;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.vehicles in de class VehicleModule.
*/

import me.Maiky1304.treelife.main.Main;
import me.Maiky1304.treelife.modules.interfaces.MinetopiaModule;
import me.Maiky1304.treelife.modules.manager.CommandManager;
import me.Maiky1304.treelife.modules.vehicles.commands.VehicleAdminCommand;
import me.Maiky1304.treelife.modules.vehicles.commands.VehicleCommand;
import me.Maiky1304.treelife.modules.vehicles.listeners.VehicleInteractEvent;
import me.Maiky1304.treelife.modules.vehicles.listeners.VehicleInventoryClick;
import me.Maiky1304.treelife.modules.vehicles.listeners.VehiclePlaceEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class VehicleModule implements MinetopiaModule {

    private Main plugin = Main.getPlugin(Main.class);

    public VehicleModule(){
    }

    @Override
    public void start() {
        // Events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new VehicleInteractEvent(), plugin);
        pm.registerEvents(new VehicleInventoryClick(), plugin);
        pm.registerEvents(new VehiclePlaceEvent(), plugin);

        // Commands
        VehicleCommand vehiclesCommand = new VehicleCommand();
        VehicleAdminCommand vehiclesAdminCommand = new VehicleAdminCommand();

        CommandManager manager = new CommandManager();
        manager.register(vehiclesCommand.getCommand(), vehiclesCommand);
        manager.register(vehiclesAdminCommand.getCommand(), vehiclesAdminCommand);
    }

    @Override
    public void stop() {
        //TODO: Save vehicles
    }
}
