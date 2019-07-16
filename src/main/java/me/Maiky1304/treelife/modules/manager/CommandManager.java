package me.Maiky1304.treelife.modules.manager;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.manager in de class CommandManager.
*/

import me.Maiky1304.treelife.main.Main;
import me.Maiky1304.treelife.modules.interfaces.CommandModule;
import me.Maiky1304.treelife.modules.interfaces.MinetopiaCommand;
import me.Maiky1304.treelife.modules.interfaces.MinetopiaModule;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CommandManager implements CommandExecutor, MinetopiaCommand {

    private final HashMap<String, CommandModule> commands = new HashMap<>();

    @Override
    public void register(String command, CommandModule module) {
        commands.put(command.toLowerCase(), module);

        Main main = Main.getPlugin(Main.class);
        main.getCommand(command).setExecutor(this);
        main.getCommand(command).setAliases(module.getAliases());

        Bukkit.getLogger().info("[Loaded] /" + command + " (Executor: " + module + ")");
    }

    @Override
    public void unregister(String command) {
        if (commands.containsKey(command)){
            commands.remove(command);

            Main main = Main.getPlugin(Main.class);
            main.getCommand(command).setExecutor(null);
            main.getCommand(command).setAliases(null);

            Bukkit.getLogger().info("[Unloaded] /" + command + " (Executor: " + commands.get(command) + ")");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (commands.containsKey(command.getName())){
            if (commands.get(command.getName()).getPermission() == null){
                return commands.get(command.getName()).execute(sender, args);
            }else{
                if (sender.hasPermission(commands.get(command.getName()).getPermission())){
                    return commands.get(command.getName()).execute(sender, args);
                }else{
                    sender.sendMessage(ChatColor.RED + "Je hebt geen permissies om dit commando uit te voeren.");
                    return true;
                }
            }
        }
        return false;
    }
}
