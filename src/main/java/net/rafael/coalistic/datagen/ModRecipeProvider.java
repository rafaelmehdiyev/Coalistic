package net.rafael.coalistic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.rafael.coalistic.Coalistic;
import net.rafael.coalistic.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COAL_PIECE, 8)
                .input(Items.COAL)  // You can use Coal
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COAL_PIECE, 8)
                .input(Items.CHARCOAL)  // Or you can use Charcoal
                .criterion(hasItem(Items.CHARCOAL), conditionsFromItem(Items.CHARCOAL))
                .offerTo(recipeExporter, Coalistic.MOD_IDENTIFIER("coal_piece_from_charcoal"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOUBLE_COAL,1)
                .pattern("CCC")
                .pattern("CPC")
                .pattern("CCC")
                .input('P',Items.COAL)
                .input('C',ModItems.COAL_PIECE)
                .criterion(hasItem(Items.COAL),conditionsFromItem(Items.COAL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOUBLE_CHARCOAL,1)
                .pattern("CCC")
                .pattern("CPC")
                .pattern("CCC")
                .input('P',Items.CHARCOAL)
                .input('C',ModItems.COAL_PIECE)
                .criterion(hasItem(Items.CHARCOAL),conditionsFromItem(Items.CHARCOAL))
                .offerTo(recipeExporter);
    }
}
