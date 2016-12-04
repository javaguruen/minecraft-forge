package no.hamre.minecraft;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TreeSaver {

	public static final int EXPLOSION_RANGE = 2;
	public static final boolean EXPLOSION_DESTROY_BLOCKS = false;

	@SubscribeEvent
	public void sendMessage(BlockEvent.BreakEvent event) {
		if (!event.state.getBlock().getUnlocalizedName().equals("tile.log")) {
			return;
		}
		event.world.createExplosion(
				event.getPlayer(),
				event.pos.getX(), event.pos.getY(),
				event.pos.getZ(),
				EXPLOSION_RANGE,
				EXPLOSION_DESTROY_BLOCKS);
		event.getPlayer().addChatComponentMessage(
				new ChatComponentText(EnumChatFormatting.DARK_GREEN + "Save the forrest"));
		event.setCanceled(true);
	}

}


