package Heyblock0712.mbc;

import Heyblock0712.mbc.command.CommandManager;
import Heyblock0712.mbc.command.MBCCommand;
import net.md_5.bungee.api.plugin.Plugin;

public final class MBC extends Plugin {
    private static MBC instance;
    private static CommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;
        getProxy().getPluginManager().registerCommand(this, new MBCCommand());

        commandManager = new CommandManager();


    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static MBC getInstance() {return instance;}
    public static CommandManager getCommandManager() {return commandManager;}
}
