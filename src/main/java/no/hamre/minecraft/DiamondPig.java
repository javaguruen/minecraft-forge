package no.hamre.minecraft;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class DiamondPig {

	@SubscribeEvent
	public void sendMessage(LivingDeathEvent event) {
		if (!(event.entity instanceof EntityPig)) {
			return;
		}
		if (!event.entity.worldObj.isRemote) {
			event.entity.dropItem(Items.diamond, 2);
			event.entity.dropItem(Items.stick, 1);

			EntityDragon dragon = new EntityDragon(event.entity.worldObj);
			dragon.setLocationAndAngles(event.entity.posX, event.entity.posY, event.entity.posZ, 0, 0);
			event.entity.worldObj.spawnEntityInWorld(dragon);
		}
	}


}


