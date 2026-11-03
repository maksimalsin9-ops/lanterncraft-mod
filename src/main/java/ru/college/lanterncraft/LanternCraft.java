package ru.college.lanterncraft;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LanternCraft implements ModInitializer {
	public static final String MOD_ID = "lanterncraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("LanternCraft успешно загружен!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}