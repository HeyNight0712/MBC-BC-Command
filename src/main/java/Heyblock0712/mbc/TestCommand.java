package Heyblock0712.mbc;

import Heyblock0712.mbc.command.CommandOption;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;

public class TestCommand extends CommandOption {
    public TestCommand() {
        super("test", "測試");
    }


    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        commandSender.sendMessage(new TextComponent("測試成功"));
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender commandSender, String[] strings) {
        return null;
    }
}
