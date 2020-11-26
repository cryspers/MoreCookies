package net.cryspers.morecookies.tools;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class CookiePickaxe extends PickaxeItem {
    public CookiePickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings.rarity(Rarity.EPIC));
    }
}
