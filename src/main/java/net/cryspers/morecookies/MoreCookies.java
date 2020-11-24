package net.cryspers.morecookies;

import net.cryspers.morecookies.items.Cookie;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.lwjgl.system.CallbackI;


public class MoreCookies implements ModInitializer {
	public static final String MODID = "morecookies";

	public static final Cookie PURPLE_COOKIE = new Cookie(new FabricItemSettings(), 2);
	public static final Cookie GREEN_COOKIE = new Cookie(new FabricItemSettings(), 3);
<<<<<<< HEAD
	public static final Cookie YELLOW_COOKIE = new Cookie(new FabricItemSettings(), -1);
=======
	public static final Cookie BLUE_COOKIE = new Cookie(new FabricItemSettings(), 3);
>>>>>>> d6e06eec684f5377e9af97768f5c36eab42b43a2

	@Override
	public void onInitialize() {
		registerItems();
	}

	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "purple_cookie"), PURPLE_COOKIE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "green_cookie"), GREEN_COOKIE);
<<<<<<< HEAD
		Registry.register(Registry.ITEM, new Identifier(MODID, "yellow_cookie"), YELLOW_COOKIE);
=======
		Registry.register(Registry.ITEM, new Identifier(MODID, "blue_cookie"), BLUE_COOKIE);
>>>>>>> d6e06eec684f5377e9af97768f5c36eab42b43a2
	}

	public static String createItemModelJson(String id, String type) {
		if ("generated".equals(type) || "handheld".equals(type)) {
			//The two types of items. "handheld" is used mostly for tools and the like, while "generated" is used for everything else.
			return "{\n" +
					"  \"parent\": \"item/" + type + "\",\n" +
					"  \"textures\": {\n" +
					"    \"layer0\": \"morecookies:" + id + "\"\n" +
					"  }\n" +
					"}";
		} else if ("block".equals(type)) {
			//However, if the item is a block-item, it will have a different model json than the previous two.
			return "{\n" +
					"  \"parent\": \"morecookies:" + id + "\"\n"
					+"}";
		}
		else {
			//If the type is invalid, return an empty json string.
			return "";
		}
	}
}
