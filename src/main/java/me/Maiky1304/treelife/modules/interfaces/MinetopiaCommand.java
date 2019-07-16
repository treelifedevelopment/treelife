package me.Maiky1304.treelife.modules.interfaces;

public interface MinetopiaCommand {

    public void register(String command, CommandModule module);

    public void unregister(String command);

}
