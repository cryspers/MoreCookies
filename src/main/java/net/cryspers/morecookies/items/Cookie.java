package net.cryspers.morecookies.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Cookie extends Item {
    public Cookie(Settings settings, int setHunger) {
        super(settings
                .group(ItemGroup.FOOD)
                .food(new FoodComponent.Builder().hunger(setHunger).alwaysEdible().build())
        );
    }
}
