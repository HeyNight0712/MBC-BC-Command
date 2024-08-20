package Heyblock0712.mbc.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {
    private final Map<String, CommandOption> commandOptionMBC = new HashMap<>();

    public void putCommandOption(CommandOption option) {
        commandOptionMBC.put(option.getName(), option);
    }

    public Map<String, CommandOption> getCommandOptionMBC() {
        return commandOptionMBC;
    }

    public List<String> getCommandOptionMBCName() {
        return new ArrayList<>(commandOptionMBC.keySet());
    }

    public CommandOption getCommandOptionMBC(String optionName) {
        return commandOptionMBC.get(optionName);
    }
}
