package fun.servertest;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.Objects;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1 && args[0].equals("help")) {
            player.sendMessage("插件帮助");
            player.sendMessage("/myplugin gm1");
            return false;
        }
        if (args.length == 1 && args[0].equals("open")) {
            Inventory inventory = Bukkit.createInventory(null, 9, "我的箱子");
            Inventory inventory2 = Bukkit.createInventory(null, InventoryType.WORKBENCH, "我的工作台");
            player.openInventory(inventory);
        }
        if (args.length == 2 && args[0].equals("gm") && args[1].equals("1")) {
            player.setGameMode(GameMode.CREATIVE);
        }
        return false;
    }
}
