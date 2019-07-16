package me.Maiky1304.treelife.modules.manager;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.manager in de class ModuleManager.
*/

import me.Maiky1304.treelife.main.Main;
import me.Maiky1304.treelife.modules.vehicles.VehicleModule;
import me.Maiky1304.treelife.modules.vehicles.commands.VehicleAdminCommand;
import me.Maiky1304.treelife.modules.vehicles.commands.VehicleCommand;

public class ModuleManager{

    private Main instance;
    public ModuleManager(Main instance){}

    public void startModules(){
        VehicleModule module = new VehicleModule();

        module.start();
    }

    public void stopModules(){
        VehicleModule module = new VehicleModule();

        CommandManager manager = new CommandManager();
        manager.unregister("vehicles");

        module.stop();
    }

}