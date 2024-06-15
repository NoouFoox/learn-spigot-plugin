package fun.servertest.enchant;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import fun.servertest.ServerTest;

import java.lang.reflect.Field;
import java.util.Map;

public class EnchantmentWrapper {
    public static void registerEnchantment(){
        NamespacedKey key = new NamespacedKey(ServerTest.main, "custom_enchantment");
        CustomEnchantmentWrapper enchantment = new CustomEnchantmentWrapper(key);
        try {
            Field byKeyField = Enchantment.class.getDeclaredField("byKey");
            Field byNameField = Enchantment.class.getDeclaredField("byName");

            byKeyField.setAccessible(true);
            byNameField.setAccessible(true);

            Map<NamespacedKey, Enchantment> byKey = (Map<NamespacedKey, Enchantment>) byKeyField.get(null);
            Map<String, Enchantment> byName = (Map<String, Enchantment>) byNameField.get(null);

            if(byKey.containsKey(key)) {
                byKey.remove(key);
            }

            if(byName.containsKey(enchantment.getName())) {
                byName.remove(enchantment.getName());
            }

            byKeyField.set(null, byKey);
            byNameField.set(null, byName);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Field byKeyField = Enchantment.class.getDeclaredField("byKey");
            byKeyField.setAccessible(true);
            ((Map<NamespacedKey, Enchantment>) byKeyField.get(null)).put(key, enchantment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}