package fun.servertest;

import fun.servertest.tools.MTxt;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1 & args[0].equals("reload")) {
            ServerTest.main.reloadConfig();
        }
        if (args.length == 1 && args[0].equals("help")) {
            player.sendMessage("插件帮助");
            player.sendMessage("/myplugin gm1");
            player.sendMessage("/myplugin reload - 重载插件");
            return false;
        }
        if (args.length == 1 && args[0].equals("open")) {
            Inventory inventory = Bukkit.createInventory(null, 9, "城镇列表");
//            Inventory inventory2 = Bukkit.createInventory(null, InventoryType.WORKBENCH, "我的工作台");
            ItemStack item = new ItemStack(Material.GLOW_BERRIES, 1);
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta != null) {
                itemMeta.setDisplayName(MTxt.format("千金镇"));
            }
            item.setItemMeta(itemMeta);
            player.openInventory(inventory);
            inventory.addItem(item);
        }
        if (args.length == 2 && args[0].equals("gm") && args[1].equals("1")) {
            player.setGameMode(GameMode.CREATIVE);
        }
        return false;
    }
}
