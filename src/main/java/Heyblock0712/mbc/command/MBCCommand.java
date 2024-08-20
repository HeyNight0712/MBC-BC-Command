package Heyblock0712.mbc.command;

import Heyblock0712.mbc.MBC;
import Heyblock0712.mbc.utils.Title;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MBCCommand extends Command implements TabExecutor {
    public MBCCommand() {
        super("mbc");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        TextComponent message;
        if (!commandSender.hasPermission("mbc.command")) {
            message = new TextComponent("你沒有權限");
            message.setColor(ChatColor.RED);
            commandSender.sendMessage(Title.title(message));
            return;
        }

        if (strings.length < 1) {
            message = buildCommandOptionsMessage(getName(), MBC.getCommandManager().getCommandOptionMBC().values().iterator());
            commandSender.sendMessage(message);
            return;
        }

        String Option = strings[0];
        CommandOption commandOption = MBC.getCommandManager().getCommandOptionMBC(Option);
        if (commandOption == null) {
            message = new TextComponent("沒有這指令");
            message.setColor(ChatColor.RED);
            commandSender.sendMessage(message);
            return;
        }

        String Permission = commandOption.getPermission();
        if (Permission != null && !commandSender.hasPermission(Permission)) {
            message = new TextComponent("你沒有權限");
            message.setColor(ChatColor.RED);
            commandSender.sendMessage(Title.title(message));
            return;
        }

        commandOption.execute(commandSender, strings); // 啟用功能
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender commandSender, String[] strings) {
        List<String> tabComplete = new ArrayList<>();

        if (strings.length == 1) {
            String currentInput = strings[0].toLowerCase();
            List<String> allOptions = MBC.getCommandManager().getCommandOptionMBCName();

            for (String optionName : allOptions) {
                CommandOption option = MBC.getCommandManager().getCommandOptionMBC(optionName);

                // 權限判定
                if (option.getPermission() != null && !commandSender.hasPermission(option.getPermission())) continue;

                // 補全 寫入
                if (optionName.toLowerCase().startsWith(currentInput)) {
                    tabComplete.add(optionName);
                }
            }
            return tabComplete;
        }

        String Option = strings[0];
        CommandOption commandOption = MBC.getCommandManager().getCommandOptionMBC(Option);
        if (commandOption == null) {
            return tabComplete;
        }

        return commandOption.onTabComplete(commandSender, strings);
    }

    public static TextComponent buildCommandOptionsMessage(String name, Iterator<CommandOption> iterator) {
        TextComponent message = new TextComponent(name + " 幫助指令一覽: ");
        message.setColor(ChatColor.GOLD);
        message.addExtra("\n");

        while (iterator.hasNext()) {
            CommandOption option = iterator.next();

            TextComponent Name = new TextComponent(option.getName());
            Name.setColor(ChatColor.WHITE);

            TextComponent Divider = new TextComponent(" - ");
            Divider.setColor(ChatColor.DARK_GRAY);

            TextComponent Description = new TextComponent(option.getDescription());
            Description.setColor(ChatColor.GRAY);

            message.addExtra(Name);
            message.addExtra(Divider);
            message.addExtra(Description);

            if (iterator.hasNext()) {
                message.addExtra("\n");
            }
        }

        return message;
    }
}
