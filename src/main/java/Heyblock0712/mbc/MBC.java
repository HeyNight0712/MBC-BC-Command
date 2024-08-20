package Heyblock0712.mbc;

import Heyblock0712.mbc.command.CommandManager;
import Heyblock0712.mbc.command.MBCCommand;
import net.md_5.bungee.api.plugin.Plugin;

public final class MBC extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getProxy().getPluginManager().registerCommand(this, new MBCCommand());

        CommandManager.putCommandOption(new TestCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
