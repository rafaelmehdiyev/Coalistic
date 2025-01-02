package net.rafael.coalistic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.rafael.coalistic.Coalistic;
import net.rafael.coalistic.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {

                createShapeless(RecipeCategory.MISC, ModItems.COAL_PIECE, 8)
                        .input(Items.COAL)  // You can use Coal
                        .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                        .offerTo(recipeExporter);

                createShapeless(RecipeCategory.MISC, ModItems.COAL_PIECE, 8)
                        .input(Items.CHARCOAL)  // Or you can use Charcoal
                        .criterion(hasItem(Items.CHARCOAL), conditionsFromItem(Items.CHARCOAL))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE, Coalistic.MOD_IDENTIFIER("coal_piece_from_charcoal")));

                createShaped(RecipeCategory.MISC, ModItems.DOUBLE_COAL,1)
                        .pattern("CCC")
                        .pattern("CPC")
                        .pattern("CCC")
                        .input('P',Items.COAL)
                        .input('C',ModItems.COAL_PIECE)
                        .criterion(hasItem(Items.COAL),conditionsFromItem(Items.COAL))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.DOUBLE_CHARCOAL,1)
                        .pattern("CCC")
                        .pattern("CPC")
                        .pattern("CCC")
                        .input('P',Items.CHARCOAL)
                        .input('C',ModItems.COAL_PIECE)
                        .criterion(hasItem(Items.CHARCOAL),conditionsFromItem(Items.CHARCOAL))
                        .offerTo(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Coalistic Recipes";
    }
}