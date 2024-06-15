package fun.servertest.enchant;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class CustomEnchantmentWrapper extends Enchantment {
    private final NamespacedKey key;

    public CustomEnchantmentWrapper(NamespacedKey key){
        super();
        this.key = key;
    }

    @Override
    public String getName() {
        return "Custom Enchantment";
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ALL;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public String getTranslationKey() {
        return key.getKey();
    }
}