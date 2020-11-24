package net.cryspers.morecookies;

import net.cryspers.morecookies.blocks.CookieBlock;
import net.cryspers.morecookies.items.Cookie;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class MoreCookies implements ModInitializer {
	public static final String MODID = "morecookies";

	public static final Cookie PURPLE_COOKIE = new Cookie(new FabricItemSettings(), 2);
	public static final Cookie GREEN_COOKIE = new Cookie(new FabricItemSettings(), 3);
	public static final Cookie YELLOW_COOKIE = new Cookie(new FabricItemSettings(), -1);
	public static final Cookie BLUE_COOKIE = new Cookie(new FabricItemSettings(), 3);

	public static final CookieBlock PURPLE_COOKIE_BLOCK = new CookieBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT));

	@Override
	public void onInitialize() {
		registerItems();
		registerBlocks();
	}

	public static void registerItems() {
		Registry.register(Registry.ITEM, id("purple_cookie"), PURPLE_COOKIE);
		Registry.register(Registry.ITEM, id("green_cookie"), GREEN_COOKIE);
		Registry.register(Registry.ITEM, id("yellow_cookie"), YELLOW_COOKIE);
		Registry.register(Registry.ITEM, id("blue_cookie"), BLUE_COOKIE);

		Registry.register(Registry.ITEM, id("purple_cookie_block"), new BlockItem(PURPLE_COOKIE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}

	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, id("purple_cookie_block"), PURPLE_COOKIE_BLOCK);
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
