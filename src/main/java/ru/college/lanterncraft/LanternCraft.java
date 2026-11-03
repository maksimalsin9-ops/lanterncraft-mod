package ru.college.lanterncraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LanternCraft implements ModInitializer {
	public static final String MOD_ID = "lanterncraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("LanternCraft успешно инициализирован!");
		ModBlocks.initialize();

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			BlockPos pos = hitResult.getBlockPos();
			if (!world.isClient() && world.getBlockState(pos).isOf(ModBlocks.CHINESE_LANTERN)) {
				world.playSound(null, pos, SoundEvents.BLOCK_BELL_USE, SoundCategory.BLOCKS, 1.0F, 1.2F);
				if (world instanceof ServerWorld serverWorld) {
					serverWorld.spawnParticles(ParticleTypes.FIREWORK,
							pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
							15, 0.3, 0.3, 0.3, 0.05);
				}
				return ActionResult.SUCCESS;
			}
			return ActionResult.PASS;
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}