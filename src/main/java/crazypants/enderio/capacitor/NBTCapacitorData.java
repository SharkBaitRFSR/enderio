package crazypants.enderio.capacitor;

import javax.annotation.Nonnull;

import crazypants.enderio.EnderIO;
import net.minecraft.nbt.NBTTagCompound;

public class NBTCapacitorData implements ICapacitorData {

  private final @Nonnull String unlocalizedName;
  private final int baselevel;
  private final @Nonnull NBTTagCompound tag;

  public NBTCapacitorData(@Nonnull String unlocalizedName, int baselevel, @Nonnull NBTTagCompound tag) {
    this.unlocalizedName = unlocalizedName;
    this.baselevel = baselevel;
    this.tag = tag;
  }

  @Override
  public @Nonnull String getUnlocalizedName() {
    return unlocalizedName;
  }

  @Override
  public float getUnscaledValue(@Nonnull ICapacitorKey key) {
    if (tag.hasKey(key.getName(), 99)) {
      return tag.getFloat(key.getName());
    }
    if (tag.hasKey(key.getOwner().getUnlocalisedName(), 10)) {
      NBTTagCompound subtag = tag.getCompoundTag(key.getOwner().getUnlocalisedName());
      if (subtag.hasKey(key.getValueType().getName(), 99)) {
        return subtag.getFloat(key.getValueType().getName());
      }
    }
    if (tag.hasKey(key.getValueType().getName(), 99)) {
      return tag.getFloat(key.getValueType().getName());
    }
    return baselevel;
  }

  @Override
  public @Nonnull String getLocalizedName() {
    return EnderIO.lang.localizeExact(unlocalizedName + ".name");
  }

  @Override
  public int getBaseLevel() {
    return baselevel;
  }

}