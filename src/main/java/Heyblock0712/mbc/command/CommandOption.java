package Heyblock0712.mbc.command;

import net.md_5.bungee.api.CommandSender;

public abstract class CommandOption {
    private final String Name;
    private final String Description;
    private String Permission;

    public CommandOption(String name, String description) {
        Name = name;
        Description = description;
    }

    public CommandOption(String name, String description, String permission) {
        Name = name;
        Description = description;
        Permission = permission;
    }

    public String getName() {return Name;}
    public String getDescription() {return Description;}
    public String getPermission() {return Permission;}

    public abstract void execute(CommandSender commandSender, String[] strings);
    public abstract Iterable<String> onTabComplete(CommandSender commandSender, String[] strings);
}
