package me.Maiky1304.treelife.modules.interfaces;

import me.Maiky1304.treelife.main.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandModule {

    private String permission = null;
    private String command;

    private List<String> aliases = new ArrayList<>();

    public CommandModule(String command){
        this.command = command;
    }

    public CommandModule(String command, String permission){
        this(command);

        this.permission = permission;
    }

    public void addAlias(String alias){
        if (!this.aliases.contains(alias)){
            this.aliases.add(alias);
        }
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getCommand() {
        return this.command;
    }

    public abstract boolean execute(CommandSender sender, String[] args);
}
