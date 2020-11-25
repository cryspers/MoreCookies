package net.cryspers.morecookies.mixin;

import net.cryspers.morecookies.items.Cookie;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public class VanillaCookieMixin {
    @SuppressWarnings("UnresolvedMixinReference")
    @ModifyArg(method = "<clinit>",
        slice = @Slice(
                from = @At(
                        value = "CONSTANT",
                        args = "stringValue=cookie"
                )
        ),
        at = @At(
                value= "INVOKE",
                target = "Lnet/minecraft/item/Item;<init>(Lnet/minecraft/item/Item$Settings;)V",
                ordinal = 0
        )
    )
    private static Item.Settings adjustItemSettings(Item.Settings settings) {
        return settings.rarity(Rarity.EPIC);
    }
}
