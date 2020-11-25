package net.cryspers.morecookies.blocks;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class CookieBlock extends Block {
    public CookieBlock(Settings settings) {
        super(settings.sounds(BlockSoundGroup.LILY_PAD));
    }
}
