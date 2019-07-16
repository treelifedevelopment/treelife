package me.Maiky1304.treelife.modules.config;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.config.handler in de class ConfigHandler.
*/

import me.Maiky1304.treelife.main.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigHandler {

    private File file;
    private FileConfiguration config;

    private String fileName;
    private Main plugin = Main.getPlugin(Main.class);

    public ConfigHandler(String filename){
        this.plugin = plugin;
        this.fileName = filename;
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig(){
        try {
            config.save ( file );
        } catch (IOException e){
            e.printStackTrace ();
        }
    }

    public void loadConfig() {
        file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource(fileName, false);
        }

        config= new YamlConfiguration();
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
