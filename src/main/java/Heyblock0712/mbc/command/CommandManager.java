package Heyblock0712.mbc.command;

import Heyblock0712.mbc.MBC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {
    private static Map<String, CommandOption> commandOptionMBC = new HashMap<String, CommandOption>();

    public static void putCommandOption(CommandOption option) {
        commandOptionMBC.put(option.getName(), option);
    }

    public static Map<String, CommandOption> getCommandOptionMBC() {
        return commandOptionMBC;
    }

    public static List<String> getCommandOptionMBCName() {
        return new ArrayList<>(commandOptionMBC.keySet());
    }

    public static CommandOption getCommandOptionMBC(String optionName) {
        return commandOptionMBC.get(optionName);
    }
}
