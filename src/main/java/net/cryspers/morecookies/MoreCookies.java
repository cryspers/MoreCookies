package net.cryspers.morecookies;

import net.cryspers.morecookies.blocks.CookieBlock;
import net.cryspers.morecookies.items.Cookie;
import net.cryspers.morecookies.materials.CookieToolMaterial;
import net.cryspers.morecookies.tools.CookiePickaxe;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.lang.JLang;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.List;

import static net.devtech.arrp.json.models.JModel.model;
import static net.devtech.arrp.json.models.JModel.textures;

public class MoreCookies implements ModInitializer {
	public static final String MODID = "morecookies";
	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("morecookies:test");

	public static final Cookie PURPLE_COOKIE = new Cookie(new FabricItemSettings(), 2, Rarity.COMMON);
	public static final Cookie GREEN_COOKIE = new Cookie(new FabricItemSettings(), 3, Rarity.COMMON);
	public static final Cookie YELLOW_COOKIE = new Cookie(new FabricItemSettings(), -1, Rarity.COMMON);
	public static final Cookie BLUE_COOKIE = new Cookie(new FabricItemSettings(), 3, Rarity.COMMON);
	public static final Cookie COOKIE_CHIP = new Cookie(new FabricItemSettings().food(new FoodComponent.Builder().snack().build()), 1, Rarity.COMMON);

	public static final CookieBlock PURPLE_COOKIE_BLOCK = new CookieBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT));

	public static ToolItem COOKIE_PICKAXE = new CookiePickaxe(CookieToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings().group(ItemGroup.TOOLS));

	public static List<Cookie> cookieList = Arrays.asList(
			PURPLE_COOKIE,
			GREEN_COOKIE,
			YELLOW_COOKIE,
			BLUE_COOKIE,
			COOKIE_CHIP
	);

	@Override
	public void onInitialize() {
		registerItems();
		registerBlocks();
		setResourcePack();
	}

	public static void registerItems() {
		Registry.register(Registry.ITEM, myId("purple_cookie"), PURPLE_COOKIE);
		Registry.register(Registry.ITEM, myId("green_cookie"), GREEN_COOKIE);
		Registry.register(Registry.ITEM, myId("yellow_cookie"), YELLOW_COOKIE);
		Registry.register(Registry.ITEM, myId("blue_cookie"), BLUE_COOKIE);
		Registry.register(Registry.ITEM, myId("cookie_chip"), COOKIE_CHIP);

		Registry.register(Registry.ITEM, myId("cookie_pickaxe"), COOKIE_PICKAXE);

		Registry.register(Registry.ITEM, myId("purple_cookie_block"), new BlockItem(PURPLE_COOKIE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}

	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, myId("purple_cookie_block"), PURPLE_COOKIE_BLOCK);
	}

	public static void setResourcePack() {

		setResourceModels();
		setResourceRecipes();


		RESOURCE_PACK.addLang(myId("en_us"),
				JLang.lang().item(myId("blue_cookie"),"Blue Cookie")
				);

		RESOURCE_PACK.addLang(myId("en_us"),
				JLang.lang().item(myId("yellow_cookie"),"Yellow Cookie")
		);

		RESOURCE_PACK.addLang(myId("en_us"),
				JLang.lang().item(myId("cookie_chip"),"Cookie Chip")
		);

		RRPCallback.EVENT.register(a -> a.add(RESOURCE_PACK));
	}

	@SuppressWarnings("deprecation")
	public static void setResourceModels() {
		for(Cookie cookie_id : cookieList) {
			RESOURCE_PACK.addModel(model("item/generated").textures(textures().layer0(myId("item/" + cookie_id).toString())), myId("item/" + cookie_id));
		}

		RESOURCE_PACK.addModel(model("item/generated").textures(textures().layer0(myId("item/cookie_pickaxe").toString())), myId("item/cookie_pickaxe"));

		RESOURCE_PACK.addModel(model(myId("block/purple_cookie_block").toString()), myId("item/purple_cookie_block"));

		RESOURCE_PACK.addModel(model("block/cube_all").textures(textures().var("all", myId("block/purple_cookie_block").toString())), myId("block/purple_cookie_block"));

	}

	public static void setResourceRecipes() {
		RESOURCE_PACK.addRecipe(myId("purple_cookie_block"),
				JRecipe.shaped(
						JPattern.pattern().row1("WWW").row2("WWW").row3("WWW"),
						JKeys.keys().key("W", JIngredient.ingredient().item(myId("purple_cookie").toString())),
						JResult.result(myId("purple_cookie_block").toString())
				)
		);

		RESOURCE_PACK.addRecipe(myId("cookie_chip"),
				JRecipe.shapeless(
						JIngredients.ingredients()
								.add(JIngredient.ingredient().item(Items.COOKIE)),
						JResult.stackedResult(myId("cookie_chip").toString(), 9)
				)
		);

		RESOURCE_PACK.addRecipe(myId("minecraft_cookie"),
				JRecipe.shaped(
						JPattern.pattern()
						.row1("WWW")
						.row2("WWW")
						.row3("WWW"),
						JKeys.keys().key("W", JIngredient.ingredient().item(myId("cookie_chip").toString())),
						JResult.item(Items.COOKIE)
				)
		);
	}

	public static Identifier myId(String path) {
		return new Identifier(MODID, path);
	}
}
