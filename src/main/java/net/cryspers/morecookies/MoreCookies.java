package net.cryspers.morecookies;

import net.cryspers.morecookies.items.Cookie;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreCookies implements ModInitializer {
	public static final String MODID = "morecookies";

	public static final Cookie PURPLE_COOKIE = new Cookie(new FabricItemSettings(), 2);
	public static final Cookie GREEN_COOKIE = new Cookie(new FabricItemSettings(), 3);

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "purple_cookie"), PURPLE_COOKIE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "green_cookie"), GREEN_COOKIE);
	}
}
