package me.alien.meksifi.mek.items;
import me.alien.meksifi.mek.Energy;
import me.alien.meksifi.mek.Provider;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;
import java.util.List;

import static me.alien.meksifi.mek.Mek.ModID;

public class Test extends Item {

    private Provider provider;
    @CapabilityInject(IEnergyStorage.class)
    public static Capability<IEnergyStorage> ENERGY = CapabilityEnergy.ENERGY;

    public Test() {
        super(new Item.Properties());
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        int energy = stack.getCapability(ENERGY, null).resolve().get().getEnergyStored();

        tooltip.add(1, new StringTextComponent("Power: "+energy));
        if(provider.stack == null){
            provider.stack = stack;
        }
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {

        provider = new Provider(stack) {};
        return provider;
    }
}
