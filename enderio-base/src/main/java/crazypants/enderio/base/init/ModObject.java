package crazypants.enderio.base.init;

import java.util.function.BiFunction;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.enderio.core.common.util.NullHelper;

import crazypants.enderio.api.IModObject;
import crazypants.enderio.api.IModTileEntity;
import crazypants.enderio.base.block.charge.BlockConcussionCharge;
import crazypants.enderio.base.block.charge.BlockConfusionCharge;
import crazypants.enderio.base.block.charge.BlockEnderCharge;
import crazypants.enderio.base.block.coldfire.BlockColdFire;
import crazypants.enderio.base.block.darksteel.anvil.BlockBlackPaperAnvil;
import crazypants.enderio.base.block.darksteel.anvil.BlockBrokenAnvil;
import crazypants.enderio.base.block.darksteel.anvil.BlockDarkSteelAnvil;
import crazypants.enderio.base.block.darksteel.bars.BlockDarkIronBars;
import crazypants.enderio.base.block.darksteel.bars.BlockEndIronBars;
import crazypants.enderio.base.block.darksteel.door.BlockDarkSteelDoor;
import crazypants.enderio.base.block.darksteel.ladder.BlockDarkSteelLadder;
import crazypants.enderio.base.block.darksteel.obsidian.BlockReinforcedObsidian;
import crazypants.enderio.base.block.darksteel.trapdoor.BlockDarkSteelTrapDoor;
import crazypants.enderio.base.block.decoration.BlockDecoration;
import crazypants.enderio.base.block.decoration.BlockDecorationFacing;
import crazypants.enderio.base.block.detector.BlockDetector;
import crazypants.enderio.base.block.holy.BlockHolyFog;
import crazypants.enderio.base.block.infinity.BlockInfinity;
import crazypants.enderio.base.block.infinity.BlockInfinityFog;
import crazypants.enderio.base.block.insulation.BlockIndustrialInsulation;
import crazypants.enderio.base.block.lever.BlockSelfResettingLever;
import crazypants.enderio.base.block.painted.BlockPaintedCarpet;
import crazypants.enderio.base.block.painted.BlockPaintedDoor;
import crazypants.enderio.base.block.painted.BlockPaintedFence;
import crazypants.enderio.base.block.painted.BlockPaintedFenceGate;
import crazypants.enderio.base.block.painted.BlockPaintedGlowstone;
import crazypants.enderio.base.block.painted.BlockPaintedPressurePlate;
import crazypants.enderio.base.block.painted.BlockPaintedRedstone;
import crazypants.enderio.base.block.painted.BlockPaintedReinforcedObsidian;
import crazypants.enderio.base.block.painted.BlockPaintedSlabManager;
import crazypants.enderio.base.block.painted.BlockPaintedStairs;
import crazypants.enderio.base.block.painted.BlockPaintedStone;
import crazypants.enderio.base.block.painted.BlockPaintedTrapDoor;
import crazypants.enderio.base.block.painted.BlockPaintedWall;
import crazypants.enderio.base.block.painted.BlockPaintedWorkbench;
import crazypants.enderio.base.block.rail.BlockExitRail;
import crazypants.enderio.base.block.skull.BlockEndermanSkull;
import crazypants.enderio.base.capacitor.ItemCapacitor;
import crazypants.enderio.base.conduit.facade.ItemConduitFacade;
import crazypants.enderio.base.filter.fluid.items.ItemFluidFilter;
import crazypants.enderio.base.filter.item.items.ItemBasicItemFilter;
import crazypants.enderio.base.filter.item.items.ItemEnchantmentFilter;
import crazypants.enderio.base.filter.item.items.ItemExistingItemFilter;
import crazypants.enderio.base.filter.item.items.ItemModItemFilter;
import crazypants.enderio.base.filter.item.items.ItemPowerItemFilter;
import crazypants.enderio.base.filter.item.items.ItemSoulFilter;
import crazypants.enderio.base.filter.redstone.items.ItemBasicOutputSignalFilter;
import crazypants.enderio.base.filter.redstone.items.ItemComparatorInputSignalFilter;
import crazypants.enderio.base.filter.redstone.items.ItemCountingOutputSignalFilter;
import crazypants.enderio.base.filter.redstone.items.ItemInvertingOutputSignalFilter;
import crazypants.enderio.base.filter.redstone.items.ItemTimerInputSignalFilter;
import crazypants.enderio.base.filter.redstone.items.ItemToggleOutputSignalFilter;
import crazypants.enderio.base.item.coldfire.ItemColdFireIgniter;
import crazypants.enderio.base.item.conduitprobe.ItemConduitProbe;
import crazypants.enderio.base.item.coordselector.ItemCoordSelector;
import crazypants.enderio.base.item.coordselector.ItemLocationPrintout;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelArmor;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelAxe;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelBow;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelCrook;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelHand;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelPickaxe;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelShears;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelShield;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelSword;
import crazypants.enderio.base.item.darksteel.ItemDarkSteelTreetap;
import crazypants.enderio.base.item.darksteel.ItemInventoryCharger;
import crazypants.enderio.base.item.eggs.ItemOwlEgg;
import crazypants.enderio.base.item.enderface.ItemEnderface;
import crazypants.enderio.base.item.magnet.ItemMagnet;
import crazypants.enderio.base.item.rodofreturn.ItemRodOfReturn;
import crazypants.enderio.base.item.soulvial.ItemSoulVial;
import crazypants.enderio.base.item.spawner.ItemBrokenSpawner;
import crazypants.enderio.base.item.staffoflevity.ItemStaffOfLevity;
import crazypants.enderio.base.item.travelstaff.ItemTravelStaff;
import crazypants.enderio.base.item.xptransfer.ItemXpTransfer;
import crazypants.enderio.base.item.yetawrench.ItemYetaWrench;
import crazypants.enderio.base.material.alloy.BlockAlloy;
import crazypants.enderio.base.material.alloy.ItemAlloy;
import crazypants.enderio.base.material.alloy.endergy.BlockEndergyAlloy;
import crazypants.enderio.base.material.alloy.endergy.ItemEndergyAlloy;
import crazypants.enderio.base.material.food.ItemEnderFood;
import crazypants.enderio.base.material.glass.BlockFusedQuartz;
import crazypants.enderio.base.material.glass.BlockPaintedFusedQuartz;
import crazypants.enderio.base.material.material.ItemMaterial;
import crazypants.enderio.base.material.upgrades.ItemUpgrades;
import crazypants.enderio.base.render.dummy.BlockMachineBase;
import crazypants.enderio.base.render.dummy.BlockMachineIO;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum ModObject implements IModObjectBase {

  // Dummies
  block_machine_io(BlockMachineIO::create),
  block_machine_base(BlockMachineBase::create),
  itemEnderface(ItemEnderface::create),

  // Conduits
  itemConduitFacade(ItemConduitFacade::create),

  // Materials
  itemBasicCapacitor(ItemCapacitor::create),
  blockAlloy(BlockAlloy::create),
  itemAlloyIngot(ItemAlloy::create),
  itemAlloyNugget(ItemAlloy::create),
  itemAlloyBall(ItemAlloy::create),
  itemMaterial(ItemMaterial::create),

  itemBrokenSpawner(ItemBrokenSpawner::create),
  block_infinity_fog(BlockInfinityFog::create),
  block_infinity(BlockInfinity::create),
  block_holy_fog(BlockHolyFog::create),

  // Blocks
  blockColdFire(BlockColdFire::create),
  blockDarkSteelAnvil(BlockDarkSteelAnvil::create),
  blockBrokenAnvil(BlockBrokenAnvil::create),
  blockDarkPaperAnvil(BlockBlackPaperAnvil::new),
  blockDarkSteelLadder(BlockDarkSteelLadder::create),
  blockDarkIronBars(BlockDarkIronBars::create),
  blockDarkSteelTrapdoor(BlockDarkSteelTrapDoor::create),
  blockDarkSteelDoor(BlockDarkSteelDoor::create),
  blockReinforcedObsidian(BlockReinforcedObsidian::create),
  blockSelfResettingLever5(BlockSelfResettingLever::create5),
  blockSelfResettingLever10(BlockSelfResettingLever::create10),
  blockSelfResettingLever30(BlockSelfResettingLever::create30),
  blockSelfResettingLever60(BlockSelfResettingLever::create60),
  blockSelfResettingLever300(BlockSelfResettingLever::create300),
  blockDecoration1(BlockDecoration::create),
  blockDecoration2(BlockDecorationFacing::create),
  blockDecoration3(BlockDecorationFacing::create2),
  blockIndustrialInsulation(BlockIndustrialInsulation::create),
  blockEndIronBars(BlockEndIronBars::create),

  // Charges
  blockConfusionCharge(BlockConfusionCharge::create),
  blockConcussionCharge(BlockConcussionCharge::create),
  blockEnderCharge(BlockEnderCharge::create),

  // Painter
  blockPaintedFence(BlockPaintedFence::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedStoneFence(BlockPaintedFence::create_stone, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedFenceGate(BlockPaintedFenceGate::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedWall(BlockPaintedWall::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedStair(BlockPaintedStairs::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedStoneStair(BlockPaintedStairs::create_stone, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedSlab(BlockPaintedSlabManager::create_wood, BlockPaintedSlabManager::create_item, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedDoubleSlab(BlockPaintedSlabManager::create_wood_double, (mo, b) -> null, ModTileEntity.TileEntityTwicePaintedBlock),
  blockPaintedStoneSlab(BlockPaintedSlabManager::create_stone, BlockPaintedSlabManager::create_item, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedStoneDoubleSlab(BlockPaintedSlabManager::create_stone_double, null, ModTileEntity.TileEntityTwicePaintedBlock),
  blockPaintedGlowstone(BlockPaintedGlowstone::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedGlowstoneSolid(BlockPaintedGlowstone::create_solid, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedCarpet(BlockPaintedCarpet::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedPressurePlate(BlockPaintedPressurePlate::create, ModTileEntity.TilePaintedPressurePlate),
  blockPaintedRedstone(BlockPaintedRedstone::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedRedstoneSolid(BlockPaintedRedstone::create_solid, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedStone(BlockPaintedStone::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedWoodenTrapdoor(BlockPaintedTrapDoor::create_wooden, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedIronTrapdoor(BlockPaintedTrapDoor::create_iron, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedDarkSteelTrapdoor(BlockPaintedTrapDoor::create_dark, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedWoodenDoor(BlockPaintedDoor::create_wooden, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedIronDoor(BlockPaintedDoor::create_iron, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedDarkSteelDoor(BlockPaintedDoor::create_dark, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedWorkbench(BlockPaintedWorkbench::create, ModTileEntity.TileEntityPaintedBlock),
  blockPaintedReinforcedObsidian(BlockPaintedReinforcedObsidian::create, ModTileEntity.TileEntityPaintedBlock),

  blockExitRail(BlockExitRail::create),

  itemConduitProbe(ItemConduitProbe::create),
  itemYetaWrench(ItemYetaWrench::create),
  itemXpTransfer(ItemXpTransfer::create),
  itemColdFireIgniter(ItemColdFireIgniter::create),

  itemCoordSelector(ItemCoordSelector::create),
  itemLocationPrintout(ItemLocationPrintout::create),
  itemTravelStaff(ItemTravelStaff::create),
  itemRodOfReturn(ItemRodOfReturn::create),
  itemMagnet(ItemMagnet::create),
  blockEndermanSkull(BlockEndermanSkull::create, ModTileEntity.TileEndermanSkull),
  itemEnderFood(ItemEnderFood::create),

  // Filters
  itemBasicItemFilter(ItemBasicItemFilter::createBasicItemFilter),
  itemAdvancedItemFilter(ItemBasicItemFilter::createAdvancedItemFilter),
  itemLimitedItemFilter(ItemBasicItemFilter::createLimitedItemFilter),
  itemBigItemFilter(ItemBasicItemFilter::createBigItemFilter),
  itemBigAdvancedItemFilter(ItemBasicItemFilter::createBigAdvancedItemFilter),
  itemExistingItemFilter(ItemExistingItemFilter::create),
  itemModItemFilter(ItemModItemFilter::create),
  itemPowerItemFilter(ItemPowerItemFilter::create),
  itemSoulFilterNormal(ItemSoulFilter::createNormal),
  itemSoulFilterBig(ItemSoulFilter::createBig),
  itemEnchantmentFilterNormal(ItemEnchantmentFilter::createNormal),
  itemEnchantmentFilterBig(ItemEnchantmentFilter::createBig),

  itemFluidFilter(ItemFluidFilter::create),

  itemRedstoneNotFilter(ItemInvertingOutputSignalFilter::create),
  itemRedstoneOrFilter(ItemBasicOutputSignalFilter::createOr),
  itemRedstoneAndFilter(ItemBasicOutputSignalFilter::createAnd),
  itemRedstoneNorFilter(ItemBasicOutputSignalFilter::createNor),
  itemRedstoneNandFilter(ItemBasicOutputSignalFilter::createNand),
  itemRedstoneXorFilter(ItemBasicOutputSignalFilter::createXor),
  itemRedstoneXnorFilter(ItemBasicOutputSignalFilter::createXnor),
  itemRedstoneToggleFilter(ItemToggleOutputSignalFilter::create),
  itemRedstoneCountingFilter(ItemCountingOutputSignalFilter::create),

  itemRedstoneSensorFilter(ItemComparatorInputSignalFilter::create),
  itemRedstoneTimerFilter(ItemTimerInputSignalFilter::create),

  blockFusedQuartz(BlockFusedQuartz::createFusedQuartz),
  blockFusedGlass(BlockFusedQuartz::createFusedGlass),
  blockEnlightenedFusedQuartz(BlockFusedQuartz::createEnlightenedFusedQuartz),
  blockEnlightenedFusedGlass(BlockFusedQuartz::createEnlightenedFusedGlass),
  blockDarkFusedQuartz(BlockFusedQuartz::createDarkFusedQuartz),
  blockDarkFusedGlass(BlockFusedQuartz::createDarkFusedGlass),
  blockPaintedFusedQuartz(BlockPaintedFusedQuartz::create, ModTileEntity.TileEntityPaintedBlock),

  itemSoulVial(ItemSoulVial::create),

  block_detector_block(BlockDetector::create, ModTileEntity.TileEntityPaintedBlock),
  block_detector_block_silent(BlockDetector::createSilent, ModTileEntity.TileEntityPaintedBlock),

  itemDarkSteelHelmet(ItemDarkSteelArmor::createDarkSteelHelmet),
  itemDarkSteelChestplate(ItemDarkSteelArmor::createDarkSteelChestplate),
  itemDarkSteelLeggings(ItemDarkSteelArmor::createDarkSteelLeggings),
  itemDarkSteelBoots(ItemDarkSteelArmor::createDarkSteelBoots),
  itemDarkSteelShield(ItemDarkSteelShield::createDarkSteel),

  itemDarkSteelSword(ItemDarkSteelSword::createDarkSteel),
  itemDarkSteelPickaxe(ItemDarkSteelPickaxe::createDarkSteel),
  itemDarkSteelAxe(ItemDarkSteelAxe::createDarkSteel),
  itemDarkSteelBow(ItemDarkSteelBow::createDarkSteel),
  itemDarkSteelShears(ItemDarkSteelShears::create),
  itemDarkSteelTreetap(ItemDarkSteelTreetap::create),
  itemDarkSteelCrook(ItemDarkSteelCrook::createDarkSteel),
  itemDarkSteelHand(ItemDarkSteelHand::create),

  itemInventoryChargerSimple(ItemInventoryCharger::createSimple),
  itemInventoryChargerBasic(ItemInventoryCharger::createBasic),
  itemInventoryCharger(ItemInventoryCharger::create),
  itemInventoryChargerVibrant(ItemInventoryCharger::createVibrant),

  itemEndSteelSword(ItemDarkSteelSword::createEndSteel),
  itemEndSteelPickaxe(ItemDarkSteelPickaxe::createEndSteel),
  itemEndSteelAxe(ItemDarkSteelAxe::createEndSteel),
  itemEndSteelBow(ItemDarkSteelBow::createEndSteel),

  itemEndSteelHelmet(ItemDarkSteelArmor::createEndSteelHelmet),
  itemEndSteelChestplate(ItemDarkSteelArmor::createEndSteelChestplate),
  itemEndSteelLeggings(ItemDarkSteelArmor::createEndSteelLeggings),
  itemEndSteelBoots(ItemDarkSteelArmor::createEndSteelBoots),
  itemEndSteelShield(ItemDarkSteelShield::createEndSteel),

  itemStaffOfLevity(ItemStaffOfLevity::create),

  // upgrades
  itemDarkSteelUpgrade(ItemUpgrades::create),

  item_owl_egg(ItemOwlEgg::create),

  // endergy Items
  blockAlloyEndergy(BlockEndergyAlloy::create),
  itemAlloyEndergyIngot(ItemEndergyAlloy::create),
  itemAlloyEndergyNugget(ItemEndergyAlloy::create),
  itemAlloyEndergyBall(ItemEndergyAlloy::create),

  ;

  final @Nonnull String unlocalisedName;

  protected @Nullable Block block;
  protected @Nullable Item item;

  protected final @Nullable IModTileEntity modTileEntity;

  protected final @Nullable Function<IModObject, Block> blockMaker;
  protected final @Nullable BiFunction<IModObject, Block, Item> itemMaker;

  private ModObject(@Nonnull BiFunction<IModObject, Block, Item> itemMaker) {
    this(null, itemMaker, null);
  }

  private ModObject(@Nonnull Function<IModObject, Block> blockMaker) {
    this(blockMaker, null, null);
  }

  private ModObject(@Nonnull Function<IModObject, Block> blockMaker, @Nonnull BiFunction<IModObject, Block, Item> itemMaker) {
    this(blockMaker, itemMaker, null);
  }

  private ModObject(@Nonnull Function<IModObject, Block> blockMaker, @Nonnull IModTileEntity modTileEntity) {
    this(blockMaker, null, modTileEntity);
  }

  private ModObject(@Nullable Function<IModObject, Block> blockMaker, @Nullable BiFunction<IModObject, Block, Item> itemMaker,
      @Nullable IModTileEntity modTileEntity) {
    this.unlocalisedName = ModObjectRegistry.sanitizeName(NullHelper.notnullJ(name(), "Enum.name()"));
    this.blockMaker = blockMaker;
    this.itemMaker = itemMaker;
    if (blockMaker == null && itemMaker == null) {
      throw new RuntimeException(this + " unexpectedly is neither a Block nor an Item.");
    }
    this.modTileEntity = modTileEntity;
  }

  @Override
  public final @Nonnull String getUnlocalisedName() {
    return unlocalisedName;
  }

  @Override
  public final @Nullable Block getBlock() {
    return block;
  }

  @Override
  public final @Nullable Item getItem() {
    return item;
  }

  @Override
  public final @Nullable Class<?> getClazz() {
    return null;
  }

  @Override
  public final String getBlockMethodName() {
    return null;
  }

  @Override
  public final String getItemMethodName() {
    return null;
  }

  @Override
  public final void setItem(@Nullable Item obj) {
    item = obj;
  }

  @Override
  public final void setBlock(@Nullable Block obj) {
    block = obj;
  }

  @Override
  @Nullable
  public IModTileEntity getTileEntity() {
    return modTileEntity;
  }

  @Override
  public @Nonnull Function<IModObject, Block> getBlockCreator() {
    return blockMaker != null ? blockMaker : mo -> null;
  }

  @Override
  public @Nonnull BiFunction<IModObject, Block, Item> getItemCreator() {
    return NullHelper.first(itemMaker, IModObject.WithBlockItem.itemCreator);
  }

}
