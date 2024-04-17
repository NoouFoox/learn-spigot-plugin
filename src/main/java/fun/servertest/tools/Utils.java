package fun.servertest.tools;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    //    创建标识物品
    public ItemStack createCrateIdentifier(){
        ItemStack item = new ItemStack(Material.RED_BED);
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(MTxt.format("fox"));
        if (itemMeta != null) {
            itemMeta.setDisplayName(MTxt.format("nouFox"));
            itemMeta.setLore(lore);
        }
        return item;
    }
}
