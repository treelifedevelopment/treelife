package me.Maiky1304.treelife.main;

import me.Maiky1304.treelife.modules.manager.ModuleManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    ModuleManager moduleManager;

    @Override
    public void onEnable() {
        moduleManager = new ModuleManager(this);
        moduleManager.startModules();
    }

    @Override
    public void onDisable() {
        if (moduleManager != null){
            moduleManager.stopModules();
        }
    }
}
