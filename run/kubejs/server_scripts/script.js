// priority: 0

ServerEvents.recipes(event => {
  // make item free
  event.recipes.minestuck.grist_cost("minecraft:cobblestone", {});

  // using custom grist types
  event.recipes.minestuck.grist_cost("minestuck:carved_heavy_planks", {
    "minestuck:build": 4,
    "kubejs:lumber": 1000,
  });

  event.recipes.minestuck.combination(
    "minestuck:carved_planks",
    "stone_bricks",
    "and",
    "minestuck:carved_heavy_planks"
  );
});

MinestuckEvents.gristDrops(event => {
  event.newDrops = GristSet.of(new GristAmount("minestuck:build", 1000));
});

ServerEvents.loaded(event => {
  DeployList.registerItem("minestuck:carved_heavy_planks", Item.of("minestuck:carved_heavy_planks"), GristSet.of(new GristAmount("minestuck:build", 2)), 0, DeployList.EntryLists.ATHENEUM);
})