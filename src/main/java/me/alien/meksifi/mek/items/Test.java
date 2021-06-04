package me.alien.meksifi.mek.items;
import me.alien.meksifi.mek.Provider;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;
import java.util.List;

import static me.alien.meksifi.mek.Mek.ModID;

public class Test extends Item {

    private Provider provider;

    public Test() {
        super(new Item.Properties());
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        CompoundNBT nbt = stack.getOrCreateChildTag(ModID);

        if(!nbt.contains("pow", Constants.NBT.TAG_INT)){
            nbt.putInt("pow", 0);
        }

        int energy = nbt.getInt("pow");

        tooltip.add(1, new StringTextComponent("Power: "+energy));
        if(provider.stack == null){
            provider.stack = stack;
        }
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {

        provider = new Provider(stack, this) {};
        return provider;
    }
}
