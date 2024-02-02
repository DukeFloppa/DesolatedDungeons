package dukefloppa.desolateddungeons.datagen;

import dukefloppa.desolateddungeons.block.ModBlocks;
import dukefloppa.desolateddungeons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }
    public RecipeExporter exporter;

    @Override
    public void generate(RecipeExporter exporter) {
        this.exporter = exporter;
        generateCombat();
        generateBuildingBlocks();
    }

    public void generateCombat() {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.KHOPESH_HANDLE)
                .pattern(" g")
                .pattern("g ")
                .input('g', Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WOODEN_KHOPESH)
                .pattern("  m")
                .pattern(" mm")
                .pattern("h  ")
                .input('h', Items.STICK)
                .input('m', ItemTags.PLANKS)
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STONE_KHOPESH)
                .pattern("  m")
                .pattern(" mm")
                .pattern("h  ")
                .input('h', Items.STICK)
                .input('m', ItemTags.STONE_CRAFTING_MATERIALS)
                .criterion(FabricRecipeProvider.hasItem(Items.COBBLESTONE),
                        FabricRecipeProvider.conditionsFromTag(ItemTags.STONE_CRAFTING_MATERIALS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.IRON_KHOPESH)
                .pattern("  m")
                .pattern(" mm")
                .pattern("h  ")
                .input('h', ModItems.KHOPESH_HANDLE)
                .input('m', Items.IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GOLDEN_KHOPESH)
                .pattern("  m")
                .pattern(" mm")
                .pattern("h  ")
                .input('h', ModItems.KHOPESH_HANDLE)
                .input('m', Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DIAMOND_KHOPESH)
                .pattern("  m")
                .pattern(" mm")
                .pattern("h  ")
                .input('h', ModItems.KHOPESH_HANDLE)
                .input('m', Items.DIAMOND)
                .criterion(FabricRecipeProvider.hasItem(Items.DIAMOND),
                        FabricRecipeProvider.conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ModItems.DIAMOND_KHOPESH), Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ModItems.NETHERITE_KHOPESH)
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, "desolated_dungeons:netherite_khopesh");
    }

    public void generateBuildingBlocks() {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICKS, 4)
                .pattern("xx")
                .pattern("xx")
                .input('x', Blocks.SANDSTONE)
                .criterion(FabricRecipeProvider.hasItem(Blocks.SANDSTONE),
                        FabricRecipeProvider.conditionsFromItem(Blocks.SANDSTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICKS, Blocks.SANDSTONE);

        createStairsRecipe(ModBlocks.SANDSTONE_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.SANDSTONE_BRICKS))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SANDSTONE_BRICKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SANDSTONE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_STAIRS, ModBlocks.SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_STAIRS, Blocks.SANDSTONE);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_SLAB, Ingredient.ofItems(ModBlocks.SANDSTONE_BRICKS))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SANDSTONE_BRICKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SANDSTONE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_SLAB, ModBlocks.SANDSTONE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_SLAB, Blocks.SANDSTONE, 2);

        getWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_WALL, Ingredient.ofItems(ModBlocks.SANDSTONE_BRICKS))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SANDSTONE_BRICKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SANDSTONE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_WALL, ModBlocks.SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_WALL, Blocks.SANDSTONE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LATERITE_BRICKS, 4)
                .pattern("xx")
                .pattern("xx")
                .input('x', ModBlocks.LATERITE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LATERITE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.LATERITE))
                .offerTo(exporter);

        createStairsRecipe(ModBlocks.LATERITE_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.LATERITE_BRICKS))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LATERITE_BRICKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.LATERITE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LATERITE_BRICK_STAIRS, ModBlocks.LATERITE_BRICKS);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LATERITE_BRICK_SLAB, Ingredient.ofItems(ModBlocks.LATERITE_BRICKS))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LATERITE_BRICKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.LATERITE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LATERITE_BRICK_SLAB, ModBlocks.LATERITE_BRICKS, 2);

        getWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LATERITE_BRICK_WALL, Ingredient.ofItems(ModBlocks.LATERITE_BRICKS))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LATERITE_BRICKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.LATERITE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LATERITE_BRICK_WALL, ModBlocks.LATERITE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE, 4)
                .pattern("xx")
                .pattern("xx")
                .input('x', ModBlocks.LIMESTONE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LIMESTONE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.LIMESTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE, ModBlocks.LIMESTONE);

        createStairsRecipe(ModBlocks.POLISHED_LIMESTONE_STAIRS, Ingredient.ofItems(ModBlocks.POLISHED_LIMESTONE))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_LIMESTONE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_LIMESTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_STAIRS, ModBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_STAIRS, ModBlocks.LIMESTONE);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_SLAB, Ingredient.ofItems(ModBlocks.POLISHED_LIMESTONE))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_LIMESTONE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_LIMESTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_SLAB, ModBlocks.POLISHED_LIMESTONE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_SLAB, ModBlocks.LIMESTONE, 2);

        getWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_WALL, Ingredient.ofItems(ModBlocks.POLISHED_LIMESTONE))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_LIMESTONE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_LIMESTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_WALL, ModBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_WALL, ModBlocks.LIMESTONE);
    }
}
