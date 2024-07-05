# KubeJS Minestuck

A small addon for [kubejs](https://www.curseforge.com/minecraft/mc-mods/kubejs) that adds support for [minestuck](https://www.curseforge.com/minecraft/mc-mods/minestuck), including recipes, custom grist types, and Sburb player data.

## Current Features:
- Combination Recipes (totem lathe / punch designix)
    - `combination(input1, input2, mode, output)`
    - inputs and output are all item IDs
    - mode can be "and", "or", or their symbol variants "&&" and "||"
- Grist Cost Recipes
    - `grist_cost(item, {"grist_type": amount, ...}, priority?)`
      - the most common type of grist cost
    - `wildcard_grist_cost(item, amount, priority?)`
      - uses the specified amount of wildcard grist (usually build)
    - `unavailable_grist_cost(item, priority?)`
      - makes an item unable to be alchemized
    - priority: recipes with higher priority take precedence, this is optional and defaults to 100
    - to make an item free, use the normal grist cost type with an empty object as the cost
    - resource locations default to minecraft, so make sure to include `minestuck:` in the id
- Irradiating Recipes (cookalyzer)
    - uses the same syntax as vanilla furnace recipes
- Custom Grist
    - uses the startup event `minestuck.grist`
    - chain up to four methods to modify properties, all optional
    - `rarity(float)`: controls use in world generation
    - `value(float)`: controls strength in alchemy and boondollar costs
    - `underlingType(int color, float power)`: controls color and strength of underlings
      - the colour is most easily written in the format `0xRRGGBB`
    - `candy(item id)`: item representation of the grist
- Minestuck Playerdata
  - use `player.data.minestuck` to access various resources
  - getting can be replaced with just the field name, e.g. `data.minestuck.getColor()` can be written as `data.minestuck.color`
  - setting (single values) can be replaced with assignment, e.g. `data.minestuck.setRung(4)` can be written as `data.minestuck.rung = 4`
  - color: get/set, can only be set before connecting to a server player
  - modus: get
  - boondollars: get/set/add/take
  - title: get/set
  - hero class/aspect: get
  - echeladder rung + progress: get/set, increase progress
  - grist cache
    - use `getGrist()` to get the whole cache
    - use `getGrist(type)` to get the amount stored of a specific type
    - use `addGrist(type, amount)` to add a specific grist type to the cache 
    - use `addGrist(GristSet.of(GristAmount, GristAmount, ...))` to add multiple types to the cache at once