package me.alien.meksifi.mek.items;
import me.alien.meksifi.mek.Provider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Test extends Item implements {

    public Test() {
        super(new Item.Properties());
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new ItemCapabilityProvider(stack, this) {};
    }
}
