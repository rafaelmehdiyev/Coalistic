package net.rafael.coalistic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.rafael.coalistic.Coalistic;

public class ModItems {

    public static final Item COAL_PIECE = registerItem("coal_piece", new Item(new Item.Settings()));
    public static final Item DOUBLE_COAL = registerItem("double_coal", new Item(new Item.Settings()));
    public static final Item DOUBLE_CHARCOAL = registerItem("double_charcoal", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Coalistic.MOD_IDENTIFIER(name), item);
    }
    public static void registerModItems() {
        Coalistic.LOGGER.info("Registering Mod Items for "+Coalistic.MOD_ID );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(DOUBLE_COAL);
            entries.add(DOUBLE_CHARCOAL);
            entries.add(COAL_PIECE);
        });
    }
}
