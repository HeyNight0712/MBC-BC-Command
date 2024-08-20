package Heyblock0712.mbc.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class Title {

    public static TextComponent title() {
        TextComponent message = new TextComponent("【");
        message.setColor(ChatColor.GRAY);

        TextComponent mbcPart = new TextComponent("MBC");
        mbcPart.setColor(ChatColor.AQUA);

        TextComponent endBracket = new TextComponent("】");
        endBracket.setColor(ChatColor.GRAY);

        message.addExtra(mbcPart);
        mbcPart.addExtra(endBracket);
        return message;
    }

    public static TextComponent title(TextComponent message) {
        TextComponent MessageComponent = title();
        MessageComponent.addExtra(message);
        return MessageComponent;
    }
}
