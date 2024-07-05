package com.havingfunrightnow.kubejsminestuck;

import com.mraof.minestuck.api.alchemy.GristType;
import com.mraof.minestuck.api.alchemy.recipe.combination.CombinationMode;
import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.util.TinyMap;

public class KJSMRecipeSchemas {
    private static final RecipeKey<InputItem> INGREDIENT = ItemComponents.INPUT.key("ingredient");
    private static final RecipeKey<TinyMap<GristType, Long>> GRIST_COSTS = new MapRecipeComponent<>(
            new RegistryComponent<>(KubeJSMinestuckPlugin.GRIST), NumberComponent.ANY_LONG, true
    ).key("grist_cost").allowEmpty();
    private static final RecipeKey<Long> WILDCARD_AMOUNT = NumberComponent.ANY_LONG.key("grist_cost");
    private static final RecipeKey<Integer> PRIORITY = NumberComponent.ANY_INT.key("priority").defaultOptional();

    public static final RecipeSchema GRIST_COST_SCHEMA = new RecipeSchema(INGREDIENT, GRIST_COSTS, PRIORITY).uniqueInputId(INGREDIENT);
    public static final RecipeSchema WILDCARD_GRIST_COST_SCHEMA = new RecipeSchema(INGREDIENT, WILDCARD_AMOUNT, PRIORITY).uniqueInputId(INGREDIENT);
    public static final RecipeSchema UNAVAILABLE_GRIST_COST_SCHEMA = new RecipeSchema(INGREDIENT, PRIORITY).uniqueInputId(INGREDIENT);

    private static final RecipeKey<InputItem> INPUT1 = ItemComponents.INPUT.key("input1");
    private static final RecipeKey<InputItem> INPUT2 = ItemComponents.INPUT.key("input2");
    private static final RecipeKey<CombinationMode> MODE = new EnumComponent<>(
            CombinationMode.class, CombinationMode::asString, (c, s) -> CombinationMode.fromString(s)
    ).key("mode");
    private static final RecipeKey<OutputItem> OUTPUT = ItemComponents.OUTPUT.key("output");

    public static final RecipeSchema COMBINATION_SCHEMA = new RecipeSchema(INPUT1, INPUT2, MODE, OUTPUT);
}
