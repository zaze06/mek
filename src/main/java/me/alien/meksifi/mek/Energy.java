package me.alien.meksifi.mek;

import net.minecraftforge.energy.IEnergyStorage;

public class Energy implements IEnergyStorage {

    public final int maxEnergy = 10;
    public int energy = 0;

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if(simulate){
            return maxEnergy-energy;
        }
        if(maxReceive+energy>maxEnergy){
            energy=maxEnergy;
            return 0;
        }
        energy+=maxReceive;
        return energy;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if(simulate){
            return energy;
        }
        if(maxExtract-energy<0){
            energy=0;
            return 0;
        }
        energy-=maxExtract;
        return energy;
    }

    @Override
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return maxEnergy;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}
