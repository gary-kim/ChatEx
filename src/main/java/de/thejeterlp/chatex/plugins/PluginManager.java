package de.thejeterlp.chatex.plugins;

import de.thejeterlp.chatex.ChatEX;
import de.thejeterlp.chatex.utils.HookManager;
import de.thejeterlp.chatex.utils.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

/**
 * @author TheJeterLP
 */
public class PluginManager implements PermissionsPlugin {

    private static PermissionsPlugin handler;
    private static PluginManager INSTANCE;

    public static PermissionsPlugin getInstance() {
        return INSTANCE;
    }

    public static void load() {
        INSTANCE = new PluginManager();
        if (HookManager.checkPEX()) {
            handler = new PermissionsEx();
        } else if (HookManager.checkVault() && Vault.setupChat()) {
            handler = new Vault();
        } else {
            handler = new Nothing();
        }
        ChatEX.getInstance().getLogger().info("Successfully hooked into: " + handler.getName());
    }
  
    @Override
    public String getName() {
        if (!HookManager.checkPlaceholderAPI()) {
            return handler.getName();
        } else {
            return handler.getName() + ", PlaceholderAPI";
        }
    }

    @Override
    public String getPrefix(Player p) {
        return handler.getPrefix(p);
    }

    @Override
    public String getSuffix(Player p) {
        return handler.getSuffix(p);
    }

    @Override
    public String[] getGroupNames(Player p) {
        return handler.getGroupNames(p);
    }

    @Override
    public String getMessageFormat(Player p) {
        if (!HookManager.checkPlaceholderAPI()) {
            return Utils.replaceColors(handler.getMessageFormat(p));
        } else {
            return Utils.replaceColors(PlaceholderAPI.setPlaceholders(p, handler.getMessageFormat(p)));
        }
    }

    @Override
    public String getGlobalMessageFormat(Player p) {
        if (!HookManager.checkPlaceholderAPI()) {
            return Utils.replaceColors(handler.getGlobalMessageFormat(p));
        } else {
            return Utils.replaceColors(PlaceholderAPI.setPlaceholders(p, handler.getGlobalMessageFormat(p)));
        }
    }
}
