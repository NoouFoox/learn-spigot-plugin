package fun.servertest;

import fun.servertest.enums.TextColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyListener implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String msg = ServerTest.main.getConfig().getString("joinMessage");
//        String msg2 = ServerTest.main.getConfig().getString("key4.key1");
        if (msg != null) {
            event.setJoinMessage(msg.replace("%player%",player.getName()));
        }
    }

    @EventHandler
    public void click(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (event.getView().getTitle().equals("城镇列表") && event.getRawSlot() == 0) {
            ItemStack itemStack = new ItemStack(Material.RED_BANNER,1);
            ItemMeta itemMeta = itemStack.getItemMeta();
//            alt+167
            if (itemMeta != null) {
                itemMeta.setDisplayName("§3测试");
                List<String> lore = new ArrayList<>();
                lore.add("道具介绍");
                lore.add("§1哈哈哈");
                itemMeta.setLore(lore);
            }
            itemStack.setItemMeta(itemMeta);
            Player player = (Player) event.getWhoClicked();
            player.getInventory().addItem(itemStack);
//            取消默认事件
            event.setCancelled(true);
            player.sendMessage("§e发送成功");
            event.getView().close();
        }
    }
}
