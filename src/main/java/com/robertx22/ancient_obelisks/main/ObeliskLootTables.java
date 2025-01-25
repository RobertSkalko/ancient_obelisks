package com.robertx22.ancient_obelisks.main;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ObeliskLootTables {

    public static ResourceLocation LOOT = ObelisksMain.id("obelisk_loot");
  

    public static class ObeliskLootTableProvider implements LootTableSubProvider {

        @Override
        public void generate(BiConsumer<ResourceLocation, LootTable.Builder> output) {

            var essB = LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3, 6))
                            .add(LootItem.lootTableItem(ObeliskEntries.ENVY.get()))
                            .add(LootItem.lootTableItem(ObeliskEntries.WRATH.get()))
                            .add(LootItem.lootTableItem(ObeliskEntries.GREED.get()))
                    ).withPool(
                            LootPool.lootPool().setRolls(UniformGenerator.between(3, 6))
                                    .add(LootItem.lootTableItem(Items.DIAMOND))
                                    .add(LootItem.lootTableItem(Items.GOLD_INGOT))
                                    .add(LootItem.lootTableItem(Items.IRON_INGOT))
                                    .add(LootItem.lootTableItem(Items.LAPIS_LAZULI))
                                    .add(LootItem.lootTableItem(Items.REDSTONE))
                                    .add(LootItem.lootTableItem(Items.COAL))
                                    .add(LootItem.lootTableItem(Items.COPPER_INGOT))
                    );

            output.accept(LOOT, essB);


        }
    }

}
