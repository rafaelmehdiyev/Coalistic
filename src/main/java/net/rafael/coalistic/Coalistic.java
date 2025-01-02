package net.rafael.coalistic;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.util.Identifier;
import net.rafael.coalistic.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coalistic implements ModInitializer {
	public static final String MOD_ID = "coalistic";
	public static Identifier MOD_IDENTIFIER (String path){
		return Identifier.of(MOD_ID, path);
	}
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		FuelRegistry.INSTANCE.add(ModItems.COAL_PIECE, 200);
		FuelRegistry.INSTANCE.add(ModItems.DOUBLE_COAL, 3200);
		FuelRegistry.INSTANCE.add(ModItems.DOUBLE_CHARCOAL, 3200);
	}
}