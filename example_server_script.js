// priority: 0

ServerEvents.recipes(event => {
  // make item free
  event.recipes.minestuck.grist_cost("minecraft:cobblestone", {});

  // using custom grist types
  event.recipes.minestuck.grist_cost("minestuck:carved_heavy_planks", {
    "minestuck:build": 4,
    "kubejs:lumber": 1000,
  });

  // combination recipes
  event.recipes.minestuck.combination(
    "minestuck:carved_planks",
    "stone_bricks",
    "and",
    "minestuck:carved_heavy_planks"
  );
});

// altering grist drops
MinestuckEvents.gristDrops(event => {
  event.newDrops = GristSet.of(new GristAmount("minestuck:build", 1000));
});

// adding items to the server player deploy list
ServerEvents.loaded(event => {
  DeployList.registerItem("minestuck:carved_heavy_planks", Item.of("minestuck:carved_heavy_planks"), GristSet.of(new GristAmount("minestuck:build", 2)), 0, DeployList.EntryLists.ATHENEUM);
})

// adding a new entry to the StructureBlockRegistry
ServerEvents.loaded(event => {
  StructureBlockRegistry.registerBlock("crafting_table", Block.getBlock("minecraft:crafting_table").defaultBlockState());
})

// giving players grist
ItemEvents.rightClicked("golden_pickaxe", event => {
  event.entity.data.minestuck.addGrist(GristSet.of(new GristAmount("minestuck:gold", 8), new GristAmount("minestuck:rust", 3)));
})